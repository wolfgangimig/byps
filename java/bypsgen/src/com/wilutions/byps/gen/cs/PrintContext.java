package com.wilutions.byps.gen.cs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.gen.api.CommentInfo;
import com.wilutions.byps.gen.api.GeneratorException;
import com.wilutions.byps.gen.api.GeneratorProperties;
import com.wilutions.byps.gen.api.MemberInfo;
import com.wilutions.byps.gen.api.MethodInfo;
import com.wilutions.byps.gen.api.RemoteInfo;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.api.TypeInfo;
import com.wilutions.byps.gen.db.ClassDB;
import com.wilutions.byps.gen.j.PrintHelper;
import com.wilutions.byps.gen.utils.CodePrinter;
import com.wilutions.byps.gen.utils.PrintContextBase;
import com.wilutions.byps.gen.utils.Utils;

public class PrintContext extends PrintContextBase {

	public final static String STUB_PREFIX = "BStub_";
	public final static String SKELETON_PREFIX = "BSkeleton_";
	public final static String INTERFACE_SUFFIX = "";

	PrintContext(ClassDB classDB, GeneratorProperties props) throws IOException {
		super(classDB, props);
		
		dirSer = props.getMandatoryPropertyFile(PropertiesCS.DEST_DIR_SER);
		dirApi = props.getOptionalPropertyFile(PropertiesCS.DEST_DIR_API, dirSer);
		dirSerBin = props.getOptionalPropertyFile(PropertiesCS.DEST_DIR_SER_BIN, dirSer);
	
		dirApi.mkdirs();
		dirSerBin.mkdirs();
		dirSer.mkdirs();
		
	}

	CodePrinter getPrinterForApiClass(TypeInfo tinfo, String namePrefix, boolean inSerDir) throws IOException {
		String packDirs = Utils.getPackageAsSubdir(tinfo.pack); 
		File file = new File(inSerDir ? dirSer : dirApi, packDirs);
		file.mkdirs();
		file = new File(file, namePrefix + tinfo.name + ".cs");
		return new CodePrinter(new FileOutputStream(file));
	}
	
	public String getApiDescriptorClassName() {
		String tdescClassName = "BApiDescriptor_" + apiName;
		return tdescClassName;
	}

	public String getApiDescriptorPackage() {
		return apiPack;
	}
	
	public String getRegistryPackage() {
		return apiPack;
	}
	
	public String getRegistryClassName(BBinaryModel pformat) {
		String tdescClassName = pformat == BBinaryModel.JSON ? "JRegistry_" : "BRegistry_";
		return tdescClassName + apiName;
	}
	
	CodePrinter getPrinterForRegistry(BBinaryModel pformat) throws IOException {
		String tdescClassName = getRegistryClassName(pformat);
		String packDirs = Utils.getPackageAsSubdir(apiPack); 
		File file = new File(dirSerBin, packDirs);
		file.mkdirs();
		file = new File(file, tdescClassName + ".cs");
		return new CodePrinter(new FileOutputStream(file));
	}

	CodePrinter getPrinterForApiDescriptor() throws IOException {
		String tdescClassName = getApiDescriptorClassName();
		String packDirs = Utils.getPackageAsSubdir(apiPack); 
		File file = new File(dirSer, packDirs);
		file.mkdirs();
		file = new File(file, tdescClassName + ".cs");
		return new CodePrinter(new FileOutputStream(file));
	}

	String getterForMember(String name, boolean isPrivate, TypeInfo tinfo, boolean useGetter) throws GeneratorException {
		if (!useGetter) return "_" + name;
		return makePublicMemberName(name);
	}
		
	private String setterForMember(String name, boolean isPrivate, String value, boolean useSetter) throws GeneratorException {
		if (!useSetter) return "_" + name + " = " + value;
		return makePublicMemberName(name) + " = " + value;
	}
	
	private static class TypeInfoCS extends TypeInfo {
		
		public TypeInfoCS(String name, String qname, String dims, List<TypeInfo> typeArgs, boolean isEnum, boolean isFinal, boolean inlineInstance)  {
			super(name, qname, dims, typeArgs, isEnum, isFinal, inlineInstance);
		}

