﻿package com.wilutions.byps.test.api.prim;

/*
 * Serializer for com.wilutions.byps.test.api.prim.PrimitiveTypes
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=13

@SuppressWarnings("all")
public class JSerializer_1000 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1000();
	
	
	public JSerializer_1000() {
		super(1000);
	}
	
	public JSerializer_1000(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final PrimitiveTypes obj = (PrimitiveTypes)obj1;		
		bbuf.putBoolean("boolVal", obj.boolVal);
		bbuf.putByte("byteVal", obj.byteVal);
		bbuf.putChar("charVal", obj.charVal);
		bbuf.putDouble("doubleVal", obj.doubleVal);
		bbuf.putFloat("floatVal", obj.floatVal);
		bbuf.putInt("intVal", obj.intVal);
		bbuf.putLong("longVal", obj.longVal);
		bbuf.putShort("shortVal", obj.shortVal);
		bbuf.putString("stringVal", obj.stringVal);
		bbuf.putBoolean("value", obj.value);
		bout.writeObj("objVal",obj.objVal, false, null);
		bout.writeObj("objVal2",obj.objVal2, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final PrimitiveTypes obj = (PrimitiveTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new PrimitiveTypes()));
		
		final BJsonObject js = bin.currentObject;
		obj.boolVal = js.getBoolean("boolVal");
		obj.byteVal = js.getByte("byteVal");
		obj.charVal = js.getChar("charVal");
		obj.doubleVal = js.getDouble("doubleVal");
		obj.floatVal = js.getFloat("floatVal");
		obj.intVal = js.getInt("intVal");
		obj.longVal = js.getLong("longVal");
		obj.shortVal = js.getShort("shortVal");
		obj.stringVal = js.getString("stringVal");
		obj.value = js.getBoolean("value");
		obj.objVal = (java.lang.Object)bin.readObj("objVal", false, null);
		obj.objVal2 = (java.lang.Object)bin.readObj("objVal2", false, null);
		
		return obj;
	}
	
}