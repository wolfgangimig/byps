package com.wilutions.byps.gen.doclet;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.Doc;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.Parameter;
import com.sun.javadoc.ParameterizedType;
import com.sun.javadoc.RootDoc;
import com.sun.javadoc.Tag;
import com.sun.javadoc.Type;
import com.sun.javadoc.WildcardType;
import com.wilutions.byps.BApiDescriptor;
import com.wilutions.byps.BException;
import com.wilutions.byps.BVersioning;
import com.wilutions.byps.RemoteException;
import com.wilutions.byps.gen.api.CommentInfo;
import com.wilutions.byps.gen.api.ErrorInfo;
import com.wilutions.byps.gen.api.GeneratorException;
import com.wilutions.byps.gen.api.MemberInfo;
import com.wilutions.byps.gen.api.MethodInfo;
import com.wilutions.byps.gen.api.RemoteInfo;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.api.TypeInfo;
import com.wilutions.byps.gen.db.ClassDB;
import com.wilutions.byps.gen.db.ConstFieldReader;

public class BConvert {
	
	public ClassDB classDB;

	public static final int OPT_ALL_SERIALS = 0x1;
	public static final int OPT_ALL_REMOTES = 0x2;
	
	/**
	 * Process only classes tagged with BSerializable 
	 */
  public static final int OPT_ONLY_BSERIALS = 0x4;
  
  /**
   * Process only interfaces tagged with BRemote
   */
  public static final int OPT_ONLY_BREMOTES = 0x8;
  
	
	public final static HashSet<String> FORBIDDEN_FIELD_NAMES = new HashSet<String>(
			Arrays.asList("_typeId"));
	
	public BConvert(int options) {
		this.options = options;
	}
	
	public static ClassDB makeClassDB(ClassDB prevClassDB, RootDoc rdoc, ConstFieldReader constReader, int opts) throws GeneratorException {
		BConvert conv = new BConvert(opts);
		return conv.internalMakeClassDB(prevClassDB, rdoc, constReader);
	}
	
	public ClassDB internalMakeClassDB(ClassDB prevClassDB, RootDoc rdoc, ConstFieldReader constReader) throws GeneratorException {
		log.debug("makeClassDB(prevClassDB=" + prevClassDB + ", rdoc=" + rdoc + ", + constReader=" + constReader);

		classDB = ClassDB.createNewVersion(prevClassDB, constReader);
		
		ClassDoc[] classes = rdoc.classes();
		log.debug("#classes=" + classes.length);

		log.info("API Descriptor -------------------");
		
		log.debug("search for API descriptor");
		boolean apiDescFound = false;
		for (ClassDoc c : classes) {
			if (c.simpleTypeName().equals("BApi")) {
				log.debug("found API descriptor=" + c);
				BApiDescriptor apiDesc = makeApiDescriptor(c, constReader);
				log.info("API Descriptor=" + apiDesc);
				apiDescFound = true;
				break;
			}
		}
		if (!apiDescFound) {
			ErrorInfo errInfo = new ErrorInfo();
			errInfo.msg = "No API descriptor found. Missing class BApi.";
			throw new GeneratorException(errInfo);
		}

		log.info("Process classes -------------------");
		
		log.debug("for all classes...");
		for (ClassDoc c : classes) {
			
			log.debug("class=" + c);
			
			if (c.simpleTypeName().equals("BApi")) {
				continue;
			}
			
			log.info("Process class=" + c);
			
			if (isRemote(c)) {
				if (isSerializable(c)) {
					ErrorInfo errInfo = new ErrorInfo();
					errInfo.className = c.qualifiedName();
					errInfo.msg = "Class must be either a Remote or a Serializable";
					throw new GeneratorException(errInfo);
				}
				makeRemoteInfo(c);
				continue;
			}

			if (isSerializable(c)) {
				makeSerialInfo(c);
				continue;
			}
			
			if ((options & (OPT_ONLY_BREMOTES|OPT_ONLY_BSERIALS)) == 0) {
			  log.warn("Skip class " + c.qualifiedName() + 
			      ", neither Remote nor Serializable. Either implement com.wilutions.byps.BRemote or java.io.Serializable. "
			      + "Or tag with @BRemote or @BSerializable");
			}
		}
		
		log.info("Assign type IDs -------------------");
		
		classDB.assignTypeIds();
		
		log.debug(")makeClassDB");
		return classDB;
	}

