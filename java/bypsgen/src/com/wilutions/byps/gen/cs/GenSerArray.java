package com.wilutions.byps.gen.cs;

import java.io.IOException;
import java.text.MessageFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.BException;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.api.TypeInfo;
import com.wilutions.byps.gen.utils.CodePrinter;

public class GenSerArray {
	static Log log = LogFactory.getLog(GenSerArray.class);

	protected GenSerArray(PrintContext pctxt, SerialInfo serInfo, CodePrinter pr) {
		this(pctxt, serInfo, pr, BBinaryModel.MEDIUM);
	}
	
	protected GenSerArray(PrintContext pctxt, SerialInfo serInfo, CodePrinter pr, BBinaryModel pformat) {
		this.serInfo = serInfo;
		this.pr = pr;
		this.serializerName = pctxt.getSerializerClassName(serInfo, pformat);
		this.pack = pctxt.getSerializerPackage(serInfo);
		this.elmType = pctxt.classDB.getTypeInfo(serInfo.qname); // serInfo.qname is without []
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
		
		pr.print("public ").print(serializerName).println("() : ");
		pr.beginBlock();
		pr.print("base(" + serInfo.typeId + ") {}").println();
		pr.endBlock();

		//log.debug(GeneratorJ.class.getName(), "printConstructors");
	}
	
	protected void printSize() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printSize");
		
		int ndims = serInfo.dims.length() / 2;
		
		pr.print("public override int size(Object obj, BBinaryModel bmodel) { ").println();
		pr.beginBlock();
		
		if (elmType.isPointerType()) {
			pr.println("int elementSize = bmodel.pointerSize;");
		}
		else {
			int elmSize = elmType.getMemberSize(pctxt.bmodel);
			pr.println("int elementSize = " + elmSize + ";");
		}
		
		TypeInfo csinfo = pctxt.toCSharp(serInfo);
		String arrType = csinfo.toString(pack); 
		pr.print("").print(arrType).print(" arr = (").print(arrType).print(")obj;").println();
		for (int i = 0; i < ndims; i++) {
			if (i == 0) {
				pr.println("int n = arr.GetLength(" + i + ");");
			}
			else {
				pr.println("n *= arr.GetLength(" + i + ");");
			}
		}

		pr.println("return bmodel.computeArrayWireSize(elementSize, n);");
		
		pr.endBlock();
		pr.println("}");
		
