﻿package com.wilutions.byps.test.api;

/*
 * Serializer for com.wilutions.byps.test.api.BResult_9001
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
public class JSerializer_1462529269 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1462529269();
	
	
	public JSerializer_1462529269() {
		super(1462529269);
	}
	
	public JSerializer_1462529269(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_9001 obj = (BResult_9001)obj1;		
		bout.writeObj("result",obj.result, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_9001 obj = (BResult_9001)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_9001()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (com.wilutions.byps.test.api.refs.Node)bin.readObj("result", false, null);
		
		return obj;
	}
	
}