	private boolean isRemote(ClassDoc c) {
	  
	  if ((options & OPT_ONLY_BREMOTES) != 0) {
	    return c.tags("@BRemote").length != 0;
	  }
		
		boolean doesImplementBRemote = doesImplement(c, com.wilutions.byps.Remote.class.getName());
		log.debug("does implement BRemote: " + doesImplementBRemote);
		if (doesImplementBRemote) return doesImplementBRemote;
		
		if ((options & OPT_ALL_REMOTES) != 0 && c.isInterface()) return true;
		
		return false;
	}
	
	private boolean isSerializable(ClassDoc c) {
		
    if ((options & OPT_ONLY_BSERIALS) != 0) {
      return c.tags("@BSerializable").length != 0;
    }

    boolean doesImplementSerializable = doesImplement(c, Serializable.class.getName());
		log.debug("does implement Serializable: " + doesImplementSerializable);
		if (doesImplementSerializable) return true;

		if ((options & OPT_ALL_SERIALS) != 0 && !c.isInterface()) return true;
		
		return false;
	}
	
	private BApiDescriptor makeApiDescriptor(ClassDoc c, ConstFieldReader constReader) throws GeneratorException {
		log.debug("makeApiDescriptor(" + c.qualifiedName());
		
		BApiDescriptor apiDesc = classDB.getApiDescriptor();
		if (apiDesc != null) {
			ErrorInfo errInfo = new ErrorInfo();
			errInfo.className = c.qualifiedName();
			errInfo.msg = "Duplicate API descriptor: first definition was " + apiDesc.basePackage;
			throw new GeneratorException(errInfo);
		}
		
		try {
			PackageDoc pack = c.containingPackage();
			log.debug("api-package=" + pack);
			
			TypeInfo tinfo = new TypeInfo(c.simpleTypeName(), c.qualifiedTypeName(), "", null, false, false, false);
			String name = (String)constReader.getValue(tinfo,  "NAME");
			log.debug("api-name=" + name);
			if (name == null) {
				ErrorInfo errInfo = new ErrorInfo();
				errInfo.className = c.qualifiedName();
				errInfo.msg = "Missing \"public final static String NAME = ...\"";
				throw new GeneratorException(errInfo);				
			}
			String version = (String)constReader.getValue(tinfo, "VERSION");
			if (version == null) {
				ErrorInfo errInfo = new ErrorInfo();
				errInfo.className = c.qualifiedName();
				errInfo.msg = "Missing \"public final static String VERSION = ...\"";
				throw new GeneratorException(errInfo);				
			}
			log.debug("api-version=" + version);
			Boolean uniqueObjects = (Boolean)constReader.getValue(tinfo,  "UNIQUE_OBJECTS");
			if (uniqueObjects == null) uniqueObjects = Boolean.FALSE;

			apiDesc = new BApiDescriptor(name, pack.toString(), BVersioning.stringToLong(version), uniqueObjects);
			classDB.setApiDescriptor(apiDesc);

		}
		finally {
		}
		
		log.debug(")makeApiDescriptor=" + apiDesc);
		return apiDesc;
	}

