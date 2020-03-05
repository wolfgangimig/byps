package byps.gen.utils;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BRegistry;
import byps.gen.api.TypeInfo;



public class PrintHelper {
	static Logger log = LoggerFactory.getLogger(PrintHelper.class);
	
	public static String streamGetMember(TypeInfo tinfo) {
		String fnct = "";
		int typeId = tinfo.typeId;
		if (tinfo.isEnum) fnct = "getInt";
		else if (typeId == BRegistry.TYPEID_INT8   ) fnct = "getByte";
		else if (typeId == BRegistry.TYPEID_WCHAR   ) fnct = "getChar";
		else if (typeId == BRegistry.TYPEID_INT16  ) fnct = "getShort";
		else if (typeId == BRegistry.TYPEID_INT32  ) fnct = "getInt";
		else if (typeId == BRegistry.TYPEID_INT64  ) fnct = "getLong";
		else if (typeId == BRegistry.TYPEID_FLOAT  ) fnct = "getFloat";
		else if (typeId == BRegistry.TYPEID_DOUBLE ) fnct = "getDouble";
		else if (typeId == BRegistry.TYPEID_BOOL   ) fnct = "getBoolean";
		else if (typeId == BRegistry.TYPEID_STRING   ) fnct = "getString";
		else if (typeId == BRegistry.TYPEID_DATE   ) fnct = "getDate";
			else {
			String msg = "Unknown typeId=" + typeId;
			log.error(msg);
			throw new IllegalStateException(msg);
		}
		return fnct;
	}
	
	public static String streamPutMember(TypeInfo tinfo) {
		String fnct = "";
		int typeId = tinfo.typeId;
		if (tinfo.isEnum) fnct = "putInt";
		else if (typeId == BRegistry.TYPEID_INT8   ) fnct = "putByte";
		else if (typeId == BRegistry.TYPEID_WCHAR   ) fnct = "putChar";
		else if (typeId == BRegistry.TYPEID_INT16  ) fnct = "putShort";
		else if (typeId == BRegistry.TYPEID_INT32  ) fnct = "putInt";
		else if (typeId == BRegistry.TYPEID_INT64  ) fnct = "putLong";
		else if (typeId == BRegistry.TYPEID_FLOAT  ) fnct = "putFloat";
		else if (typeId == BRegistry.TYPEID_DOUBLE ) fnct = "putDouble";
		else if (typeId == BRegistry.TYPEID_BOOL   ) fnct = "putBoolean";
		else if (typeId == BRegistry.TYPEID_STRING   ) fnct = "putString";
		else if (typeId == BRegistry.TYPEID_DATE   ) fnct = "putDate";
		else {
			String msg = "Unknown tpyeId=" + typeId;
			log.error(msg);
			throw new IllegalStateException(msg);
		}
		return fnct;
	}
	
	public static String getDefaultValueForType(TypeInfo tinfo) {
		String fnct = "";
		int typeId = tinfo.typeId;
		if (tinfo.isEnum) fnct = "0"; 
		else if (typeId == BRegistry.TYPEID_INT8   ) fnct = "((byte)0)";
		else if (typeId == BRegistry.TYPEID_WCHAR   ) fnct = "((char)0)";
		else if (typeId == BRegistry.TYPEID_INT16  ) fnct = "((short)0)";
		else if (typeId == BRegistry.TYPEID_INT32  ) fnct = "0";
		else if (typeId == BRegistry.TYPEID_INT64  ) fnct = "0L";
		else if (typeId == BRegistry.TYPEID_FLOAT  ) fnct = "0.0f";
		else if (typeId == BRegistry.TYPEID_DOUBLE ) fnct = "0.0";
		else if (typeId == BRegistry.TYPEID_BOOL   ) fnct = "false";
		else if (typeId == BRegistry.TYPEID_STRING ) fnct = "\"\"";
		else {
			return "null";
		}
		return fnct;
	}
	
}
