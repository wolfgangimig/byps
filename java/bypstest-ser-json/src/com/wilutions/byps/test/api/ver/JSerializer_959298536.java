package com.wilutions.byps.test.api.ver;

/*
 * Serializer for com.wilutions.byps.test.api.ver.BResult_EvolveIF_setEvolve
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
public class JSerializer_959298536 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_959298536();
	
	
	public JSerializer_959298536() {
		super(959298536);
	}
	
	public JSerializer_959298536(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_EvolveIF_setEvolve obj = (BResult_EvolveIF_setEvolve)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_EvolveIF_setEvolve()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
