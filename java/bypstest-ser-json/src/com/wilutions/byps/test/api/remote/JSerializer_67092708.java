package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteException_throwException
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
public class JSerializer_67092708 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_67092708();
	
	
	public JSerializer_67092708() {
		super(67092708);
	}
	
	public JSerializer_67092708(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteException_throwException obj = (BRequest_RemoteException_throwException)obj1;		
		bbuf.putInt("what", obj.what);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteException_throwException obj = (BRequest_RemoteException_throwException)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteException_throwException()));
		
		final BJsonObject js = bin.currentObject;
		obj.what = js.getInt("what");
		
		return obj;
	}
	
}
