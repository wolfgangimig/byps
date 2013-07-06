package com.wilutions.byps.test.api;

/*
 * Serializer for com.wilutions.byps.test.api.BResult_1859644668
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
public class JSerializer_101217472 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_101217472();
	
	
	public JSerializer_101217472() {
		super(101217472);
	}
	
	public JSerializer_101217472(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_1859644668 obj = (BResult_1859644668)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1859644668.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_1859644668 obj = (BResult_1859644668)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1859644668()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (short[][][][])bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1859644668.instance);
		
		return obj;
	}
	
}
