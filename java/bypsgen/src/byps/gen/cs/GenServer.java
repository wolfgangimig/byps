package byps.gen.cs;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BApiDescriptor;
import byps.gen.api.RemoteInfo;
import byps.gen.utils.CodePrinter;

   
public class GenServer {
	static Log log = LogFactory.getLog(GenServer.class);
	
	static void generate(PrintContext pctxt, BApiDescriptor apiDesc) throws IOException {
		//log.debug(GenServer.class.getName(), "generate");
		CodePrinter pr = pctxt.getPrinterForServer();
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
		
		pr.println("using System;");
		pr.println("using System.Collections.Generic;");
		pr.println("using byps;");
		pr.println();
    pr.print("namespace ").println(pctxt.renamePackage(pack));
		pr.println("{");
		pr.beginBlock();
		pr.println();
		
		pr.print("public class ").print(serverClassName).println(" : BServer { ");
		pr.println();
		
		pr.beginBlock();
		
		printCreate(true);
		pr.println();
		
		printCreate(false);
		pr.println();
		
		printConstructor(false);
		pr.println();
		
		printConstructor(true);
		pr.println();
		
		for (RemoteInfo rinfo : pctxt.classDB.getRemotes()) {
			printAddRemote(rinfo);
		}
		
		pr.endBlock();
		pr.println("}");
		pr.endBlock();
		pr.println("}");

		//log.debug(GenServer.class.getName(), "generate");
	}
	
	private void printConstructor(boolean withClientR) {
		
		CodePrinter mpr = pr.print("public ").print(serverClassName);
		if (withClientR) {
			mpr.println("(BTransportFactory transportFactory) ");
		}
		else {
			mpr.println("(BTransport transport) ");
		}

		pr.beginBlock();

		if (withClientR) {
			String clientClassName = pctxt.getClientClassName();
			pr.println(": base(");
			pr.beginBlock();
			pr.println("transportFactory.createServerTransport(),");
			pr.println("transportFactory.createClientR(");
			pr.beginBlock();
			pr.println(clientClassName + ".createClientR(");
			pr.beginBlock();
			pr.println("transportFactory.createClientTransport()");
			pr.endBlock();
			pr.println(")");
			pr.endBlock();
			pr.println(")");
			pr.endBlock();
			pr.println(")");

		}
		else {
			pr.println(": base(transport, null)");
		}
		
		pr.endBlock();
		pr.println("{");
		pr.beginBlock();
		
		pr.endBlock();
		pr.println("}");
	}

	private void printCreate(boolean withClientR) {
		
		CodePrinter mpr = pr.print("public static ").print(serverClassName);
		if (withClientR) {
			mpr.println(" createServer(BTransportFactory transportFactory) {");
		}
		else {
			mpr.println(" createServerR(BTransport transport) {");
		}

		pr.beginBlock();

		if (withClientR) {
			pr.print("return new ").print(serverClassName).println("(transportFactory);");
		}
		else {
			pr.print("return new ").print(serverClassName).println("(transport);");
		}

		pr.endBlock();
		pr.println("}");
	}

	protected void printAddRemote(RemoteInfo rinfo) {
	  if (rinfo.isClientRemote) {
  		String typeName = pctxt.getSkeletonClassQName(rinfo, pack);
  		pr.print("public ").print(serverClassName).print(" addRemote(").print(typeName).println(" remoteSkeleton) {");
  		pr.beginBlock();
  		pr.println("addRemote(" + rinfo.typeId + ", remoteSkeleton);");
  		pr.println("return this;");
  		pr.endBlock();
  		pr.println("}");
  		pr.println();
	  }
	}

	private CodePrinter pr;
	private String pack;
	private String serverClassName;
	private PrintContext pctxt; 
	
}


/*
public BSerializer getByClassName(Object obj) {
Class<?> clazz = obj.getClass();
if (clazz == Alpha.class) return byps.example.api.BSerializer_132.instance;
if (clazz == int[].class)return  

return null;
}
*/