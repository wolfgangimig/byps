package com.wilutions.byps.gen.db;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Random;

import com.wilutions.byps.BBinaryModel;
import com.wilutions.byps.BException;
import com.wilutions.byps.BRegistry;
import com.wilutions.byps.BRemote;
import com.wilutions.byps.BSerializer;
import com.wilutions.byps.gen.api.GeneratorException;
import com.wilutions.byps.gen.api.TypeInfo;

public class BRegistryForClassDB extends BRegistry {

	public BRegistryForClassDB(BBinaryModel bmodel) {
		super(bmodel);
	}
	
	@Override
	protected BSerializer getApiSerializer(int typeId) throws BException {
		// This BRegistry subclass is used only by the ClassDB and is
		// never called to serialize any object.
		throw new IllegalStateException("BRegistryForClassDB.getApiSerializer must not be called");
	}
	
	int getTypeIdForBuiltInType(TypeInfo typeInfo) throws GeneratorException {
		
    	// Die funktion gibt's ganz ähnlich auch in ClassDB.getTypeInfo
    	// kann man eine eliminieren?
		
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

    private Random rand = new Random(System.currentTimeMillis()+1L);

	public int makeRandomTypeId() {
		int typeId = 0;
		
		if (bmodel == BBinaryModel.LARGE) {
			do {
				typeId = rand.nextInt();
				if (typeId < 0) typeId = -typeId;
			}
			while (typeId < getMinTypeIdUser());
		}
		else if (bmodel == BBinaryModel.MEDIUM) {
			do {
				typeId = rand.nextInt();
				if (typeId < 0) typeId = -typeId;
			}
			while (typeId < getMinTypeIdUser());
		}
		else if (bmodel == BBinaryModel.SMALL) {
			do {
				typeId = rand.nextInt((int)getMaxTypeIdUser());
			}
			while (typeId < getMinTypeIdUser());
		}
		else if (bmodel == BBinaryModel.TINY) {
			int _128 = (int)getMinTypeIdUser();
			typeId = rand.nextInt(_128) + _128;
		}
		else throw new IllegalStateException();
		
		return typeId;
	}

}
