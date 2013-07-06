package com.wilutions.byps.test.api;

/*
 * Serializer for com.wilutions.byps.test.api.BResult_2067161310
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
public class JSerializer_1305849624 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1305849624();
	
	
	public JSerializer_1305849624() {
		super(1305849624);
	}
	
	public JSerializer_1305849624(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_2067161310 obj = (BResult_2067161310)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_2067161310.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_2067161310 obj = (BResult_2067161310)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_2067161310()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (short[])bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_2067161310.instance);
		
		return obj;
	}
	
}
