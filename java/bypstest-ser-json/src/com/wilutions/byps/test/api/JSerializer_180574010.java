﻿package com.wilutions.byps.test.api;

/*
 * Serializer for com.wilutions.byps.test.api.BResult_1888799711
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
public class JSerializer_180574010 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_180574010();
	
	
	public JSerializer_180574010() {
		super(180574010);
	}
	
	public JSerializer_180574010(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_1888799711 obj = (BResult_1888799711)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1888799711.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_1888799711 obj = (BResult_1888799711)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1888799711()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.Set<java.lang.String>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1888799711.instance);
		
		return obj;
	}
	
}
