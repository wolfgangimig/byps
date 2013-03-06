package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteStreams_throwLastException
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
public class JSerializer_1243858054 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1243858054();
	
	
	public JSerializer_1243858054() {
		super(1243858054);
	}
	
	public JSerializer_1243858054(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteStreams_throwLastException obj = (BResult_RemoteStreams_throwLastException)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteStreams_throwLastException()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
