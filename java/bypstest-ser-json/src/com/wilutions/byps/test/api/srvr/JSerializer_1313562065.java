package com.wilutions.byps.test.api.srvr;

/*
 * Serializer for com.wilutions.byps.test.api.srvr.BStub_ServerIF
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
@SuppressWarnings("all")
public class JSerializer_1313562065 extends JSerializer_16 {
	
	public final static BSerializer instance = new JSerializer_1313562065();
	
	public JSerializer_1313562065() {
		super(1313562065);
	}
	
	@Override
	public BRemote internalCreate(final BTransport transport) throws BException {
		return new BStub_ServerIF(transport);
	}
	
}