	private void makeSerialInfoForCollectionType(ErrorInfo errInfo, TypeInfo tinfo) throws GeneratorException {
		log.debug("makeSerialInfoForCollectionType(" + tinfo);
		errInfo = errInfo.copy();
		
		// Create SerialInfo for List and Map and Set
		log.debug("isCollectionType=" + tinfo.isCollectionType());
		if (tinfo.isCollectionType()) {
			
			checkSupportedCollectionType(errInfo, tinfo);

			// List, ArrayList, LinkedList ohne Argumenttype?
			if (tinfo.typeArgs.size() == 0) {
				errInfo.msg = "Missing argument types.";
				throw new GeneratorException(errInfo);
			}
			else {
				// List<?>, List<Integer>, Map<?,?> ... 
				for (int i = 0; i < tinfo.typeArgs.size(); i++) {
					TypeInfo ainfo = tinfo.typeArgs.get(i);
					log.debug("type argument=" + ainfo);
					if (ainfo.name.equals("?")) {
						tinfo.typeArgs.set(i, ainfo);
					}
				}
			}
			
			if (tinfo.isMapType()) {
				TypeInfo type = tinfo.typeArgs.get(0);
				// JavaScript supports only numbers and strings as map keys.
				if (!type.isPrimitiveType()) {
					errInfo.typeArg = type.toString();
					errInfo.msg = "Map types must be specified with a key type of Boolean, Byte, Short, Integer, Long, Float, Double or String.";
					throw new GeneratorException(errInfo);
				}
			}
			
			SerialInfo serInfo = classDB.createSerialInfo(tinfo.name, null, tinfo.qname, null, "", tinfo.typeArgs,
					null, tinfo.isEnum, tinfo.isFinal, tinfo.isInline);
			classDB.add(serInfo);
		}

		// If tinfo is an array (maybe an array of collections),
		// generate a SerialInfo for this array type. 
		log.debug("isArrayType=" + tinfo.isArrayType());
		if (tinfo.isArrayType()) {
			
			// Arrays of generic types are unsupported by the java programming language
			if (tinfo.typeArgs.size() != 0) {

				// new List<Integer>[2] leads to this compiler error:
				// Cannot create a generic array of List<Integer>
				errInfo.msg = "Arrays of collection types are not supported by java. Declare this type without type arguments, e.g. java.util.HashMap instead of java.util.HashMap<Integer,String>.";
				throw new GeneratorException(errInfo);
			}
			
			SerialInfo sinfo = classDB.createSerialInfo(tinfo.name, null, tinfo.qname, null, 
					tinfo.dims, tinfo.typeArgs, null, tinfo.isEnum, tinfo.isFinal, tinfo.isInline);
			classDB.add(sinfo);
		}
		
		// Walk recursively though the type arguments
		for (TypeInfo argInfo : tinfo.typeArgs) {
			makeSerialInfoForCollectionType(errInfo, argInfo);
		}

		log.debug(")makeSerialInfoForCollectionType");
	}
	
	private boolean doesImplement(ClassDoc cls, String interfaceQname) {
		log.debug("doesImplement(" + cls + ","+ interfaceQname);
		boolean ret = cls.qualifiedTypeName().equals(interfaceQname);
		if (!ret) {
			ClassDoc[] interfaces = cls.interfaces();
			if (interfaces != null) {
				for (ClassDoc ifc : interfaces) {
					ret = doesImplement(ifc, interfaceQname);
					if (ret) break;
				}
			}
			if (!ret) {
				ClassDoc superclass = cls.superclass();
				if (superclass != null) {
					ret = doesImplement(superclass, interfaceQname);
				}
			}
		}
		
		log.debug(")doesImplement");
		return ret;
	}
	
	private List<TypeInfo> getParameterizedTypeArgs(ErrorInfo errInfo, ParameterizedType ptype, String errorContext) throws GeneratorException {
		errInfo = errInfo.copy();
		List<TypeInfo> argInfos = null;
		if (ptype != null) {
			Type[] targs = ptype.typeArguments();
			argInfos = new ArrayList<TypeInfo>(targs.length);
			for (int i = 0; i < targs.length; i++) {
				errInfo.typeArg = "<" + targs[i] + ">";
				argInfos.add( makeElementTypeInfo(errInfo, targs[i], errorContext) );
			}
		}
		return argInfos;
	}
	
