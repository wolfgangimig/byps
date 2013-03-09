package com.wilutions.byps.gen.js;

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
		
		pr.print(serializerName).println(" = function() {");
		
		pr.beginBlock();
		pr.println();
		
		pr.println("this.write = function(remote, bout) {");
		pr.beginBlock();
		pr.println("var transport = new com.wilutions.byps.BTransport(bout.transport.apiDesc, remote.transport.targetId");
		pr.print("return stub;");

		pr.println("this.read = function(obj, bin) {");
		pr.beginBlock();
		pr.println("var transport = new com.wilutions.byps.BTransport(bin.transport.apiDesc, obj.targetId");
		pr.print("var remote = new ").print(serInfo.pack).print(".").print(serInfo.name).println("(transport);");
		pr.print("return remote;");
		
		pr.endBlock();
		pr.println("};");

		pr.endBlock();
		pr.println("};");
		pr.print(serializerName).print(".prototype = new com.wilutions.byps.BSerializer();");

		//log.debug(GenSerArray.class.getName(), "generate");
	}

	final protected SerialInfo serInfo;
	final protected CodePrinter pr;
	final protected String serializerName;
	final protected String pack;
	final protected PrintContext pctxt;
	final protected BBinaryModel bmodel;
}