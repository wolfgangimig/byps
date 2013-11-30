package byps.gen.js;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BException;
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

class PrintContext extends PrintContextBase {
	
	public final static String STUB_PREFIX = "BStub_";
	public final static String SKELETON_PREFIX = "BSkeleton_";
	public final static String INTERFACE_SUFFIX = "";
	
	PrintContext(ClassDB classDB, GeneratorProperties props) throws IOException {
		super(classDB, props);
		
		destFile = props.getMandatoryPropertyFile(PropertiesJS.DEST_FILE);
		
		File destDir = destFile.getParentFile();
		destDir.mkdir();
		
		logProperties();
	}

	/**
	 * Do not generate classes with constants. 
	 * The API provides functions to obtain constants as normal class members.
	 * @return
	 * @throws GeneratorException
	 */
  public boolean isSuppressConstantClassesAndObjects() throws GeneratorException {
    boolean val = props.getOptionalPropertyBoolean(PropertiesJS.SUPPRESS_CONST_CLASSES, false);
    return val;
  }
	
	CodePrinter getPrinter() throws IOException {
		FileOutputStream fos = new FileOutputStream(destFile, true);
		return new CodePrinter(fos, false);
	}
	
	public String getRegistryClassName() {
		return apiPack + ".BRegistry_" + apiName;
	}
	
	public String getRegistryPackage() {
		return apiPack;
	}
	
	public String getApiDescriptorClassName() {
		String tdescClassName = apiPack + ".BApiDescriptor_" + apiName;
		return tdescClassName;
	}

	public String getClientClassName() {
		String tdescClassName = apiPack + ".BClient_" + apiName;
		return tdescClassName;
	}

	public String getServerClassName() {
		String tdescClassName = apiPack + ".BServer_" + apiName;
		return tdescClassName;
	}

	public String getApiDescriptorPackage() {
		return apiPack;
	}

	public String getStubClassQName(RemoteInfo rinfo, String pack) {
		String className = "";
		className += rinfo.pack + ".";
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
					if (cmt.kind != null && !cmt.kind.equals(CommentInfo.KIND_REMARKS) && !cmt.kind.equals(CommentInfo.KIND_SUMMARY)) {
						mpr.print(cmt.kind).print(" ");
					}
					mpr.println(line.trim());
				}
			}
			pr.println("*/");
		}
	}

	public final File destFile;

	public CodePrinter printDeclareMethod(CodePrinter pr, RemoteInfo rinfo, MethodInfo methodInfo, boolean async, boolean skeleton) throws IOException {
		
	  pr.checkpoint();
	  
		printComments(pr, methodInfo.comments);
		
		String className = skeleton ? getSkeletonClassQName(rinfo, "") : getStubClassQName(rinfo, "");
				
		MemberInfo returnInfo = methodInfo.resultInfo.members.get(0);
		CodePrinter mpr = pr.print(className).print(".prototype.");
		if (async && skeleton) {
			mpr.print("async_");
		}
		mpr.print(methodInfo.name).print(" = function(");
		
		for (int i = 0; i < methodInfo.requestInfo.members.size(); i++) {
			MemberInfo pinfo = methodInfo.requestInfo.members.get(i);
			
			if (!skeleton) {
		     // Skip authentication parameter
	      if (isSessionParam(rinfo, pinfo)) continue;
			}
			
			mpr.print(pinfo.name);
			if (async || i != methodInfo.requestInfo.members.size()-1) mpr.print(", ");
		}
		
		if (async) {
			mpr.print("__byps__asyncResult)");
		}
		else {
			String returnsClause = "returns " + returnInfo.type;
			
			String throwsClause = ", throws BException, InterruptedException";
			for (int i = 0; i < methodInfo.exceptions.size(); i++) {
				TypeInfo exInfo = methodInfo.exceptions.get(i);
				if (exInfo.qname.equals(BException.class.getName())) continue;
				if (exInfo.qname.equals(InterruptedException.class.getName())) continue;
				throwsClause += ", " + exInfo.toString(rinfo.pack);
			}

			mpr.print(") /* ").print(returnsClause).print(" ").print(throwsClause).print("*/ ");
		}
		
		return mpr;
	}
	
  protected String getConstObjectName(SerialInfo serInfo) {
    String objName = null;
    ArrayList<MemberInfo> valueMembers = new ArrayList<MemberInfo>();
    ArrayList<MemberInfo> constMembers = new ArrayList<MemberInfo>();
    PrintHelper.collectAllMembers(serInfo, valueMembers, constMembers);
    if (constMembers.size() != 0) {
      String classSuffix = valueMembers.size() != 0 ? "C" : "";
      objName = serInfo.pack + "." + serInfo.name + classSuffix;
    }
    return objName;
  }

	private void logProperties() {
		log.info("Output file for generated JavaScript code:" + destFile);
	}
	
	private Log log = LogFactory.getLog(PrintContext.class);

}
