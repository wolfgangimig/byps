package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BStub_RemoteReferences
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
@SuppressWarnings("all")
public class JSerializer_2086824050 extends JSerializer_16 {
	
	public final static BSerializer instance = new JSerializer_2086824050();
	
	public JSerializer_2086824050() {
		super(2086824050);
	}
	
	@Override
	public BRemote internalCreate(final BTransport transport) throws BException {
		return new BStub_RemoteReferences(transport);
	}
	
}
