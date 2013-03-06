package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteStreams_setImages
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
public class JSerializer_502125363 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_502125363();
	
	
	public JSerializer_502125363() {
		super(502125363);
	}
	
	public JSerializer_502125363(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteStreams_setImages obj = (BResult_RemoteStreams_setImages)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteStreams_setImages()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
