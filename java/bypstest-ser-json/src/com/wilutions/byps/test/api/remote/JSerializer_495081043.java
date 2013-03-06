package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getByte2
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
public class JSerializer_495081043 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_495081043();
	
	
	public JSerializer_495081043() {
		super(495081043);
	}
	
	public JSerializer_495081043(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteListTypes_getByte2 obj = (BResult_RemoteListTypes_getByte2)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1174971318.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteListTypes_getByte2 obj = (BResult_RemoteListTypes_getByte2)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteListTypes_getByte2()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.List<byte[]>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1174971318.instance);
		
		return obj;
	}
	
}
