package com.wilutions.byps.test.api;

/*
 * Serializer for com.wilutions.byps.test.api.BResult_1218831438
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
public class JSerializer_1151524674 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1151524674();
	
	
	public JSerializer_1151524674() {
		super(1151524674);
	}
	
	public JSerializer_1151524674(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_1218831438 obj = (BResult_1218831438)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1218831438.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_1218831438 obj = (BResult_1218831438)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1218831438()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.List<java.io.InputStream>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1218831438.instance);
		
		return obj;
	}
	
}