		protected String getDimsAsString() {
			int cdims = dims.length() / 2;
			StringBuilder sdims = new StringBuilder();
			if (cdims != 0) {
				sdims.append("[");
				for (int i = 1; i < cdims; i++) {
					sdims.append(",");
				}
				sdims.append("]");
			}
			return sdims.toString();
		}

	}

	TypeInfo toCSharp(TypeInfo tinfo) {
		String name = tinfo.name;
		String qname = tinfo.qname;
		
		if (qname.equals("boolean")) name = qname = "bool"; 
		else if (qname.equals("java.lang.Boolean")) name = qname = "bool"; 
		else if (qname.equals("java.lang.Byte")) name = qname = "byte";
		else if (qname.equals("java.lang.Character")) name = qname = "char";
		else if (qname.equals("java.lang.Short")) name = qname = "short";
		else if (qname.equals("java.lang.Integer")) name = qname = "int";
		else if (qname.equals("java.lang.Long")) name = qname = "long";
		else if (qname.equals("java.lang.Float")) name = qname = "float";
		else if (qname.equals("java.lang.Double")) name = qname = "double";
		else if (qname.equals("java.lang.String")) name = qname = "String";
		else if (qname.equals("java.lang.Object")) name = qname = "Object";
		else if (qname.equals("java.lang.Exception")) name = qname = "Exception";
		else if (qname.equals("java.lang.Throwable")) name = qname = "Exception";
		else if (qname.equals("java.util.List")) name = qname = "IList";
		else if (qname.equals("java.util.ArrayList")) name = qname = "List";
		else if (qname.equals("java.util.Map")) name = qname = "IDictionary";
		else if (qname.equals("java.util.HashMap")) name = qname = "Dictionary";
		else if (qname.equals("java.util.TreeMap")) name = qname = "Dictionary";
		else if (qname.equals("java.util.Set")) name = qname = "ISet";
		else if (qname.equals("java.util.HashSet")) name = qname = "HashSet";
		else if (qname.equals("java.util.TreeSet")) name = qname = "HashSet";
		else if (qname.equals("java.io.InputStream")) { name = "Stream"; qname = "System.IO.Stream"; }
		
		ArrayList<TypeInfo> args = toCSharp(tinfo.typeArgs);
		
		TypeInfo ninfo = new TypeInfoCS(name, qname, tinfo.dims, args, tinfo.isEnum, tinfo.isFinal, tinfo.isInline);
		ninfo.typeId  = tinfo.typeId;
		
		return ninfo;
	}

	protected ArrayList<TypeInfo> toCSharp(List<TypeInfo> tinfos) {
		ArrayList<TypeInfo> args = new ArrayList<TypeInfo>();
		for (TypeInfo ainfo : tinfos) {
			args.add(toCSharp(ainfo));
		}
		return args;
	}
//		
//	public MemberInfo toCSharp(MemberInfo minfo) {
//		MemberInfo ninfo = new MemberInfo(minfo.name, minfo.comments, toCSharp(minfo.type), 
//				minfo.access == MemberAccess.PUBLIC, 
//				minfo.access == MemberAccess.PROTECTED, 
//				minfo.access == MemberAccess.PACKAGE, 
//				minfo.access == MemberAccess.PRIVATE,
//				minfo.isFinal, minfo.isStatic, minfo.isTransient, 
//				minfo.since, minfo.value);
//		return ninfo;
//	}
//	
//	private HashMap<String, SerialInfo> convertedSerials = new HashMap<String, SerialInfo>();
//	
//	public SerialInfo toCSharp(SerialInfo sinfo) throws GeneratorException {
//		if (sinfo == null) return null;
//		SerialInfo ninfo = convertedSerials.get(sinfo.qname);
//		if (ninfo != null ) return ninfo;
//		
//		if (sinfo.name.equals("AllTypesC")) {
//			sinfo.typeId = 0;
//		}
//		
//		ArrayList<MemberInfo> members = new ArrayList<MemberInfo>();
//		for (MemberInfo m : sinfo.members) members.add(toCSharp(m)); 
//		
//		TypeInfo tinfo = toCSharp((TypeInfo)sinfo);
//		ninfo = new SerialInfo(tinfo.name, sinfo.comments, tinfo.qname, sinfo.baseFullName, sinfo.dims,
//				tinfo.typeArgs, members, tinfo.isEnum, tinfo.inlineInstance);
//		
//		convertedSerials.put(sinfo.qname, sinfo);
//		ninfo.methodInfo = toCSharp(sinfo.methodInfo);
//		ninfo.baseInfo = toCSharp(sinfo.baseInfo);
//		ninfo.typeId = sinfo.typeId;
//		return ninfo;
//	}
//	
//	public RemoteInfo toCSharp(RemoteInfo rinfo) throws GeneratorException {
//		TypeInfo tinfo = toCSharp((TypeInfo)rinfo);
//		
//		ArrayList<MethodInfo> methods = new ArrayList<MethodInfo>();
//		for (MethodInfo method : methods) {
//			methods.add(toCSharp(method));
//		}
//
//		RemoteInfo ninfo = new RemoteInfo(tinfo.name, rinfo.comments, tinfo.qname, methods);
//		ninfo.typeId = rinfo.typeId;
//		
//		return ninfo;
//	}
//	
//	public MethodInfo toCSharp(MethodInfo minfo) throws GeneratorException {
//		if (minfo == null) return null;
//		MethodInfo ninfo = new MethodInfo(minfo.name, minfo.comments, 
//				toCSharp(minfo.requestInfo), toCSharp(minfo.resultInfo),
//				toCSharp(minfo.exceptions));
//		ninfo.remoteInfo = toCSharp(minfo.remoteInfo);
//		return ninfo;
//	}

