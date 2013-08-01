package com.wilutions.byps.gen.j;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.utils.CodePrinter;

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

		pr.print("public final static BSerializer instance = new ").print(""+serializerName).println("();");
		
		//log.debug(GeneratorJ.class.getName(), "printSingletonInstance");
	}

	protected void printConstructors() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printConstructors");
		
		pr.print("public ").print(serializerName).println("() {");
		pr.beginBlock();
		pr.print("super(" + serInfo.typeId + ");").println();
		pr.endBlock();
		pr.println("}");

		//log.debug(GeneratorJ.class.getName(), "printConstructors");
	}

	protected void printCreate() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printCreate");
				
		pr.println("@Override");
		pr.println("public BRemote internalCreate(final BTransport transport) throws BException {");
		pr.beginBlock();
		
		String className = serInfo.toString(serInfo.pack);
		pr.print("return new ").print(className).println("(transport);");
		pr.endBlock();
		pr.println("}");
		
		//log.debug(GeneratorJ.class.getName(), "printCreate");
	}

	void generate() throws IOException {
		//log.debug(GenSerArray.class.getName(), "generate");
		
		pr.print("package ").print(pack).print(";").println();
		pr.println();

		pctxt.printDoNotModify(pr, getClass(), "Serializer for " + serInfo);

		pr.println("import com.wilutions.byps.*;");

		pr.println("@SuppressWarnings(\"all\")");
		
		String baseName = bmodel == BBinaryModel.JSON ? "JSerializer_16" : "BSerializer_16";
		pr.print("public class ").print(serializerName)
		  .print(" extends ").print(baseName).println(" {");
		
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

		//log.debug(GenSerArray.class.getName(), "generate");
	}

	final protected SerialInfo serInfo;
	final protected CodePrinter pr;
	final protected String serializerName;
	final protected String pack;
	final protected PrintContext pctxt;
	final protected BBinaryModel bmodel;
}
