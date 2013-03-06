package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getLong1
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
public class JSerializer_504012638 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_504012638();
	
	
	public JSerializer_504012638() {
		super(504012638);
	}
	
	public JSerializer_504012638(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteListTypes_getLong1 obj = (BResult_RemoteListTypes_getLong1)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1050216688.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteListTypes_getLong1 obj = (BResult_RemoteListTypes_getLong1)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteListTypes_getLong1()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.List<java.lang.Long>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1050216688.instance);
		
		return obj;
	}
	
}
