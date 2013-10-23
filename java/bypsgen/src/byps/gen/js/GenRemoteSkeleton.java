package byps.gen.js;

import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BRegistry;
import byps.gen.api.MemberInfo;
import byps.gen.api.MethodInfo;
import byps.gen.api.RemoteInfo;
import byps.gen.utils.CodePrinter;

class GenRemoteSkeleton {
	
	static Log log = LogFactory.getLog(GenRemoteSkeleton.class);
	
	static void generate(PrintContext pctxt, RemoteInfo rinfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "generate");
	  if (rinfo.isClientRemote) {
  		log.info("generate " + rinfo.qname);
  		CodePrinter pr = pctxt.getPrinter();
  		new GenRemoteSkeleton(pctxt, rinfo, pr).generate();
  		pr.close();
	  }
		//log.debug(GeneratorJ.class.getName(), "generate");
	}
	
	private GenRemoteSkeleton(PrintContext pctxt, RemoteInfo rinfo, CodePrinter pr) {
		this.rinfo = rinfo;
		this.pr = pr;
		this.className = pctxt.getSkeletonClassQName(rinfo, "");
		this.interfaceName = rinfo.name + PrintContext.INTERFACE_SUFFIX;
		this.pctxt = pctxt;
	}
	
	private void printMethod(MethodInfo methodInfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printMethod");
		
		pctxt.printDeclareMethod(pr, rinfo, methodInfo, false, true).println(" {");
		
		pr.beginBlock();
		pr.println("byps.throwUNSUPPORTED(\"\");");	// Server does not call synchronous methods
		pr.endBlock();
		pr.println("};");
		
		//log.debug(GeneratorJ.class.getName(), "printMethod");
	}
	
	private void printMethodAsync(MethodInfo methodInfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printMethodAsync");
		
		CodePrinter mpr = pctxt.printDeclareMethod(pr, rinfo, methodInfo, true, true);
		mpr.println("{");
		pr.beginBlock();
		
		MemberInfo returnInfo = methodInfo.resultInfo.members.get(0);
		boolean isReturnVoid = returnInfo.type.typeId == BRegistry.TYPEID_VOID;
		
		pr.println("try {");
		pr.beginBlock();
		
		if (isReturnVoid) {
			mpr = pr;
		}
		else {
			mpr = pr.print("var __byps__ret = ");
		}
		
		// Call synchronous method
		mpr = mpr.print("this.").print(methodInfo.name + "(");
		boolean first = true;
		for (MemberInfo pinfo : methodInfo.requestInfo.members) {
			if (first) first = false; else mpr.print(", ");
			mpr.print(pinfo.name);
		}
		mpr.println(");");
		
		if (isReturnVoid) {
			pr.println("__byps__asyncResult(null, null);");
		} 
		else {
			pr.println("__byps__asyncResult(__byps__ret, null);");
		}
		
		pr.endBlock();
		pr.println("} catch (e) {");
		pr.beginBlock();
		pr.println("__byps__asyncResult(null, e);");
		pr.endBlock();
		pr.println("};");
		
		pr.endBlock();
		
		pr.println("};");
		//log.debug(GeneratorJ.class.getName(), "printMethodAsync");
	}

	private void generate() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "generate");

		pr.println("/**");
		pr.println(" * This class provides a skeleton implementation of the interface " + interfaceName + ".");
		pr.println(" * Use an object of this class as the prototype of your interface implementation.");
		pr.println(" * Either provide an asynchronous or a synchronous function in your implementation.");
		pr.println(" * The framework calls only the asynchronous function.");
		pr.println(" */");

		pr.print(className).print(" = function() {"); 
		pr.println();

		pr.beginBlock();
		pr.println();
		
		printSerialVersionUID();
		pr.println();
		
		pr.println("this.transport = null; // is set in BServer.addRemote");
		pr.println();
		
		printToJSON();
		pr.println();
		
		pr.println();
		
		pr.endBlock();
		
		pr.println("};");
		pr.println();

    HashMap<String, RemoteInfo> remotes = new HashMap<String, RemoteInfo>();
    pctxt.collectAllRemotesForStubOrSkeleton(rinfo, remotes);
    for (RemoteInfo r : remotes.values()) {
      printMethods(r);
    }

		//log.debug(GeneratorJ.class.getName(), "generate");
	}
	
  private void printMethods(RemoteInfo rinfo) throws IOException {
    
    RemoteInfo rinfoImpl = rinfo.getRemoteInfoAuthOrAsync();
    
    for (MethodInfo minfo : rinfoImpl.methods) {
      printMethod(minfo);
      printMethodAsync(minfo);
      pr.println();
    }
    
  }

	private void printToJSON() {
		pr.println("this.toJSON = function (key) {");
		pr.beginBlock();
		pr.print("return { _typeId : ").print(rinfo.typeId).print(", targetId : this.transport.targetId };").println();
		pr.endBlock();
		pr.println("};");
	}

	private void printSerialVersionUID() {
		//log.debug(GenApiClass.class.getName(), "printSerialVersionUID");
		pr.println("this._typeId = " + rinfo.typeId + ";");
		//log.debug(GenApiClass.class.getName(), "printSerialVersionUID");
	}
	

	private final RemoteInfo rinfo;
	private final CodePrinter pr;
	private final String className;
	private final String interfaceName;
	private final PrintContext pctxt;
	
}
