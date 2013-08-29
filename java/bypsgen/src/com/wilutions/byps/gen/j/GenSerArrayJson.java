package com.wilutions.byps.gen.j;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.BException;
import com.wilutions.byps.BExceptionO;
import com.wilutions.byps.BJsonObject;
import com.wilutions.byps.gen.api.SerialInfo;
import com.wilutions.byps.gen.api.TypeInfo;
import com.wilutions.byps.gen.utils.CodePrinter;

public class GenSerArrayJson extends GenSerArray {
	
	GenSerArrayJson(PrintContext pctxt, SerialInfo serInfo, CodePrinter pr) {
		super(pctxt, serInfo, pr, BBinaryModel.JSON);
	}

	static Log log = LogFactory.getLog(GenSerArrayJson.class);
	
	protected void printSize() throws IOException {
	}
	
	protected void printRead() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printCreateObject");

		pr.println("@Override");
		pr.println("public Object internalRead(final BInputJson bin) throws BException {");
		pr.beginBlock();
		
//		final BInputJson bin = (BInputJson)bin1;
//		final BJsonObject obj3 = bin.currentObject;
		
//		pr.println("final BInputJson bin = (BInputJson)bin1;");
		printReadArray("bin.currentObject", true);
		pr.println();

		pr.endBlock();
		pr.println("}");
		//log.debug(GeneratorJ.class.getName(), "printCreateObject");
	}

	protected void printReadArray(String currentObject, boolean isOnObjectCreated) throws IOException {
		int ndims = serInfo.dims.length() / 2;

		String jsonObject = "js" + (ndims-1);
		pr.print("final ").print(Json_OBJECT_CLASS_NAME).print(" ").print(jsonObject).print(" = ").print(currentObject).print(";").println();
		pr.println();

		// int n2 = 0, n1 = 0, n0 = 0;
		CodePrinter mpr = pr.print("int ");
		for (int i = ndims-1; i >= 0; i--) {
			if (i != ndims-1) mpr.print(", ");
			mpr.print("n" + i + " = 0");
		}
		mpr.println(";");
		
		// get lengths
		for (int i = ndims-1; i >= 0; i--) {
			String obj_i = "js"+i;
			String obj_p = "js"+(i+1);
			if (i != ndims-1) {
				pr.print("final ").print(Json_OBJECT_CLASS_NAME).print(" ").print(obj_i).print(" = ")
					.print(obj_p + ".getJsonObject(0)").println(";");
			}
			pr.print("n" + i).print(" = ").print(obj_i).print(" != null ? ")
				.print(obj_i).print(".size()").print(" : 0")
				.println(";");

			if (i != 0) {
				pr.println("if (n" + i + " != 0) {");
				pr.beginBlock();
			}
		}
		for (int i = 0; i < ndims-1; i++) {
			pr.endBlock();
			pr.println("}");
		}
		pr.println();
		
		// create array
		String className = serInfo.toString(pack);
		mpr = pr.print("final ").print(className).print(" arr = ").print(" new ").print(serInfo.qname);
		for (int i = ndims-1; i >= 0; i--) {
			String idxVar = "n" + i;
			mpr.print("[").print(idxVar).print("]");
		}
		mpr.println(";");
		
		if (isOnObjectCreated) {
			pr.println("bin.onObjectCreated(arr);");
			pr.println();
		}
		
		printReadWriteLoop("arr", jsonObject, false);
		
		if (isOnObjectCreated) {
			pr.println("return arr;");
		}
		
	}

	protected void printWrite() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printStore");

		pr.println("@Override");
		pr.println("public void internalWrite(Object obj1, final BOutputJson bout, BBufferJson bbuf) throws BException {");
		pr.beginBlock();
		
//		pr.println("final BOutputJson bout = (BOutputJson)bout1;");
//		pr.println("final BBufferJson bbuf = bout.bbuf;");
		
		String className = serInfo.toString(pack);

		pr.print("final ").print(className).print(" arr = (").print(className).print(")obj1;").println();
		pr.println();
		
		printWriteArray("arr");
		
		pr.endBlock();
		pr.println("}");
		
		//log.debug(GeneratorJ.class.getName(), "printStore");
	}

	protected void printWriteArray(String arrayVariableName) throws IOException {
		int ndims = serInfo.dims.length() / 2;
		pr.println("// lengths");
		String subArr = arrayVariableName;
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
		pr.println();

		printReadWriteLoop(arrayVariableName, "bin.currentObject", true);
	}

	protected void printReadWriteLoop(String varName, String jsonObject, boolean isWrite) throws IOException {

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
			
			if (isWrite) {
				pr.println("bbuf.beginArray();");
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
					pctxt.printStreamPutItem(pr, BBinaryModel.JSON, "a0[i0]", elmType);

				}
				else { 
					pctxt.printStreamGetItem(pr,  BBinaryModel.JSON, "a0[i0]", elmType);
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
			
			if (!isWrite) {
				// obj0 = (BJsonObject)obj1.get(i1);
				CodePrinter mpr = null;
				if (i == 1) {
					mpr = pr.print("bin.currentObject");
				}
				else {
					mpr = pr.print("final ").print(Json_OBJECT_CLASS_NAME).print(" js" + (i-1));
				}
				mpr.print(" = js" + i).print(".getJsonObject(").print(idxVar).print(");").println();
			}
			

		}
		
		for (int i = ndims-1; i >= 0; i--) {
			//if (i == 0 && serInfo.isPrimitiveType()) break;
			pr.endBlock();
			pr.println("}");
			if (isWrite) {
				pr.println("bbuf.endArray();");
			}
		}
	}
	
	private final static String Json_OBJECT_CLASS_NAME = BJsonObject.class.getSimpleName();

}
