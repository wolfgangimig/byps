package com.wilutions.byps.gen.j;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.BException;
import com.wilutions.byps.BRegistry;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.api.TypeInfo;
import com.wilutions.byps.gen.utils.CodePrinter;

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
		
		if (serInfo.typeArgs.size() != 2) throw new BException(BException.INTERNAL, "Expected 2 type arguments for Map class: " + serInfo.toString());
		keyType = serInfo.typeArgs.get(0);
		valueType = serInfo.typeArgs.get(1);
	}
	
	protected void printConstructors() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printConstructors");
		
		pr.print("public ").print(serializerName).println("() {");
		pr.beginBlock();
		pr.print("super(" + serInfo.typeId + ");");
		pr.endBlock();
		pr.println("}");
		pr.println();

		//log.debug(GeneratorJ.class.getName(), "printConstructors");
	}
	
	protected void printSingletonInstance() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printSingletonInstance");

		pr.print("public final static BSerializer instance = new ").print(""+serializerName).println("();");
		
		//log.debug(GeneratorJ.class.getName(), "printSingletonInstance");
	}
	
	protected String getMapTypeToCreate() {
		String listType = serInfo.toString("java.util");
		if (serInfo.name.equals("Map")) {
			listType = "HashMap<" + keyType.toString() + "," + valueType.toString() + ">";
		}
		return listType;
	}

	protected void printRead() throws IOException {
		String listType = getMapTypeToCreate();

	    pr.println("public Object read(final Object obj1, final BInput bin1, final int version) throws BException {");
		pr.beginBlock();
	    pr.println("final BInputBin bin = (BInputBin)bin1;");
	    pr.println("final BBufferBin bbuf = bin.bbuf;");
	    
	    pr.print("final ").print(listType).print(" map = new ").print(listType).print("();").println();
		pr.println("bin.onObjectCreated(map);");

    	pr.println("int n = bbuf.getLength();");

	    pr.println("for (int i0 = 0; i0 < n; i0++) {");
	    pr.beginBlock();
	    
		CodePrinter mpr = pr.print(keyType.toString()).print(" ");
		pctxt.printStreamGetItem(mpr, bmodel, "key", keyType);

		mpr = pr.print(valueType.toString()).print(" ");
		pctxt.printStreamGetItem(mpr, bmodel, "value", valueType);
		
		pr.println("map.put(key, value);");

	    pr.endBlock();
	    pr.println("}");
	    
	    pr.println("return map;");
		pr.endBlock();
		pr.println("}");
	}
	
	protected void printWrite() throws IOException {
		String listType = serInfo.toString("java.util");

	    pr.println("public void write(Object obj1, BOutput bout1, int version)  throws BException {");
	    pr.beginBlock();
	    
	    pr.println("BOutputBin bout = (BOutputBin)bout1;");
	    pr.println("BBufferBin bbuf = bout.bbuf;");
	    
	    pr.print(listType).print(" map = (").print(listType).print(")obj1;").println();
	    pr.println("int n = map.size();");
    	pr.println("bbuf.putLength(n);");
	    pr.print("for (Map.Entry<").print(keyType.toString()).print(",").print(valueType.toString()).print("> obj : map.entrySet()) {").println();
	    pr.beginBlock();
	    pctxt.printStreamPutItem(pr, bmodel, "obj.getKey()", keyType);
	    pctxt.printStreamPutItem(pr, bmodel, "obj.getValue()", valueType);
	    pr.endBlock();
	    pr.println("}");
	    
	    pr.endBlock();
	    pr.println("}");
	}

	void generate() throws IOException {
		//log.debug(GenSerMap.class.getName(), "generateListSerializer");
		
		pr.print("package ").print(pack).print(";").println();
		pr.println();
		
		pctxt.printDoNotModify(pr, "Serializer for " + serInfo);

		pr.println("import com.wilutions.byps.*;");
		pr.println("import java.util.*;");

		pr.println();
		
		pr.println("@SuppressWarnings(\"all\")");
		
		String baseClass = bmodel == BBinaryModel.JSON ? "JSerializer" : "BSerializer";
		pr.print("public class ").print(serializerName)
		  .print(" extends " + baseClass + "_" + BRegistry.TYPEID_MAP).println(" {");
		
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
