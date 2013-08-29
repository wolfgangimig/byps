package com.wilutions.byps.gen.j;

import java.io.IOException;
import java.text.MessageFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.BException;
import com.wilutions.byps.BExceptionO;
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
	
	protected void printSize() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printSize");
		
		int ndims = serInfo.dims.length() / 2;
		
		pr.println("@Override");
		pr.print("public int size(Object obj, BBinaryModel bmodel) throws BException { ").println();
		pr.beginBlock();
		
		if (elmType.isPointerType()) {
			pr.println("final int elementSize = bmodel.pointerSize;");
		}
		else {
			int elmSize = elmType.getMemberSize(pctxt.bmodel);
			pr.println("final int elementSize = " + elmSize + ";");
		}
		
		String arrType = serInfo.toString(pack); 
		pr.print("final ").print(arrType).print(" arr = (").print(arrType).print(")obj;").println();
		String loopVar = "arr";
		for (int i = 0; i < ndims; i++) {
			if (i == 0) {
				pr.print("int n = ").print(loopVar).print(".length;").println();
			}
			else {
				pr.print("n *= ").print(loopVar).print(".length;").println();
			}
			if (i != ndims-1) {
				pr.println("if (n != 0) {");
				pr.beginBlock();
				loopVar += "[0]";
			}
		}
		for (int i = 0; i < ndims-1; i++) {
			pr.endBlock();
			pr.println("}");
		}

		pr.println("return bmodel.computeArrayWireSize(elementSize, n);");
		
		pr.endBlock();
		pr.println("}");
		
		//log.debug(GeneratorJ.class.getName(), "printSize");
	}
	
	protected void printRead() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printCreateObject");

		pr.println("@Override");
		pr.println("public Object read(final Object obj1, final BInput bin1, final long version) throws BException {");
		pr.beginBlock();
		
		pr.println("final BInputBin bin = (BInputBin)bin1;");
		pr.println("final BBufferBin bbuf = bin.bbuf;");
		pr.println();
		
		int ndims = serInfo.dims.length() / 2;

		// read lengths
		pr.println("// lengths");
		for (int i = ndims-1; i >= 0; i--) {
			String idxVar = "n" + i;
			String fnct = "getLength()";
			pr.print("final int ").print(idxVar).print(" = bbuf.").print(fnct).print(";").println();
		}
		pr.println();
		
		// create array
		pr.println("// create array");
		String className = serInfo.toString(pack);
		CodePrinter mpr = pr.print("final ").print(className).print(" arr = ").print(" new ").print(serInfo.qname);
		for (int i = ndims-1; i >= 0; i--) {
			String idxVar = "n" + i;
			mpr.print("[").print(idxVar).print("]");
		}
		mpr.println(";");
		pr.println("bin.onObjectCreated(arr);");
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

		pr.println("@Override");
		pr.println("public void write(Object obj1, BOutput bout1, final long version) throws BException {");
		pr.beginBlock();
		
		pr.println("final BOutputBin bout = (BOutputBin)bout1;");
		pr.println("final BBufferBin bbuf = bout.bbuf;");
		pr.println();
		
		String className = serInfo.toString(pack);
		pr.print("final ").print(className).print(" arr = (").print(className).print(")obj1;").println();
		pr.println();

		internalPrintWriteArray();
		
		pr.endBlock();
		pr.println("}");
		
		//log.debug(GeneratorJ.class.getName(), "printStore");
	}

	protected void internalPrintWriteArray() throws IOException {
		int ndims = serInfo.dims.length() / 2;
		// write lengths
		pr.println("// lengths");
		String subArr = "arr";
		for (int i = ndims-1; i >= 0; i--) {
			String idxVar = "n" + i;
			CodePrinter mpr = pr.print("final int ").print(idxVar).print(" = ");
			if (i != ndims-1) {
				String prevIdxVar = "n" + (i+1); 
				mpr.print(prevIdxVar).print("!=0 ? ").print(subArr).print(".length : 0;").println();
			}
			else {
				mpr.print(subArr).print(".length;").println();
			}
			subArr += "[0]";
		}
		for (int i = ndims-1; i >= 0; i--) {
			String idxVar = "n" + i;
			pr.print("bbuf.putLength(").print(idxVar).print(");").println();
		}
		pr.println();
		
		printReadWriteLoop("arr", true);
	}
	
	protected void printReadWritePrimitiveArray(boolean isWrite) {
		String elmType = serInfo.toStringNoDims("java.lang");
		elmType = elmType.substring(0, 1).toUpperCase() + elmType.substring(1);
		String s = MessageFormat.format("{0}.bbuf.{1}Array{2}(a0);", 
				isWrite ? "bout" : "bin", 
				isWrite ? "put" : "get", 
				elmType);
		pr.println(s);
	}

	private void printReadWriteLoop(String varName, boolean isWrite) throws IOException {

		pr.println(isWrite ? "// write" : "// read");

		String elmQName = serInfo.toStringNoDims("");
		TypeInfo elmType = pctxt.classDB.getTypeInfo(elmQName);
		if (elmType == null) {
			throw new BException(BExceptionO.GENERATOR_EXCEPTION, "Unknown element type=" + elmQName + ", for " + serInfo);
		}
		
		String className = serInfo.toString(pack);
		int ndims = serInfo.dims.length() / 2;
		
		String loopType = className;
		
		String loopVar = "a" + (ndims-1);

		// final double[][][][] a3 = arr;
		pr.print("final ").print(loopType).print(" ").print(loopVar).print(" = ").print(varName).print(";").println();
		
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
				
				if (isWrite) { 
					
					// bout.writeObj(v, false, false, null);
					pctxt.printStreamPutItem(pr, BBinaryModel.MEDIUM, "a0[i0]", elmType);

				}
				else { 
					pctxt.printStreamGetItem(pr,  BBinaryModel.MEDIUM, "a0[i0]", elmType);
				}
				break;
			}
			
			// final double[][][] a2 = a3[i3];
			//   final double[][] a1 = a2[i2];
			//     final double[] a0 = a1[i1];
			{
				String loopVar1 = "a" + (i-1);
				loopType = loopType.substring(0, loopType.length()-2);
				pr.print("final ").print(loopType).print(" ").print(loopVar1).print(" = ").print(loopVar).print("[").print(idxVar).print("];").println();
				loopVar = loopVar1;
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
		
		pr.print("package ").print(pack).print(";").println();
		pr.println();

		pctxt.printDoNotModify(pr, getClass(), "Serializer for " + serInfo);

		pr.println("import com.wilutions.byps.*;");

		pr.println("@SuppressWarnings(\"all\")");
		
		String baseName = bmodel == BBinaryModel.JSON ? "JSerializer_Array" : "BSerializer";
		pr.print("public class ").print(serializerName).print(" extends ").print(baseName).println(" {");
		
		pr.beginBlock();
		pr.println();
		
		printSingletonInstance();
		pr.println();
		
		printConstructors();
		pr.println();
		
		printSize();
		pr.println();
		
		printRead();
		pr.println();
		
		printWrite();
		pr.println();
		
		pr.endBlock();
		
		pr.println("}");

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
