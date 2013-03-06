package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
@SuppressWarnings("all")
public class JSerializer_1557173854 extends JSerializer_16 {
	
	public final static BSerializer instance = new JSerializer_1557173854();
	
	public JSerializer_1557173854() {
		super(1557173854);
	}
	
	@Override
	public BRemote internalCreate(final BTransport transport) throws BException {
		return new BStub_RemoteArrayTypes4dim(transport);
	}
	
}
