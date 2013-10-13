package com.wilutions.byps.gen.db;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BApiDescriptor;
import com.wilutions.byps.BException;
import com.wilutions.byps.BExceptionC;
import com.wilutions.byps.BRegistry;
import com.wilutions.byps.BRemote;
import com.wilutions.byps.gen.api.CommentInfo;
import com.wilutions.byps.gen.api.ErrorInfo;
import com.wilutions.byps.gen.api.GeneratorException;
import com.wilutions.byps.gen.api.MemberInfo;
import com.wilutions.byps.gen.api.MethodInfo;
import com.wilutions.byps.gen.api.RemoteInfo;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.api.TypeInfo;

public class ClassDB {

  public static ClassDB createNewVersion(ClassDB prevClassDB, ConstFieldReader tidProv) throws GeneratorException {
    ClassDB classDB = new ClassDB(tidProv);

    // Die Type-IDs der vorigen ClassDB-Version
    // sollen auch für die aktuelle ClassDB gelten.
    // D.h. gleichnamige Strukturen bekommen dieselbe Typ-ID.
    if (prevClassDB != null) {
      classDB.prevClassDB = prevClassDB;
    }

    return classDB;
  }

  public void add(RemoteInfo v) {
    if (remotes.put(v.toString(), v) == null) {
      log.info("Add remote Class " + v);
    }
  }

  public void add(SerialInfo v) {
    SerialInfo p = serials.get(v.toString());

    // Während der Code analysiert wird, kann es dazu kommen, dass
    // eine Klasse zuerst als Array-Typ (z. B. Point2D[]) gefunden wird,
    // bevor sie als Serializable eingelesen wird.
    // In diesem Fall ist keine Information darüber verfügbar,
    // ob die Klasse "inline" ist. Sie gelangt hier also zunächst
    // mit isInline=false in die Map.
    // Wenn sie später als Serializable aufgenommen wird,
    // tausche ich sie aus.

    if (p == null) {
      log.info("Add serializable Class " + v);
      serials.put(v.toString(), v);
    }

  }

  /**
   * Get SerialInfo object to given full name
   * 
   * @param fullName
   *          , qualified name plus type arguments, e.g.
   *          java.util.ArrayList&lt;Integer&gt;
   * @return SerialInfo object
   */
  public SerialInfo getSerInfo(String fullName) {
    return serials.get(fullName);
  }

  public RemoteInfo getRemoteInfo(String fullName) {
    return remotes.get(fullName);
  }

  public TypeInfo getTypeInfo(String fullName) {

    // Die funktion gibt's ganz ähnlich auch in
    // BRegistryForClassDB-getTypeIdForBuiltInType
    // kann man eine eliminieren?

    int typeId = -1;
    if (fullName.equals("boolean")) typeId = BRegistry.TYPEID_BOOL;
    else if (fullName.equals("byte")) typeId = BRegistry.TYPEID_INT8;
    else if (fullName.equals("char")) typeId = BRegistry.TYPEID_WCHAR;
    else if (fullName.equals("short")) typeId = BRegistry.TYPEID_INT16;
    else if (fullName.equals("int")) typeId = BRegistry.TYPEID_INT32;
    else if (fullName.equals("long")) typeId = BRegistry.TYPEID_INT64;
    else if (fullName.equals("float")) typeId = BRegistry.TYPEID_FLOAT;
    else if (fullName.equals("double")) typeId = BRegistry.TYPEID_DOUBLE;
    else if (fullName.equals("void")) typeId = BRegistry.TYPEID_VOID;
    else if (fullName.equals(Object.class.getName())) typeId = BRegistry.TYPEID_OBJECT;
    else if (fullName.equals(String.class.getName())) typeId = BRegistry.TYPEID_STRING_UTF16;
    else if (fullName.equals(Boolean.class.getName())) typeId = BRegistry.TYPEID_BOOL;
    else if (fullName.equals(Byte.class.getName())) typeId = BRegistry.TYPEID_INT8;
    else if (fullName.equals(Character.class.getName())) typeId = BRegistry.TYPEID_WCHAR;
    else if (fullName.equals(Short.class.getName())) typeId = BRegistry.TYPEID_INT16;
    else if (fullName.equals(Integer.class.getName())) typeId = BRegistry.TYPEID_INT32;
    else if (fullName.equals(Long.class.getName())) typeId = BRegistry.TYPEID_INT64;
    else if (fullName.equals(Float.class.getName())) typeId = BRegistry.TYPEID_FLOAT;
    else if (fullName.equals(Double.class.getName())) typeId = BRegistry.TYPEID_DOUBLE;
    else if (fullName.equals(InputStream.class.getName())) typeId = BRegistry.TYPEID_STREAM;
    else if (fullName.equals(BRemote.class.getName())) typeId = BRegistry.TYPEID_STUB;

    TypeInfo tinfo = null;
    if (typeId >= 0) {
      String name = fullName;
      int p = name.lastIndexOf(".");
      if (p >= 0) name = name.substring(p + 1);
      tinfo = new TypeInfo(name, fullName, "", null, false, false, false);
      tinfo.typeId = typeId;
    }
    else {
      tinfo = serials.get(fullName);
      if (tinfo == null) {
        tinfo = remotes.get(fullName);
      }
    }

    if (tinfo == null) {
      throw new IllegalStateException("Missing type information for \"" + fullName + "\"");
    }

    return tinfo;
  }

