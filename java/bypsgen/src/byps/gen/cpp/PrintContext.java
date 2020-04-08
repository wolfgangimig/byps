package byps.gen.cpp;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BBinaryModel;
import byps.gen.api.CommentInfo;
import byps.gen.api.GeneratorException;
import byps.gen.api.GeneratorProperties;
import byps.gen.api.MemberInfo;
import byps.gen.api.MethodInfo;
import byps.gen.api.RemoteInfo;
import byps.gen.api.SerialInfo;
import byps.gen.api.TypeInfo;
import byps.gen.db.ClassDB;
import byps.gen.utils.CodePrinter;
import byps.gen.utils.PrintContextBase;
import byps.gen.utils.SplitFileOutputStream;
import byps.gen.utils.Utils;

class PrintContext extends PrintContextBase {
	
	private CodePrinter prImplC;

	/**
	 * Schreibt in den Header f�r �ffentliche Definitionen.
	 */
	private CodePrinter prApiAllH;

	private CodePrinter prImplAllH;
	
	PrintContext(ClassDB classDB, GeneratorProperties props) throws IOException {
		super(classDB, props);
		
		lambdaSupported = props.getOptionalPropertyBoolean(PropertiesCpp.LAMBDA, true);
		
		dirApi = props.getMandatoryPropertyFile(PropertiesCpp.DEST_DIR_API);
		File dirImpl = props.getOptionalPropertyFile(PropertiesCpp.DEST_DIR_IMPL, dirApi);
		dirImplC = props.getOptionalPropertyFile(PropertiesCpp.DEST_DIR_IMPL_C, dirImpl);
		dirImplH = props.getOptionalPropertyFile(PropertiesCpp.DEST_DIR_IMPL_H, dirImpl);
		packageAliasMap = props.getPropertyAsMap(PropertiesCpp.PACK_ALIAS, null);
		maxFileSize = props.getOptionalPropertyInt(PropertiesCpp.MAX_FILE_SIZE, 50 * 1000);
		
		dirApi.mkdirs();
		dirImplC.mkdirs();
		dirImplH.mkdirs();

		File fileApiAllH = new File(dirApi, apiName + "-api.h");
		prApiAllH = new CodePrinter(new FileOutputStream(fileApiAllH), true);
		prApiAllH.print("#ifndef __{0}__", apiName + "_api_H"); prApiAllH.println();
		prApiAllH.print("#define __{0}__", apiName + "_api_H"); prApiAllH.println();
		prApiAllH.println();
		prApiAllH.println("#include \"Byps.h\"");
		
		File fileImplAllH = new File(dirImplH, apiName + "-impl.h");
		prImplAllH = new CodePrinter(new FileOutputStream(fileImplAllH), true);
		prImplAllH.print("#ifndef __{0}__", apiName + "_impl_H"); prImplAllH.println();
		prImplAllH.print("#define __{0}__", apiName + "_impl_H"); prImplAllH.println();
		prImplAllH.println();
		prImplAllH.println("#include \"Byps-impl.h\"");
		prImplAllH.print("#include \"{0}\"", apiName + "-api.h").println();
		prImplAllH.println();
		
		OutputStream osImplC = new SplitFileOutputStreamSource(null, apiName + "-impl-%03d.cpp", maxFileSize);
		prImplC = new CodePrinter(osImplC, false);
	
		logProperties();
	}
	
	void close() throws IOException {
		prImplC.close();

		prApiAllH.println();
		prApiAllH.println("#endif");
		prApiAllH.close();
		
		prImplAllH.println();
		prImplAllH.println("#endif");
		prImplAllH.close();
	}
	
	/**
	 * C type name of pointer.
	 * If no package alias is defined, the returned pointer name is equal to tinfo.name.
	 * Otherwise the pointer name is computed as: [alias]_[tinfo.name].
	 * @param tinfo Type descriptor 
	 * @param dims if not empty, array dimensions
	 * @return Pointer name
	 */
	String getPointerName(SerialInfo tinfo, String dims) {
		return internalGetPointerName(tinfo, dims, false);
	}
	
