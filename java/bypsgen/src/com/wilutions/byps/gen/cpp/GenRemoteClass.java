package com.wilutions.byps.gen.cpp;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.gen.api.GeneratorException;
import com.wilutions.byps.gen.api.MethodInfo;
import com.wilutions.byps.gen.api.RemoteInfo;
import com.wilutions.byps.gen.utils.CodePrinter;

class GenRemoteClass {
	
	static Log log = LogFactory.getLog(GenRemoteClass.class);
	
	
	static void generate(PrintContext pctxt, RemoteInfo rinfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "generate");
	  if (rinfo != null) {
  		log.info("generate " + rinfo.qname);
  		new GenRemoteClass(pctxt, rinfo).generate();
	  }
		//log.debug(GeneratorJ.class.getName(), "generate");
	}
	
	protected GenRemoteClass(PrintContext pctxt, RemoteInfo rinfo) {
		this.pctxt = pctxt;
		this.cppInfo = new TypeInfoCpp(rinfo);
		this.prH = pctxt.getPrApiAllH();
		this.rinfo = rinfo;
	}
	
	private void printMethod(MethodInfo methodInfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printMember");
		
		pctxt.printComments(prH, methodInfo.comments);
		
		pctxt.printDeclareMethod(prH, null, rinfo, methodInfo).println(" = 0;");
		
		//log.debug(GeneratorJ.class.getName(), "printMember");
	}
	
	private void printMethodAsync(MethodInfo methodInfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printMethodAsync");
		
		pctxt.printDeclareMethodAsync(prH, null, rinfo, methodInfo).println(" = 0;");
		
		//log.debug(GeneratorJ.class.getName(), "printMethodAsync");
	}

	protected void generate() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "generate");

		String className = cppInfo.getClassName(rinfo.pack);
		
		beginClass(prH, className);
		prH.println("using namespace ::com::wilutions::byps;");
		prH.println();

		pctxt.printComments(prH, rinfo.comments);
		
		//beginClass(prC, className);

		CodePrinter mpr = prH.print("class ").print(rinfo.name).print(" : public virtual BRemote");
		
		prH.beginBlock();
    for (String baseName : rinfo.baseQNames) {
      
      RemoteInfo rinfoBase = pctxt.classDB.getRemoteInfo(baseName);
      RemoteInfo rinfoImpl = getBaseRemoteInfo(rinfoBase);
      TypeInfoCpp rinfoImplCpp = new TypeInfoCpp(rinfoImpl);
    
      mpr.print(", ").println();
      mpr = prH.print("public virtual ").print(rinfoImplCpp.getClassName(rinfo.pack));
    }
      
    prH.endBlock();
		
		prH.println(" {");
		
		prH.beginBlock();
		
		prH.println();
		
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

  protected String getBaseRemote() {
    return null;
  }
  
  protected RemoteInfo getBaseRemoteInfo(RemoteInfo rinfoBase) throws GeneratorException {
    return rinfoBase;
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
	

	protected final RemoteInfo rinfo;
	private final TypeInfoCpp cppInfo;
	private final CodePrinter prH;
	private final PrintContext pctxt;
}