  public SerialInfo createSerialInfo(String name, List<CommentInfo> comments, String qname, String baseQname, String dims, List<TypeInfo> typeArgs, List<MemberInfo> members, boolean isEnum,
      boolean isFinal, boolean inlineInstance) throws GeneratorException {
    log.debug("createSerialInfo: " + qname + ", baseQname=" + baseQname + ", dims=" + dims + ", typeArgs=" + typeArgs + ", members=" + members + ", inlineInstance=" + inlineInstance + ", isEnum="
        + isEnum);
    SerialInfo serInfo = new SerialInfo(name, comments, qname, baseQname, dims, typeArgs, members, isEnum, isFinal, inlineInstance);
    return serInfo;
  }

  public RemoteInfo createRemoteInfo(String name, List<CommentInfo> comments, String qname, List<String> baseQNames, List<MethodInfo> methods, String authParamClassName, boolean isClientRemote)
      throws GeneratorException {

    RemoteInfo rinfo = new RemoteInfo(name, comments, qname, baseQNames, methods, authParamClassName, isClientRemote);

    if (methods != null) {
      for (MethodInfo method : methods) {
        method.remoteInfo = rinfo;

        String methodQName = method.getQName();
        if (mapQnameToMethodInfo.get(methodQName) != null) {
          ErrorInfo errInfo = new ErrorInfo();
          errInfo.className = rinfo.toString();
          errInfo.msg = method.name + " already defined. Methods cannot be overloaded. Their names must be unique.";
          throw new GeneratorException(errInfo);
        }

        mapQnameToMethodInfo.put(methodQName, method);
      }
    }

    add(rinfo);

    return rinfo;
  }

  public SerialInfo createStubForRemote(RemoteInfo rinfo) throws GeneratorException {
    String baseQname = ""; // BStub.class.getName();
    String stubName = makeStubName(rinfo.name);
    String stubQname = makeStubName(rinfo.qname);
    List<MemberInfo> stubMembers = new ArrayList<MemberInfo>();

    SerialInfo sinfo = createSerialInfo(stubName, null, stubQname, baseQname, "", null, stubMembers, false, false, false);
    add(sinfo);

    return sinfo;
  }

  public static String makeStubName(String remoteName) {
    String pack = "";
    int p = remoteName.lastIndexOf(".");
    if (p >= 0) {
      pack = remoteName.substring(0, p + 1);
      remoteName = remoteName.substring(p + 1);
    }
    return pack + RemoteInfo.STUB_NAME_PREFIX + remoteName;
  }

  MethodInfo getMethodInfo(String qname) {
    return mapQnameToMethodInfo.get(qname);
  }

