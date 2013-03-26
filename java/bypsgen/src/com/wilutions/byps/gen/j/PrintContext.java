package com.wilutions.byps.gen.j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.BException;
import com.wilutions.byps.gen.api.CommentInfo;
import com.wilutions.byps.gen.api.GeneratorProperties;
import com.wilutions.byps.gen.api.MemberInfo;
import com.wilutions.byps.gen.api.MethodInfo;
import com.wilutions.byps.gen.api.RemoteInfo;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.api.TypeInfo;
import com.wilutions.byps.gen.db.ClassDB;
import com.wilutions.byps.gen.utils.CodePrinter;
import com.wilutions.byps.gen.utils.PrintContextBase;
import com.wilutions.byps.gen.utils.Utils;

class PrintContext extends PrintContextBase {
	
	public final static String STUB_PREFIX = "BStub_";
	public final static String SKELETON_PREFIX = "BSkeleton_";
	
	PrintContext(ClassDB classDB, GeneratorProperties props) throws IOException {
		super(classDB, props);
		
		dirApi = props.getOptionalPropertyFile(PropertiesJ.DEST_DIR_API, null);
		dirSer = props.getMandatoryPropertyFile(PropertiesJ.DEST_DIR_SER);
		dirSerBin = props.getOptionalPropertyFile(PropertiesJ.DEST_DIR_SER_BIN, dirSer);
		dirSerJson = props.getOptionalPropertyFile(PropertiesJ.DEST_DIR_SER_Json, dirSer);
	
		if (dirApi != null) dirApi.mkdirs();
		dirSerBin.mkdirs();
		dirSerJson.mkdirs();
		dirSer.mkdirs();
		
		generateHashCodeAndEquals = props.getOptionalPropertyInt(PropertiesJ.HASHCODE_AND_EQUALS, 0) != 0;
	}
	
	public boolean isGenerateHashCodeAndEquals() {
		return generateHashCodeAndEquals;
	}

	CodePrinter getPrinterForApiClass(TypeInfo tinfo, String namePrefix, boolean inSerDir) throws IOException {
		
		// Return null, if API classes should not be generated.
		if (!inSerDir && dirApi == null) return null;
		
		String packDirs = Utils.getPackageAsSubdir(tinfo.pack); 
		File file = new File(inSerDir ? dirSer : dirApi, packDirs);
		file.mkdirs();
		file = new File(file, namePrefix + tinfo.name + ".java");
		return new CodePrinter(new FileOutputStream(file));
	}
	
	CodePrinter getPrinterForSerClass(SerialInfo serInfo, BBinaryModel pformat) throws IOException {
		String serClassName = getSerializerClassName(serInfo, pformat);
		String pack = getSerializerPackage(serInfo);
		String packDirs = Utils.getPackageAsSubdir(pack); 
		File file = new File(pformat == BBinaryModel.JSON ? dirSerJson : dirSerBin, packDirs);
		file.mkdirs();
		file = new File(file, serClassName + ".java");
		return new CodePrinter(new FileOutputStream(file));
	}
	
	public String getRegistryClassName(BBinaryModel pformat) {
		String tdescClassName = pformat == BBinaryModel.JSON ? "JRegistry_" : "BRegistry_";
		return tdescClassName + apiName;
	}
	
	public String getRegistryPackage() {
		return apiPack;
	}
	
	public String getApiDescriptorClassName() {
		String tdescClassName = "BApiDescriptor_" + apiName;
		return tdescClassName;
	}

	public String getClientClassName() {
		String tdescClassName = "BClient_" + apiName;
		return tdescClassName;
	}

	public String getServerClassName() {
		String tdescClassName = "BServer_" + apiName;
		return tdescClassName;
	}

	public String getApiDescriptorPackage() {
		return apiPack;
	}
	

