package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteException_throwBException
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=2

@SuppressWarnings("all")
public class JSerializer_641509600 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_641509600();
	
	
	public JSerializer_641509600() {
		super(641509600);
	}
	
	public JSerializer_641509600(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteException_throwBException obj = (BRequest_RemoteException_throwBException)obj1;		
		bbuf.putInt("code", obj.code);
		bbuf.putString("msg", obj.msg);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteException_throwBException obj = (BRequest_RemoteException_throwBException)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteException_throwBException()));
		
		final BJsonObject js = bin.currentObject;
		obj.code = js.getInt("code");
		obj.msg = js.getString("msg");
		
		return obj;
	}
	
}
