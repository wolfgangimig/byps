package byps.gen.db;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;

import byps.BBinaryModel;
import byps.BException;
import byps.BRegistry;
import byps.BRemote;
import byps.gen.api.GeneratorException;
import byps.gen.api.TypeInfo;

public class BRegistryForClassDB extends BRegistry {

	public BRegistryForClassDB() {
		super(BBinaryModel.MEDIUM);
	}
	
	@Override
	protected BRegisteredSerializer[] getSortedSerializers() {
		// This BRegistry subclass is used only by the ClassDB and is
		// never called to serialize any object.
		throw new IllegalStateException("BRegistryForClassDB.getApiSerializer must not be called");
	}
	
	int getTypeIdForBuiltInType(TypeInfo typeInfo) throws GeneratorException {
		
		// A similar function can be found in ClassDB.getTypeInfo.
		// Can one be eliminated?
		
		String qname = typeInfo.qname;
		int typeId = 0;
		
		if (typeInfo.dims.length() == 0) {
			if (qname.equals("boolean")) typeId = TYPEID_BOOL;
			else if (qname.equals("byte")) typeId = TYPEID_INT8;
			else if (qname.equals("char")) typeId = TYPEID_WCHAR;
			else if (qname.equals("short")) typeId = TYPEID_INT16;
			else if (qname.equals("int")) typeId = TYPEID_INT32;
			else if (qname.equals("long")) typeId = TYPEID_INT64;
			else if (qname.equals("float")) typeId = TYPEID_FLOAT;
			else if (qname.equals("double")) typeId = TYPEID_DOUBLE;
			else if (qname.equals("void")) typeId = TYPEID_VOID;
			else if (qname.equals(Boolean.class.getName())) typeId = TYPEID_BOOL;
			else if (qname.equals(Character.class.getName())) typeId = TYPEID_WCHAR;
			else if (qname.equals(Byte.class.getName())) typeId = TYPEID_INT8;
			else if (qname.equals(Short.class.getName())) typeId = TYPEID_INT16;
			else if (qname.equals(Integer.class.getName())) typeId = TYPEID_INT32;
			else if (qname.equals(Long.class.getName())) typeId = TYPEID_INT64;
			else if (qname.equals(Float.class.getName())) typeId = TYPEID_FLOAT;
			else if (qname.equals(Double.class.getName())) typeId = TYPEID_DOUBLE;
			else if (qname.equals(Void.class.getName())) typeId = TYPEID_VOID;
			else if (qname.equals(Object.class.getName())) typeId = TYPEID_OBJECT;
			else if (qname.equals(Serializable.class.getName())) typeId = TYPEID_OBJECT;
			else if (qname.equals(String.class.getName())) typeId = TYPEID_STRING;
			else if (qname.equals(IOException.class.getName())) typeId = TYPEID_EXCEPTION;
			else if (qname.equals(InputStream.class.getName())) typeId = TYPEID_STREAM;
			else if (qname.equals(BRemote.class.getName())) typeId = TYPEID_STUB;
			else if (qname.equals(Date.class.getName())) typeId = TYPEID_DATE;
			
			else if (typeInfo.isListType()) {
				if (typeInfo.typeArgs.get(0).isAnyType()) {
					typeId = TYPEID_LIST;
				}
			}
			else if (typeInfo.isMapType()) {
				if (typeInfo.typeArgs.get(0).isAnyType() && typeInfo.typeArgs.get(1).isAnyType()) {
					typeId = TYPEID_MAP;
				}
			}
			else if (typeInfo.isSetType()) {
				if (typeInfo.typeArgs.get(0).isAnyType()) {
					typeId = TYPEID_SET;
				}
			}
		}
		
		return typeId;
	}
	
	public String getObjTypeOfPrimitive(String qname) {
		if (qname.equals("int")) return "Integer";
		if (qname.equals("void")) return "Object";
		if (qname.equals("char")) return "Character";
		return qname.substring(0,1).toUpperCase() + qname.substring(1);
	}


}
