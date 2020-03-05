package byps.gen.cs;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
import byps.gen.db.Keywords;
import byps.gen.utils.CodePrinter;
import byps.gen.utils.PrintContextBase;
import byps.gen.utils.PrintHelper;
import byps.gen.utils.Utils;

public class PrintContext extends PrintContextBase {

	public final static String STUB_PREFIX = "BStub_";
	public final static String SKELETON_PREFIX = "BSkeleton_";
	public final static String INTERFACE_SUFFIX = "";

	PrintContext(ClassDB classDB, GeneratorProperties props) throws GeneratorException {
		super(classDB, props);
		
		dirSer = props.getMandatoryPropertyFile(PropertiesCS.DEST_DIR_SER);
		dirApi = props.getOptionalPropertyFile(PropertiesCS.DEST_DIR_API, dirSer);
		dirSerBin = props.getOptionalPropertyFile(PropertiesCS.DEST_DIR_SER_BIN, dirSer);
		
		dirApi.mkdirs();
		dirSerBin.mkdirs();
		dirSer.mkdirs();
		
		String packAlias = props.getOptionalPropertyString(PropertiesCS.RENAME_PACKAGES, "");
		if (packAlias.length() != 0) {
		  String[] aliasDefs = packAlias.split(";");
		  for (int i = 0; i < aliasDefs.length; i++) {
		    String[] alias = aliasDefs[i].trim().split("=");
		    if (alias.length != 2) {
		      throw new GeneratorException("Option " + PropertiesCS.RENAME_PACKAGES + " must be a semicolon separated list of new=old pairs. Error at " + Arrays.toString(alias));
		    }
		    packageAliasses.put(alias[1].trim(), alias[0].trim());		    
		  }
		}
		
		logProperties();
	}

	CodePrinter getPrinterForApiClass(TypeInfo tinfo, String namePrefix, boolean inSerDir) throws IOException {
		String packDirs = Utils.getPackageAsSubdir(renamePackage(tinfo.pack)); 
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
		String packDirs = Utils.getPackageAsSubdir(renamePackage(apiPack)); 
		File file = new File(dirSerBin, packDirs);
		file.mkdirs();
		file = new File(file, tdescClassName + ".cs");
		return new CodePrinter(new FileOutputStream(file));
	}

	CodePrinter getPrinterForApiDescriptor() throws IOException {
		String tdescClassName = getApiDescriptorClassName();
		String packDirs = Utils.getPackageAsSubdir(renamePackage(apiPack)); 
		File file = new File(dirSer, packDirs);
		file.mkdirs();
		file = new File(file, tdescClassName + ".cs");
		return new CodePrinter(new FileOutputStream(file));
	}
	
	String makeDataMemberName(String name) {
	  return name + "Value";
	}

	String getterForMember(String name, boolean isPrivate, TypeInfo tinfo, boolean useGetter) throws GeneratorException {
		if (!useGetter) return makeDataMemberName(name);
		return makePublicMemberName(name);
	}
		
	private String setterForMember(String name, boolean isPrivate, String value, boolean useSetter) throws GeneratorException {
		if (!useSetter) return makeDataMemberName(name) + " = " + value;
		return makePublicMemberName(name) + " = " + value;
	}
	
	public static class TypeInfoCS extends TypeInfo {
		
		private TypeInfoCS(String name, String qname, String dims, List<TypeInfo> typeArgs, boolean isEnum, boolean isFinal, boolean inlineInstance)  {
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

	TypeInfoCS toCSharp(TypeInfo tinfo) {
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
		else if (qname.equals("java.util.Date")) name = qname = "DateTime";
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
		else { qname = renameClassPackage(qname); }
		
		ArrayList<TypeInfo> args = toCSharp(tinfo.typeArgs);
		
		TypeInfoCS ninfo = new TypeInfoCS(name, qname, tinfo.dims, args, tinfo.isEnum, tinfo.isFinal, tinfo.isInline);
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
      
      // Skip authentication parameter
      if (isSessionParam(rinfo, pinfo)) continue;
            
      if (first) first = false; else mpr.print(", ");
      cstype = toCSharp(pinfo.type);
      String mname = makeValidParamName(pinfo.name);
      mpr.print(cstype.toString(rinfo.pack)).print(" ").print(mname);
    }
    
    mpr.print(")");
    return mpr;
  }
  
