package com.wilutions.byps.gen.j;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.gen.api.MethodInfo;
import com.wilutions.byps.gen.api.RemoteInfo;
import com.wilutions.byps.gen.utils.CodePrinter;

class GenRemoteClassAsync extends GenRemoteClass {
	
	static Log log = LogFactory.getLog(GenRemoteClassAsync.class);
	
	private final static String IMPL_SUFFIX = "";
	
	static void generate(PrintContext pctxt, RemoteInfo rinfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "generate");
		RemoteInfo rinfoAsync = rinfo.getRemoteAsync();
		log.info("generate " + rinfoAsync.qname);
		CodePrinter pr = pctxt.getPrinterForApiClass(rinfoAsync, IMPL_SUFFIX, true);
		new GenRemoteClassAsync(pctxt, rinfoAsync, pr).generate();
		pr.close();
		//log.debug(GeneratorJ.class.getName(), "generate");
	}
	
	private GenRemoteClassAsync(PrintContext pctxt, RemoteInfo rinfo, CodePrinter pr) {
		super(pctxt, rinfo, pr);
	}
	
	private void printMethodAsync(MethodInfo methodInfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printMethodAsync");
		
		CodePrinter mpr = pctxt.printDeclareMethodAsync(pr, rinfo, methodInfo);
		mpr.println(";");
		
		//log.debug(GeneratorJ.class.getName(), "printMethodAsync");
	}

	private void generate() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "generate");

		pr.print("package ").print(rinfo.pack).print(";").println();
		pr.println();
		
		pctxt.printDoNotModify(pr);

		pr.println("import com.wilutions.byps.*;");
		pr.println();

		String superClass = interfaceName.substring(0, interfaceName.indexOf(RemoteInfo.ASYNC_SUFFIX));
		pr.print("public interface ").print(interfaceName).print(" extends ").print(superClass).println(" {");
		pr.println();
		
		pr.beginBlock();
		
		for (MethodInfo minfo : rinfo.methods) {
			printMethodAsync(minfo);
			pr.println();
		}
		
		pr.println();
		
		pr.endBlock();
		
		pr.println("}");

		//log.debug(GeneratorJ.class.getName(), "generate");
	}

}
