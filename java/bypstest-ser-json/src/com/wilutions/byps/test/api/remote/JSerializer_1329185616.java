package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getBool
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
public class JSerializer_1329185616 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1329185616();
	
	
	public JSerializer_1329185616() {
		super(1329185616);
	}
	
	public JSerializer_1329185616(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteArrayTypes4dim_getBool obj = (BResult_RemoteArrayTypes4dim_getBool)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_945713488.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteArrayTypes4dim_getBool obj = (BResult_RemoteArrayTypes4dim_getBool)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteArrayTypes4dim_getBool()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (boolean[][][][])bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_945713488.instance);
		
		return obj;
	}
	
}
