package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BStub_RemoteException
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
@SuppressWarnings("all")
public class BSerializer_1959416539 extends BSerializer_16 {
	
	public final static BSerializer instance = new BSerializer_1959416539();
	
	public BSerializer_1959416539() {
		super(1959416539);
	}
	
	@Override
	public BRemote internalCreate(final BTransport transport) throws BException {
		return new BStub_RemoteException(transport);
	}
	
}
