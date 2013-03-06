package com.wilutions.byps.test.api.arr;

/*
 * Serializer for com.wilutions.byps.test.api.arr.ArrayTypes4dim
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=10

@SuppressWarnings("all")
public class JSerializer_2004 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_2004();
	
	
	public JSerializer_2004() {
		super(2004);
	}
	
	public JSerializer_2004(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final ArrayTypes4dim obj = (ArrayTypes4dim)obj1;		
		bout.writeObj("boolean4",obj.boolean4, false, com.wilutions.byps.test.api.JSerializer_945713488.instance);
		bout.writeObj("byte4",obj.byte4, false, com.wilutions.byps.test.api.JSerializer_1201775504.instance);
		bout.writeObj("char4",obj.char4, false, com.wilutions.byps.test.api.JSerializer_769021986.instance);
		bout.writeObj("double4",obj.double4, false, com.wilutions.byps.test.api.JSerializer_2087445849.instance);
		bout.writeObj("float4",obj.float4, false, com.wilutions.byps.test.api.JSerializer_1516687588.instance);
		bout.writeObj("int4",obj.int4, false, com.wilutions.byps.test.api.JSerializer_39910537.instance);
		bout.writeObj("long4",obj.long4, false, com.wilutions.byps.test.api.JSerializer_846419204.instance);
		bout.writeObj("primitiveTypes4",obj.primitiveTypes4, false, com.wilutions.byps.test.api.JSerializer_1503107601.instance);
		bout.writeObj("short4",obj.short4, false, com.wilutions.byps.test.api.JSerializer_1859644668.instance);
		bout.writeObj("string4",obj.string4, true, com.wilutions.byps.test.api.JSerializer_588723219.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final ArrayTypes4dim obj = (ArrayTypes4dim)(obj1 != null ? obj1 : bin.onObjectCreated(new ArrayTypes4dim()));
		
		final BJsonObject js = bin.currentObject;
		obj.boolean4 = (boolean[][][][])bin.readObj("boolean4", false, com.wilutions.byps.test.api.JSerializer_945713488.instance);
		obj.byte4 = (byte[][][][])bin.readObj("byte4", false, com.wilutions.byps.test.api.JSerializer_1201775504.instance);
		obj.char4 = (char[][][][])bin.readObj("char4", false, com.wilutions.byps.test.api.JSerializer_769021986.instance);
		obj.double4 = (double[][][][])bin.readObj("double4", false, com.wilutions.byps.test.api.JSerializer_2087445849.instance);
		obj.float4 = (float[][][][])bin.readObj("float4", false, com.wilutions.byps.test.api.JSerializer_1516687588.instance);
		obj.int4 = (int[][][][])bin.readObj("int4", false, com.wilutions.byps.test.api.JSerializer_39910537.instance);
		obj.long4 = (long[][][][])bin.readObj("long4", false, com.wilutions.byps.test.api.JSerializer_846419204.instance);
		obj.primitiveTypes4 = (com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][])bin.readObj("primitiveTypes4", false, com.wilutions.byps.test.api.JSerializer_1503107601.instance);
		obj.short4 = (short[][][][])bin.readObj("short4", false, com.wilutions.byps.test.api.JSerializer_1859644668.instance);
		obj.string4 = (java.lang.String[][][][])bin.readObj("string4", true, com.wilutions.byps.test.api.JSerializer_588723219.instance);
		
		return obj;
	}
	
}
