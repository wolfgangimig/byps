﻿package com.wilutions.byps.test.api;

/*
 * Serializer for com.wilutions.byps.test.api.BResult_1178379224
 * 
 * THIS FILE HAS BEEN GENERATED BY class com.wilutions.byps.gen.j.GenSerStructJson DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=1

@SuppressWarnings("all")
public class JSerializer_1911325389 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1911325389();
	
	
	public JSerializer_1911325389() {
		super(1911325389);
	}
	
	public JSerializer_1911325389(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_1178379224 obj = (BResult_1178379224)obj1;		
		bout.writeObj("result",obj.result, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_1178379224 obj = (BResult_1178379224)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1178379224()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (com.wilutions.byps.test.api.ver.EvolveIF)bin.readObj("result", false, null);
		
		return obj;
	}
	
}