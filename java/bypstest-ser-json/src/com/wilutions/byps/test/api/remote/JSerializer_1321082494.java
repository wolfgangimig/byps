package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getPoint2DMap
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=0

@SuppressWarnings("all")
public class JSerializer_1321082494 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1321082494();
	
	
	public JSerializer_1321082494() {
		super(1321082494);
	}
	
	public JSerializer_1321082494(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteInlineInstance_getPoint2DMap obj = (BRequest_RemoteInlineInstance_getPoint2DMap)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_getPoint2DMap()));
		
		return obj;
	}
	
}
