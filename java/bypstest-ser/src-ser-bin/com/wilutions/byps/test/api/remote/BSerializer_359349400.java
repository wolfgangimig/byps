package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BStub_RemoteEnums
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
@SuppressWarnings("all")
public class BSerializer_359349400 extends BSerializer_16 {
	
	public final static BSerializer instance = new BSerializer_359349400();
	
	public BSerializer_359349400() {
		super(359349400);
	}
	
	@Override
	public BRemote internalCreate(final BTransport transport) throws BException {
		return new BStub_RemoteEnums(transport);
	}
	
}