	/**
	 * C type name of structure.
	 * The structure name is built by _[pointer-name]. 
	 * @param tinfo Type descriptor
	 * @param dims if not empty, array dimensions
	 * @return Pointer name
	 */
	String getStructName(SerialInfo tinfo, String dims) {
		return "_" + getPointerName(tinfo, dims);
	}
	
	/**
	 * Generates the #define symbol for the type ID.
	 * The symbol is computed by [pointer-name]_TypeId
	 * @param tinfo Type descriptor
	 * @return Type ID symbol
	 */
	String getTypeIdSymbol(SerialInfo tinfo) {
		return getPointerName(tinfo, "") + "_TypeId";
	}
	
	/**
	 * Union type name of R-pointer.
	 * Returns R[pointer-name].
	 * @param tinfo Type descriptor
	 * @param dims if not empty, array dimensions
	 * @return Type ID symbol
	 */
	String getRPointerName(SerialInfo tinfo, String dims) {
		return internalGetPointerName(tinfo, dims, true);
	}
	
	String getTypeC(TypeInfo tinfo, int dims) {
		String tname = "";
		if (tinfo.name.equals("boolean")) tname = "BBOOL";
		else if (tinfo.name.equals("byte")) tname = "BBYTE";
		else if (tinfo.name.equals("char")) tname = "BWCHAR";
		else if (tinfo.name.equals("int")) tname = "BINT32";
		else if (tinfo.name.equals("long")) tname = "BINT64";
		else if (tinfo.name.equals("float")) tname = "BFLOAT";
		else if (tinfo.name.equals("double")) tname = "BDOUBLE";
		else if (tinfo.name.equals("String")) tname = "RSTRING_UTF16";
		else if (tinfo.name.equals("Object")) tname = "RObject";
		return tname;
	}
	
//	private static class SplitFileOutputStreamHeader extends SplitFileOutputStream {
//		private CodePrinter prAll;
//		public SplitFileOutputStreamHeader(CodePrinter prAll, File dir, String fileNameFormat, int maxFileSize) {
//			super(dir, fileNameFormat, maxFileSize);
//			this.prAll = prAll;
//		}
//		@Override
//		public void onClosedSplitFile(File closedFile) {
//			prAll.print("#include \"");
//			prAll.print(closedFile.getName());
//			prAll.println("\"");
//		}
//		@Override
//		public void onOpenedSplitFile(File openedFile) {
//			PrintWriter pr = new PrintWriter(this);
//			pr.println("#include <Byps-api.h>");
//			pr.println();
//		}
//	};

	private class SplitFileOutputStreamSource extends SplitFileOutputStream {
		public SplitFileOutputStreamSource(CodePrinter prAll, String fileNameFormat, int maxFileSize) throws IOException {
			super(dirImplC, fileNameFormat, maxFileSize);
		}
		@Override
		public void onClosedSplitFile(File closedFile) {
		}
		@Override
		public void onOpenedSplitFile() throws IOException {
			printIncludeUsingForCpp(this);
		}
	};

	private void printIncludeUsingForCpp(OutputStream os) throws IOException {
		CodePrinter prImplC = new CodePrinter(os, true);
		prImplC.print("#include \"{0}\"",
				getDirRelative(dirImplC.getAbsolutePath(), dirImplH.getAbsolutePath()) + apiName + "-impl.h");
		prImplC.println(); 
		prImplC.println("using namespace ::std;");
		prImplC.println("using namespace ::byps;");
		prImplC.println();
		prImplC.flush();
	}