	private TypeInfo makeElementTypeInfo(ErrorInfo errInfo, Type type, String errorContext) throws GeneratorException {
		errInfo = errInfo.copy();
		
		if (type == null) return null;
		
		TypeInfo tinfo = null;

		WildcardType wtype = type.asWildcardType();
		
		String qname = type.qualifiedTypeName();
		if (wtype != null) {

			// Wildcard Parameter machen keinen Sinn.
			// Die Elemente werden sowohl als Konsument als auch als Produzent verwendet.
			// http://www.torsten-horn.de/techdocs/java-generics.htm#Wildcard-extends-versus-T-extends
			errInfo.msg = "Wildcard parameter types are unsupported, please replace type=\"" + type +"\" by \"Object\".";
			throw new GeneratorException(errInfo);
			
		}
		else {
			ParameterizedType ptype = type.asParameterizedType();
			List<TypeInfo> argInfos = getParameterizedTypeArgs(errInfo, ptype, errorContext);
			
			ClassDoc cls = type.asClassDoc();
			boolean isEnum = false;
			boolean isInline = false; 
			boolean isFinal = false;
			
			if (cls != null) {
				isEnum = cls.isEnum() || cls.isEnumConstant();
				isInline = isInline(cls);
				isFinal = cls.isFinal();
			}
			
			tinfo = classDB.createTypeInfo(
					type.simpleTypeName(),
					qname,
					type.dimension(),
					argInfos,
					isEnum, 
					isFinal, 
					isInline);
			
			
			
//			if (tinfo.isSetType()) {
//				TypeInfo targ = tinfo.typeArgs.get(0);
//				if ( targ.isInline && !targ.isArrayType()) {
//					// Das geht nicht in C++. Ich müsste einen operator < definieren.
//					throw new GeneratorException(errInfo + ": Inline classes cannot be used as elements of sets.");
//				}
//			}
			
			makeSerialInfoForCollectionType(errInfo, tinfo);
		}
		

		return tinfo;
	}
	
	private MemberInfo makeMemberInfo(ErrorInfo errInfo, FieldDoc field, String errorContext) throws GeneratorException {
		errInfo = errInfo.copy();
		
		String name = field.name();
		if (FORBIDDEN_FIELD_NAMES.contains(name)) {
			errInfo.fieldName = name;
			errInfo.msg = "Forbidden field name";
			throw new GeneratorException(errInfo);
		}
		
		ArrayList<CommentInfo> cinfos = new ArrayList<CommentInfo>();
		addSummaryAndRemarksCommentInfo(field, cinfos);
		
		errInfo.fieldName = name;
		TypeInfo type = makeElementTypeInfo(errInfo, field.type(), errorContext + "." + name);
		
		long since = getSince(errInfo, field.tags());
		
		// Constant or Enum?
		String value = null;
		if (((field.isFinal() && field.isStatic()) || field.isEnumConstant())) {
			ClassDoc cls = field.containingClass();
			TypeInfo ctype = new TypeInfo(cls.name(), cls.qualifiedName(), "", null, field.isEnumConstant(), false, false);
			Object valueObj = classDB.fieldReader.getValue(ctype, name);
			if (valueObj != null) {
				if (field.isEnumConstant()) {
					Enum<?> en = (Enum<?>)valueObj;
					value = Integer.toString(en.ordinal());  
				}
				else {
					value = serializeObjectToJson(errInfo, valueObj);
				}
			}
			else if (type.isStringType() && type.dims.length() == 0) {
				value = "";
			}
		}
		
		MemberInfo minfo = new MemberInfo(name, cinfos, type, 
				field.isPublic(), field.isProtected(), field.isPackagePrivate(), field.isPrivate(), 
				field.isFinal(), field.isStatic(), field.isTransient(),
				since, value);
		
		return minfo;
	}
	
