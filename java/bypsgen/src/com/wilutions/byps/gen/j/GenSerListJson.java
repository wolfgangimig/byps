package com.wilutions.byps.gen.j;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.BException;
import com.wilutions.byps.BJsonObject;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.api.TypeInfo;
import com.wilutions.byps.gen.utils.CodePrinter;


public class GenSerListJson extends GenSerList {
	static Log log = LogFactory.getLog(GenSerListJson.class);
	private static final String[] knownPacks = new String[] {"java.lang"};
	
	GenSerListJson(PrintContext pctxt, SerialInfo serInfo, CodePrinter pr) throws BException {
		super(pctxt, serInfo, pr, BBinaryModel.JSON);
	}
	
	protected void printRead() throws IOException {
		String listType = getListTypeNameForCreate(serInfo);

		pr.println("@Override");
	    pr.println("public Object read(final Object obj1, final BInput bin1, final int version) throws BException {");
		pr.beginBlock();
	    pr.println("final BInputJson bin = (BInputJson)bin1;");
	    pr.println("final BBufferJson bbuf = bin.bbuf;");
	    	    
    	pr.println("final int n = bin.currentObject.size();");
	    
	    pr.print("final ").print(listType).print(" arr = new ").print(listType)
	    	.print(serInfo.isListType() ? "(n)" : "()").println(";");
		pr.println("bin.onObjectCreated(arr);");

	    pr.println("for (int i0 = 0; i0 < n; i0++) {");
	    pr.beginBlock();
	    
		CodePrinter mpr = pr.print(elmType.toString()).print(" ");
		pctxt.printStreamGetItem(mpr, bmodel, "obj", elmType);
		
		pr.println("arr.add(obj);");

	    pr.endBlock();
	    pr.println("}");
	    
	    pr.println("return arr;");
		pr.endBlock();
		pr.println("}");
	}
	
	protected void printWrite() throws IOException {
		String listType = serInfo.toString();

		pr.println("@Override");
		pr.println("public void write(Object obj1, BOutput bout1, int version)  throws BException {");
	    pr.beginBlock();
	    
	    pr.println("BOutputJson bout = (BOutputJson)bout1;");
	    pr.println("BBufferJson bbuf = bout.bbuf;");
	    
	    pr.print(listType).print(" arr = (").print(listType).print(")obj1;").println();
	    pr.println("int n = arr.size();");
	    pr.println("bbuf.beginArray();");
	    pr.print("for (").print(elmType.toString()).print(" obj : arr) {").println();
	    pr.beginBlock();
	    pctxt.printStreamPutItem(pr, bmodel, "obj", elmType);
	    pr.endBlock();
	    pr.println("}");
	    pr.println("bbuf.endArray();");

	    pr.endBlock();
	    pr.println("}");
	}	
	
	private void _printRead() throws IOException {

		pr.println("@Override");
	    pr.println("public Object read(final Object obj1, final BInput bin1, final int version) throws BException {");
		pr.beginBlock();
	    pr.println("final BInputJson bin = (BInputJson)bin1;");
	    pr.println("final BBufferJson bbuf = bin.bbuf;");
	   
		printReadArrayOrElement(serInfo, 1, "");
	    
	    pr.println("return v1;");
		pr.endBlock();
		pr.println("}");
	}
	
	private void _printWrite() throws IOException {
		String listType = serInfo.toString();

		pr.println("@Override");
		pr.println("public void write(Object obj1, BOutput bout1, int version)  throws BException {");
	    pr.beginBlock();
	    
	    pr.println("final BOutputJson bout = (BOutputJson)bout1;");
	    pr.println("final BBufferJson bbuf = bout.bbuf;");
	    
	    pr.print("final ").print(listType).print(" v1 = (").print(listType).print(")obj1;").println();
	    printWriteArrayOrElement(serInfo, 1);
	    
	    pr.endBlock();
	    pr.println("}");
	}