  public TypeInfo createTypeInfo(String name, String qname, String dims, List<TypeInfo> typeArgs, boolean isEnum, boolean isFinal, boolean isInline) throws GeneratorException {
    TypeInfo tinfo = new TypeInfo(name, qname, dims, typeArgs, isEnum, isFinal, isInline);
    return tinfo;
  }

  public void assignTypeIds() throws GeneratorException {
    log.debug("assignTypeIds(");

    for (SerialInfo sinfo : serials.values()) {
      sinfo.typeId = getOrCreateTypeId(sinfo);
    }

    for (SerialInfo sinfo : serials.values()) {
      assignTypeIdToMembers(sinfo);
    }

    for (SerialInfo sinfo : serials.values()) {
      assignBaseInfo(sinfo);
    }

    for (RemoteInfo rinfo : remotes.values()) {
      String stubQname = makeStubName(rinfo.qname);
      SerialInfo sinfo = serials.get(stubQname);
      rinfo.typeId = sinfo.typeId;
    }

    log.debug(")assignTypeIds");
  }

  public BRegistryForClassDB getRegistry() {
    return registry;
  }

  private void assignTypeIdToType(TypeInfo tinfo) throws GeneratorException {
    TypeInfo knownType = getKnownType(tinfo.qname, tinfo.dims, tinfo.typeArgs);
    if (knownType == null) {
      ErrorInfo errInfo = new ErrorInfo();
      errInfo.className = tinfo.toString();
      errInfo.msg = "Unexpected type=" + tinfo + ", did you miss to derive from the Serializable/BSerializable interface? Make sure, the source file resides in one of the analyzed directories.";
      throw new GeneratorException(errInfo);
    }

    tinfo.typeId = knownType.typeId;
    tinfo.isInline = knownType.isInline;

    if (tinfo.typeArgs != null) {
      for (TypeInfo ainfo : tinfo.typeArgs) {
        assignTypeIdToType(ainfo);
      }
    }
  }

  private void assignTypeIdToMembers(SerialInfo sinfo) throws GeneratorException {
    for (MemberInfo minfo : sinfo.members) {
      assignTypeIdToType(minfo.type);
    }
  }

  private void assignBaseInfo(SerialInfo sinfo) throws GeneratorException {
    if (sinfo.baseFullName != null && sinfo.baseFullName.length() != 0) {
      SerialInfo binfo = serials.get(sinfo.baseFullName);
      if (binfo == null) {
        ErrorInfo errInfo = new ErrorInfo();
        errInfo.className = sinfo.toString();
        errInfo.msg = " missing base class " + sinfo.baseFullName;
        throw new GeneratorException(errInfo);
      }
      sinfo.baseInfo = binfo;
    }
  }

  public void updateType(TypeInfo tinfo, String errorMsg) throws GeneratorException {
    log.debug("updateType(" + tinfo);
    if (tinfo.typeId == 0) {
      TypeInfo knownType = getKnownType(tinfo.qname, tinfo.dims, tinfo.typeArgs);
      if (knownType == null) {
        String msg = errorMsg + tinfo.toString();
        log.error(msg);
      }
      else {
        log.debug("assign known typeId from " + knownType);
        tinfo.typeId = knownType.typeId;
        tinfo.isInline = knownType.isInline;
        tinfo.isEnum = knownType.isEnum;
      }
    }
    for (TypeInfo a : tinfo.typeArgs) {
      updateType(a, errorMsg + " argument type ");
    }
    log.debug(")updateType");
  }

  public int getOrCreateTypeId(TypeInfo tinfo) throws GeneratorException {
    log.debug("getOrCreateTypeId(" + tinfo);
    TypeInfo knownType = getKnownType(tinfo.qname, tinfo.dims, tinfo.typeArgs);
    int typeId = (knownType != null) ? knownType.typeId : 0;
    if (typeId == 0) {
      typeId = makeNewTypeId(tinfo);
      log.info("typeId=" + typeId + " for " + tinfo + " (new class)");
    }
    else if (typeId >= registry.getMinTypeIdUser()) {
      log.info("typeId=" + typeId + " for " + tinfo + " (found in ClassDB)");
    }
    log.debug(")getOrCreateTypeId=" + typeId);
    return typeId;
  }

