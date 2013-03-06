package com.wilutions.byps.gen.cs;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.BException;
import com.wilutions.byps.BRegistry;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.api.TypeInfo;
import com.wilutions.byps.gen.utils.CodePrinter;


public class GenSerList {
	static Log log = LogFactory.getLog(GenSerList.class);

	GenSerList(PrintContext pctxt, SerialInfo serInfo, CodePrinter pr) throws BException {
		this(pctxt, serInfo, pr, BBinaryModel.MEDIUM);
	}
	
	GenSerList(PrintContext pctxt, SerialInfo serInfo, CodePrinter pr, BBinaryModel bmodel) throws BException {
		this.serInfo = serInfo;
		this.pr = pr;
		this.serializerName = pctxt.getSerializerClassName(serInfo, bmodel);
		this.pack = pctxt.getSerializerPackage(serInfo);
		this.pctxt = pctxt;
		this.bmodel = bmodel;
		
		if (serInfo.typeArgs.size() != 1) throw new BException(BException.INTERNAL, "Expected 1 type argument for Set/List class: " + serInfo.toString());
		elmType = serInfo.typeArgs.get(0);
	}
	
	protected void printConstructors() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printConstructors");
		
		pr.print("public ").print(serializerName).println("() ");
		pr.beginBlock();
		pr.println(": base(" + serInfo.typeId + ") {}");
		pr.endBlock();
		
		//log.debug(GeneratorJ.class.getName(), "printConstructors");
	}
	
	protected void printSingletonInstance() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printSingletonInstance");

		pr.print("public readonly static new BSerializer instance = new ").print(""+serializerName).println("();");
		
		//log.debug(GeneratorJ.class.getName(), "printSingletonInstance");
	}
	
	protected void printRead() throws IOException {
	    String csElmType = pctxt.toCSharp(elmType).toString();
	    String csType = ((serInfo.isListType()) ? "List<" : "HashSet<") + csElmType + ">";

	    pr.println("public override Object read(object obj1, BInput bin1, int version) {");
		pr.beginBlock();
	    pr.println("BInputBin bin = ((BInputBin)bin1);");
	    pr.println("BBufferBin bbuf = bin.bbuf;");
	    
	    pr.println("int n = bbuf.getLength();");
	    
	    pr.print(csType).print(" arr = new ").print(csType)
			.print(serInfo.isListType() ? "(n)" : "()").println(";");
	    pr.println("bin.onObjectCreated(arr);");

	    pr.println("for (int i = 0; i < n; i++) {");
	    pr.beginBlock();
	    
		CodePrinter mpr = pr.print(csElmType).print(" ");
		pctxt.printStreamGetItem(mpr, BBinaryModel.MEDIUM, "obj", elmType);
		
		pr.println("arr.Add(obj);");

	    pr.endBlock();
	    pr.println("}");
	    pr.println("return arr;");
		pr.endBlock();
		pr.println("}");
	}
	
	protected void printWrite() throws IOException {
	    String cstype = pctxt.toCSharp(serInfo).toString();
	    String csElmType = pctxt.toCSharp(elmType).toString();

	    pr.println("public override void write(Object obj1, BOutput bout1, int version)  {");
	    pr.beginBlock();
	    pr.println("BOutputBin bout = ((BOutputBin)bout1);");
	    pr.println("BBufferBin bbuf = bout.bbuf;");
	    pr.print(cstype).print(" arr = (").print(cstype).print(")obj1;").println();
	    pr.println("int n = arr.Count;");
	    pr.println("bout.bbuf.putLength(n);");
	    pr.print("foreach (").print(csElmType).print(" obj in arr) {").println();
	    pr.beginBlock();
	    pctxt.printStreamPutItem(pr, BBinaryModel.MEDIUM, "obj", elmType);
	    pr.endBlock();
	    pr.println("}");
	    pr.endBlock();
	    pr.println("}");
	}
	
	void generate() throws IOException {
		//log.debug(GenSerList.class.getName(), "generateListSerializer");
		
		pctxt.printDoNotModify(pr, "Serializer for " + serInfo);
		
		pr.println("using System;");
		pr.println("using System.Collections.Generic;");
		pr.println("using com.wilutions.byps;");
		pr.println();
		pr.println("namespace " + pack);
		pr.println("{");
		pr.beginBlock();
		pr.println();
		
		String baseClass = bmodel == BBinaryModel.JSON ? "JSerializer_" : "BSerializer_";
		int baseTypeId = serInfo.isSetType() ? BRegistry.TYPEID_SET : BRegistry.TYPEID_LIST; 
		pr.print("public class ").print(serializerName)
		  .print(" : " + baseClass + baseTypeId).println(" {");
		
		pr.beginBlock();
		pr.println();
		
		printSingletonInstance();
		pr.println();
		
		printConstructors();
		pr.println();
		
		printRead();
		pr.println();

		printWrite();
		pr.println();
		
		pr.endBlock();
		pr.println("}");

		pr.endBlock();
		pr.println("} // namespace");

		//log.debug(GenSerList.class.getName(), "generateListSerializer");
	}

	
	final protected SerialInfo serInfo;
	final protected CodePrinter pr;
	final protected String serializerName;
	final protected String pack;
	final protected TypeInfo elmType;
	final protected PrintContext pctxt;
	final protected BBinaryModel bmodel;
}
