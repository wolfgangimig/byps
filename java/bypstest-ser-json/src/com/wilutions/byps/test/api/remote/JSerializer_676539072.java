package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteStreams_setImage
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
public class JSerializer_676539072 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_676539072();
	
	
	public JSerializer_676539072() {
		super(676539072);
	}
	
	public JSerializer_676539072(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteStreams_setImage obj = (BResult_RemoteStreams_setImage)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteStreams_setImage()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