	private String serializeFieldsToJson(ErrorInfo errInfo, Object value) {
		errInfo = errInfo.copy();
		StringBuilder sbuf = new StringBuilder();
		boolean addComma = false;
		Class<?> clazz = value.getClass();
		for (java.lang.reflect.Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			try {
				field.get(null);
			} catch (Exception e) {
				try {
					Object fieldValue = field.get(value);
					if (fieldValue != null) {
						if (addComma) sbuf.append(","); else addComma = true;
						sbuf.append("\"").append(field.getName()).append("\":");
						errInfo.fieldName = field.getName();
						sbuf.append(serializeObjectToJson(errInfo, fieldValue));
					}
					else {
						Class<?> fclazz = field.getType();
						if (fclazz.getName().equals("java.lang.String")) {
							if (addComma) sbuf.append(","); else addComma = true;
							sbuf.append("\"").append(field.getName()).append("\":\"\"");
						}
					}
				}
				catch (Exception e2) {}
			}
		}
		return sbuf.toString();
	}
	
	private String serializeObjectToJson(ErrorInfo errInfo, Object value) throws GeneratorException {
		errInfo = errInfo.copy();
		
		StringBuilder sbuf = new StringBuilder();
		Class<?> clazz = value.getClass();
		if (clazz.isArray()) {
			sbuf.append("[");
			for (int i = 0; i < Array.getLength(value); i++) {
				if (i != 0) sbuf.append(",");
				Object elm = Array.get(value, i);
				sbuf.append(serializeObjectToJson(errInfo, elm));
			}
			sbuf.append("]");
		}
		else if (clazz == Character.class) {
			int ch = (Character)value;
			if (!Character.isDefined(ch)) {
				errInfo.msg = "Invalid unicode character";
				throw new GeneratorException(errInfo);
			}
			sbuf.append("\"").append(value).append("\"");
		}
		else if (clazz == String.class) {
			sbuf.append("\"").append(value).append("\"");
		}
		else if (clazz.getName().startsWith("java.lang.")) {
			sbuf.append(value);
		}
		else {
			sbuf.append("{").append(serializeFieldsToJson(errInfo, value)).append("}");
		}
		return sbuf.toString();
	}

	private MemberInfo makeMethodParamInfo(ErrorInfo errInfo, Parameter param, String errorContext) throws GeneratorException {
		errInfo = errInfo.copy();
		String name = param.name();
		errInfo.paramName = name;
		TypeInfo tinfo = makeElementTypeInfo(errInfo, param.type(), errorContext + " parameter " + name);
		MemberInfo pinfo = new MemberInfo(name, tinfo);
		return pinfo;
	}
	
	private SerialInfo makeSerialInfo(ClassDoc cls) throws GeneratorException {
		log.debug("makeSerialInfo(" + cls);
		String name = cls.simpleTypeName();
		String qname = cls.qualifiedTypeName();

		ErrorInfo errInfo = new ErrorInfo();
		errInfo.className = qname;
		
		ArrayList<CommentInfo> commentInfos = new ArrayList<CommentInfo>();
		addSummaryAndRemarksCommentInfo(cls, commentInfos);

		ArrayList<MemberInfo> members = new ArrayList<MemberInfo>(cls.fields().length);
		for (FieldDoc field : cls.fields()) {
			
//			if (field.isFinal() || field.isStatic()) {
//				log.debug("skip final or static field: " + field);
//				continue;
//			}
			
			if (field.name().equals("serialVersionUID")) continue;
			
			errInfo.fieldName = field.name();
			checkSupportedFieldType(errInfo, field.type());
			
			MemberInfo minfo = makeMemberInfo(errInfo, field, qname);
			if (minfo == null) continue;
			
			members.add(minfo);
			
		}
		
		if (cls.isEnum()) {
			for (FieldDoc field : cls.enumConstants()) {
				MemberInfo minfo = makeMemberInfo(errInfo, field, qname);
				if (minfo == null) continue;
				
				members.add(minfo);
			}
		}
		
		List<TypeInfo> argInfos = getParameterizedTypeArgs(errInfo, cls.asParameterizedType(), qname);
		
		ClassDoc baseClass = cls.superclass();
		String baseQname = "";
		if (baseClass != null && 
			!baseClass.qualifiedName().equals("java.lang.Object") && 
			!baseClass.qualifiedName().equals("java.lang.Enum")) {
			
			baseQname = baseClass.qualifiedName();
			
			if (baseQname.equals("java.lang.Throwable")) {
				log.warn("Class \"" + qname + "\": " +
						"Exception classes must inherit from java.lang.Exception instead of java.lang.Throwable. " +
						"Assuming base class java.lang.Exception for serialization.");
				baseQname = "java.lang.Exception";
			}
		}
		
		boolean isInline = isInline(cls);
		
		SerialInfo sinfo = classDB.createSerialInfo(name, commentInfos, qname, baseQname, "", argInfos, 
				members, cls.isEnum(), cls.isFinal(), isInline);
		classDB.add(sinfo);
		
		log.debug(")makeSerialInfo");
		return sinfo;
	}
	
