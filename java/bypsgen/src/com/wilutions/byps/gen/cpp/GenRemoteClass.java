package com.wilutions.byps.gen.cpp;

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
		log.info("generate " + rinfo.qname);
		new GenRemoteClass(pctxt, rinfo).generate();
		//log.debug(GeneratorJ.class.getName(), "generate");
	}
	
	private GenRemoteClass(PrintContext pctxt, RemoteInfo rinfo) {
		this.pctxt = pctxt;
		this.cppInfo = new TypeInfoCpp(rinfo);
		this.baseCppInfo = cppInfo.getBaseInfo();
		this.prH = pctxt.prApiAllH;
		this.prC = pctxt.prImplC;
		this.rinfo = rinfo;
		this.interfaceName = IMPL_SUFFIX + rinfo.name;
	}
	
	private void printMethod(MethodInfo methodInfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printMember");
		
		pctxt.printComments(prH, methodInfo.comments);
		
		CodePrinter mpr = prH.print("virtual ");
		pctxt.printDeclareMethod(mpr, rinfo, methodInfo);
		mpr.println(" = 0;");
		
		//log.debug(GeneratorJ.class.getName(), "printMember");
	}
	
	private void printMethodAsync(MethodInfo methodInfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printMethodAsync");
		
		CodePrinter mpr = prH.print("virtual ");
		pctxt.printDeclareMethodAsync(mpr, rinfo, methodInfo);
		mpr.println(" = 0;");
		
		//log.debug(GeneratorJ.class.getName(), "printMethodAsync");
	}

	private void generate() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "generate");

		String className = cppInfo.getClassName(rinfo.pack);
		
		beginClass(prH, className);
		prH.println("using namespace com::wilutions::byps;");
		prH.println();

		pctxt.printComments(prH, rinfo.comments);
		
		//beginClass(prC, className);

		prH.print("class ").print(interfaceName).println(" : public BRemote");
		prH.println("{");
		
		prH.beginBlock();
		
		for (MethodInfo minfo : rinfo.methods) {
			printMethod(minfo);
			printMethodAsync(minfo);
			prH.println();
		}
		
		prH.println();
		
		prH.endBlock();
		
		prH.println("};");

		prH.endBlock();
		
		endClass(prH);
		
		//endClass(prC);

		//log.debug(GeneratorJ.class.getName(), "generate");
	}

	private void beginClass(CodePrinter pr, String className) throws IOException {
		pr.println();
		pctxt.printLine(pr);
		pr.print("// ").println(className);
		pr.println();

		pr.print(cppInfo.namespaceBegin).println();
		pr.println();
	}
	
	private void endClass(CodePrinter pr) throws IOException {
		pr.println();
		pr.println(cppInfo.namespaceEnd);
	}
	

	private final String interfaceName;
	private final RemoteInfo rinfo;
	private final TypeInfoCpp cppInfo;
	private final TypeInfoCpp baseCppInfo;
	private final CodePrinter prH;
	private final CodePrinter prC;
	private final PrintContext pctxt;
}
