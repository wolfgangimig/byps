package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getByte
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
public class JSerializer_1716424015 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1716424015();
	
	
	public JSerializer_1716424015() {
		super(1716424015);
	}
	
	public JSerializer_1716424015(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteArrayTypes1dim_getByte obj = (BResult_RemoteArrayTypes1dim_getByte)obj1;		
		bbuf.putArrayByte("result", obj.result);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteArrayTypes1dim_getByte obj = (BResult_RemoteArrayTypes1dim_getByte)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteArrayTypes1dim_getByte()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = js.getArrayByte("result");
		
		return obj;
	}
	
}