	private void checkSupportedFieldType(ErrorInfo errInfo, Type type) throws GeneratorException {
		errInfo = errInfo.copy();
		
		// Do not use reference types of primitives, e.g. java.lang.Integer.
		// This primitive types cannot be null in all languages, e.g. in C++;
		String qname = type.qualifiedTypeName();
		TypeInfo tinfo = new TypeInfo(type.simpleTypeName(), qname, type.dimension(), null, false, false, false);
		if (qname.startsWith("java.lang.") && 
			tinfo.isPrimitiveType() && 
			!qname.equals("java.lang.String")) {
			
			errInfo.msg = "Reference types of primitives cannot be used as class members" +
					" or function parameters or return values. " + 
					"Please use the primitive type. " +
					"Example: use \"int\" instead of \"Integer\".";
			throw new GeneratorException(errInfo);
		}
	}

	private long getSince(ErrorInfo errInfo, Tag[] tags) throws GeneratorException {
		errInfo = errInfo.copy();
		long n = 0;
		for (Tag t : tags) {
			String tkind = t.kind();
			String ttext = t.text();
			if (tkind.equals("@since") && ttext != null & ttext.length() != 0) {
				n = BVersioning.stringToLong(ttext);
				break;
			}
		}
		return n;
	}
	
	private boolean isInline(ClassDoc clazz) {
		Tag[] tags = clazz.tags("@inline");
		return tags != null && tags.length != 0;
	}
	
	private CommentInfo makeCommentInfo(String kind, String text) {
		CommentInfo cinfo = new CommentInfo(kind, text);
		return cinfo;
	}
	
	private String concatTags(Tag[] tags) {
		String stext = "";
		if (tags != null && tags.length != 0) {
			for (Tag t : tags) {
				if (!t.kind().equals("Text")) {
					stext += "{" + t.name() + " " + t.text() + "}";
				}
				else {
					stext += t.text();
				}
			}
		}
		return stext;
	}
	
	private void addSummaryAndRemarksCommentInfo(Doc doc, ArrayList<CommentInfo> cinfos) {
		String summaryText = concatTags(doc.firstSentenceTags());
		String totalText = concatTags(doc.inlineTags());
		String remarksText = "";
		if (totalText.length() > summaryText.length()) {
			remarksText = totalText.substring(summaryText.length()).trim();
		}
		if (summaryText.length() != 0) {
			cinfos.add(makeCommentInfo(CommentInfo.KIND_SUMMARY, summaryText));
		}
		if (remarksText.length() != 0) {
			cinfos.add(makeCommentInfo(CommentInfo.KIND_REMARKS, remarksText));
		}
		for (Tag tag : doc.tags()) {
			cinfos.add(makeCommentInfo(tag.kind(), tag.text()));
		}
	}
	