	/**
	 * Return the directory dirAbs relative to dirBase
	 * @param dirBase Base directory
	 * @param dirAbs Absolute directory
	 * @return Relative directory
	 */
	private static String getDirRelative(String dirBase, String dirAbs) {
		StringBuilder dirRel = new StringBuilder();
		
		// Example 1
		// dirBase=d:/temp/byps/genc/impl/source
		// dirAbs=d:/temp/byps/genc/impl/header
		// dirRel=../header/
		
		// Example 2
		// dirBase=d:/temp/byps/genc/impl/source
		// dirAbs=d:/temp/byps/genc/impl/source/header
		// dirRel=header/

		// Example 3
		// dirBase=d:/temp/byps/genc/impl/source
		// dirAbs=d:/temp/byps/genc/header-impl
		// dirRel=../../header/

		String[] dirsBase = dirBase.split("\\" + File.separator);
		String[] dirsAbs = dirAbs.split("\\" + File.separator);
		int i = 0;
		while (i < dirsBase.length && i < dirsAbs.length && 
				dirsBase[i].equalsIgnoreCase(dirsAbs[i])) {
			i++;
		}
		
		// Example 1, i=6, dirsBase[i..] = {source}, dirsAbs[i...] = {header}
		// Example 2, i=7, dirsBase[i..] = {}, dirsAbs[i...] = {header}
		// Example 3, i=5, dirsBase[i..] = {impl, source}, dirsAbs[i...] = {header-impl}
		
		for (int j = i; j < dirsAbs.length; j++) {
			dirRel.append("..").append(File.separator);
		}
		for (int j = i; j < dirsAbs.length; j++) {
			dirRel.append(dirsAbs[j]).append(File.separator);
		}

		return dirRel.toString();
	}
	
	private String internalGetPointerName(SerialInfo tinfo, String dims, boolean isRPointer) {
		String palias = packageAliasMap.get(tinfo.pack);
		String r = tinfo.name;

		int dimCount = Utils.getDimCount(dims);
		if (dimCount == 0) {
			
		} else if (dimCount == 1) {
			r = "Array_" + r; 
		}
		else {
			r = "Array" + dimCount + "_" + r;
		}

		if (isRPointer) {
			r = "R" + r;
		}
		
		if (palias != null) {
			r = palias + "_" + r;
		}
		
		return r;
	}
	
	static void printDoNotModify(CodePrinter pr, String ... lines) {
		pr.println("/*");
		pr.print(" * ").line();
		pr.println(" * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.");
		pr.print(" * ").line();
		if (lines != null) {
			for (String line : lines) {
				pr.print(" * ").println(line);
			}
		}
		pr.println(" */");
		pr.println();
		
	}
	
	void printLine(CodePrinter pr) {
		pr.println("//-------------------------------------------------");
	}

	TypeInfoCpp getReturnType(MethodInfo methodInfo) {
		TypeInfo rtype = methodInfo.resultInfo.members.get(0).type;
		TypeInfoCpp cppInfo = new TypeInfoCpp(rtype, apiPack);
		return cppInfo;
	}
	
	String getReturnTypeName(MethodInfo methodInfo) {
		TypeInfoCpp rtype = getReturnType(methodInfo);
		String rtypeName = rtype.getQTypeName();
		if (rtypeName.equals("void")) rtypeName = "bool";
		return rtypeName;
	}
		
	private void printComment(CodePrinter pr, Iterable<CommentInfo> comments, String jkind, String cskindBegin, String cskindEnd) throws IOException {
		for (CommentInfo cmt : comments) {
			if (!cmt.kind.equals(jkind)) continue;
			String t = cmt.text.trim().replace("\r", "\n"); 
			pr.print("/// ").print(cskindBegin).println();
			for (String line : t.split("\n")) {
				pr.print("/// ").println(line.trim());
			}
			pr.print("/// ").print(cskindEnd).println();
			break;
		}
	}

	public void printComments(CodePrinter pr, Iterable<CommentInfo> comments) throws IOException {
		if (comments != null) {
			printComment(pr, comments, CommentInfo.KIND_SUMMARY, "<summary>", "</summary>");
			printComment(pr, comments, CommentInfo.KIND_REMARKS, "<remarks>", "</remarks>");
		}
	}

	public String makePublicMemberName(String name) throws GeneratorException {
		if (((PropertiesCpp)props).isUppercaseFirstLetter()) {
			name = Utils.firstCharToUpper(name);
		}
		return name;
	}
	
	enum EMethodDecl {
		Header, StubImpl, SkeletonImpl
	}

