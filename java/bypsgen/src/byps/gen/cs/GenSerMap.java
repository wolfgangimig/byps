package byps.gen.cs;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BBinaryModel;
import byps.BException;
import byps.BExceptionC;
import byps.BRegistry;
import byps.gen.api.SerialInfo;
import byps.gen.api.TypeInfo;
import byps.gen.utils.CodePrinter;

public class GenSerMap {
	static Log log = LogFactory.getLog(GenSerMap.class);
	
	GenSerMap(PrintContext pctxt, SerialInfo serInfo, CodePrinter pr) throws BException {
		this(pctxt, serInfo, pr, BBinaryModel.MEDIUM);
	}
	
	protected GenSerMap(PrintContext pctxt, SerialInfo serInfo, CodePrinter pr, BBinaryModel bmodel) throws BException {
		this.serInfo = serInfo;
		this.pr = pr;
		this.serializerName = pctxt.getSerializerClassName(serInfo, bmodel);
		this.pack = pctxt.getSerializerPackage(serInfo);
		this.pctxt = pctxt;
		this.bmodel = bmodel;
		
		if (serInfo.typeArgs.size() != 2) throw new BException(BExceptionC.INTERNAL, "Expected 2 type arguments for Map class: " + serInfo.toString());
		keyType = serInfo.typeArgs.get(0);
		valueType = serInfo.typeArgs.get(1);
	}
	
	protected void printConstructors() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printConstructors");
		
		pr.print("public ").print(serializerName).println("()");
		pr.beginBlock();
		pr.print(": base(" + serInfo.typeId + ") {}");
		pr.endBlock();
		pr.println();

		//log.debug(GeneratorJ.class.getName(), "printConstructors");
	}
	
	protected void printSingletonInstance() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printSingletonInstance");

		pr.print("public readonly static new BSerializer instance = new ").print(""+serializerName).println("();");
		
		//log.debug(GeneratorJ.class.getName(), "printSingletonInstance");
	}
	
	protected void printWrite() throws IOException {
		String csKeyType = pctxt.toCSharp(keyType).toString();
		String csValueType = pctxt.toCSharp(valueType).toString();
		String csType = "Dictionary<" + csKeyType + "," + csValueType + ">";

	    pr.println("public override void write(Object obj1, BOutput bout1, long version)  {");
	    pr.beginBlock();
	    pr.println("BOutputBin bout = ((BOutputBin)bout1);");
	    pr.println("BBufferBin bbuf = bout.bbuf;");
	    pr.print(csType).print(" map = (").print(csType).print(")obj1;").println();
	    pr.println("int n = map.Count;");
	    pr.println("bout.bbuf.putLength(n);");
	    pr.print("foreach (KeyValuePair<").print(csKeyType).print(",").print(csValueType).print("> obj in map) {").println();
	    pr.beginBlock();
	    pctxt.printStreamPutItem(pr, BBinaryModel.MEDIUM, "obj.Key", keyType);
	    pctxt.printStreamPutItem(pr, BBinaryModel.MEDIUM, "obj.Value", valueType);
	    pr.endBlock();
	    pr.println("}");
	    pr.endBlock();
	    pr.println("}");
	}

	protected void printRead() {
		String csKeyType = pctxt.toCSharp(keyType).toString();
		String csValueType = pctxt.toCSharp(valueType).toString();
		String csType = "Dictionary<" + csKeyType + "," + csValueType + ">";
		
	    pr.println("public override Object read(object obj1, BInput bin1, long version) {");
		pr.beginBlock();
	    pr.println("BInputBin bin = ((BInputBin)bin1);");
	    pr.println("BBufferBin bbuf = bin.bbuf;");
	    
	    pr.print(csType).print(" map = new ").print(csType).println("();");
	    pr.println("bin.onObjectCreated(map);");
	    
	    pr.println("int n = bbuf.getLength();");
		pr.println("for (int i = 0; i < n; i++) {");
		pr.beginBlock();
		
		CodePrinter mpr = pr.print(csKeyType).print(" ");
		pctxt.printStreamGetItem(mpr, BBinaryModel.MEDIUM, "key", keyType);

		mpr = pr.print(csValueType).print(" ");
		pctxt.printStreamGetItem(mpr, BBinaryModel.MEDIUM, "value", valueType);

		pr.println("map[key] = value;");
		pr.endBlock();
		pr.println("}");
	    pr.println("return map;");
		pr.endBlock();
		pr.println("}");

	}

	void generate() throws IOException {
		//log.debug(GenSerMap.class.getName(), "generateListSerializer");
		
		pctxt.printDoNotModify(pr, "Serializer for " + serInfo);
		
		pr.println("using System;");
		pr.println("using System.Collections.Generic;");
		pr.println("using byps;");
		pr.println();
		pr.println("namespace " + pack);
		pr.println("{");
		pr.beginBlock();
		pr.println();
		
		String baseClass = bmodel == BBinaryModel.JSON ? "JSerializer" : "BSerializer";
		pr.print("public class ").print(serializerName)
		  .print(" : " + baseClass + "_" + BRegistry.TYPEID_MAP).println(" {");
		
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

		//log.debug(GenSerMap.class.getName(), "generateListSerializer");
	}

	
	final protected SerialInfo serInfo;
	final protected CodePrinter pr;
	final protected String serializerName;
	final protected String pack;
	final protected TypeInfo keyType;
	final protected TypeInfo valueType;
	final protected PrintContext pctxt;
	final protected BBinaryModel bmodel;
}