 	protected void printReadArrayOrElement(TypeInfo elmType, int level, String loopVariable) throws IOException {
		
		String jsonObjectRhs = level > 1 ? ("jsonObject" + (level-1) + ".getJsonObject(" + loopVariable + ")") : "bin.currentObject";

		if (elmType.isListType() || elmType.isSetType()) {

			String jsonObject = "jsonObject" + level;
		    pr.print("final ").print(Json_OBJECT_CLASS_NAME).print(" ").print(jsonObject).print(" = ").print(jsonObjectRhs).println(";");
		    
		    if (level > 1) {
			    pr.print("if (").print(jsonObject).print(" == null) {").println();
			    pr.beginBlock();
			    pr.print("v" + (level-1)).print(".add(null);").println();
			    pr.println("continue;");
			    pr.endBlock();
			    pr.println("}");
		    }
			
			String listType = getListTypeNameForCreate(elmType);
			String listVariable = "v" + level;
		    pr.print("final ").print(listType).print(" ").print(listVariable).print(" = new ").print(listType).println("();");
		    
		    if (level == 1) {
				pr.println("bin.onObjectCreated(v1);");
		    }
		    else {
				pr.print("v" + (level-1)).print(".add(").print(listVariable).println(");");
		    }

			TypeInfo arrType = elmType;
			SerialInfo serArrInfo = pctxt.classDB.getSerInfo(arrType.toString());
		    elmType = serArrInfo.typeArgs.get(0);
			
		    String lengthVariable = "m" + level;
		    loopVariable = "j" + level;
		    
		    pr.print("final int ").print(lengthVariable).print(" = ").print(jsonObject).println(".size();");
		    
		    pr.print("for (int ").print(loopVariable).print(" = 0; ").print(loopVariable).print(" < ").print(lengthVariable).print("; ").print(loopVariable).println("++) {");
		    pr.beginBlock();
		    
		    printReadArrayOrElement(elmType, level+1, loopVariable);
		    
		    pr.endBlock();
		    pr.println("}");
			
		}
		else if (elmType.isArrayType() && !elmType.isByteArray1dim()) {
			pr.println();
			pr.print("bin.currentObject = ").print(jsonObjectRhs).println(";");
			
		    if (level > 1) {
			    pr.print("if (bin.currentObject == null) {").println();
			    pr.beginBlock();
			    pr.print("v" + (level-1)).print(".add(null);").println();
			    pr.println("continue;");
			    pr.endBlock();
			    pr.println("}");
		    }
			
			pr.println();
			pr.println("// begin read array ---");
			pr.println();
			SerialInfo serArrInfo = pctxt.classDB.getSerInfo(elmType.toString());
			GenSerArrayJson genArray = new GenSerArrayJson(pctxt, serArrInfo, pr);
			genArray.printReadArray("bin.currentObject", false);
			
			pr.println();
			pr.println("// end read array ---");
			pr.println();
			pr.println("v" + (level-1) + ".add(arr);");
		}
		else {
			String elementName = "v" + level;
			String jsonObject = "jsonObject" + (level-1);
			CodePrinter mpr = pr.print(elmType.toString()).print(" ");
			pctxt.printStreamGetItem(mpr, bmodel, elementName, elmType, jsonObject, loopVariable);
			pr.print("v" + (level-1) + ".add(").print(elementName).println(");");
		}
		
	}
	
 	protected void printWriteArrayOrElement(TypeInfo elmType, int level) throws IOException {
		if (elmType.isListType() || elmType.isSetType()) {
			
			TypeInfo arrType = elmType;
			SerialInfo serArrInfo = pctxt.classDB.getSerInfo(arrType.toString());
		    elmType = serArrInfo.typeArgs.get(0);
			
		    //pr.println("int n" + level + " = arr" + level + ".size();");
		    pr.println("bbuf.beginArray();");
		    pr.print("for (").print(elmType.toString(knownPacks)).print(" v" + (level+1) + " : v" + level +") {").println();
		    pr.beginBlock();
		    
		    pr.print("if (v" + (level+1)).println(" == null) {");
		    pr.beginBlock();
		    pr.println("bbuf.putNull();");
		    pr.println("continue;");
		    pr.endBlock();
		    pr.println("}");

		    printWriteArrayOrElement(elmType, level+1);
		    
		    pr.endBlock();
		    pr.println("}");
		    pr.println("bbuf.endArray();");
			
		}
		else if (elmType.isArrayType() && !elmType.isByteArray1dim()) {
			
			pr.println();
			pr.println("// begin write array ---");
			pr.println();
			
			SerialInfo serArrInfo = pctxt.classDB.getSerInfo(elmType.toString());
			GenSerArrayJson genArray = new GenSerArrayJson(pctxt, serArrInfo, pr);
			genArray.printWriteArray("v" + level);
			
			pr.println();
			pr.println("// end write array ---");
			pr.println();

		}
		else {
			pctxt.printStreamPutItem(pr, bmodel, "v" + level, elmType);
		}
	}

	private final static String Json_OBJECT_CLASS_NAME = BJsonObject.class.getSimpleName();
}
