package byps.gen.js;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.gen.api.MemberInfo;
import byps.gen.api.MethodInfo;
import byps.gen.api.RemoteInfo;
import byps.gen.utils.CodePrinter;

class GenRemoteStub {
	
	static Logger log = LoggerFactory.getLogger(GenRemoteStub.class);
	
	static void generate(PrintContext pctxt, RemoteInfo rinfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "generate");
		log.info("generate " + rinfo.qname);
		CodePrinter pr = pctxt.getPrinter();
		new GenRemoteStub(pctxt, rinfo, pr).generate();
		pr.close();
		//log.debug(GeneratorJ.class.getName(), "generate");
	}
	
	private GenRemoteStub(PrintContext pctxt, RemoteInfo rinfo, CodePrinter pr) {
		this.rinfo = rinfo;
		this.pr = pr;
		this.className = pctxt.getStubClassQName(rinfo, "");
		this.pctxt = pctxt;
	}
	
	private void printMethod(MethodInfo methodInfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printMethod");
		
		pctxt.printDeclareMethod(pr, rinfo, methodInfo, true, false).println(" {");
		
		pr.beginBlock();
		pr.checkpoint();
		
		CodePrinter mpr = pr.print("var req = ").print(" { ");
		mpr.print("_typeId : ").print(methodInfo.requestInfo.typeId);
		
		for (MemberInfo pinfo : methodInfo.requestInfo.members) {

			mpr.print(", ");
			
      // Skip authentication parameter name
			// BTransport will replace it with the session object
      if (pctxt.isSessionParam(rinfo, pinfo)) {
        mpr.print("__byps__sess : '").print(pinfo.name).print("'");
      }
      else {
        mpr.print(pinfo.name).print(" : ").print(pinfo.name);
      }
      
		}
		mpr.println(" };");

		pr.println("var ret = this.transport.sendMethod(req, __byps__asyncResult);");
		pr.println("return ret;");
				
		pr.endBlock();
		pr.println("};");
		
		//log.debug(GeneratorJ.class.getName(), "printMethod");
	}
	
	private void generate() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "generate");

		pctxt.printComments(pr, rinfo.comments);
		
		pr.print(className).print(" = function(transport) {").println();
		pr.beginBlock();
		pr.println();
		
		printSerialVersionUID();
		pr.println();
		
		pr.println("this.transport = transport;");
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
      pr.println();
    }
    
  }

	private void printSerialVersionUID() {
		//log.debug(GenApiClass.class.getName(), "printSerialVersionUID");
		pr.println("this._typeId = " + rinfo.typeId + ";");
		//log.debug(GenApiClass.class.getName(), "printSerialVersionUID");
	}
	
	
	private final RemoteInfo rinfo;
	private final CodePrinter pr;
	private final String className;
	private final PrintContext pctxt;
	
}
