package com.wilutions.byps.test.api;

/*
 * Serializer for com.wilutions.byps.test.api.BResult_1633750383
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
public class JSerializer_770118380 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_770118380();
	
	
	public JSerializer_770118380() {
		super(770118380);
	}
	
	public JSerializer_770118380(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_1633750383 obj = (BResult_1633750383)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1633750383.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_1633750383 obj = (BResult_1633750383)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1633750383()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.Map<java.lang.Integer,int[]>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1633750383.instance);
		
		return obj;
	}
	
}