	private SerialInfo makeMethodRequest(ErrorInfo errInfo, String remoteName, String remoteQName, MethodDoc method) throws GeneratorException {
		errInfo = errInfo.copy();
		ArrayList<MemberInfo> pinfos = new ArrayList<MemberInfo>(method.parameters().length);
		Parameter[] params = method.parameters();
		errInfo.methodName = method.name();
		for (int i = 0; i < params.length; i++) {
			Parameter param = params[i];
			MemberInfo pinfo = makeMethodParamInfo(errInfo, param, remoteQName);
			errInfo.methodName = method.name();
			errInfo.paramName = param.name();
			checkSupportedFieldType(errInfo, param.type());
			
			if (pinfo.type.isInline && !pinfo.type.isArrayType()) {
				// Das geht nicht in C++
				errInfo.msg = "Inline classes cannot be used as method parameters.";
				throw new GeneratorException(errInfo);
			}
			
			pinfos.add(pinfo);
		}
		
		String methodName = MethodInfo.METHOD_REQUEST_NAME_PREFIX + remoteName + "_" + method.name();
		String remotePack = remoteQName.substring(0, remoteQName.lastIndexOf(".")+1);
		String methodQName = remotePack + MethodInfo.METHOD_REQUEST_NAME_PREFIX + remoteName + "_" + method.name();
		
		SerialInfo requestInfo = classDB.createSerialInfo(
				methodName, 
				null, 
				methodQName, 
				null, 
				"", 
				null, 
				pinfos,
				false, // isEnum
				true, // isFinal
				false // inlineInstance
				);
		classDB.add(requestInfo);
		
		return requestInfo;
	}