	public final File dirApi;
	public final File dirSerBin;
	public final File dirSer;

	public String getReturnTypeAsObjType(MethodInfo methodInfo, String currentPackage) throws GeneratorException {
		MemberInfo returnInfo = methodInfo.resultInfo.members.get(0);
		String rtype = returnInfo.type.toString(currentPackage);
		if (rtype.equals("void")) return "Object";
		return toCSharp(returnInfo.type).toString(currentPackage);
	}

	public void printDoNotModify(CodePrinter pr, String ... lines) {
		pr.println("//");
		if (lines != null) {
			for (String line : lines) {
				pr.print("// ").println(line);
			}
		}
		pr.println("// ");
		pr.println("// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.");
		pr.println("//");
		pr.println();
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
	

	public boolean isGenerateHashCodeAndEquals() {
		return false;
	}

	public CodePrinter printDeclareMethod(CodePrinter pr, RemoteInfo rinfo,
			MethodInfo methodInfo) throws GeneratorException {
		String methodName = makePublicMemberName(methodInfo.name);
		
		MemberInfo returnInfo = methodInfo.resultInfo.members.get(0);
		TypeInfo cstype = toCSharp(returnInfo.type);
		String rtype = cstype.toString(rinfo.pack);
		CodePrinter mpr = pr.print(rtype).print(" ")
		  .print(methodName).print("(");
		
		boolean first = true;
		for (MemberInfo pinfo : methodInfo.requestInfo.members) {
			if (first) first = false; else mpr.print(", ");
			cstype = toCSharp(pinfo.type);
			String mname = makeValidMemberName(pinfo.name);
			mpr.print(cstype.toString(rinfo.pack)).print(" ").print(mname);
		}
		
		mpr.print(")");
		return mpr;
	}
	
	public CodePrinter printDeclareMethodBeginAsync(CodePrinter pr, RemoteInfo rinfo, MethodInfo methodInfo) throws GeneratorException {
		String methodName = Utils.firstCharToUpper(methodInfo.name);
		CodePrinter mpr = pr.print("IAsyncResult Begin").print(methodName).print("(");
		
		boolean first = true;
		for (MemberInfo pinfo : methodInfo.requestInfo.members) {
			if (first) first = false; else mpr.print(", ");
			TypeInfo cstype = toCSharp(pinfo.type);
			String mname = makeValidMemberName(pinfo.name);
			mpr.print(cstype.toString(rinfo.pack)).print(" ").print(mname);
		}
		
		if (!first) mpr = mpr.print(", ");
		
		mpr.print("AsyncCallback callback, object state)");
		return mpr;
	}
	
	public CodePrinter printDeclareMethodEndAsync(CodePrinter pr, RemoteInfo rinfo, MethodInfo methodInfo) throws GeneratorException {
		String methodName = Utils.firstCharToUpper(methodInfo.name);
		String rtype = getReturnTypeAsObjType(methodInfo, rinfo.pack);
		CodePrinter mpr = pr.print(rtype).print(" End").print(methodName).print("(IAsyncResult asyncResult)");
		return mpr;
	}
	
	public String makePublicMemberName(String name) throws GeneratorException {
		if (((PropertiesCS)props).isUppercaseFirstLetter()) {
			name = Utils.firstCharToUpper(name);
		}
		return name;
	}
	
	public String makeValidMemberName(String mname) {
		if (mname.equals("value")) return mname = "@value";
		if (mname.equals("params")) return mname = "@params";
		return mname;
	}

	public CodePrinter printDeclareMethodAsync(CodePrinter pr,
			RemoteInfo rinfo, MethodInfo methodInfo) throws GeneratorException {
		String methodName = makePublicMemberName(methodInfo.name);
		CodePrinter mpr = pr.print("void ").print("async_").print(methodName).print("(");
		
		boolean first = true;
		for (MemberInfo pinfo : methodInfo.requestInfo.members) {
			if (first) first = false; else mpr.print(", ");
			TypeInfo cstype = toCSharp(pinfo.type);
			String mname = makeValidMemberName(pinfo.name);
			mpr.print(cstype.toString(rinfo.pack)).print(" ").print(mname);
		}
		
		String rtype = getReturnTypeAsObjType(methodInfo, rinfo.pack);
		String asyncResultType = "BAsyncResult<" + rtype + ">";
		if (!first) mpr.print(", ");
		mpr.print(asyncResultType).print(" asyncResult) ");

		return mpr;
	}

	CodePrinter getPrinterForSerClass(SerialInfo serInfo, BBinaryModel pformat) throws IOException {
		String serClassName = getSerializerClassName(serInfo, pformat);
		String pack = getSerializerPackage(serInfo);
		String packDirs = Utils.getPackageAsSubdir(pack); 
		File file = new File(dirSerBin, packDirs);
		file.mkdirs();
		file = new File(file, serClassName + ".cs");
		return new CodePrinter(new FileOutputStream(file));
	}
	
	public String getClientClassName() {
		String tdescClassName = "BClient_" + apiName;
		return tdescClassName;
	}

	public String getServerClassName() {
		String tdescClassName = "BServer_" + apiName;
		return tdescClassName;
	}

	CodePrinter getPrinterForClient() throws IOException {
		String className = getClientClassName();
		String packDirs = Utils.getPackageAsSubdir(apiPack); 
		File file = new File(dirSer, packDirs);
		file.mkdirs();
		file = new File(file, className + ".cs");
		return new CodePrinter(new FileOutputStream(file));
	}

	CodePrinter getPrinterForServer() throws IOException {
		String className = getServerClassName();
		String packDirs = Utils.getPackageAsSubdir(apiPack); 
		File file = new File(dirSer, packDirs);
		file.mkdirs();
		file = new File(file, className + ".cs");
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

	protected void printStreamGetMember(CodePrinter pr, BBinaryModel pformat, String objName, String memberKey, String memberName, boolean isPrivate, TypeInfo tinfo, boolean useSetter) throws IOException {
		// pr.println("// printStreamGetMember(" + pformat + ", objName=" + objName + ", memberKey=" + memberKey + ", memberName=" + memberName + ", isPrivate=" + isPrivate + ", tinfo=" + tinfo);
		
		if (pformat == BBinaryModel.JSON && tinfo.isByteArray1dim()) {
			// byte[] is serialized as Base64 encoded String
			pr.print(objName).print(setterForMember(memberName, isPrivate, "js.getArrayByte(\"" + memberKey + "\")", useSetter))
			  .println(";");
		}
		else if (tinfo.isPointerType()) {
			tinfo = toCSharp(tinfo);

			StringBuilder sbuf = new StringBuilder();
			String memberSerializer = getSerializerInstance(tinfo, pformat);
			sbuf.append("(" + tinfo.getTypeCast() + ")").append("bin.readObj(");
			if (pformat == BBinaryModel.JSON){
				if (!tinfo.isInline) memberKey += "*i";
				sbuf.append("\"").append(memberKey).append("\", ");
			}
			sbuf.append(tinfo.isUnique())
			  .append(", " + memberSerializer);
			
			pr.print(objName).print(setterForMember(memberName, isPrivate, sbuf.toString(), useSetter))
				.println(");");
		}
		else {
			tinfo = toCSharp(tinfo);
			String streamGetter = PrintHelper.streamGetMember(tinfo);
			
			if (pformat == BBinaryModel.JSON) {
				streamGetter = "js." + streamGetter + "(\"" + memberKey + "\")";
			}
			else {
				streamGetter = "bbuf." + streamGetter + "()";
			}

			if (tinfo.isEnum) {
				streamGetter = "(" + tinfo + ")" + streamGetter;
			}
			
			pr.print(objName).print(setterForMember(memberName, isPrivate, streamGetter, useSetter))
				.println(";");
		}
	}
	
	protected void printStreamPutMember(CodePrinter pr, BBinaryModel pformat, String objName, String memberKey, String memberName, boolean isPrivate, TypeInfo tinfo, boolean useGetter) throws IOException {
		// pr.println("// printStreamPutMember(" + pformat + ", objName=" + objName + ", memberKey=" + memberKey + ", memberName=" + memberName + ", isPrivate=" + isPrivate + ", tinfo=" + tinfo);
		
		String memberGetter = objName + getterForMember(memberName, isPrivate, tinfo, useGetter);
		
		if (pformat == BBinaryModel.JSON && tinfo.isByteArray1dim()) {
			pr.print("bbuf.putArrayByte(\"").print(memberKey).print("\", ").print(memberGetter)
			  .println(");");
		}
		else if (tinfo.isPointerType()) {
			String memberSerializer = getSerializerInstance(tinfo, pformat);
			CodePrinter mpr = pr.print("bout.writeObj(");
			if (pformat == BBinaryModel.JSON) {
				if (!tinfo.isInline) memberKey += "*i";
				mpr.print("\"").print(memberKey).print("\",");
			}
			mpr.print(memberGetter)
			  .print(", " + tinfo.isUnique())
			  .print(", ").print(memberSerializer)
			  .println(");");
		}
		else {
			if (tinfo.isEnum) {
				memberGetter = "(int)" + memberGetter; 
			}
			String fnct = PrintHelper.streamPutMember(tinfo);
			CodePrinter mpr = pr.print("bbuf.").print(fnct).print("(");
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
			tinfo = toCSharp(tinfo);
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
			tinfo = toCSharp(tinfo);
			String streamGetter = PrintHelper.streamGetMember(tinfo);
			
			String rhs = "";
			if (pformat == BBinaryModel.JSON) {
				rhs = jsObjName + "." + streamGetter + "(" + jsParamName + ")";
			}
			else {
				rhs = "bbuf." + streamGetter + "()";
			}
		
			if (tinfo.isEnum) rhs = "(" + tinfo + ")" + rhs;

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
	
	public void printStreamPutItem(CodePrinter pr, BBinaryModel pformat, String varName, 
			TypeInfo tinfo, String jsKeyName) {
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
			String arg = varName;
			mpr = pr.print("bbuf." + fnct + "(");
			if (jsKeyName != null) mpr = mpr.print(jsKeyName).print(", ");
			mpr = mpr.print(arg).print(");");
		}
		
		// Item für int[]
		else {
			String fnct = PrintHelper.streamPutMember(tinfo);
			String arg = varName;
			if (tinfo.isEnum) {
				arg = "(int)((" + tinfo.qname + ")" + varName + ")";
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

	public void printSetChangedMember(CodePrinter pr, SerialInfo serInfo, MemberInfo minfo) {
		if (isGenerateChangedMembers()) {
			SerialInfo serInfoC = classDB.getSerInfo(serInfo.qname + "C");
			if (serInfoC != null) {
				String elementSelectorName = getElementSelectorName(minfo);
				MemberInfo minfoC = serInfoC.findMember(elementSelectorName, "long");
				if (minfoC != null) {
					String elms = getElementSelectorClassName(serInfo) + "." + minfoC.name;
					pr.print("setChangedMember(").print(elms).print(");").println();
				}
			}
		}
	
	}


}
