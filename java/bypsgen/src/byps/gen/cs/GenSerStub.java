package byps.gen.cs;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BBinaryModel;
import byps.gen.api.SerialInfo;
import byps.gen.utils.CodePrinter;

public class GenSerStub {
	static Log log = LogFactory.getLog(GenSerStub.class);
	
	GenSerStub(PrintContext pctxt, SerialInfo serInfo, CodePrinter pr, BBinaryModel pformat) {
		this.serInfo = serInfo;
		this.pr = pr;
		this.serializerName = pctxt.getSerializerClassName(serInfo, pformat);
		this.pack = pctxt.getSerializerPackage(serInfo);
		this.pctxt = pctxt;
		this.bmodel = pformat;
	}
	
	protected void printSingletonInstance() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printSingletonInstance");

		pr.print("public readonly static BSerializer instance = new ").print(""+serializerName).println("();");
		
		//log.debug(GeneratorJ.class.getName(), "printSingletonInstance");
	}

	protected void printConstructors() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printConstructors");
		
		pr.print("public ").print(serializerName).println("()");
		pr.beginBlock();
		pr.print(": base(" + serInfo.typeId + ") {}").println();
		pr.endBlock();

		//log.debug(GeneratorJ.class.getName(), "printConstructors");
	}

	protected void printCreate() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printCreate");
				
		pr.println("protected override BRemote internalCreate(BTransport transport) {");
		pr.beginBlock();
		
		String className = serInfo.toString(serInfo.pack);
		pr.print("return new ").print(className).println("(transport);");
		pr.endBlock();
		pr.println("}");
		
		//log.debug(GeneratorJ.class.getName(), "printCreate");
	}

	void generate() throws IOException {
		//log.debug(GenSerArray.class.getName(), "generate");
		
		pctxt.printDoNotModify(pr, "Serializer for " + serInfo);
		
		pr.println("using System;");
		pr.println("using System.Collections.Generic;");
		pr.println("using byps;");
		pr.println();
    pr.print("namespace ").println(pctxt.renamePackage(pack));
		pr.println("{");
		pr.beginBlock();
		pr.println();

		String baseName = bmodel == BBinaryModel.JSON ? "JSerializer_16" : "BSerializer_16";
		pr.print("public class ").print(serializerName)
		  .print(" : ").print(baseName).println(" {");
		
		pr.beginBlock();
		pr.println();
		
		printSingletonInstance();
		pr.println();
		
		printConstructors();
		pr.println();
		
		printCreate();
		pr.println();
		
		pr.endBlock();
		
		pr.println("}");
		
		pr.endBlock();
		pr.println("} // namespace");

		//log.debug(GenSerArray.class.getName(), "generate");
	}

	final protected SerialInfo serInfo;
	final protected CodePrinter pr;
	final protected String serializerName;
	final protected String pack;
	final protected PrintContext pctxt;
	final protected BBinaryModel bmodel;
}