	CodePrinter getPrinterForRegistry(BBinaryModel pformat) throws IOException {
		String tdescClassName = getRegistryClassName(pformat);
		String packDirs = Utils.getPackageAsSubdir(apiPack); 
		File file = new File(pformat == BBinaryModel.JSON ? dirSerJson : dirSerBin, packDirs);
		file.mkdirs();
		file = new File(file, tdescClassName + ".java");
		return new CodePrinter(new FileOutputStream(file));
	}

	CodePrinter getPrinterForApiDescriptor() throws IOException {
		String tdescClassName = getApiDescriptorClassName();
		String packDirs = Utils.getPackageAsSubdir(apiPack); 
		File file = new File(dirSer, packDirs);
		file.mkdirs();
		file = new File(file, tdescClassName + ".java");
		return new CodePrinter(new FileOutputStream(file));
	}

	CodePrinter getPrinterForClient() throws IOException {
		String className = getClientClassName();
		String packDirs = Utils.getPackageAsSubdir(apiPack); 
		File file = new File(dirSer, packDirs);
		file.mkdirs();
		file = new File(file, className + ".java");
		return new CodePrinter(new FileOutputStream(file));
	}

	CodePrinter getPrinterForServer() throws IOException {
		String className = getServerClassName();
		String packDirs = Utils.getPackageAsSubdir(apiPack); 
		File file = new File(dirSer, packDirs);
		file.mkdirs();
		file = new File(file, className + ".java");
		return new CodePrinter(new FileOutputStream(file));
	}

	String getSerializerInstance(TypeInfo tinfo, BBinaryModel pformat) {
		if (tinfo.isInline || tinfo.isArrayType() || tinfo.isCollectionType()) {
			String pack = getSerializerPackage(tinfo);
			String s = pack + "." + getSerializerClassName(tinfo, pformat) + ".instance";
			return s;
		}
		else {
			return null;
		}
	}
	
	String getterForMember(String name, boolean isPrivate, TypeInfo tinfo) {
		if (isPrivate) {
			int p = name.indexOf('.');
			String objName = (p >= 0) ? name.substring(0, p+1) : "";
			String memberName = (p >= 0) ? name.substring(p+1) : name;
			boolean isBool = (tinfo.qname.equals("boolean") || tinfo.qname.equals("java.lang.Boolean")) && tinfo.dims.length() == 0;
			String prefix = isBool ? "is" : "get";
			return objName + prefix + Utils.firstCharToUpper(memberName) + "()";
		}
		else {
			return name;
		}
	}
	
	private String setterForMember(String name, boolean isPrivate, String value) {
		if (isPrivate) {
			return "set" + Utils.firstCharToUpper(name) + "(" + value + ")";
		}
		else {
			return name + " = " + value;
		}
	}
	
	/**
	 * 
	 * @param pr
	 * @param pformat
	 * @param memberName
	 * @param memberSetter 
	 * @param tinfo
	 * @throws IOException
	 */
	protected void printStreamGetMember(CodePrinter pr, BBinaryModel pformat, String objName, String memberKey, String memberName, boolean isPrivate, TypeInfo tinfo) throws IOException {
		// pr.println("// printStreamGetMember(" + pformat + ", objName=" + objName + ", memberKey=" + memberKey + ", memberName=" + memberName + ", isPrivate=" + isPrivate + ", tinfo=" + tinfo);
		
		if (pformat == BBinaryModel.JSON && tinfo.isByteArray1dim()) {
			// byte[] is serialized as Base64 encoded String
			pr.print(objName).print(setterForMember(memberName, isPrivate, "js.getArrayByte(\"" + memberKey + "\")"))
			  .println(";");
		}
		else if (tinfo.isPointerType()) {
			
			StringBuilder sbuf = new StringBuilder();
			String memberSerializer = getSerializerInstance(tinfo, pformat);
			sbuf.append("(" + tinfo.getTypeCast() + ")").append("bin.readObj(");
			if (pformat == BBinaryModel.JSON){
				sbuf.append("\"").append(memberKey).append("\", ");
			}
			sbuf.append(tinfo.isUnique())
			  .append(", " + memberSerializer);
			
			pr.print(objName).print(setterForMember(memberName, isPrivate, sbuf.toString()))
				.println(");");
		}
		else {
			String streamGetter = PrintHelper.streamGetMember(tinfo);
			
			if (pformat == BBinaryModel.JSON) {
				streamGetter = "js." + streamGetter + "(\"" + memberKey + "\")";
			}
			else {
				streamGetter = "bbuf." + streamGetter + "()";
			}

			if (tinfo.isEnum) streamGetter = "BEnumHelper.fromOrdinal(" + tinfo + ".values(), " + streamGetter + ")";
			
			pr.print(objName).print(setterForMember(memberName, isPrivate, streamGetter))
				.println(";");
		}
	}
	
