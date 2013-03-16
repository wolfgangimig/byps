package com.wilutions.byps.gen.doclet;

import java.io.IOException;
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
import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.BException;
import com.wilutions.byps.BRemote;
import java.io.Serializable;
import com.wilutions.byps.gen.api.CommentInfo;
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
			String msg = "No API descriptor found. Missing class BApi.";
			log.error(msg);
			throw new GeneratorException(msg);
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
					throw new GeneratorException("Class \"" + c.qualifiedName() + "\" must be either a Remote or a Serializable.");
				}
				makeRemoteInfo(c);
				continue;
			}

			if (isSerializable(c)) {
				makeSerialInfo(c);
				continue;
			}
			
			log.info("Skip class " + c.qualifiedName() + ", neither Remote nor Serializable. Either implement com.wilutions.byps.BRemote or java.io.Serializable. Or tag with @BRemote or @BSerializable");
		}

		log.info("Assign type IDs -------------------");
		
		classDB.assignTypeIds();
		
		log.debug(")makeClassDB");
		return classDB;
	}

	private boolean isRemote(ClassDoc c) {
		
		boolean doesImplementBRemote = doesImplement(c, BRemote.class.getName(), "BRemote");
		log.debug("does implement BRemote: " + doesImplementBRemote);
		if (doesImplementBRemote) return doesImplementBRemote;
		
		return false;
	}
	
	private boolean isSerializable(ClassDoc c) {
		
		boolean doesImplementSerializable = doesImplement(c, Serializable.class.getName(), "Serializable");
		log.debug("does implement Serializable: " + doesImplementSerializable);
		if (doesImplementSerializable) return true;

		return false;
	}
	
	private BApiDescriptor makeApiDescriptor(ClassDoc c, ConstFieldReader constReader) throws GeneratorException {
		log.debug("makeApiDescriptor(" + c.qualifiedName());
		
		BApiDescriptor apiDesc = classDB.getApiDescriptor();
		if (apiDesc != null) {
			throw new GeneratorException("Duplicate API descriptor: first=" + apiDesc.basePackage + ", second=" + c.containingPackage());
		}
		
		try {
			PackageDoc pack = c.containingPackage();
			log.debug("api-package=" + pack);
			
			TypeInfo tinfo = new TypeInfo(c.simpleTypeName(), c.qualifiedTypeName(), "", null, false, false, false);
			String name = (String)constReader.getValue(tinfo,  "NAME");
			log.debug("api-name=" + name);
			if (name == null) throw new GeneratorException("Missing \"public final static String NAME = ...\" in " + c);
			Integer version = (Integer)constReader.getValue(tinfo, "VERSION");
			if (version == null) throw new GeneratorException("Missing \"public final static int VERSION = ...\" in " + c);
			log.debug("api-version=" + version);
			Boolean uniqueObjects = (Boolean)constReader.getValue(tinfo,  "UNIQUE_OBJECTS");
			if (uniqueObjects == null) uniqueObjects = Boolean.FALSE;
			String bmodelStr = (String)constReader.getValue(tinfo,  "BINARY_MODEL");
			if (bmodelStr == null) bmodelStr = "MEDIUM";
			BBinaryModel bmodel = BBinaryModel.fromString(bmodelStr);
			
			apiDesc = new BApiDescriptor(name, pack.toString(), bmodel, version, uniqueObjects, "", null);
			classDB.setApiDescriptor(apiDesc);

		}
		catch (GeneratorException e) {
			String msg = "Error in class " + c.qualifiedName() + ": " + e.getMessage();
			throw new GeneratorException(msg);
		}
		
		log.debug(")makeApiDescriptor=" + apiDesc);
		return apiDesc;
	}

	private void makeSerialInfoForCollectionType(TypeInfo tinfo, String errorContext) throws GeneratorException {
		log.debug("makeSerialInfoForCollectionType(" + tinfo);
		
		// Create SerialInfo for List and Map and Set
		log.debug("isCollectionType=" + tinfo.isCollectionType());
		if (tinfo.isCollectionType()) {
			
			checkSupportedCollectionType(tinfo);

			// List, ArrayList, LinkedList ohne Argumenttype?
			if (tinfo.typeArgs.size() == 0) {
				throw new GeneratorException("Missing argument types in " + errorContext);
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
					throw new GeneratorException(errorContext + 
							": Map types must be specified with a key type of Boolean, Byte, Short, Integer, Long, Float, Double or String. " + 
							" The given key type " + tinfo.typeArgs.get(0) + " is not supported.");
				}
			}
			
			SerialInfo serInfo = classDB.createSerialInfo(tinfo.name, null, tinfo.qname, null, "", tinfo.typeArgs,
					null, tinfo.isEnum, false, false);
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
				
				throw new GeneratorException(tinfo + ": Arrays of collection types are not supported by java. Declare this type without type arguments, e.g. java.util.HashMap instead of java.util.HashMap<Integer,String>.");
			}
			
			SerialInfo sinfo = classDB.createSerialInfo(tinfo.name, null, tinfo.qname, null, 
					tinfo.dims, tinfo.typeArgs, null, tinfo.isEnum, false, false);
			classDB.add(sinfo);
		}
		
		// Walk recursively though the type arguments
		for (TypeInfo argInfo : tinfo.typeArgs) {
			makeSerialInfoForCollectionType(argInfo, errorContext);
		}

		log.debug(")makeSerialInfoForCollectionType");
	}

	private void makeSerialInfoForMembersOfCollectionTypes(List<MemberInfo> minfos, String errorContext) throws GeneratorException {
		for (MemberInfo minfo : minfos) {
			makeSerialInfoForCollectionType(minfo.type, errorContext + "." + minfo.name);
		}
	}
	
	private boolean doesImplement(ClassDoc cls, String interfaceQname, String tagName) {
		log.debug("doesImplement(" + cls + ","+ interfaceQname);
		boolean ret = cls.qualifiedTypeName().equals(interfaceQname);
		if (!ret) {
			ClassDoc[] interfaces = cls.interfaces();
			if (interfaces != null) {
				for (ClassDoc ifc : interfaces) {
					ret = doesImplement(ifc, interfaceQname, tagName);
					if (ret) break;
				}
			}
			if (!ret) {
				ClassDoc superclass = cls.superclass();
				if (superclass != null) {
					ret = doesImplement(superclass, interfaceQname, tagName);
				}
			}
		}
		
		log.debug(")doesImplement");
		return ret;
	}
	
	private List<TypeInfo> getParameterizedTypeArgs(ParameterizedType ptype, String errorContext) throws GeneratorException {
		List<TypeInfo> argInfos = null;
		if (ptype != null) {
			Type[] targs = ptype.typeArguments();
			argInfos = new ArrayList<TypeInfo>(targs.length);
			for (int i = 0; i < targs.length; i++) {
				argInfos.add( makeElementTypeInfo(targs[i], errorContext) );
			}
		}
		return argInfos;
	}
	
	private TypeInfo makeElementTypeInfo(Type type, String errorContext) throws GeneratorException {
		
		if (type == null) return null;
		
		TypeInfo tinfo = null;

		WildcardType wtype = type.asWildcardType();
		
		String qname = type.qualifiedTypeName();
		if (wtype != null) {

			// Wildcard Parameter machen keinen Sinn.
			// Die Elemente werden sowohl als Konsument als auch als Produzent verwendet.
			// http://www.torsten-horn.de/techdocs/java-generics.htm#Wildcard-extends-versus-T-extends
			String msg = errorContext + ": Wildcard parameter types are unsupported, please replace type=\"" + type +"\" by \"Object\".";
			throw new GeneratorException(msg);
			
		}
		else {
			ParameterizedType ptype = type.asParameterizedType();
			List<TypeInfo> argInfos = getParameterizedTypeArgs(ptype, errorContext);
			
			// Es dürfte zum Aufstellen der classDB hier nur der Klassenname des Elements von Bedeutung sein.
			// Die Klasse wird auch als Serializable in der Hauptschleife gefunden. Dort sind alle Eigenschaften
			// - insbes. isInline - ermittelbar.
//			ClassDoc cls = type.asClassDoc();
//			boolean isEnum = false;
//			boolean inlineInstance = false;
//
//			if (cls != null) {
//				isEnum = cls.isEnum() || cls.isEnumConstant();
//				inlineInstance = cls.isFinal() && type.dimension().length() == 0; // cls.dimenstion is without [][][]...
//			}

			tinfo = classDB.createTypeInfo(
					type.simpleTypeName(),
					qname,
					type.dimension(),
					argInfos,
					false, false, false);
		}
		

		return tinfo;
	}
	
	private MemberInfo makeMemberInfo(FieldDoc field, String errorContext) throws GeneratorException {
		String name = field.name();
		if (FORBIDDEN_FIELD_NAMES.contains(name)) {
			throw new GeneratorException("Forbidden field name " + name + " in " + errorContext);
		}
		
		ArrayList<CommentInfo> cinfos = new ArrayList<CommentInfo>();
		addSummaryAndRemarksCommentInfo(field, cinfos);
		addTagCommentInfos(field.tags(), cinfos);
		
		TypeInfo type = makeElementTypeInfo(field.type(), errorContext + "." + name);
		
		int since = getSince(field.tags());
		
		// Constant or Enum?
		String value = null;
		if ((field.isFinal() && field.isStatic() || field.isEnumConstant())) {
			ClassDoc cls = field.containingClass();
			TypeInfo ctype = new TypeInfo(cls.name(), cls.qualifiedName(), "", null, field.isEnumConstant(), false, false);
			Object valueObj = classDB.fieldReader.getValue(ctype, name);
			if (valueObj != null) {
				if (field.isEnumConstant()) {
					Enum<?> en = (Enum<?>)valueObj;
					value = Integer.toString(en.ordinal());  
				}
				else {
					value = serializeObjectToJson(valueObj);
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
	
	private String serializeFieldsToJson(Object value) {
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
						sbuf.append(serializeObjectToJson(fieldValue));
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
	
	private String serializeObjectToJson(Object value) {
		StringBuilder sbuf = new StringBuilder();
		Class<?> clazz = value.getClass();
		if (clazz.isArray()) {
			sbuf.append("[");
			for (int i = 0; i < Array.getLength(value); i++) {
				if (i != 0) sbuf.append(",");
				Object elm = Array.get(value, i);
				sbuf.append(serializeObjectToJson(elm));
			}
			sbuf.append("]");
		}
		else if (clazz == Character.class) {
			sbuf.append("\"").append(value).append("\"");
		}
		else if (clazz == String.class) {
			sbuf.append("\"").append(value).append("\"");
		}
		else if (clazz.getName().startsWith("java.lang.")) {
			sbuf.append(value);
		}
		else {
			sbuf.append("{").append(serializeFieldsToJson(value)).append("}");
		}
		return sbuf.toString();
	}

	private MemberInfo makeMethodParamInfo(Parameter param, String errorContext) throws GeneratorException {
		String name = param.name();
		TypeInfo tinfo = makeElementTypeInfo(param.type(), errorContext + " parameter " + name);
		MemberInfo pinfo = new MemberInfo(name, tinfo);
		return pinfo;
	}
	
	private void makeSerialInfo(ClassDoc cls) throws GeneratorException {
		log.debug("makeSerialInfo(" + cls);
		String name = cls.simpleTypeName();
		String qname = cls.qualifiedTypeName();
				
		ArrayList<CommentInfo> commentInfos = new ArrayList<CommentInfo>();
		addSummaryAndRemarksCommentInfo(cls, commentInfos);
		addTagCommentInfos(cls.tags(), commentInfos);

		ArrayList<MemberInfo> members = new ArrayList<MemberInfo>(cls.fields().length);
		for (FieldDoc field : cls.fields()) {
			
//			if (field.isFinal() || field.isStatic()) {
//				log.debug("skip final or static field: " + field);
//				continue;
//			}
			
			if (field.name().equals("serialVersionUID")) continue;
			
			checkSupportedFieldType(field.toString(), field.type());
			
			MemberInfo minfo = makeMemberInfo(field, qname);
			if (minfo == null) continue;
			
			members.add(minfo);
			
		}
		
		if (cls.isEnum()) {
			for (FieldDoc field : cls.enumConstants()) {
				MemberInfo minfo = makeMemberInfo(field, qname);
				if (minfo == null) continue;
				
				members.add(minfo);
			}
		}
		
		List<TypeInfo> argInfos = getParameterizedTypeArgs(cls.asParameterizedType(), qname);
		
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
		
		makeSerialInfoForMembersOfCollectionTypes(sinfo.members, qname);
		
		log.debug(")makeSerialInfo");
	}
	
	private void checkSupportedFieldType(String name, Type type) throws GeneratorException {
		// Do not use reference types of primitives, e.g. java.lang.Integer.
		// This primitive types cannot be null in all languages, e.g. in C++;
		String qname = type.qualifiedTypeName();
		TypeInfo tinfo = new TypeInfo(type.simpleTypeName(), qname, type.dimension(), null, false, false, false);
		if (qname.startsWith("java.lang.") && 
			tinfo.isPrimitiveType() && 
			!qname.equals("java.lang.String")) {
			String msg = name + ": reference types of primitives cannot be used as class members" +
					" or function parameters or return values. " + 
					"Please use the primitive type. " +
					"Example: use \"int\" instead of \"Integer\".";
			throw new GeneratorException(msg);
		}
	}

	private void addTagCommentInfos(Tag[] tags, ArrayList<CommentInfo> cinfos) {
		for (Tag t : tags) {
			String tkind = t.kind();
			if (tkind.equals("@inline")) continue;
			String ttext = t.text();
			CommentInfo cinfo = makeCommentInfo(tkind, ttext);
			cinfos.add(cinfo);	
		}
	}
	
	private int getSince(Tag[] tags) throws GeneratorException {
		int n = 0;
		for (Tag t : tags) {
			String tkind = t.kind();
			String ttext = t.text();
			if (tkind.equals("@since") && ttext != null & ttext.length() != 0) {
				n = stringVersionToInt(ttext);
				break;
			}
		}
		return n;
	}
	
	private boolean isInline(ClassDoc clazz) {
		Tag[] tags = clazz.tags("@inline");
		return tags != null && tags.length != 0;
	}
	
	/**
	 * Converts the string representation of a version number into an Integer.
	 * The string representation follows the format +9.+9.+9.++9. Whereby
	 * 9 is a placeholder for a digit and + is either nothing or a digit.
	 * Each section between the dots can have up to 2 digits, except
	 * the last section which can have at most 3 digits.
	 * Example: the version string "12.3.45.67" is converted into the Integer
	 * 120345067. 
	 * @param strVer Version number in String format.
	 * @return Version number in Integer format.
	 * @throws GeneratorException 
	 */
	protected int stringVersionToInt(String strVer) throws GeneratorException {
		int n = 0;
		String[] versionNumbers = strVer.split("\\.");
		for (int i = 0; i < versionNumbers.length; i++) {
			String s = versionNumbers[i];
			int n1 = Integer.parseInt(s);
			if (i == versionNumbers.length-1 ||
				i == versionNumbers.length-2) {
				if (n1 >= 1000) {
					throw new GeneratorException("Last version number part must be less than 1000");
				}
				n *= 1000;
			}
			else {
				if (n1 >= 100) {
					throw new GeneratorException("Last version number part must be less than 1000");
				}
				n *= 100;
			}
			n += n1;
		}
		return n;
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
	
	private SerialInfo makeMethodRequest(String remoteName, String remoteQName, MethodDoc method) throws GeneratorException {
		ArrayList<MemberInfo> pinfos = new ArrayList<MemberInfo>(method.parameters().length);
		Parameter[] params = method.parameters();
		for (int i = 0; i < params.length; i++) {
			Parameter param = params[i];
			MemberInfo pinfo = makeMethodParamInfo(param, remoteQName);
			checkSupportedFieldType(method.qualifiedName() + ("(...") + param.name() + ("...)"), param.type());
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

	private SerialInfo makeMethodResult(String remoteName, String remoteQName, MethodDoc method) throws GeneratorException {

		ArrayList<MemberInfo> rinfos = new ArrayList<MemberInfo>(2);
		
		Type rtype = method.returnType();
		checkSupportedFieldType(method.qualifiedName() + ("(return)"), rtype);

		TypeInfo rinfo = makeElementTypeInfo(rtype, remoteQName);
		rinfos.add( new MemberInfo("result", null, rinfo, true, false, false, false, false, false, false, 0, null) );
		
		String methodName = MethodInfo.METHOD_RESULT_NAME_PREFIX + remoteName + "_" + method.name();
		String remotePack = remoteQName.substring(0, remoteQName.lastIndexOf(".")+1);
		String methodQName = remotePack + MethodInfo.METHOD_RESULT_NAME_PREFIX + remoteName + "_" + method.name();
		
		SerialInfo resultInfo = classDB.createSerialInfo(
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

		return resultInfo;
	}	

	private MethodInfo makeMethodInfo(String remoteName, String remoteQName, MethodDoc method) throws GeneratorException {
		
		ArrayList<CommentInfo> cinfos = new ArrayList<CommentInfo>();
		addSummaryAndRemarksCommentInfo(method, cinfos);
		addTagCommentInfos(method.tags(), cinfos);
		
		SerialInfo requestInfo = makeMethodRequest(remoteName, remoteQName, method);
		makeSerialInfoForMembersOfCollectionTypes(requestInfo.members, method + ", parameter ");

		SerialInfo resultInfo = makeMethodResult(remoteName, remoteQName, method);
		makeSerialInfoForMembersOfCollectionTypes(resultInfo.members, method + ", return value ");
				
		boolean foundBException = false;
		boolean foundInterruptedException = false;
		ArrayList<TypeInfo> exceptions = new ArrayList<TypeInfo>();
		
		for (Type ex : method.thrownExceptionTypes()) {
			if (ex.toString().equals(InterruptedException.class.getName())) {
				foundInterruptedException = true;
				continue;
			}
			if (ex.toString().equals(BException.class.getName())) {
				foundBException = true; 
				continue;
			}
			if (ex.toString().equals(IOException.class.getName())) continue;
			
			if (!isSerializable(ex.asClassDoc())) {
				throw new GeneratorException("Custom exception class \"" + ex.toString() + "\" must implement BSerializable.");
			}
			
			TypeInfo exInfo = makeElementTypeInfo(ex, remoteQName);
			exceptions.add( exInfo );
		}
		
		if (!foundBException) {
			throw new GeneratorException("Method " + remoteQName + "." + method.name() + " must throw BException");
		}
		
		if (!foundInterruptedException) {
			throw new GeneratorException("Method " + remoteQName + "." + method.name() + " must throw InterruptedException");
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

		ClassDoc baseClass = cls.superclass();
		if (baseClass != null) {
			throw new GeneratorException(qname + ": inheritance of Remote interfaces is not supported.");
		}

		ArrayList<CommentInfo> cinfos = new ArrayList<CommentInfo>();
		addSummaryAndRemarksCommentInfo(cls, cinfos);

		ArrayList<MethodInfo> minfos = new ArrayList<MethodInfo>(cls.methods().length);
		
		for (MethodDoc method : cls.methods()) {
			MethodInfo minfo = makeMethodInfo(name, qname, method);
			minfos.add(minfo);
		}
		
		RemoteInfo rinfo = classDB.createRemoteInfo(name, cinfos, qname, minfos);
		
		classDB.createStubForRemote(rinfo);

		return rinfo;
	}
	
	private void checkSupportedCollectionType(TypeInfo tinfo) throws GeneratorException {
		int p = tinfo.qname.indexOf('<');
		String qname = p >= 0 ? tinfo.qname.substring(0, p) : tinfo.qname;
		if (!supportedCollections.contains(qname)) {
			StringBuilder msg = new StringBuilder();
			msg.append("Unsupported collection type \"").append(tinfo.toString()).append("\". ");
			msg.append("Please use one of this types: ").append(supportedCollections).append(", ");
			msg.append("e.g. List<Map<Integer,Set<String>>>.");
			throw new GeneratorException(msg.toString());
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
