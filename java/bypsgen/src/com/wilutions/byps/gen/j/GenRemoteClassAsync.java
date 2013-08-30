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
	
	static void generate(PrintContext pctxt, RemoteInfo rinfoAsync) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "generate");
	  if (rinfoAsync != null) {
  		log.info("generate " + rinfoAsync.qname);
  		CodePrinter pr = pctxt.getPrinterForApiClass(rinfoAsync, IMPL_SUFFIX, true);
  		new GenRemoteClassAsync(pctxt, rinfoAsync, pr).generate();
  		pr.close();
	  }
		//log.debug(GeneratorJ.class.getName(), "generate");
	}
	
	private GenRemoteClassAsync(PrintContext pctxt, RemoteInfo rinfo, CodePrinter pr) {
		super(pctxt, rinfo, pr);
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

	private void generate() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "generate");

		pr.print("package ").print(rinfo.pack).print(";").println();
		pr.println();
		
		pctxt.printDoNotModify(pr, getClass());

		pr.println("import com.wilutions.byps.*;");
		pr.println();

		pr.checkpoint();
		pr.print("public interface ").print(interfaceName);

		String superClass = rinfo.getBaseClassQName();
		pr.print(" extends ");
		if (superClass != null) pr.print(superClass).print(", ");
		pr.println("BRemote {");
		pr.println();
		
		pr.beginBlock();
		
		for (MethodInfo minfo : rinfo.methods) {
      printMethod(minfo);
      printMethodAsync(minfo);
			pr.println();
		}
		
		pr.println();
		
		pr.endBlock();
		
		pr.println("}");

		//log.debug(GeneratorJ.class.getName(), "generate");
	}

}
