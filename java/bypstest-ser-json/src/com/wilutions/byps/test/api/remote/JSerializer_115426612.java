package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteStreams_getImage
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
public class JSerializer_115426612 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_115426612();
	
	
	public JSerializer_115426612() {
		super(115426612);
	}
	
	public JSerializer_115426612(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteStreams_getImage obj = (BResult_RemoteStreams_getImage)obj1;		
		bout.writeObj("result",obj.result, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteStreams_getImage obj = (BResult_RemoteStreams_getImage)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteStreams_getImage()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.io.InputStream)bin.readObj("result", false, null);
		
		return obj;
	}
	
}
