﻿package com.wilutions.byps.test.api;

/*
 * Serializer for com.wilutions.byps.test.api.BResult_1320560671
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=1

@SuppressWarnings("all")
public class JSerializer_190591700 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_190591700();
	
	
	public JSerializer_190591700() {
		super(190591700);
	}
	
	public JSerializer_190591700(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_1320560671 obj = (BResult_1320560671)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1320560671.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_1320560671 obj = (BResult_1320560671)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1320560671()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.Set<java.lang.Double>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1320560671.instance);
		
		return obj;
	}
	
}