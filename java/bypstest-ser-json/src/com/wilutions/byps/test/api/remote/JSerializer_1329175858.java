package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getByte
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
public class JSerializer_1329175858 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1329175858();
	
	
	public JSerializer_1329175858() {
		super(1329175858);
	}
	
	public JSerializer_1329175858(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteArrayTypes4dim_getByte obj = (BResult_RemoteArrayTypes4dim_getByte)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1201775504.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteArrayTypes4dim_getByte obj = (BResult_RemoteArrayTypes4dim_getByte)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteArrayTypes4dim_getByte()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (byte[][][][])bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1201775504.instance);
		
		return obj;
	}
	
}