	public CodePrinter printDeclareMethodAsync(CodePrinter pr, String stubSkelClassName,
			RemoteInfo rinfo, MethodInfo methodInfo) throws GeneratorException {
		String methodName = makePublicMemberName(methodInfo.name);
		
    String classNameMethodName = methodName;
    String accessDecl = "public: virtual ";
    if (stubSkelClassName != null) {
      classNameMethodName = stubSkelClassName + "::" + methodName;
      accessDecl = "";
    }

		CodePrinter mpr = pr.print(accessDecl).print("void ").print(classNameMethodName).print("(");
		
		boolean first = true;
		for (MemberInfo pinfo : methodInfo.requestInfo.members) {
		  
      // Skip authentication parameter
      if (isSessionParam(rinfo, pinfo)) continue;
		  
			if (first) first = false; else mpr.print(", ");
			mpr = mpr.print( printMethodParam(pinfo,rinfo.pack) );
		}
		
		MemberInfo returnInfo = methodInfo.resultInfo.members.get(0);
		TypeInfoCpp tinfoCpp = new TypeInfoCpp(returnInfo.type, apiPack);
		String rtype = tinfoCpp.toString(rinfo.pack);
		if (rtype.equals("void")) rtype = "bool";
		if (!first) mpr.print(", ");
		
		if (lambdaSupported) {
			mpr.print("::std::function< void (").print(rtype).print(", BException ex) > asyncResult) ");
		}
		else {
			mpr.print("byps_ptr<BAsyncResultT<").print(rtype).print(" > > asyncResult) ");
		}

		return mpr;
	}

	public CodePrinter printDeclareMethod(CodePrinter pr, String stubSkelClassName, RemoteInfo rinfo,
			MethodInfo methodInfo) throws GeneratorException {
		String methodName = makePublicMemberName(methodInfo.name);

		MemberInfo returnInfo = methodInfo.resultInfo.members.get(0);
		TypeInfoCpp tinfoCpp = new TypeInfoCpp(returnInfo.type, apiPack);
		String rtype = tinfoCpp.toString(rinfo.pack);
		
		String classNameMethodName = methodName;
		String accessDecl = "public: virtual ";
    if (stubSkelClassName != null) {
      classNameMethodName = stubSkelClassName + "::" + methodName;
      accessDecl = "";
    }
    
		CodePrinter mpr = pr.print(accessDecl).print(rtype).print(" ").print(classNameMethodName).print("(");
		
		boolean first = true;
		for (MemberInfo pinfo : methodInfo.requestInfo.members) {
		  
      // Skip authentication parameter
      if (isSessionParam(rinfo, pinfo)) continue;
		  
			if (first) first = false; else mpr.print(", ");
			mpr = mpr.print( printMethodParam(pinfo,rinfo.pack) );
		}
		
		mpr.print(") ");

		return mpr;
	}
	
	public String printMethodParam(MemberInfo pinfo, String pack) {
	  StringBuilder sbuf = new StringBuilder();
    TypeInfoCpp tinfoCppParam = new TypeInfoCpp(pinfo.type, apiPack);
    String stype = tinfoCppParam.toString(pack);
    
    if (pinfo.type.isPointerType() || pinfo.type.isStringType() || pinfo.type.isDateType()) {
      sbuf.append("const ").append(stype).append("& ");
    }
    else {
      sbuf.append(stype).append(" ");
    }
    sbuf.append(pinfo.name);
    
    return sbuf.toString();
	}

	String getSerializerInstance(TypeInfo tinfo, BBinaryModel pformat) {
		if (tinfo.isInline || tinfo.isArrayType() || tinfo.isCollectionType()) {
			String pack = getSerializerPackage(tinfo);
			String s = pack + "." + getSerializerClassName(tinfo, pformat) + "()";
			return s;
		}
		else {
			return null;
		}
	}

	public String getRegistryClassName(BBinaryModel pformat) {
		return "BRegistry_" + apiName;
	}

	public TypeInfoCpp getRegistryTypeInfoCpp(BBinaryModel pformat) {
		String registryClassName = getRegistryClassName(pformat);
		String pack = getRegistryPackage();
		TypeInfo regInfo = new TypeInfo(registryClassName, pack + "." + registryClassName, "", null, false, false, false);
		return new TypeInfoCpp(regInfo, apiPack);
	}
	
	public String getRegistryPackage() {
		return apiPack;
	}

	public TypeInfoCpp getClientTypeInfoCpp() {
		String cs = "BClient_" + apiName;
		TypeInfo regInfo = new TypeInfo(cs, apiPack + "." + cs, "", null, false, false, false);
		return new TypeInfoCpp(regInfo, apiPack);
	}
	
