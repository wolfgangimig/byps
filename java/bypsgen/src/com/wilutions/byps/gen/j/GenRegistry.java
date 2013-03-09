package com.wilutions.byps.gen.j;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.BException;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.utils.CodePrinter;

   
public class GenRegistry {
	static Log log = LogFactory.getLog(GenRegistry.class);
	
	static void generate(PrintContext pctxt, Iterable<SerialInfo> serInfos, BBinaryModel pformat) throws IOException {
		log.debug("generate");
		CodePrinter pr = pctxt.getPrinterForRegistry(pformat);
		new GenRegistry(pctxt, serInfos, pr, pformat).generate();
		pr.close();
		log.debug(")generate");
	}

	private GenRegistry(PrintContext pctxt, Iterable<SerialInfo> serInfos, CodePrinter pr, BBinaryModel pformat) {
		this.pctxt = pctxt;
		this.serInfos = serInfos;
		this.registryClassName = pctxt.getRegistryClassName(pformat);
		this.pack = pctxt.getRegistryPackage();
		this.pr = pr;
		this.pformat = pformat;
	}
	
	private void generate() throws IOException {
		log.debug("generate");
		
		pr.print("package ").print(pack).print(";").println();
		pr.println();
		
		pctxt.printDoNotModify(pr);

		pr.println("import com.wilutions.byps.*;");
		pr.println();
		
		pr.print("public class ").print(registryClassName).println(" extends BRegistry { ");
		pr.println();
		
		pr.beginBlock();
		
		printConstructor();
		
		printGetSerializerByTypeId();
		
		pr.endBlock();
		
		pr.println("}");

		log.debug(")generate");
	}

	private void printConstructor() {
		log.debug("printConstructors(");
		
		pr.print("public ").print(registryClassName).println("(BBinaryModel bmodel) {");
		pr.beginBlock();
		pr.println("super(bmodel);");
		pr.endBlock();
		pr.println("}");
		pr.println();

		log.debug("printConstructors");
	}

	private void printGetSerializerByTypeId()
			throws BException {
		pr.println("@Override");
		pr.println("public BSerializer getApiSerializer(int typeId) {");
		
		pr.beginBlock();
		for (SerialInfo serInfo : serInfos) {
			
			if (serInfo.isBuiltInType()) continue;
			if (!serInfo.isPointerType()) continue;
			
			String serializerName = pctxt.getSerializerPackage(serInfo) + "." + pctxt.getSerializerClassName(serInfo, pformat);
			
			pr.print("// ").print(serInfo.toString()).println();
			pr.print("if (typeId == " + serInfo.typeId +") return ")
				.print(serializerName).print(".instance;")
				.println();
		}
		
		pr.println("return null;");
		
		pr.endBlock();
		pr.println("};");
	}
	
	private Iterable<SerialInfo> serInfos;
	private CodePrinter pr;
	private String pack;
	private String registryClassName;
	private PrintContext pctxt; 
	private final BBinaryModel pformat;
}