	protected void printStreamPutMember(CodePrinter pr, BBinaryModel pformat, String objName, String memberKey, String memberName, boolean isPrivate, TypeInfo tinfo) throws IOException {
		// pr.println("// printStreamPutMember(" + pformat + ", objName=" + objName + ", memberKey=" + memberKey + ", memberName=" + memberName + ", isPrivate=" + isPrivate + ", tinfo=" + tinfo);
		
		String fnctIfNotDefault = ""; //pformat == BBinaryModel.JSON ? "If" : "";
		
		String memberGetter = objName + getterForMember(memberName, isPrivate, tinfo);
		if (pformat == BBinaryModel.JSON && tinfo.isByteArray1dim()) {
			pr.print("bbuf.putArrayByte").print(fnctIfNotDefault).print("(\"").print(memberKey).print("\", ").print(memberGetter)
			  .println(");");
		}
		else if (tinfo.isPointerType()) {
			String memberSerializer = getSerializerInstance(tinfo, pformat);
			CodePrinter mpr = pr.print("bout.writeObj(");
			if (pformat == BBinaryModel.JSON) {
				mpr.print("\"").print(memberKey).print("\",");
			}
			mpr.print(memberGetter)
			  .print(", " + tinfo.isUnique())
			  .print(", ").print(memberSerializer)
			  .println(");");
		}
		else {
			if (tinfo.isEnum) {
				memberGetter = memberGetter + "!=null ? " + memberGetter + ".ordinal() : 0"; 
			}
			String fnct = PrintHelper.streamPutMember(tinfo);
			CodePrinter mpr = pr.print("bbuf.").print(fnct).print(fnctIfNotDefault).print("(");
			if (pformat == BBinaryModel.JSON) mpr.print("\"").print(memberKey).print("\", ");
			mpr.print(memberGetter).println(");");
		}
	}

	public void printStreamGetItem(CodePrinter pr, BBinaryModel pformat, String lhs, TypeInfo tinfo) {
		printStreamGetItem(pr, pformat, lhs, tinfo, "bin.currentObject", "i0");
	}
	
	public void printStreamGetItem(CodePrinter pr, BBinaryModel pformat, String lhs, TypeInfo tinfo, String jsObjName, String jsParamName) {
		CodePrinter mpr = null;
		
		if (pformat == BBinaryModel.JSON && tinfo.isByteArray1dim()) {
			mpr = pr.print(lhs).print(" = ").print(jsObjName).print(".getArrayByte(").print(jsParamName).print(");");
		}
		else if (tinfo.isPointerType()) {
			String serName = getSerializerInstance(tinfo, pformat);
			mpr = pr.print(lhs).print(" = (").print(tinfo.toString()).print(")");
			if (pformat == BBinaryModel.JSON) {
				mpr.print("bin.readObj(").print(jsParamName).print(", "); 
			}
			else {
				mpr.print("bin.readObj(");
			}
			mpr = mpr.print("" + tinfo.isUnique()).print(", " + serName + ");");
		}
		else {
			String streamGetter = PrintHelper.streamGetMember(tinfo);
			
			String rhs = "";
			if (pformat == BBinaryModel.JSON) {
				rhs = jsObjName + "." + streamGetter + "(" + jsParamName + ")";
			}
			else {
				rhs = "bbuf." + streamGetter + "()";
			}
		
			if (tinfo.isEnum) rhs = "BEnumHelper.fromOrdinal(" + tinfo + ".values(), " + rhs + ")";

			mpr = pr.print(lhs).print(" = ").print(rhs).print(";");
		}
		
		if (mpr != null) {
			// mpr.print("// printStreamGetItem(" + pformat + ", lhs=" + lhs + ", tinfo=" + tinfo + ", jsObjName=" + jsObjName + ", jsParamName=" + jsParamName);
			mpr.println();
		}
		
	}
	

