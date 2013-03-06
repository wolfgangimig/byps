package com.wilutions.byps.gen.js;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BApiDescriptor;
import com.wilutions.byps.gen.api.MemberInfo;
import com.wilutions.byps.gen.api.MethodInfo;
import com.wilutions.byps.gen.api.RemoteInfo;
import com.wilutions.byps.gen.utils.CodePrinter;

   
public class GenServer {
	static Log log = LogFactory.getLog(GenServer.class);
	
	static void generate(PrintContext pctxt, BApiDescriptor apiDesc) throws IOException {
		//log.debug(GenServer.class.getName(), "generate");
		CodePrinter pr = pctxt.getPrinter();
		new GenServer(pctxt, apiDesc, pr).generate();
		pr.close();
		//log.debug(GenServer.class.getName(), "generate");
	}

	private GenServer(PrintContext pctxt, BApiDescriptor apiDesc, CodePrinter pr) {
		this.pctxt = pctxt;
		this.serverClassName = pctxt.getServerClassName();
		this.pack = pctxt.getApiDescriptorPackage();
		this.pr = pr;
	}
	
	private void generate() throws IOException {
		//log.debug(GenServer.class.getName(), "generate");

		pr.print(serverClassName).println(" = function(transport) { ");
		pr.println();
				
		pr.beginBlock();
		
		pr.println("this.transport = transport;");
		pr.println("this._remotes = {};");
		pr.println();

		printMethodMap();
		
		pr.endBlock();
		
		pr.println("};");
		
		pr.print(serverClassName).println(".prototype = new com.wilutions.byps.BServer();");
		
		pr.println();

		//log.debug(GenServer.class.getName(), "generate");
	}
	
	private void printMethodMap() {
		pr.println("this._methodMap = {");
		pr.beginBlock();
		
		for (RemoteInfo rinfo : pctxt.classDB.getRemotes()) {
			pr.println();
			
			pr.print("// Remote Interface ").print(rinfo.name);
			pr.beginBlock();
			
			for (MethodInfo minfo : rinfo.methods) {
				pr.println();
				
				pr.print("// Method ").println(minfo.name);
				pr.print(minfo.requestInfo.typeId).println(" : [ // _typeId of request class");
				pr.beginBlock();
				
				pr.print(rinfo.typeId).println(", // _typeId of remote interface");
				
				pr.print(minfo.resultInfo.typeId).println(", // _typeId of result class");
				
				pr.println("function(remote, methodObj, methodResult) {");
				pr.beginBlock();
				
				// Call asynchronous method
				CodePrinter mpr = pr.print("remote.async_").print(minfo.name).print("(");
				boolean first = true;
				for (MemberInfo pinfo : minfo.requestInfo.members) {
					if (first) first = false; else mpr.print(", ");
					mpr.print("methodObj.").print(pinfo.name);
				}
				if (!first) mpr.print(", ");
				mpr.println("methodResult);");
				
				pr.endBlock();
				pr.println("}");
				
				pr.endBlock();
				pr.println("],");
			}

			pr.endBlock();
			pr.println();
		}
		
		pr.endBlock();
		pr.println("};");
	}

	private CodePrinter pr;
	private String pack;
	private String serverClassName;
	private PrintContext pctxt; 
	
}


/*
public BSerializer getByClassName(Object obj) {
Class<?> clazz = obj.getClass();
if (clazz == Alpha.class) return com.wilutions.byps.example.api.BSerializer_132.instance;
if (clazz == int[].class)return  

return null;
}
*/