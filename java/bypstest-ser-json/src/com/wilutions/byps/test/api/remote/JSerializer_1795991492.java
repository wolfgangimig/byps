package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteStreams_getTextStream
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
public class JSerializer_1795991492 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1795991492();
	
	
	public JSerializer_1795991492() {
		super(1795991492);
	}
	
	public JSerializer_1795991492(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteStreams_getTextStream obj = (BResult_RemoteStreams_getTextStream)obj1;		
		bout.writeObj("result",obj.result, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteStreams_getTextStream obj = (BResult_RemoteStreams_getTextStream)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteStreams_getTextStream()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.io.InputStream)bin.readObj("result", false, null);
		
		return obj;
	}
	
}
