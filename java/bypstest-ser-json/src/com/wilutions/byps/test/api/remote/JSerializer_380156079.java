﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BStub_RemoteListTypes
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
@SuppressWarnings("all")
public class JSerializer_380156079 extends JSerializer_16 {
	
	public final static BSerializer instance = new JSerializer_380156079();
	
	public JSerializer_380156079() {
		super(380156079);
	}
	
	@Override
	public BRemote internalCreate(final BTransport transport) throws BException {
		return new BStub_RemoteListTypes(transport);
	}
	
}