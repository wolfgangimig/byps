package com.wilutions.byps.test.api;

/*
 * Serializer for com.wilutions.byps.test.api.BResult_183594037
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
public class JSerializer_333265053 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_333265053();
	
	
	public JSerializer_333265053() {
		super(333265053);
	}
	
	public JSerializer_333265053(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_183594037 obj = (BResult_183594037)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_183594037.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_183594037 obj = (BResult_183594037)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_183594037()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.lang.Object[])bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_183594037.instance);
		
		return obj;
	}
	
}
