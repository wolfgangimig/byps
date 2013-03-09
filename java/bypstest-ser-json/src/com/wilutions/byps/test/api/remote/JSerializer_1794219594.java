﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_sendAllTypes
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=10

@SuppressWarnings("all")
public class JSerializer_1794219594 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1794219594();
	
	
	public JSerializer_1794219594() {
		super(1794219594);
	}
	
	public JSerializer_1794219594(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemotePrimitiveTypes_sendAllTypes obj = (BRequest_RemotePrimitiveTypes_sendAllTypes)obj1;		
		bbuf.putBoolean("b", obj.b);
		bbuf.putChar("c", obj.c);
		bbuf.putDouble("d", obj.d);
		bbuf.putFloat("f", obj.f);
		bbuf.putInt("i", obj.i);
		bbuf.putLong("l", obj.l);
		bbuf.putShort("s", obj.s);
		bbuf.putString("str", obj.str);
		bout.writeObj("o",obj.o, false, null);
		bout.writeObj("pt",obj.pt, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemotePrimitiveTypes_sendAllTypes obj = (BRequest_RemotePrimitiveTypes_sendAllTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_sendAllTypes()));
		
		final BJsonObject js = bin.currentObject;
		obj.b = js.getBoolean("b");
		obj.c = js.getChar("c");
		obj.d = js.getDouble("d");
		obj.f = js.getFloat("f");
		obj.i = js.getInt("i");
		obj.l = js.getLong("l");
		obj.s = js.getShort("s");
		obj.str = js.getString("str");
		obj.o = (java.lang.Object)bin.readObj("o", false, null);
		obj.pt = (com.wilutions.byps.test.api.prim.PrimitiveTypes)bin.readObj("pt", false, null);
		
		return obj;
	}
	
}