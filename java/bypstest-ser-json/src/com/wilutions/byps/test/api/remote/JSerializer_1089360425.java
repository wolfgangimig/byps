package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getString1
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
public class JSerializer_1089360425 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1089360425();
	
	
	public JSerializer_1089360425() {
		super(1089360425);
	}
	
	public JSerializer_1089360425(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteListTypes_getString1 obj = (BResult_RemoteListTypes_getString1)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_2123584667.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteListTypes_getString1 obj = (BResult_RemoteListTypes_getString1)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteListTypes_getString1()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.List<java.lang.String>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_2123584667.instance);
		
		return obj;
	}
	
}
