package byps.gen.j;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BBinaryModel;
import byps.BException;
import byps.BExceptionC;
import byps.BRegistry;
import byps.gen.api.SerialInfo;
import byps.gen.api.TypeInfo;
import byps.gen.utils.CodePrinter;

public class GenSerMap {
	static Logger log = LoggerFactory.getLogger(GenSerMap.class);
	
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

	    pr.println("public Object read(final Object obj1, final BInput bin1, final long version) throws BException {");
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

	    pr.println("public void write(Object obj1, BOutput bout1, final long version)  throws BException {");
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
	
  protected void printPrepareForLazyLoading() {
    String listType = serInfo.toString("java.util");
    
    pr.println("@Override");
    pr.println("public void prepareForLazyLoading(final Object obj1, final BInput bin, final long version) throws BException {");
    pr.beginBlock();

    pr.print(listType).print(" map = (").print(listType).print(")obj1;").println();

    pr.print("for (Map.Entry<").print(keyType.toString()).print(",").print(valueType.toString()).print("> obj : map.entrySet()) {").println();
    pr.beginBlock();

    pctxt.printStreamPrepareMember(pr, bmodel, "obj.", "key", true, keyType);
    pctxt.printStreamPrepareMember(pr, bmodel, "obj.", "value", true, valueType);
    
    pr.endBlock();
    pr.println("}");

    pr.endBlock();
    pr.println("}");
  }

	void generate() throws IOException {
		//log.debug(GenSerMap.class.getName(), "generateListSerializer");
		
		pr.print("package ").print(pack).print(";").println();
		pr.println();
		
		pctxt.printDoNotModify(pr, getClass(), "Serializer for " + serInfo);

		pr.println("import byps.*;");
		pr.println("import java.util.*;");

		pr.println();
		
		pr.println("@SuppressWarnings({\"all\", \"deprecation\"})");
		
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
		
    // Does element type contain members that are potentially lazy loaded?
    if (pctxt.isLazyLoadingType(serInfo)) {
  		printPrepareForLazyLoading();
  		pr.println();
    }
    
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
