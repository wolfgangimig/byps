package com.wilutions.byps.test.api.ver;

/*
 * Serializer for com.wilutions.byps.test.api.ver.BRequest_EvolveIF_getEvolve
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=0

@SuppressWarnings("all")
public class JSerializer_32041374 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_32041374();
	
	
	public JSerializer_32041374() {
		super(32041374);
	}
	
	public JSerializer_32041374(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_EvolveIF_getEvolve obj = (BRequest_EvolveIF_getEvolve)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_EvolveIF_getEvolve()));
		
		return obj;
	}
	
}
