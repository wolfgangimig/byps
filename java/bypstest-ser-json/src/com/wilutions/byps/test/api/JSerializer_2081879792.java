package com.wilutions.byps.test.api;

/*
 * Serializer for com.wilutions.byps.test.api.BResult_1487265161
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
public class JSerializer_2081879792 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_2081879792();
	
	
	public JSerializer_2081879792() {
		super(2081879792);
	}
	
	public JSerializer_2081879792(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_1487265161 obj = (BResult_1487265161)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1487265161.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_1487265161 obj = (BResult_1487265161)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1487265161()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.Map<java.lang.Byte,java.lang.Double>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1487265161.instance);
		
		return obj;
	}
	
}
