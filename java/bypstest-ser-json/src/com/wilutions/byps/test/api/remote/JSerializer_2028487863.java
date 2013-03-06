package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BStub_RemoteStreams
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
@SuppressWarnings("all")
public class JSerializer_2028487863 extends JSerializer_16 {
	
	public final static BSerializer instance = new JSerializer_2028487863();
	
	public JSerializer_2028487863() {
		super(2028487863);
	}
	
	@Override
	public BRemote internalCreate(final BTransport transport) throws BException {
		return new BStub_RemoteStreams(transport);
	}
	
}