  /**
   * 
   * @param qname
   * @param dims
   * @param typeArgs
   * @return -1, wenn nicht gefunden
   * @throws GeneratorException
   */
  private TypeInfo getKnownType(String qname, String dims, List<TypeInfo> typeArgs) throws GeneratorException {
    log.debug("getKnownType(" + qname + ", dims=" + dims + ", typeArgs=" + typeArgs);

    TypeInfo retTypeInfo = null;

    if (prevClassDB != null) {
      log.debug("get from prevClassDB");
      TypeInfo prevTypeInfo = prevClassDB.getKnownType(qname, dims, typeArgs);
      log.debug("prevTypeInfo=" + prevTypeInfo);
      retTypeInfo = prevTypeInfo;
    }

    if (retTypeInfo == null) {
      String name = qname;
      int p = name.lastIndexOf('.');
      if (p >= 0) name = name.substring(p + 1);
      TypeInfo typeInfo = new TypeInfo(name, qname, dims, typeArgs, false, false, false);
      retTypeInfo = typeInfo;

      retTypeInfo.typeId = registry.getTypeIdForBuiltInType(retTypeInfo);
      log.debug("typeId from built-in types, typeId=" + retTypeInfo.typeId);

      if (retTypeInfo.typeId == 0) {
        retTypeInfo = serials.get(typeInfo.toString());
        log.debug("typeId from serials, type=" + retTypeInfo);
        if (retTypeInfo == null) {
          retTypeInfo = remotes.get(typeInfo.toString());
          log.debug("typeId from remotes, typeId=" + retTypeInfo);
        }
      }
    }

    log.debug(")getKnownType=" + retTypeInfo);
    return retTypeInfo;
  }

  public Collection<SerialInfo> getSerials() {
    return serials.values();
  }

  public Collection<RemoteInfo> getRemotes() {
    ArrayList<RemoteInfo> arr = new ArrayList<RemoteInfo>(remotes.values());
    Collections.sort(arr, new Comparator<RemoteInfo>() {
      @Override
      public int compare(RemoteInfo o1, RemoteInfo o2) {
        return o1.qname.compareTo(o2.qname);
      }
    });
    return arr;
  }

  public Collection<MethodInfo> getMethods() {
    if (methods == null) {
      methods = new ArrayList<MethodInfo>();
      for (RemoteInfo r : remotes.values()) {
        for (MethodInfo m : r.methods) {
          m.remoteInfo = r;
          methods.add(m);
        }
      }
    }
    return methods;
  }

  private SerialInfo makeExceptionSerialInfo() throws GeneratorException {
    ArrayList<MemberInfo> memberInfos = new ArrayList<MemberInfo>(1);
    SerialInfo sinfo = new SerialInfo("Exception", null, Exception.class.getName(), "", "", null, memberInfos, false, false, false);
    sinfo.typeId = BRegistry.TYPEID_EXCEPTION;
    return sinfo;
  }

  private SerialInfo makeThrowableSerialInfo() throws GeneratorException {
    ArrayList<MemberInfo> memberInfos = new ArrayList<MemberInfo>(1);
    SerialInfo sinfo = new SerialInfo("Throwable", null, Throwable.class.getName(), "", "", null, memberInfos, false, false, false);
    sinfo.typeId = BRegistry.TYPEID_EXCEPTION;
    return sinfo;
  }

  private SerialInfo makeStringSerialInfo() throws GeneratorException {
    SerialInfo sinfo = new SerialInfo("String", null, "java.lang.String", null, "", null, null, false, true, true);
    sinfo.typeId = BRegistry.TYPEID_STRING;
    return sinfo;
  }

  private SerialInfo makeObjectSerialInfo() throws GeneratorException {
    SerialInfo sinfo = new SerialInfo("Object", null, "java.lang.Object", null, "", null, null, false, false, false);
    sinfo.typeId = BRegistry.TYPEID_OBJECT;
    return sinfo;
  }

