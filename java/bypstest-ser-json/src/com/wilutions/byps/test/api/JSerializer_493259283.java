﻿package com.wilutions.byps.test.api;

/*
 * Serializer for com.wilutions.byps.test.api.BResult_1359468275
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
public class JSerializer_493259283 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_493259283();
	
	
	public JSerializer_493259283() {
		super(493259283);
	}
	
	public JSerializer_493259283(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_1359468275 obj = (BResult_1359468275)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1359468275.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_1359468275 obj = (BResult_1359468275)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1359468275()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (double[])bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1359468275.instance);
		
		return obj;
	}
	
}
