package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setLong
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
public class JSerializer_201707498 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_201707498();
	
	
	public JSerializer_201707498() {
		super(201707498);
	}
	
	public JSerializer_201707498(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteArrayTypes4dim_setLong obj = (BRequest_RemoteArrayTypes4dim_setLong)obj1;		
		bout.writeObj("v",obj.v, false, com.wilutions.byps.test.api.JSerializer_846419204.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteArrayTypes4dim_setLong obj = (BRequest_RemoteArrayTypes4dim_setLong)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_setLong()));
		
		final BJsonObject js = bin.currentObject;
		obj.v = (long[][][][])bin.readObj("v", false, com.wilutions.byps.test.api.JSerializer_846419204.instance);
		
		return obj;
	}
	
}