	public void printStreamPutItem(CodePrinter pr, BBinaryModel pformat, String varName, TypeInfo tinfo) {
		printStreamPutItem(pr, pformat, varName, tinfo, null);
	}
	
	public void printStreamPutItem(CodePrinter pr, BBinaryModel pformat, String varName, TypeInfo tinfo, String jsKeyName) {
		CodePrinter mpr = null;
		if (pformat == BBinaryModel.JSON && tinfo.isByteArray1dim()) {
			mpr = pr.print("bbuf.putArrayByte(");
			if (jsKeyName != null) mpr = mpr.print(jsKeyName).print(", ");
			mpr = mpr.print("(byte[])").print(varName).print(");");
		}
		else if (tinfo.isPointerType()) {
			String serName = getSerializerInstance(tinfo, pformat);
			mpr = pr.print("bout.writeObj(");
			if (pformat == BBinaryModel.JSON) {
				if (jsKeyName != null) {
					mpr = mpr.print(jsKeyName).print(", ");
				}
				else {
					mpr.print("null, ");
				}
			}
			mpr = mpr.print(varName)
				.print(", " + tinfo.isUnique())
				.print(", ").print(serName)
				.print(");");
		}
		
		// Item für List<Integer> ?
		else if (tinfo.toString().startsWith("java.lang.")) {
			String fnct = PrintHelper.streamPutMember(tinfo);
			String defaultValue = PrintHelper.getDefaultValueForType(tinfo);
			String arg = varName + " != null ? (" + tinfo.name + ")" + varName + " : " + defaultValue;
			mpr = pr.print("bbuf." + fnct + "(");
			if (jsKeyName != null) mpr = mpr.print(jsKeyName).print(", ");
			mpr = mpr.print(arg).print(");");
		}
		
		// Item für int[]
		else {
			String fnct = PrintHelper.streamPutMember(tinfo);
			String arg = varName;
			if (tinfo.isEnum) {
				arg = varName + " != null ? ((" + tinfo.qname + ")" + varName + ").ordinal() : 0";
			}
			mpr = pr.print("bbuf." + fnct + "(");
			if (jsKeyName != null) mpr = mpr.print(jsKeyName).print(", ");
			mpr = mpr.print(arg).print(");");
		}
		
		if (mpr != null) {
			// mpr.print("// printStreamPutItem(" + pformat + ", varName=" + varName + ", tinfo=" + tinfo + ", jsKeyName=" + jsKeyName);
			mpr.println();
		}
	}

	public CodePrinter printDeclareMethod(CodePrinter pr, RemoteInfo rinfo, MethodInfo methodInfo) {
		
		MemberInfo returnInfo = methodInfo.resultInfo.members.get(0);
		String rtype = returnInfo.type.toString(rinfo.pack);
		CodePrinter mpr = pr.print("public ")
		  .print(rtype).print(" ")
		  .print(methodInfo.name).print("(");
		
		boolean first = true;
		for (MemberInfo pinfo : methodInfo.requestInfo.members) {
			if (first) first = false; else mpr.print(", ");
			mpr.print(pinfo.type.toString(rinfo.pack)).print(" ").print(pinfo.name);
		}
		
		String throwsClause = "throws BException, InterruptedException";
		for (int i = 0; i < methodInfo.exceptions.size(); i++) {
			TypeInfo exInfo = methodInfo.exceptions.get(i);
			if (exInfo.qname.equals(BException.class.getName())) continue;
			if (exInfo.qname.equals(InterruptedException.class.getName())) continue;
			throwsClause += ", " + exInfo.toString(rinfo.pack);
		}
		
		mpr.print(") ").print(throwsClause);
		return mpr;
	}

