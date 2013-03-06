package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getByte1
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
public class JSerializer_495081042 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_495081042();
	
	
	public JSerializer_495081042() {
		super(495081042);
	}
	
	public JSerializer_495081042(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteListTypes_getByte1 obj = (BResult_RemoteListTypes_getByte1)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1059148284.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteListTypes_getByte1 obj = (BResult_RemoteListTypes_getByte1)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteListTypes_getByte1()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.List<java.lang.Byte>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1059148284.instance);
		
		return obj;
	}
	
}