		//log.debug(GeneratorJ.class.getName(), "printSize");
	}
	
	protected void printCreate() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printCreateObject");

		pr.println("public override Object read(Object obj1, BInput bin1, long version) {");
		pr.beginBlock();
		
		pr.println("BInputBin bin = (BInputBin)bin1;");
		pr.println("BBufferBin bbuf = bin.bbuf;");
		pr.println();
		
		int ndims = serInfo.dims.length() / 2;

		// read lengths
		pr.println("// lengths");
		for (int i = ndims-1; i >= 0; i--) {
			String idxVar = "n" + i;
			String fnct = "getLength()";
			pr.print("int ").print(idxVar).print(" = bbuf.").print(fnct).print(";").println();
		}
		pr.println();
		
		// create array
		pr.println("// create array");
		TypeInfo csinfo = pctxt.toCSharp(serInfo);
		String className = csinfo.toString(pack);
		CodePrinter mpr = pr.print("").print(className).print(" arr = ").print(" new ").print(csinfo.qname);
		mpr.print("[");
		for (int i = ndims-1; i >= 0; i--) {
			String idxVar = "n" + i;
			mpr.print(idxVar).print(i > 0 ? "," : "]");
		}
		mpr.println(";");
		pr.println();

		printReadWriteLoop("arr", false);
		pr.println();
		
		pr.println("return arr;");
		pr.endBlock();
		pr.println("}");
		
		//log.debug(GeneratorJ.class.getName(), "printCreateObject");
	}

	protected void printWrite() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printStore");

		pr.println("public override void write(Object obj1, BOutput bout1, long version) {");
		pr.beginBlock();
		
		pr.println("BOutputBin bout = (BOutputBin)bout1;");
		pr.println("BBufferBin bbuf = bout.bbuf;");
		pr.println();
		
		int ndims = serInfo.dims.length() / 2;
		
		TypeInfo csinfo = pctxt.toCSharp(serInfo);
		String className = csinfo.toString(pack);

		pr.print("").print(className).print(" arr = (").print(className).print(")obj1;").println();
		pr.println();

		// write lengths
		pr.println("// lengths");
		for (int i = ndims-1; i >= 0; i--) {
			String idxVar = "n" + i;
			pr.print("int ").print(idxVar).print(" = arr.GetLength(" + (ndims - i - 1) + ");").println();
		}
		for (int i = ndims-1; i >= 0; i--) {
			String idxVar = "n" + i;
			pr.print("bbuf.putLength(").print(idxVar).print(");").println();
		}
		pr.println();
		
		printReadWriteLoop("arr", true);
		
		pr.endBlock();
		pr.println("}");
		
		//log.debug(GeneratorJ.class.getName(), "printStore");
	}
	
	protected void printReadWritePrimitiveArray(boolean isWrite) {
		String elmType = serInfo.toStringNoDims("java.lang");
		elmType = elmType.substring(0, 1).toUpperCase() + elmType.substring(1);
		String s = MessageFormat.format("bbuf.{0}Array{1}(arr);", 
				isWrite ? "put" : "get", 
				elmType);
		pr.println(s);
	}

	protected void printReadWriteLoop(String varName, boolean isWrite) throws IOException {

		pr.println(isWrite ? "// write" : "// read");

		String elmQName = serInfo.toStringNoDims("");
		TypeInfo elmType = pctxt.classDB.getTypeInfo(elmQName);
		if (elmType == null) {
			throw new BException(BException.GENERATOR_EXCEPTION, "Unknown element type=" + elmQName + ", for " + serInfo);
		}
		
		int ndims = serInfo.dims.length() / 2;
		
		for (int i = ndims-1; i >=0 ; i--) {
			
			if (i == 0 && serInfo.isByteArray1dim() ) {
				//bin.bbuf.getArrayByte(a0);
				printReadWritePrimitiveArray(isWrite);
				break;
			}

			// for (int i3 = 0; i3 < n3; i3++) {
			//   for (int i2 = 0; i2 < n2; i2++) {
			//     for (int i1 = 0; i1 < n1; i1++) {
			//       for (int i0 = 0; i0 < n0; i0++) {
			String idxVar = "i" + i;
			String loopTest = idxVar + " < n" + i;
			pr.print("for (int ").print(idxVar).print(" = 0; ").print(loopTest).print("; ").print(idxVar).print("++) {").println();
			pr.beginBlock();

			if (i == 0) {
				
				StringBuilder elmName = new StringBuilder();
				elmName.append(varName).append("[");
				for (int j = ndims-1; j >= 0; j--) {
					elmName.append("i").append(j);
					if (j != 0) elmName.append(",");
				}
				elmName.append("]");
				
				if (isWrite) { 
					
					// bout.writeObj(v, false, false, null);
					pctxt.printStreamPutItem(pr, BBinaryModel.MEDIUM, elmName.toString(), elmType);

				}
				else { 
					pctxt.printStreamGetItem(pr,  BBinaryModel.MEDIUM, elmName.toString(), elmType);
				}
				break;
			}
			
		}
		
		for (int i = ndims-1; i >= 0; i--) {
			if (i == 0 && serInfo.isByteArray1dim()) break;
			pr.endBlock();
			pr.println("}");
		}
	}

	protected void generate() throws IOException {
		//log.debug(GenSerArray.class.getName(), "generate");
		
		pctxt.printDoNotModify(pr, "Serializer for " + serInfo);
		
		pr.println("using System;");
		pr.println("using System.Collections.Generic;");
		pr.println("using com.wilutions.byps;");
		pr.println();
		pr.println("namespace " + pack);
		pr.println("{");
		pr.beginBlock();
		pr.println();
		
		String baseName = bmodel == BBinaryModel.JSON ? "JSerializer_Array" : "BSerializer";
		pr.print("public class ").print(serializerName).print(" : ").print(baseName).println(" {");
		
		pr.beginBlock();
		pr.println();
		
		printSingletonInstance();
		pr.println();
		
		printConstructors();
		pr.println();
		
		printSize();
		pr.println();
		
		printCreate();
		pr.println();
		
		printWrite();
		pr.println();
		
		pr.endBlock();		
		pr.println("}");
		
		pr.endBlock();		
		pr.println("} // namespace");

		//log.debug(GenSerArray.class.getName(), "generate");
	}

	
	final protected SerialInfo serInfo;
	final protected TypeInfo elmType;
	final protected CodePrinter pr;
	final protected String serializerName;
	final protected String pack;
	final protected PrintContext pctxt;
	final protected BBinaryModel bmodel;
}
