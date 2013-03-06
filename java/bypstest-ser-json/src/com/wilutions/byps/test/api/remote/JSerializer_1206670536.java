package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
@SuppressWarnings("all")
public class JSerializer_1206670536 extends JSerializer_16 {
	
	public final static BSerializer instance = new JSerializer_1206670536();
	
	public JSerializer_1206670536() {
		super(1206670536);
	}
	
	@Override
	public BRemote internalCreate(final BTransport transport) throws BException {
		return new BStub_RemoteInlineInstance(transport);
	}
	
}
