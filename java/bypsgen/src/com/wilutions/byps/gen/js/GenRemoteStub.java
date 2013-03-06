package com.wilutions.byps.gen.js;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.gen.api.MemberInfo;
import com.wilutions.byps.gen.api.MethodInfo;
import com.wilutions.byps.gen.api.RemoteInfo;
import com.wilutions.byps.gen.utils.CodePrinter;

class GenRemoteStub {
	
	static Log log = LogFactory.getLog(GenRemoteStub.class);
	
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
		
		CodePrinter mpr = pr.print("var req = ").print(" { ");
		mpr.print("_typeId : ").print(methodInfo.requestInfo.typeId);
		
		for (MemberInfo pinfo : methodInfo.requestInfo.members) {
			mpr.print(", ");
			mpr.print(pinfo.name).print(" : ").print(pinfo.name);
		}
		mpr.println(" };");

		pr.println("var ret = transport.send(req, asyncResult);");
		pr.println("return ret.result;");
				
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
		
		for (MethodInfo minfo : rinfo.methods) {
			printMethod(minfo);
			pr.println();
		}
		
		pr.endBlock();
		
		pr.println("};");
		pr.println();

		//log.debug(GeneratorJ.class.getName(), "generate");
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
