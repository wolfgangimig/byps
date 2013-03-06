package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_getInt2
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
public class JSerializer_431810266 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_431810266();
	
	
	public JSerializer_431810266() {
		super(431810266);
	}
	
	public JSerializer_431810266(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteListTypes_getInt2 obj = (BResult_RemoteListTypes_getInt2)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1752158699.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteListTypes_getInt2 obj = (BResult_RemoteListTypes_getInt2)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteListTypes_getInt2()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.List<int[]>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1752158699.instance);
		
		return obj;
	}
	
}