	public String getReturnTypeAsObjType(MethodInfo methodInfo, String currentPackage) {
		
		MemberInfo returnInfo = methodInfo.resultInfo.members.get(0);
		String rtype = returnInfo.type.toString(currentPackage);
		
		if (returnInfo.type.isPrimitiveType() && !returnInfo.type.isArrayType()) {
			rtype =  registry.getObjTypeOfPrimitive(returnInfo.type.name);
		}
					
		return rtype;
	}
	
	public CodePrinter printDeclareMethodAsync(CodePrinter pr, RemoteInfo rinfo, MethodInfo methodInfo) throws IOException {
		
		CodePrinter mpr = pr.print("public void ").print("async_").print(methodInfo.name).print("(");
		
		boolean first = true;
		for (MemberInfo pinfo : methodInfo.requestInfo.members) {
			if (first) first = false; else mpr.print(", ");
			mpr.print(pinfo.type.toString(rinfo.pack)).print(" ").print(pinfo.name);
		}
		
		String rtype = getReturnTypeAsObjType(methodInfo, rinfo.pack);
		String asyncResultType = "BAsyncResult<" + rtype + ">";
		if (!first) mpr.print(", ");
		mpr.print("final ").print(asyncResultType).print(" asyncResult) ");

		// nur synchrone methode wirf exceptions
		// die asynchrone Methode muss die Exception in das AsyncResult<>.setException schreiben
//		StringBuilder throwsClause = new StringBuilder();
//		for (int i = 1; i < methodInfo.resultInfo.members.size(); i++) {
//			MemberInfo memberInfo = methodInfo.resultInfo.members.get(i);
//			if (memberInfo.type.qname.equals(IOException.class.getName())) continue;
//			if (throwsClause.length() != 0) throwsClause.append(", ");
//			throwsClause.append(memberInfo.type.toString(rinfo.pack));
//		}
//		mpr.print(") ").print(throwsClause.toString()).print(" ");
		
		return mpr;
	}

	public String getStubClassQName(RemoteInfo rinfo, String pack) {
		String className = "";
		if (!rinfo.pack.equals(pack)) className += rinfo.pack + ".";
		className += PrintContext.STUB_PREFIX + rinfo.name;
		return className;
	}
	
	public String getSkeletonClassQName(RemoteInfo rinfo, String pack) {
		String className = "";
		if (!rinfo.pack.equals(pack)) className += rinfo.pack + ".";
		className += PrintContext.SKELETON_PREFIX + rinfo.name;
		return className;
	}

	public void printDoNotModify(CodePrinter pr, String ... lines) {
		pr.println("/*");
		if (lines != null) {
			for (String line : lines) {
				pr.print(" * ").println(line);
			}
		}
		pr.println(" * ");
		pr.println(" * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.");
		pr.println(" */");
		pr.println();
		
	}
	
	public void printComments(CodePrinter pr, Iterable<CommentInfo> comments) throws IOException {
		if (comments != null) {
			pr.println("/**");
			for (CommentInfo cmt : comments) {
				String t = cmt.text.trim().replace("\r", "\n"); 
				for (String line : t.split("\n")) {
					CodePrinter mpr = pr.print(" * ");
					if (!cmt.kind.equals(CommentInfo.KIND_REMARKS) && !cmt.kind.equals(CommentInfo.KIND_SUMMARY)) {
						mpr.print(cmt.kind).print(" ");
					}
					mpr.println(line.trim());
				}
			}
			pr.println("*/");
		}
	}

	public final File dirApi;
	public final File dirSerBin;
	public final File dirSerJson;
	public final File dirSer;
	private boolean generateHashCodeAndEquals;

}
