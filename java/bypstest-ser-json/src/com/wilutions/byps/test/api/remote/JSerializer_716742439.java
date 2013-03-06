package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteStreams_getImages
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
public class JSerializer_716742439 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_716742439();
	
	
	public JSerializer_716742439() {
		super(716742439);
	}
	
	public JSerializer_716742439(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteStreams_getImages obj = (BResult_RemoteStreams_getImages)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_476459792.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteStreams_getImages obj = (BResult_RemoteStreams_getImages)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteStreams_getImages()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.TreeMap<java.lang.Integer,java.io.InputStream>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_476459792.instance);
		
		return obj;
	}
	
}
