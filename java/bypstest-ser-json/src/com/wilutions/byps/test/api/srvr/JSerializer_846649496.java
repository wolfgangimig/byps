package com.wilutions.byps.test.api.srvr;

/*
 * Serializer for com.wilutions.byps.test.api.srvr.BResult_ServerIF_callClientIncrementInt
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
public class JSerializer_846649496 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_846649496();
	
	
	public JSerializer_846649496() {
		super(846649496);
	}
	
	public JSerializer_846649496(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_ServerIF_callClientIncrementInt obj = (BResult_ServerIF_callClientIncrementInt)obj1;		
		bbuf.putInt("result", obj.result);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_ServerIF_callClientIncrementInt obj = (BResult_ServerIF_callClientIncrementInt)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_ServerIF_callClientIncrementInt()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = js.getInt("result");
		
		return obj;
	}
	
}