  private SerialInfo makeListOfObjectSerialInfo() throws GeneratorException {
    ArrayList<TypeInfo> args = new ArrayList<TypeInfo>();
    args.add(this.getTypeInfo("java.lang.Object"));
    SerialInfo sinfo = new SerialInfo("List", null, "java.util.List", null, "", args, null, false, false, false);
    sinfo.typeId = BRegistry.TYPEID_LIST;
    return sinfo;
  }

  private SerialInfo makeSetOfObjectSerialInfo() throws GeneratorException {
    ArrayList<TypeInfo> args = new ArrayList<TypeInfo>();
    args.add(this.getTypeInfo("java.lang.Object"));
    SerialInfo sinfo = new SerialInfo("Set", null, "java.util.Set", null, "", args, null, false, false, false);
    sinfo.typeId = BRegistry.TYPEID_SET;
    return sinfo;
  }

  private SerialInfo makeValueClassSerialInfo() throws GeneratorException {
    SerialInfo sinfo = new SerialInfo("BValueClass", null, "com.wilutions.byps.BValueClass", null, "", null, null, false, false, false);
    sinfo.typeId = BRegistry.TYPEID_VALUECLASS;
    return sinfo;
  }

  public ClassDB(ConstFieldReader tidProv) throws GeneratorException {
    this.fieldReader = tidProv;
    SerialInfo sinfo = makeExceptionSerialInfo();
    serials.put(sinfo.toString(), sinfo);
    sinfo = makeThrowableSerialInfo();
    serials.put(sinfo.toString(), sinfo);
    sinfo = makeStringSerialInfo();
    serials.put(sinfo.toString(), sinfo);
    sinfo = makeObjectSerialInfo();
    serials.put(sinfo.toString(), sinfo);
    sinfo = makeListOfObjectSerialInfo();
    serials.put(sinfo.toString(), sinfo);
    sinfo = makeSetOfObjectSerialInfo();
    serials.put(sinfo.toString(), sinfo);
    sinfo = makeValueClassSerialInfo();
    serials.put(sinfo.toString(), sinfo);
  }

  // private int makeRandomTypeId() throws GeneratorException {
  // log.debug("makeRandomTypeId");
  // int retries = 1000;
  // int typeId = 0;
  //
  // for (int i = 0; i < retries; i++) {
  // typeId = registry.makeRandomTypeId();
  //
  // boolean found = getTypeInfoById(typeId) != null;
  // if (!found) break;
  // }
  //
  // if (typeId == 0) {
  // throw new
  // GeneratorException("Failed to generate unique type ID. Please specify serialVersionUID in all your classes or switch to a higher binary model");
  // }
  //
  // log.debug(")makeRandomTypeId=" + typeId);
  // return typeId;
  // }

  private TypeInfo getTypeInfoById(int typeId) {
    for (SerialInfo serInfo : serials.values()) {
      if (serInfo.typeId == typeId) {
        return serInfo;
      }
    }
    for (RemoteInfo remoteInfo : remotes.values()) {
      if (remoteInfo.typeId == typeId) {
        return remoteInfo;
      }
    }
    return null;
  }

  private int makeTypeIdFromNameHash(TypeInfo tinfo) {
    String s = tinfo.toString();
    int retries = 1000;
    int typeId = 0;

    for (int i = 0; i < retries; i++) {
      typeId = s.hashCode();
      if (typeId < 0) typeId = -typeId;

      boolean found = getTypeInfoById(typeId) != null;
      if (!found) break;

      s += "X";
    }

    return typeId;
  }

