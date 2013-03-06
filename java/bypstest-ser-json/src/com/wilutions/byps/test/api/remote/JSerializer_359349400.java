package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BStub_RemoteEnums
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
@SuppressWarnings("all")
public class JSerializer_359349400 extends JSerializer_16 {
	
	public final static BSerializer instance = new JSerializer_359349400();
	
	public JSerializer_359349400() {
		super(359349400);
	}
	
	@Override
	public BRemote internalCreate(final BTransport transport) throws BException {
		return new BStub_RemoteEnums(transport);
	}
	
}
