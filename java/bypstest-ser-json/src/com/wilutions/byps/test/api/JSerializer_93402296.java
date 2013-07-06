package com.wilutions.byps.test.api;

/*
 * Serializer for com.wilutions.byps.test.api.BResult_476459792
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
public class JSerializer_93402296 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_93402296();
	
	
	public JSerializer_93402296() {
		super(93402296);
	}
	
	public JSerializer_93402296(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_476459792 obj = (BResult_476459792)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_476459792.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_476459792 obj = (BResult_476459792)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_476459792()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.TreeMap<java.lang.Integer,java.io.InputStream>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_476459792.instance);
		
		return obj;
	}
	
}
