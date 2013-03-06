package com.wilutions.byps.test.api.srvr;

/*
 * Serializer for com.wilutions.byps.test.api.srvr.BResult_ClientIF_incrementInt
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
public class JSerializer_1720916535 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1720916535();
	
	
	public JSerializer_1720916535() {
		super(1720916535);
	}
	
	public JSerializer_1720916535(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_ClientIF_incrementInt obj = (BResult_ClientIF_incrementInt)obj1;		
		bbuf.putInt("result", obj.result);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_ClientIF_incrementInt obj = (BResult_ClientIF_incrementInt)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_ClientIF_incrementInt()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = js.getInt("result");
		
		return obj;
	}
	
}
