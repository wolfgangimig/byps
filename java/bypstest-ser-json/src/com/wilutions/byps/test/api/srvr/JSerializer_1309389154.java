package com.wilutions.byps.test.api.srvr;

/*
 * Serializer for com.wilutions.byps.test.api.srvr.BResult_ServerIF_getClient
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
public class JSerializer_1309389154 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1309389154();
	
	
	public JSerializer_1309389154() {
		super(1309389154);
	}
	
	public JSerializer_1309389154(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_ServerIF_getClient obj = (BResult_ServerIF_getClient)obj1;		
		bout.writeObj("result",obj.result, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_ServerIF_getClient obj = (BResult_ServerIF_getClient)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_ServerIF_getClient()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (com.wilutions.byps.test.api.srvr.ClientIF)bin.readObj("result", false, null);
		
		return obj;
	}
	
}
