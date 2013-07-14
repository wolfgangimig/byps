package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BStub_RemoteServerCtrl
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
@SuppressWarnings("all")
public class JSerializer_1124545992 extends JSerializer_16 {
	
	public final static BSerializer instance = new JSerializer_1124545992();
	
	public JSerializer_1124545992() {
		super(1124545992);
	}
	
	@Override
	public BRemote internalCreate(final BTransport transport) throws BException {
		return new BStub_RemoteServerCtrl(transport);
	}
	
}
