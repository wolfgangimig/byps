package byps.gen.xml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BApiDescriptor;
import byps.BVersioning;
import byps.gen.api.CommentInfo;
import byps.gen.api.ErrorInfo;
import byps.gen.api.GeneratorException;
import byps.gen.api.MemberInfo;
import byps.gen.api.MethodInfo;
import byps.gen.api.RemoteInfo;
import byps.gen.api.SerialInfo;
import byps.gen.api.TypeInfo;
import byps.gen.db.ClassDB;
import byps.gen.db.ConstFieldReader;

public class XmlGenerator extends XmlGeneratorBase {
  private static Log log = LogFactory.getLog(XmlGenerator.class);
  private final ConstFieldReader constFieldReader;
  private ProcessingEnvironment penv;
  private Messager messager;
  private Elements elements;
  private Types typeUtils;
  private TypeMirror bypsRemoteType;
  private TypeMirror bypsBRemoteType;
  private TypeMirror bypsSerializableType;
  private TypeMirror bypsRemoteExceptionType;

  private static final String BAPI_DESCRIPTOR_CLASS_NAME = "BApi";

  public XmlGenerator(int options, ConstFieldReader constFieldReader) {
    super(options);
    this.constFieldReader = constFieldReader;
  }

  @Override
  public synchronized void init(ProcessingEnvironment processingEnv) {
    this.penv = processingEnv;
    messager = processingEnv.getMessager();
    elements = processingEnv.getElementUtils();
    typeUtils = processingEnv.getTypeUtils();
    
    bypsRemoteType = elements.getTypeElement(byps.Remote.class.getCanonicalName()).asType();
    bypsBRemoteType = elements.getTypeElement(byps.BRemote.class.getCanonicalName()).asType();
    bypsRemoteExceptionType = elements.getTypeElement(byps.RemoteException.class.getCanonicalName()).asType();
    bypsSerializableType = elements.getTypeElement(java.io.Serializable.class.getCanonicalName()).asType();

    classDB = ClassDB.createNewVersion(constFieldReader);
    
    super.init(processingEnv);
  }

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    try {
      
      Optional<? extends Element> apiDescriptorElementOpt = roundEnv.getRootElements().stream()
          .filter(element -> element.getSimpleName().contentEquals(BAPI_DESCRIPTOR_CLASS_NAME))
          .findAny();
      
      if (apiDescriptorElementOpt.isPresent()) {
        
        makeBApiDescriptor(apiDescriptorElementOpt.get());
        
        // Remotes
        roundEnv.getRootElements().stream()
          .filter(this::isRemote)
          .forEach(this::makeRemoteInfo);
        
        // Serializables
        roundEnv.getRootElements().stream()
          .filter(this::isSerializable)
          .forEach(this::makeSerialInfo);
      
        // ------------------------------------------------------
        // Make sure that all classes and interfaces have 
        // internally have type IDs.
        // For Serializable classes the type IDs are generated 
        // from the serialVersionUID values.
        
        log.info("Assign type IDs -------------------");
        
        classDB.assignTypeIds();
        
        correctInlinePropertyForArrayTypes();

      }

    } catch (XmlGeneratorException e) {
      messager.printMessage(Diagnostic.Kind.ERROR, String.format(e.getMessage(), e.getArgs()), e.getElement());
    }
    return false;
  }
  
  @Override
  public Set<String> getSupportedAnnotationTypes() {
    Set<String> ret = new HashSet<>();
    ret.add(byps.gen.BApi.class.getCanonicalName());
    return ret;
  }

  @Override
  public SourceVersion getSupportedSourceVersion() {
    return SourceVersion.latest();
  }
  
  /**
   * Is this an interface and should it be handled?
   * @param element
   * @return
   */
  private boolean isRemote(Element element) {
    
    if (!element.getKind().isInterface()) {
      return false;
    }
    
    // Inherits from byps.Remote?
    if (typeUtils.isAssignable(element.asType(), bypsRemoteType)) {
      return true;
    }
    
    // Does not inherit from Remote, use it either?
    return ((options & OPT_ALL_REMOTES) != 0);
  }

  
  /**
   * Is this a class and should it be handled?
   * @param element
   * @return
   */
  private boolean isSerializable(Element element) {
    
    if (!element.getKind().isClass()) {
      return false;
    }
    
    if (element.getSimpleName().contentEquals(BAPI_DESCRIPTOR_CLASS_NAME)) {
      return false;
    }
    
    // Inherits from java.io.Serializable?
    if (typeUtils.isAssignable(element.asType(), bypsSerializableType)) {
      return true;
    }
    
    // Does not inherit from Serializable, use it either?
    return ((options & OPT_ALL_SERIALS) != 0);
  }
  
  private boolean isInline(Collection<CommentInfo> commentInfos) {
    return commentInfos.stream().anyMatch(cinfo -> cinfo.kind.equals("@inline"));
  }
  
  private String getSessionParamType(Collection<CommentInfo> commentInfos) {
    return commentInfos.stream().filter(cinfo -> cinfo.kind.equals("@BSessionParamType")).map(cinfo -> cinfo.text).findAny().orElse(null);
  }
  
  private boolean isClientRemote(Collection<CommentInfo> commentInfos) {
    return commentInfos.stream().anyMatch(cinfo -> cinfo.kind.equals("@BClientRemote"));
  }
  
  private long getSince(Collection<CommentInfo> commentInfos) {
    return commentInfos.stream()
        .filter(cinfo -> cinfo.kind.equals("@since"))
        .map(cinfo -> BVersioning.stringToLong(cinfo.text)).findAny().orElse(0L);
  }

  private BApiDescriptor makeBApiDescriptor(Element apiDescElement) {
    
    ClassH classH = ClassH.fromValue(penv, apiDescElement);
    String pack = classH.getPackage();

    String name = classH.getMandatoryConstantThrowEx("NAME");
    String version = classH.getMandatoryConstantThrowEx("VERSION");
    
    BApiDescriptor apiDesc = new BApiDescriptor(name, pack, BVersioning.stringToLong(version), false);
    classDB.setApiDescriptor(apiDesc);
    
    return apiDesc;
  }
  
  private SerialInfo makeSerialInfo(Element serialElement) {
    TypeElement serialType = (TypeElement)serialElement;
    String serialName = serialType.getSimpleName().toString();
    String serialQName = serialType.asType().toString();
    ErrorInfo errorInfo = new ErrorInfo();
    errorInfo.className = serialQName;
    
    if (serialName.equals("UsePlanets")) {
      errorInfo.className = serialQName;
    }
    
    ArrayList<CommentInfo> commentInfos = new ArrayList<>();
    addSummaryAndRemarksCommentInfo(serialType, commentInfos);

    ArrayList<MemberInfo> members = new ArrayList<>();
    for (Element fieldElement : serialElement.getEnclosedElements()) {
      
      if (!fieldElement.getSimpleName().contentEquals("serialVersionUID")) {
       
        switch (fieldElement.getKind()) {
          case FIELD: case ENUM_CONSTANT: {
            MemberInfo minfo = makeMemberInfo(errorInfo, fieldElement);
            members.add(minfo);
            break;
          }
          default: 
            break;
        }
       }
      
    }

    List<TypeInfo> argInfos = getTypeArguments(errorInfo, serialElement.asType());
    
    boolean isInline = isInline(commentInfos);
    long since = getSince(commentInfos);
    boolean isEnum = isEnum(serialElement.asType());
    boolean isFinal = serialElement.getModifiers().contains(Modifier.FINAL);

    String baseQName = "";
    if (!isEnum) {
      baseQName = typeUtils.directSupertypes(serialElement.asType()).stream()
        .findFirst()
        .map(Object::toString)
        .map(s -> s.equals("java.lang.Object") ? "" : s)
        .orElse("");
    }
      
    if (baseQName.equals("java.lang.Throwable")) {
      log.warn("Class \"" + baseQName + "\": " +
          "Exception classes must inherit from java.lang.Exception instead of java.lang.Throwable. " +
          "Assuming base class java.lang.Exception for serialization.");
      baseQName = "java.lang.Exception";
    }
    

    SerialInfo sinfo = classDB.createSerialInfo(serialName, commentInfos, serialQName, baseQName, "", argInfos, 
        members, isEnum, isFinal, isInline, since);
    classDB.add(sinfo);
    
    log.debug(")makeSerialInfo");
    return sinfo;

  }

  private MemberInfo makeMemberInfo(ErrorInfo errorInfo1, Element fieldElement) {
    ErrorInfo errorInfo = errorInfo1.copy();
    
    String name = fieldElement.getSimpleName().toString();
    errorInfo.fieldName = name;
    
    if (FORBIDDEN_FIELD_AND_METHOD_NAMES.contains(name)) {
      errorInfo.msg = "Forbidden field name";
      throw new GeneratorException(errorInfo);
    }
    
    ArrayList<CommentInfo> commentInfos = new ArrayList<>();
    addSummaryAndRemarksCommentInfo(fieldElement, commentInfos);
    
    boolean isInline = isInline(commentInfos);
    
    TypeInfo typeInfo = makeTypeInfo(errorInfo, fieldElement, isInline);
    checkSupportedFieldType(errorInfo, typeInfo);
    
    long since = getSince(commentInfos);
    
    // Constant or Enum?
    String value = null;
    boolean isEnumConstant = fieldElement.getKind() == ElementKind.ENUM_CONSTANT;
    boolean isStatic = fieldElement.getModifiers().contains(Modifier.STATIC);
    if ((typeInfo.isFinal && isStatic) || isEnumConstant) {
      
      Element containingClass = fieldElement.getEnclosingElement();
      TypeInfo containingTypeInfo = makeTypeInfo(errorInfo, containingClass.asType());
      
      Object valueObj = classDB.fieldReader.getValue(containingTypeInfo, name);
      if (valueObj != null) {
        if (isEnumConstant) {
          Enum<?> en = (Enum<?>)valueObj;
          value = Integer.toString(en.ordinal());  
        }
        else {
          value = serializeObjectToJson(errorInfo, valueObj);
        }
      }
      else if (typeInfo.isStringType() && !typeInfo.isArrayType()) {
        value = "";
      }
    }
    
    boolean isPublic = fieldElement.getModifiers().contains(Modifier.PUBLIC);
    boolean isProtected = fieldElement.getModifiers().contains(Modifier.PROTECTED);
    boolean isPrivate = fieldElement.getModifiers().contains(Modifier.PRIVATE);
    boolean isFinal = fieldElement.getModifiers().contains(Modifier.FINAL);
    boolean isTransient = fieldElement.getModifiers().contains(Modifier.TRANSIENT);
    boolean isPackage = !(isPublic || isProtected || isPrivate);
        
    return new MemberInfo(name, commentInfos, typeInfo, 
        isPublic, isProtected, isPackage, isPrivate,
        isFinal, isStatic, isTransient,
        since, value);
  }

  private RemoteInfo makeRemoteInfo(Element remoteElement) {
    TypeElement remoteType = (TypeElement)remoteElement;
    String remoteName = remoteType.getSimpleName().toString();
    String remoteQName = remoteType.asType().toString();
    ErrorInfo errorInfo = new ErrorInfo();
    errorInfo.className = remoteQName;

    List<String> baseQNames = remoteType.getInterfaces().stream()
        .filter(baseType -> !baseType.equals(bypsRemoteType))
        .filter(baseType -> !baseType.equals(bypsBRemoteType))
        .filter(baseType -> typeUtils.isAssignable(baseType, bypsRemoteType))
        .map(TypeMirror::toString)
        .collect(Collectors.toList());
    
    List<CommentInfo> commentInfos = new ArrayList<>();
    addSummaryAndRemarksCommentInfo(remoteType, commentInfos);

    List<MethodInfo> minfos = remoteType.getEnclosedElements().stream()
        .filter(e -> e.getKind() == ElementKind.METHOD)
        .map(e -> makeMethodInfo(errorInfo, remoteName, remoteQName, e))
        .collect(Collectors.toList());
    
    String sessionParamTypeName = getSessionParamType(commentInfos);
    boolean isClientRemote = isClientRemote(commentInfos);
    long since = getSince(commentInfos);
    
    RemoteInfo rinfo = classDB.createRemoteInfo(remoteName, commentInfos, 
        remoteQName, baseQNames, 
        minfos, sessionParamTypeName, 
        isClientRemote, since);

    classDB.createStubForRemote(rinfo);

    return rinfo;
  }
  
  private void addSummaryAndRemarksCommentInfo(Element remoteElement, List<CommentInfo> commentInfos) {
    String commentLines = elements.getDocComment(remoteElement);
    JavadocCommentParser.parse(commentLines, commentInfos);
  }

  private MethodInfo makeMethodInfo(ErrorInfo errorInfo1, String remoteName, String remoteQName, Element methodElement) {
    ErrorInfo errorInfo = errorInfo1.copy();

    List<CommentInfo> commentInfos = new ArrayList<>();
    addSummaryAndRemarksCommentInfo(methodElement, commentInfos);

    String name = errorInfo.methodName = methodElement.getSimpleName().toString();
    if (FORBIDDEN_FIELD_AND_METHOD_NAMES.contains(name)) {
      errorInfo.fieldName = name;
      errorInfo.msg = "Forbidden method name";
      throw new GeneratorException(errorInfo);
    }
    
    long since = getSince(commentInfos);

    SerialInfo requestInfo = makeMethodRequest(errorInfo, remoteName, remoteQName, methodElement);

    SerialInfo resultInfo = makeMethodResult(errorInfo, remoteQName, methodElement);

    ArrayList<TypeInfo> exceptions = getMethodExceptions(errorInfo, methodElement);
    
    return new MethodInfo(
        name, commentInfos, 
        requestInfo, resultInfo, 
        exceptions, since); 
  }
  
  private boolean isRemoteException(TypeMirror type) {
    return typeUtils.isAssignable(type, bypsRemoteExceptionType);
  }

  private ArrayList<TypeInfo> getMethodExceptions(ErrorInfo errorInfo, Element methodElement) {
    ExecutableType executableType = (ExecutableType)methodElement.asType();
    Optional<? extends TypeMirror> bypsExceptionOpt = executableType.getThrownTypes().stream()
        .filter(this::isRemoteException)
        .findAny();
    
    if (!bypsExceptionOpt.isPresent()) {
      errorInfo.msg = "Method must throw byps.RemoteException";
      throw new GeneratorException(errorInfo);
    }
    
    // Currently, I don't know how to deal with custom exception classes in C++
    Optional<? extends TypeMirror> nonBypsExceptionOpt = executableType.getThrownTypes().stream()
        .filter(exceptionType -> !typeUtils.isAssignable(exceptionType, bypsRemoteExceptionType))
        .findAny();

    if (nonBypsExceptionOpt.isPresent()) {
      errorInfo.msg = "Custom exception classes are unsupported. Methods must throw byps.RemoteException.";
      throw new GeneratorException(errorInfo);
    }
    
    return new ArrayList<>();
  }

  private void checkSupportedFieldType(ErrorInfo errorInfo, TypeInfo typeInfo) {
    // Do not use reference types of primitives, e.g. java.lang.Integer.
    // This primitive types cannot be null in all languages, e.g. C++.
    if (typeInfo.isPrimitiveType() && typeInfo.qname.startsWith("java.lang.") && !typeInfo.qname.equals("java.lang.String")) {
      
      errorInfo.msg = "Reference types of primitives cannot be used as class members" +
          " or function parameters or return values. " + 
          "Use the primitive type. " +
          "Example: use \"int\" instead of \"Integer\".";
      throw new GeneratorException(errorInfo);
    }
  }
  
  private SerialInfo makeMethodResult(ErrorInfo errorInfo1, String remoteQName, Element methodElement) {
    ErrorInfo errorInfo = errorInfo1.copy();
    ExecutableType executableType = (ExecutableType)methodElement.asType();
    
    TypeMirror returnType = executableType.getReturnType();
    errorInfo.methodName = remoteQName + "." + methodElement.getSimpleName().toString();
    errorInfo.fieldName = "return";
    
    ArrayList<MemberInfo> rinfos = new ArrayList<>(2);
    
    TypeInfo resultType = makeTypeInfo(errorInfo, returnType);
    checkSupportedFieldType(errorInfo, resultType);
    
    resultType.typeId = classDB.getOrCreateTypeId(resultType);
    
    if (resultType.isInline && !resultType.isArrayType()) {
      // Das geht nicht in C++
      errorInfo.msg = "Inline classes cannot be used as return values.";
      throw new GeneratorException(errorInfo);
    }

    rinfos.add( new MemberInfo("result", null, resultType, true, false, false, false, false, false, false, 0, null) );
    
    String remotePack = classDB.getApiDescriptor().basePackage + ".";
    String methodName = MethodInfo.METHOD_RESULT_NAME_PREFIX + resultType.typeId;
    String methodQName = remotePack + methodName;
    
    SerialInfo resultInfo = classDB.getSerInfo(methodQName);
    
    if (resultInfo == null) {
      resultInfo = classDB.createSerialInfo(
          methodName, 
          null, 
          methodQName, 
          null, 
          "", 
          null, 
          rinfos,
          false, // isEnum
          true, // isFinal
          false, // inlineInstance
          0L
          );
      classDB.add(resultInfo);
    }
    
    return resultInfo;
  }

  private TypeInfo makeTypeInfo(ErrorInfo errorInfo, TypeMirror typeMirror, boolean isFinal, boolean isInline) {
   
    // Wildcard Parameter machen keinen Sinn.
    // Die Elemente werden sowohl als Konsument als auch als Produzent verwendet.
    // http://www.torsten-horn.de/techdocs/java-generics.htm#Wildcard-extends-versus-T-extends
    if (typeMirror.getKind() == TypeKind.WILDCARD) {
      errorInfo.msg = "Wildcard parameter types are unsupported, replace type=\"" + typeMirror +"\" by \"Object\".";
      throw new GeneratorException(errorInfo);
    }
    
    boolean isEnum = isEnum(typeMirror);
    String qname = getQualifiedName(typeMirror);
    String name = getSimpleName(typeMirror);
    String dimensions = getDimensions(typeMirror);
    List<TypeInfo> typeArgs = getTypeArguments(errorInfo, typeMirror);
    TypeInfo typeInfo = new TypeInfo(name, qname, dimensions, typeArgs, isEnum, isFinal || isEnum, isInline);
    
    makeSerialInfoForCollectionType(errorInfo, typeInfo);
    
    return typeInfo;
  }
  
  private boolean isEnum(TypeMirror typeMirror) {
    
    while (typeMirror.getKind() == TypeKind.ARRAY) {
      ArrayType arrayType = (ArrayType)typeMirror;
      typeMirror =  arrayType.getComponentType();
    }
    
    return typeUtils.directSupertypes(typeMirror).stream()
        .filter(superType -> superType.getKind() == TypeKind.DECLARED)
        .map(superType -> (DeclaredType)superType)
        .map(DeclaredType::asElement)
        .map(declaredType -> (TypeElement)declaredType)
        .anyMatch(element -> element.getQualifiedName().contentEquals("java.lang.Enum"));
  }
  
  private TypeInfo makeTypeInfo(ErrorInfo errorInfo, Element element, boolean isInline) {
    TypeMirror typeMirror = element.asType();
    boolean isFinal = element.getModifiers().contains(Modifier.FINAL);
    boolean isStatic = element.getModifiers().contains(Modifier.STATIC);
    return makeTypeInfo(errorInfo, typeMirror, isFinal && isStatic, isInline);
  }
  
  private TypeInfo makeTypeInfo(ErrorInfo errorInfo, TypeMirror typeMirror) {
    return makeTypeInfo(errorInfo, typeMirror, false, false);
  }
  
  private List<TypeInfo> getTypeArguments(ErrorInfo errorInfo, TypeMirror typeMirror) {
    List<TypeInfo> typeArguments = Collections.emptyList();
    if (typeMirror instanceof DeclaredType) {
      DeclaredType declaredType = (DeclaredType)typeMirror;
      typeArguments = declaredType.getTypeArguments().stream()
          .map(typeArgument -> makeTypeInfo(errorInfo, typeArgument))
          .collect(Collectors.toList());
    }
    return typeArguments;
  }
  
  private String getDimensions(TypeMirror typeMirror) {
    String dimensions = "";
    if (typeMirror.getKind() == TypeKind.ARRAY) {
      String typeStr = typeMirror.toString();
      int p = typeStr.indexOf('[');
      dimensions = p >= 0 ? typeStr.substring(p) : "";
    }
    return dimensions;
  }
  
  private String getQualifiedName(TypeMirror typeMirror) {
    String qname = "";
    if (typeMirror instanceof DeclaredType) {
      DeclaredType declaredType = (DeclaredType)typeMirror;
      TypeElement typeElement = (TypeElement)declaredType.asElement();
      qname = typeElement.getQualifiedName().toString();
    }
    else if (typeMirror instanceof ArrayType) {
      ArrayType arrayType = (ArrayType)typeMirror;
      qname = getQualifiedName(arrayType.getComponentType());
    }
    else {
      qname = typeMirror.toString();
    }
    return qname;
  }
  
  private String getSimpleName(TypeMirror typeMirror) {
    String qname = getQualifiedName(typeMirror);
    int p = qname.lastIndexOf('.');
    return p >= 0 ? qname.substring(p+1) : qname;
  }

  private MemberInfo makeMethodParamInfo(ErrorInfo errorInfo1, TypeMirror parameterType, String parameterName) {
    ErrorInfo errorInfo = errorInfo1.copy();
    errorInfo.paramName = parameterName;
    TypeInfo typeInfo = makeTypeInfo(errorInfo, parameterType);
    
    if (typeInfo.isInline && !typeInfo.isArrayType()) {
      // Das geht nicht in C++
      errorInfo.msg = "Inline classes cannot be used as method parameters.";
      throw new GeneratorException(errorInfo);
    }
    
    checkSupportedFieldType(errorInfo, typeInfo);

    return new MemberInfo(parameterName, typeInfo);
  }

  private SerialInfo makeMethodRequest(ErrorInfo errorInfo1, String remoteName, String remoteQName, Element methodElement) {
    ErrorInfo errorInfo = errorInfo1.copy();
    ExecutableElement executableElmenent = (ExecutableElement)methodElement;
    
    ArrayList<MemberInfo> parameterInfos = new ArrayList<>();
    for (VariableElement param : executableElmenent.getParameters()) {
      String parameterName = param.getSimpleName().toString();
      TypeMirror parameterType = param.asType();
      MemberInfo pinfo = makeMethodParamInfo(errorInfo, parameterType, parameterName);
      parameterInfos.add(pinfo);
    }
    
    String methodName = MethodInfo.METHOD_REQUEST_NAME_PREFIX + remoteName + "_" + methodElement.getSimpleName();
    String remotePack = remoteQName.substring(0, remoteQName.lastIndexOf('.')+1);
    String methodQName = remotePack + MethodInfo.METHOD_REQUEST_NAME_PREFIX + remoteName + "_" + methodElement.getSimpleName();
    
    SerialInfo requestInfo = classDB.createSerialInfo(
        methodName, 
        null, 
        methodQName, 
        null, 
        "", 
        null, 
        parameterInfos,
        false, // isEnum
        true, // isFinal
        false, // inlineInstance
        0L
        );
    classDB.add(requestInfo);
    
    return requestInfo;

  }
  
  private void correctInlinePropertyForArrayTypes() {
    Set<String> inlineTypeNames = classDB.getSerials().stream()
        .filter(t -> t.isInline)
        .map(t -> t.qname)
        .collect(Collectors.toSet());
    
    classDB.getSerials().stream()
        .filter(t -> inlineTypeNames.contains(t.qname))
        .filter(t -> t.dims != null && !t.dims.isEmpty())
        .forEach(t -> t.isInline = true);
        
   }
}
