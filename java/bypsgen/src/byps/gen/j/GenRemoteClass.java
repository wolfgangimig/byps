package byps.gen.j;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.gen.api.MethodInfo;
import byps.gen.api.RemoteInfo;
import byps.gen.utils.CodePrinter;

class GenRemoteClass {
	
	static Log log = LogFactory.getLog(GenRemoteClass.class);
	
	private final static String IMPL_SUFFIX = "";
	
	static void generate(PrintContext pctxt, RemoteInfo rinfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "generate");
		log.info("generate " + rinfo.qname);
		CodePrinter pr = pctxt.getPrinterForApiClass(rinfo, IMPL_SUFFIX, false);
		if (pr != null) {
			new GenRemoteClass(pctxt, rinfo, pr).generate();
			pr.close();
		}
		//log.debug(GeneratorJ.class.getName(), "generate");
	}
	
	protected GenRemoteClass(PrintContext pctxt, RemoteInfo rinfo, CodePrinter pr) {
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
	
	private void generate() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "generate");

		pr.print("package ").print(rinfo.pack).print(";").println();
		pr.println();
		
		pctxt.printDoNotModify(pr, getClass());

		pr.println("import byps.*;");
		pr.println();

		pctxt.printComments(pr, rinfo.comments);
		
		pr.print("public interface ").print(interfaceName).println(" extends BRemote {");
		pr.println();
		
		pr.beginBlock();
		
		for (MethodInfo minfo : rinfo.methods) {
			printMethod(minfo);
			pr.println();
		}
		
		pr.println();
		
		pr.endBlock();
		
		pr.println("}");

		//log.debug(GeneratorJ.class.getName(), "generate");
	}

	protected final String interfaceName;
	protected final RemoteInfo rinfo;
	protected final CodePrinter pr;
	protected final PrintContext pctxt;
}