	private SerialInfo makeMethodResult(ErrorInfo errInfo, String remoteName, String remoteQName, MethodDoc method) throws GeneratorException {
		errInfo = errInfo.copy();
		ArrayList<MemberInfo> rinfos = new ArrayList<MemberInfo>(2);
				
		Type rtype = method.returnType();
		errInfo.methodName = method.name();
		errInfo.fieldName = "return";
		checkSupportedFieldType(errInfo, rtype);
		
		errInfo.methodName = method.name();
		
		TypeInfo resultType = makeElementTypeInfo(errInfo, rtype, remoteQName);
		resultType.typeId = classDB.getOrCreateTypeId(resultType);
		
		if (resultType.isInline && !resultType.isArrayType()) {
			// Das geht nicht in C++
			errInfo.msg = "Inline classes cannot be used as return values.";
			throw new GeneratorException(errInfo);
		}
		
		rinfos.add( new MemberInfo("result", null, resultType, true, false, false, false, false, false, false, 0, null) );
		
		//String remotePack = remoteQName.substring(0, remoteQName.lastIndexOf(".")+1);
		
		String remotePack = classDB.getApiDescriptor().basePackage + ".";
		
		String methodName = MethodInfo.METHOD_RESULT_NAME_PREFIX + resultType.typeId;
//		String methodName = MethodInfo.METHOD_RESULT_NAME_PREFIX + remoteName + "_" + method.name();

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
					false // inlineInstance
					);
			classDB.add(resultInfo);
		}
		
		return resultInfo;
	}	

	private MethodInfo makeMethodInfo(ErrorInfo errInfo, String remoteName, String remoteQName, MethodDoc method) throws GeneratorException {
		errInfo = errInfo.copy();
		ArrayList<CommentInfo> cinfos = new ArrayList<CommentInfo>();
		addSummaryAndRemarksCommentInfo(method, cinfos);
		
		errInfo.methodName = method.name();
		
		SerialInfo requestInfo = makeMethodRequest(errInfo, remoteName, remoteQName, method);

		SerialInfo resultInfo = makeMethodResult(errInfo, remoteName, remoteQName, method);
				
		boolean foundBException = false;
		ArrayList<TypeInfo> exceptions = new ArrayList<TypeInfo>();
		
		for (Type ex : method.thrownExceptionTypes()) {
			if (ex.simpleTypeName().equals(BException.class.getSimpleName())) {
				foundBException = true; 
				continue;
			}
			if (ex.simpleTypeName().equals(RemoteException.class.getSimpleName())) {
				foundBException = true; 
				continue;
			}
			
			// Currently, I don't know how to deal with custom exception classes in C++
			errInfo.msg = "Custom exception classes are unsupported. Methods must throw com.wilutions.byps.RemoteException.";
			throw new GeneratorException(errInfo);

//			if (!isSerializable(ex.asClassDoc())) {
//				throw new GeneratorException("Custom exception class \"" + ex.toString() + "\" must implement BSerializable.");
//			}
//			
//			TypeInfo exInfo = makeElementTypeInfo(ex, remoteQName);
//			exceptions.add( exInfo );
		}
		
		if (!foundBException) {
			errInfo.msg = "Method must throw BException";
			throw new GeneratorException(errInfo);
		}
		
		MethodInfo minfo = new MethodInfo(
				method.name(), cinfos, 
				requestInfo, resultInfo, 
				exceptions); 
		
		return minfo;
	}
	
	private RemoteInfo makeRemoteInfo(ClassDoc cls) throws GeneratorException {
		String name = cls.simpleTypeName();
		String qname = cls.qualifiedTypeName();
		ErrorInfo errInfo = new ErrorInfo();
		errInfo.className = qname;

		ClassDoc baseClass = cls.superclass();
		if (baseClass != null) {
			errInfo.msg = "Inheritance of Remote interfaces is not supported.";
		}

		ArrayList<CommentInfo> cinfos = new ArrayList<CommentInfo>();
		addSummaryAndRemarksCommentInfo(cls, cinfos);

		ArrayList<MethodInfo> minfos = new ArrayList<MethodInfo>(cls.methods().length);
		
		for (MethodDoc method : cls.methods()) {
			MethodInfo minfo = makeMethodInfo(errInfo, name, qname, method);
			minfos.add(minfo);
		}

		String authParamClassName = null;
		String authInterface = null;
		boolean isClientRemote = false;
    for (Tag tag : cls.tags()) {
      if (tag.kind().equals("@BSessionParamType")) authParamClassName= tag.text();
      if (tag.kind().equals("@BAuthinterface")) authInterface= tag.text();
      if (tag.kind().equals("@BClientRemote")) isClientRemote = true; 
      
      cinfos.add(makeCommentInfo(tag.kind(), tag.text()));
    }
		
		RemoteInfo rinfo = classDB.createRemoteInfo(name, cinfos, qname, minfos, authParamClassName, authInterface, isClientRemote);
		
		classDB.createStubForRemote(rinfo);

		return rinfo;
	}
	
	private void checkSupportedCollectionType(ErrorInfo errInfo, TypeInfo tinfo) throws GeneratorException {
		errInfo = errInfo.copy();
		int p = tinfo.qname.indexOf('<');
		String qname = p >= 0 ? tinfo.qname.substring(0, p) : tinfo.qname;
		if (!supportedCollections.contains(qname)) {
			StringBuilder msg = new StringBuilder();
			msg.append("Unsupported collection type. ");
			msg.append("Please use one of this types: ").append(supportedCollections).append(", ");
			msg.append("e.g. List<Map<Integer,Set<String>>>.");
			errInfo.msg = msg.toString();
			throw new GeneratorException(errInfo);
		}
	}
	
	private final static HashSet<String> supportedCollections = new HashSet<String>(Arrays.asList(
			"java.util.List", "java.util.ArrayList", 
			// LinkedList wird nicht unterstützt, weil wir in JSON-Serializierung über den Index auf die Elemente zugreifen
			"java.util.Map", "java.util.HashMap", "java.util.TreeMap",
			"java.util.Set", "java.util.HashSet", "java.util.TreeSet"));

	private static Log log = LogFactory.getLog(BConvert.class);
	
	private final int options;
}