  public CodePrinter printDeclareMethodAsync(CodePrinter pr, RemoteInfo rinfo,
      MethodInfo methodInfo) throws GeneratorException {
    String methodName = makePublicMemberName(methodInfo.name);
    
    MemberInfo returnInfo = methodInfo.resultInfo.members.get(0);
    String rtype = "Task";
    if (!returnInfo.type.isVoidType()) {
      TypeInfo cstype = toCSharp(returnInfo.type);
      rtype = "Task<" + cstype.toString(rinfo.pack) + ">";
    }
    
    CodePrinter mpr = pr.print(rtype).print(" ")
      .print(methodName).print("Async(");
    
    boolean first = true;
    for (MemberInfo pinfo : methodInfo.requestInfo.members) {
      
      // Skip authentication parameter
      if (isSessionParam(rinfo, pinfo)) continue;
            
      if (first) first = false; else mpr.print(", ");
      TypeInfo cstype = toCSharp(pinfo.type);
      String mname = makeValidParamName(pinfo.name);
      mpr.print(cstype.toString(rinfo.pack)).print(" ").print(mname);
    }
    
    mpr.print(")");
    return mpr;
  }
  
  public CodePrinter printDeclareMethodTask(CodePrinter pr, RemoteInfo rinfo,
      MethodInfo methodInfo) throws GeneratorException {
    String methodName = makePublicMemberName(methodInfo.name);
    
    String taskType = getReturnTask(rinfo, methodInfo);
    
    CodePrinter mpr = pr.print("async ").print(taskType).print(" ")
      .print(methodName).print("Task(");
    
    boolean first = true;
    for (MemberInfo pinfo : methodInfo.requestInfo.members) {
      
      // Skip authentication parameter
      if (isSessionParam(rinfo, pinfo)) continue;
            
      if (first) first = false; else mpr.print(", ");
      TypeInfo cstype = toCSharp(pinfo.type);
      String mname = makeValidParamName(pinfo.name);
      mpr.print(cstype.toString(rinfo.pack)).print(" ").print(mname);
    }
    
    mpr.print(")");
    return mpr;
  }

  public String getReturnTask(RemoteInfo rinfo, MethodInfo methodInfo) {
    String taskType = "Task";
    MemberInfo returnInfo = methodInfo.resultInfo.members.get(0);
    if (!returnInfo.type.isVoidType()) {
      TypeInfo cstype = toCSharp(returnInfo.type);
      String rtype = cstype.toString(rinfo.pack);
      taskType = "Task<" + rtype + ">";
    }
    return taskType;
  }
  