	public String getApiDescriptorPackage() {
		return apiPack;
	}
	
	public TypeInfoCpp getServerTypeInfoCpp() {
		String cs = "BServer_" + apiName;
		TypeInfo regInfo = new TypeInfo(cs, apiPack + "." + cs, "", null, false, false, false);
		return new TypeInfoCpp(regInfo, apiPack);
	}
	
	public TypeInfoCpp getStubTypeInfoCpp(RemoteInfo rinfo) {
		String cs = "BStub_" + rinfo.name;
		TypeInfo regInfo = new TypeInfo(cs, rinfo.pack + "." + cs, "", null, false, false, false);
    regInfo.typeId = rinfo.typeId;
		return new TypeInfoCpp(regInfo, apiPack);
	}
	
	public TypeInfoCpp getSkeletonTypeInfoCpp(RemoteInfo rinfo) {
		String cs = "BSkeleton_" + rinfo.name;
		TypeInfo regInfo = new TypeInfo(cs, rinfo.pack + "." + cs, "", null, false, false, false);
		regInfo.typeId = rinfo.typeId;
		return new TypeInfoCpp(regInfo, apiPack);
	}
	
	public CodePrinter getPrImplC() {
		prImplC.flush();
		return prImplC;
	}
	
	public CodePrinter getPrImplCForRegistry() throws IOException {
//		File regFile = new File(dirImplC, apiName + "-impl-reg.cpp");
//		FileOutputStream fos = new FileOutputStream(regFile);
//		printIncludeUsingForCpp(fos);
//		CodePrinter pr = new CodePrinter(fos, false);
//		return pr;
		return getPrImplC();
	}

	public CodePrinter getPrApiAllH() {
		return prApiAllH;
	}

	public CodePrinter getPrImplAllH() {
		return prImplAllH;
	}

	public String getApiDescriptorClassName() {
		String tdescClassName = "BApiDescriptor_" + apiName;
		return tdescClassName;
	}

	public void print_BSerializable_getTypeId(TypeInfoCpp cppInfo, CodePrinter prH, CodePrinter prC) {
		prH.println("public: virtual BTYPEID BSerializable_getTypeId();");
		prC.checkpoint();
		prC.print("BTYPEID ").print(cppInfo.getClassName("")).println("::BSerializable_getTypeId() {");
		prC.beginBlock();
		prC.println("return " + cppInfo.tinfo.typeId + "; ");
		prC.endBlock();
		prC.println("}");
	}

	public void printSetChangedMember(CodePrinter pr, SerialInfo serInfo, MemberInfo minfo) {
		if (isGenerateChangedMembers()) {
			SerialInfo serInfoC = classDB.getSerInfo(serInfo.qname + "C");
			if (serInfoC != null) {
				String elementSelectorName = getElementSelectorName(minfo);
				MemberInfo minfoC = serInfoC.findMember(elementSelectorName, "long");
				if (minfoC != null) {
					String elms = getElementSelectorClassName(serInfo) + "::" + minfoC.name;
					pr.print("setChangedMember(").print(elms).print(");").println();
				}
			}
		}
	
	}
	
  public RemoteInfo getBaseRemoteForStub(RemoteInfo rinfo) {
    RemoteInfo baseRemote = rinfo.getRemoteAuth();
    if (baseRemote == null) baseRemote = rinfo;
    return baseRemote;
  }

  public RemoteInfo getBaseRemoteForSkeleton(RemoteInfo rinfo) {
    RemoteInfo baseRemote = rinfo.getRemoteNoAuth();
    return baseRemote;
  }

	
	private void logProperties() {
		log.info("Output directories for generated C++ files:");
		log.info("API headers: " + dirApi);
		log.info("Private headers: " + dirImplH);
		log.info("Source: " + dirImplC);
	}

	private Logger log = LoggerFactory.getLogger(PrintContext.class);
	
	private File dirApi;
	private File dirImplH;
	private File dirImplC;
	private int maxFileSize;
	private Map<String,String> packageAliasMap;

	/**
	 * Lamda expressions supported.
	 * Currently, we do only have a generator for C++ that supports lambdas.
	 * This value must be true.
	 */
	public final boolean lambdaSupported;



}

