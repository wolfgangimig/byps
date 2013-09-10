package com.wilutions.byps.gen.cs;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.gen.api.MethodInfo;
import com.wilutions.byps.gen.api.RemoteInfo;
import com.wilutions.byps.gen.utils.CodePrinter;

class GenRemoteClass {
	
	static Log log = LogFactory.getLog(GenRemoteClass.class);
	
	private final static String IMPL_SUFFIX = "";
	
	static void generate(PrintContext pctxt, RemoteInfo rinfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "generate");
	  if (rinfo != null) {
  		log.info("generate " + rinfo.qname);
  		CodePrinter pr = pctxt.getPrinterForApiClass(rinfo, IMPL_SUFFIX, false);
  		new GenRemoteClass(pctxt, rinfo, pr).generate();
  		pr.close();
	  }
		//log.debug(GeneratorJ.class.getName(), "generate");
	}
	
	private GenRemoteClass(PrintContext pctxt, RemoteInfo rinfo, CodePrinter pr) {
		this.rinfo = rinfo;
		this.pr = pr;
		this.interfaceName = IMPL_SUFFIX + rinfo.name;
		this.pctxt = pctxt;
	}
	
	private void printMethod(MethodInfo methodInfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printMember");
		
		pctxt.printComments(pr, methodInfo.comments);
		
		CodePrinter mpr = pctxt.printDeclareMethod(pr, rinfo, methodInfo);
		mpr.println(";");
		
		//log.debug(GeneratorJ.class.getName(), "printMember");
	}
	
	private void printMethodAsync(MethodInfo methodInfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printMethodAsync");
		
		CodePrinter mpr = pctxt.printDeclareMethodAsync(pr, rinfo, methodInfo);
		mpr.println(";");
		
		//log.debug(GeneratorJ.class.getName(), "printMethodAsync");
	}

	private void printMethodBeginAsync(MethodInfo methodInfo) throws IOException {
		CodePrinter mpr = pctxt.printDeclareMethodBeginAsync(pr, rinfo, methodInfo);
		mpr.println(";");
	}
	
	private void printMethodEndAsync(MethodInfo methodInfo) throws IOException {
		CodePrinter mpr = pctxt.printDeclareMethodEndAsync(pr, rinfo, methodInfo);
		mpr.println(";");
	}
	
	private void generate() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "generate");

		pr.println("using System;");
		pr.println("using System.Collections.Generic;");
		pr.println("using com.wilutions.byps;");
		pr.println();
		pr.println("namespace " + rinfo.pack);
		pr.println("{");
		pr.beginBlock();
		pr.println();
		
		pctxt.printComments(pr, rinfo.comments);
		
		pr.print("public interface ").print(interfaceName).println(" : BRemote");
		pr.println("{");
		
		pr.beginBlock();
		
		for (MethodInfo minfo : rinfo.methods) {
			printMethod(minfo);
			printMethodAsync(minfo);
			printMethodBeginAsync(minfo);
			printMethodEndAsync(minfo);
			pr.println();
		}
		
		pr.println();
		
		pr.endBlock();
		
		pr.println("}");

		pr.endBlock();
		pr.println("}  // end namespace");

		//log.debug(GeneratorJ.class.getName(), "generate");
	}

	private final String interfaceName;
	private final RemoteInfo rinfo;
	private final CodePrinter pr;
	private final PrintContext pctxt;
}