  private int makeNewTypeId(TypeInfo tinfo) throws GeneratorException {
    log.debug("makeNewTypeId(" + tinfo);

    int typeId = 0;

    if (tinfo.isArrayType()) {
      typeId = makeTypeIdFromNameHash(tinfo);
    }
    else if (tinfo.isBuiltInType()) {
      typeId = registry.getTypeIdForBuiltInType(tinfo);
    }
    else if (tinfo.isCollectionType()) {
      typeId = makeTypeIdFromNameHash(tinfo);
    }
    else {
      long longTypeId = fieldReader.getSerialVersionUID(tinfo);

      int typeIdMask = registry.getMaxTypeId();
      typeId = (int) (longTypeId & typeIdMask);

      if (typeId == 0) {
        typeId = makeTypeIdFromNameHash(tinfo);
      }
      else if (typeId < registry.getMinTypeIdUser()) {
        log.warn("Ignoring serialVersionUID in " + tinfo.qname);
        typeId = makeTypeIdFromNameHash(tinfo);
      }

      // Type ID already assigned?
      TypeInfo prevTypeInfo = getTypeInfoById(typeId);
      if (prevTypeInfo != null) {
        ErrorInfo errInfo = new ErrorInfo();
        errInfo.className = tinfo.toString();
        errInfo.msg = "Type ID " + typeId + " is already defined for " + prevTypeInfo;
        throw new GeneratorException(errInfo);
      }

    }

    log.debug(")makeNewTypeId=" + typeId);
    return typeId;
  }

  public void setApiDescriptor(BApiDescriptor apiDesc) {
    this.registry = new BRegistryForClassDB();
    this.apiDesc = apiDesc; // new BApiDescriptor(apiDesc, registry, registry);
  }

  public BApiDescriptor getApiDescriptor() {
    return apiDesc;
  }

  public void validate() throws BException {
    boolean ret = true;

    if (!validateSerials()) ret = false;

    if (!ret) {
      throw new BException(BExceptionC.GENERATOR_EXCEPTION, "Validate classDB failed. See error(s) printed before.");
    }
  }

  private boolean validateSerials() throws BException {
    boolean ret = true;
    for (SerialInfo sinfo : serials.values()) {
      if (!validate(sinfo)) ret = false;
    }
    return ret;
  }

  private boolean validate(SerialInfo sinfo) {
    boolean ret = validatePackage(sinfo.pack);
    String errorContext = "class name \"" + sinfo.qname + "\"";

    // Class name must not be a keyword
    if (!sinfo.isPrimitiveType()) {
      if (!Keywords.checkIdentifier(log, errorContext, sinfo.name)) ret = false;
    }
    
    if (sinfo.methodInfo != null) {
      
      String errorContextMethod = sinfo.methodInfo.getQName();
      if (!Keywords.checkIdentifier(log, errorContextMethod, sinfo.methodInfo.name)) ret = false;
      
      for (MemberInfo pinfo : sinfo.methodInfo.requestInfo.members) {
        String errorContextParam = errorContextMethod + " parameter " + pinfo.name;
        if (!Keywords.checkIdentifier(log, errorContextParam, pinfo.name)) ret = false;
      }
    }

    // Check Members
    for (MemberInfo minfo : sinfo.members) {
      validate(minfo, errorContext);
    }

    return ret;
  }

  private boolean validate(MemberInfo minfo, String errorContext) {
    boolean ret = true;
    errorContext = errorContext + " member \"" + minfo.name + "\"";

    // Member name must not be a keyword
    if (!Keywords.checkIdentifier(log, errorContext, minfo.name)) ret = false;

    // A static field must also be final
    if (minfo.isStatic) {
      if (!minfo.isFinal) {
        log.warn(errorContext + ": static members must also be final.");
        ret = false;
      }
    }

    return ret;
  }

  private boolean validatePackage(String pack) {
    boolean ret = true;
    String[] arr = pack.split("\\.");
    for (String s : arr) {
      if (!Keywords.checkIdentifier(log, "Package name \"" + pack + "\"", s)) {
        ret = false;
      }
    }
    return ret;
  }
  

  private TreeMap<String, RemoteInfo> remotes = new TreeMap<String, RemoteInfo>();

  private ArrayList<MethodInfo> methods;

  private TreeMap<String, SerialInfo> serials = new TreeMap<String, SerialInfo>();

  private HashMap<String, MethodInfo> mapQnameToMethodInfo = new HashMap<String, MethodInfo>();

  private ClassDB prevClassDB;

  public final ConstFieldReader fieldReader;

  private BRegistryForClassDB registry;

  private BApiDescriptor apiDesc;

  private Log log = LogFactory.getLog(ClassDB.class);
}