	public CodePrinter printDeclareMethodBeginAsync(CodePrinter pr, RemoteInfo rinfo, MethodInfo methodInfo) throws GeneratorException {
		String methodName = Utils.firstCharToUpper(methodInfo.name);
		CodePrinter mpr = pr.print("IAsyncResult Begin").print(methodName).print("(");
		
		boolean first = true;
		for (MemberInfo pinfo : methodInfo.requestInfo.members) {
      
		  // Skip authentication parameter
      if (isSessionParam(rinfo, pinfo)) continue;

      if (first) first = false; else mpr.print(", ");
			TypeInfo cstype = toCSharp(pinfo.type);
			String mname = makeValidParamName(pinfo.name);
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
	
  public boolean isAwaitSupported() throws GeneratorException {
    return (((PropertiesCS)props).dotnetVersion() >= 4.5f);
  }


	
	public String makeValidParamName(String mname) {
	  if (Keywords.csharpKeywords.contains(mname)) return "@" + mname;
		return mname;
	}

	public CodePrinter printDeclareMethodDelegate(CodePrinter pr,
			RemoteInfo rinfo, MethodInfo methodInfo) throws GeneratorException {
		String methodName = makePublicMemberName(methodInfo.name);
		CodePrinter mpr = pr.print("void ").print(methodName).print("").print("(");
		
		boolean first = true;
		for (MemberInfo pinfo : methodInfo.requestInfo.members) {

      // Skip authentication parameter
      if (isSessionParam(rinfo, pinfo)) continue;

      if (first) first = false; else mpr.print(", ");
			TypeInfo cstype = toCSharp(pinfo.type);
			String mname = makeValidParamName(pinfo.name);
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
		String packDirs = Utils.getPackageAsSubdir(renamePackage(apiPack)); 
		File file = new File(dirSer, packDirs);
		file.mkdirs();
		file = new File(file, className + ".cs");
		return new CodePrinter(new FileOutputStream(file));
	}

	CodePrinter getPrinterForServer() throws IOException {
		String className = getServerClassName();
		String packDirs = Utils.getPackageAsSubdir(renamePackage(apiPack)); 
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
    pr.checkpoint();
	
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
    pr.checkpoint();
		
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
		
		// Item is e.g. List<Integer> ?
		else if (tinfo.toString().startsWith("java.lang.")) {
			String fnct = PrintHelper.streamPutMember(tinfo);
			String arg = varName;
			mpr = pr.print("bbuf." + fnct + "(");
			if (jsKeyName != null) mpr = mpr.print(jsKeyName).print(", ");
			mpr = mpr.print(arg).print(");");
		}
		
		else {
		  tinfo = toCSharp(tinfo);
			String fnct = PrintHelper.streamPutMember(tinfo);
			String arg = varName;
			if (tinfo.isEnum) {
				arg = "(int)((" + tinfo + ")" + varName + ")";
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
		return renameClassPackage(className);
	}
	
	public String getSkeletonClassQName(RemoteInfo rinfo, String pack) {
		String className = "";
		if (!rinfo.pack.equals(pack)) className += rinfo.pack + ".";
		className += PrintContext.SKELETON_PREFIX + rinfo.name;
    return renameClassPackage(className);
	}
	
  public String getSerializerPackage(TypeInfo tinfo) {
    return renamePackage(super.getSerializerPackage(tinfo));
  }
	
  public String renamePackage(String classPackage) {
    
//    String bestOldPackage = "";
//    for (String oldPackage : packageAliasses.keySet()) {
//      int nbOfEqualChars = 0;
//      if (oldPackage.length() <= classPackage.length()) {
//        for (; nbOfEqualChars < Math.min(oldPackage.length(), classPackage.length()); nbOfEqualChars++) {}
//        if (nbOfEqualChars > bestOldPackage.length()) {
//          bestOldPackage = oldPackage;
//        }
//      }
//    }
//
//    if (bestOldPackage.length() != 0) {
//      classPackage = packageAliasses.get(bestOldPackage);
//    }
    
    String oldPackage = packageAliasses.get(classPackage);
    if (oldPackage != null) {
      classPackage = oldPackage;
    }

    return classPackage;
  }

  public String renameClassPackage(String className) {
    
    int p = className.lastIndexOf('.');
    if (p >= 0) {
      String oldPackage = className.substring(0, p);
      String newPackage = renamePackage(oldPackage);
      if (!oldPackage.equals(newPackage)) {
        className = newPackage + className.substring(p);
      }
    }

    return className;
  }

	public void printSetChangedMembers(CodePrinter pr, SerialInfo serInfo, MemberInfo minfo) {
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

	private void logProperties() {
		log.info("Output directories for generated C# files:");
		log.info("API classes: " + dirApi);
		log.info("Common serialization classes: " + dirSer);
		log.info("Classes for binary serialization: " + dirSerBin);
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


  public final File dirApi;
  public final File dirSerBin;
  public final File dirSer;
  private final HashMap<String,String> packageAliasses = new HashMap<String,String>();

	private Logger log = LoggerFactory.getLogger(PrintContext.class);

}
