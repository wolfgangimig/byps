package com.wilutions.byps.test.api.srvr;

/*
 * Serializer for com.wilutions.byps.test.api.srvr.BResult_ServerIF_putStreamsOnClient
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=1

@SuppressWarnings("all")
public class JSerializer_1000905741 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1000905741();
	
	
	public JSerializer_1000905741() {
		super(1000905741);
	}
	
	public JSerializer_1000905741(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_ServerIF_putStreamsOnClient obj = (BResult_ServerIF_putStreamsOnClient)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_ServerIF_putStreamsOnClient()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
