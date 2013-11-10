package byps.gen.j;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BBinaryModel;
import byps.BException;
import byps.BExceptionC;
import byps.gen.api.SerialInfo;
import byps.gen.api.TypeInfo;
import byps.gen.utils.CodePrinter;

public class GenSerMapJson extends GenSerMap {
	static Log log = LogFactory.getLog(GenSerMapJson.class);
	
	GenSerMapJson(PrintContext pctxt, SerialInfo serInfo, CodePrinter pr) throws BException {
		super(pctxt, serInfo, pr, BBinaryModel.JSON);
	}
	
	protected void printGetKeyValue(TypeInfo tinfo) throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printGetKeyValue");

		CodePrinter mpr = pr.print("final Object ");
		pctxt.printStreamGetItem(mpr, BBinaryModel.JSON, "obj", tinfo, "js", "keyName");
		pr.println("return obj;");

		//log.debug(GeneratorJ.class.getName(), "printGetKeyValue");
	}
	
	private boolean makeParseValue(CodePrinter pr, TypeInfo keyType, String typeName, String parseFunction, String arg, String defaultValue ) {
		if (!keyType.name.equals(typeName)) return false;
		pr.println("keyName != null && keyName.length() != 0 ? " + parseFunction + "(" + arg + ") : " + defaultValue + ";");
		return true;
	}
	
	protected void printInternalReadKey() throws IOException {
		//log.debug(GeneratorJ.class.getName(), "printInternalReadKey");
		CodePrinter pr = this.pr.print(keyType.toString()).print(" key = ");
		if (keyType.isStringType()) {
			pr.println("keyName;");
		}
		else if (makeParseValue(pr, keyType, "Boolean", "Boolean.parseBoolean", "keyName", "Boolean.FALSE")) {
		}
		else if (makeParseValue(pr, keyType, "Byte", "Byte.parseByte", "keyName", "(byte)0")) {
		}
		else if (keyType.name.equals("Character")) {
			pr.println("keyName.charAt(0);");
		}
		else if (makeParseValue(pr, keyType, "Short", "Short.parseShort", "keyName", "(short)0")) {
		}
		else if (makeParseValue(pr, keyType, "Integer", "Integer.parseInt", "keyName", "0")) {
		}
		else if (makeParseValue(pr, keyType, "Long", "BBufferJson.parseLong", "keyName", "0L")) {
		}
		else if (makeParseValue(pr, keyType, "Float", "Float.parseFloat", "keyName", "0.0f")) {
		}
		else if (makeParseValue(pr, keyType, "Double", "Double.parseDouble", "keyName", "0.0")) {
		}
		else if (!keyType.isArrayType() && keyType.isEnum ) {
			pr.println("keyName != null && keyName.length() != 0 ? BEnumHelper.fromOrdinal(" + keyType.toString() + ".values(), Integer.parseInt(keyName)) : " + keyType.toString() + ".values()[0];");
		}
		else {
			throw new BException(BExceptionC.GENERATOR_EXCEPTION, "Unsupported type=" + keyType + " for map key");
		}
		
		//log.debug(GeneratorJ.class.getName(), "printInternalReadKey");
	}
	
	protected void printInternalWriteKeyValue() throws IOException {
		
//		if (valueType.isPointerType() && !pctxt.isByteArray1dim(valueType)) {
//			// Implemented by base class 
//			return;
//		}

		//log.debug(GeneratorJ.class.getName(), "printInternalWriteKeyValue");
		
	  pr.checkpoint();
		pr.println("@Override");
		pr.println("protected void internalWriteKeyValue(final BOutputJson bout, final BBufferJson bbuf, final Object key, final Object value) throws BException {");
		pr.beginBlock();

		CodePrinter mpr = pr.print("final String keyName = ");
		if (keyType.isStringType()) {
			mpr.print("key != null ? (String)key : \"\";");
		}
		else if (keyType.isEnum ) {
			mpr.print("Integer.toString(key != null ? ((" + keyType.toString() + ")key).ordinal() : 0);");
		}
		else {
			mpr.print("key != null ? key.toString() : \"\";");
		}
		mpr.println();

		
//		if (valueType.isByteArray1dim()) {
//			pr.print("bbuf.putArrayByte(keyName, (byte[])value")
//			  .println(");");
//		}
//		else if (valueType.isPointerType()) {
//			String memberSerializer = pctxt.getSerializerInstance(valueType, BBinaryModel.JSON);
//			pr.print("bout.writeObj(")
//			  .print("keyName, value ")
//			  .print(", " + valueType.isUnique())
//			  .print(", " + valueType.isStatic())
//			  .print(", ").print(memberSerializer)
//			  .println(");");
//		}
//		else {
//			String fnct = PrintHelper.streamPutMember(valueType);
//			pr.print("bbuf.").print(fnct).print("(").print("keyName, (").print(valueType.toString()).print(")value")
//				.println(");");
//		}

		pctxt.printStreamPutItem(pr, BBinaryModel.JSON, "value", valueType, "keyName");

		pr.endBlock();
		pr.println("}");
		
		//log.debug(GeneratorJ.class.getName(), "printInternalWriteKeyValue");
	}

	protected void printRead() throws IOException {
		String listType = getMapTypeToCreate();

	    pr.println("public Object read(final Object obj1, final BInput bin1, final long version) throws BException {");
		pr.beginBlock();
	    pr.println("final BInputJson bin = (BInputJson)bin1;");
		pr.println("final BJsonObject js = bin.currentObject;");
		pr.println("final Set<String> keys = js.keys();");
	    
		String args = serInfo.name.equals("TreeMap") ? "" : "keys.size()";
	    pr.print("final ").print(listType).print(" map = new ").print(listType)
	    	.print("(").print(args).print(");").println();
		pr.println("bin.onObjectCreated(map);");

	    pr.println("for (String keyName : keys) {");
	    pr.beginBlock();
	    
	    printInternalReadKey();
	    
		CodePrinter mpr = pr.print("final ").print(valueType.toString()).print(" ");
		pctxt.printStreamGetItem(mpr, BBinaryModel.JSON, "value", valueType, "js", "keyName");
	    
		pr.println("map.put(key, value);");

	    pr.endBlock();
	    pr.println("}");
	    
	    pr.println("return map;");
		pr.endBlock();
		pr.println("}");
	}

	protected void printWrite() throws IOException {
		printInternalWriteKeyValue();
	}

	
}
