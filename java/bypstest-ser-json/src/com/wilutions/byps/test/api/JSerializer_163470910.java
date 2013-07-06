package com.wilutions.byps.test.api;

/*
 * Serializer for com.wilutions.byps.test.api.BResult_1710660846
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
public class JSerializer_163470910 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_163470910();
	
	
	public JSerializer_163470910() {
		super(163470910);
	}
	
	public JSerializer_163470910(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_1710660846 obj = (BResult_1710660846)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1710660846.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_1710660846 obj = (BResult_1710660846)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1710660846()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.Map<java.lang.String,java.lang.String>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1710660846.instance);
		
		return obj;
	}
	
}
