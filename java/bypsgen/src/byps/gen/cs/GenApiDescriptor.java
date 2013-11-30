package byps.gen.cs;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BApiDescriptor;
import byps.BBinaryModel;
import byps.BVersioning;
import byps.gen.utils.CodePrinter;

   
public class GenApiDescriptor {
	static Log log = LogFactory.getLog(GenApiDescriptor.class);
	
	static void generate(PrintContext pctxt, BApiDescriptor apiDesc) throws IOException {
		log.debug("generate");
		CodePrinter pr = pctxt.getPrinterForApiDescriptor();
		new GenApiDescriptor(pctxt, apiDesc, pr).generate();
		pr.close();
		log.debug(")generate");
	}

	private GenApiDescriptor(PrintContext pctxt, BApiDescriptor apiDesc, CodePrinter pr) {
		this.pctxt = pctxt;
		this.apiDesc = apiDesc;
		this.apiDescClassName = pctxt.getApiDescriptorClassName();
		this.pack = pctxt.getApiDescriptorPackage();
		this.pr = pr;
	}
	
	private void generate() throws IOException {
		log.debug("generate");
		
		pr.println("using System;");
		pr.println("using System.Collections.Generic;");
		pr.println("using byps;");
		pr.println();
		pr.println("namespace " + pctxt.renamePackage(pack));
		pr.println("{");
		pr.beginBlock();
		pr.println();
		
		pr.print("public class ").print(apiDescClassName).println(" { ");
		pr.println();
		
		pr.beginBlock();
		
		printStaticMembers();
		pr.println();
		
		printInstance();
		pr.println();
		
//		printCreateRemotes();
//		pr.println();
		
		pr.endBlock();
		pr.println("}");
		pr.endBlock();
		pr.println("}");

		log.debug(")generate");
	}
	
	private void printStaticMembers() {
		log.debug("printStaticMembers");
		
		pr.println("/**");
		pr.print(" * API serialisation version: ").print(BVersioning.longToString(apiDesc.version)).println();
		pr.println(" */");
		pr.print("public const long VERSION = " + apiDesc.version + "L;").println();

		log.debug(")printStaticMembers");
	}

	private void printInstance() {
		log.debug("printInstance");
		
		pr.print("public readonly static BApiDescriptor instance = new BApiDescriptor(").println();
		pr.beginBlock();
		pr.println("\"" + apiDesc.name + "\",");
		pr.println("\"" + apiDesc.basePackage + "\",");
		pr.println("VERSION,");
		pr.println(apiDesc.uniqueObjects + ") // uniqueObjects");
		pr.print(".addRegistry(new ").print(pctxt.getRegistryClassName(BBinaryModel.MEDIUM)).println("());");
		pr.endBlock();
		pr.println();

		log.debug(")printInstance");
	}
	
//	private void printCreateRemotes() {
//		log.debug("printCreateRemotes");
//		for (RemoteInfo rinfo : pctxt.classDB.getRemotes()) {
//			printCreateRemote(rinfo);
//			pr.println();
//		}
//		log.debug(")printCreateRemotes");
//	}

//	private void printCreateRemote(RemoteInfo rinfo) {
//		log.debug("printCreateRemote");
//		pr.print("public static ").print(rinfo.toString(pack)).print(" create").print(rinfo.name)
//			.print("(BWire wire) {").println();
//		pr.beginBlock();
//		pr.println("final BTransport trans = new BTransport(instance, wire);");
//		
//		String stubClassName = pctxt.getStubClassQName(rinfo, pack);
//		pr.print("return new ").print(stubClassName).print("(trans);").println();
//		
//		pr.endBlock();
//		pr.println("}");
//		log.debug(")printCreateRemote");
//		
//	}
	
	private CodePrinter pr;
	private BApiDescriptor apiDesc;
	private String pack;
	private String apiDescClassName;
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