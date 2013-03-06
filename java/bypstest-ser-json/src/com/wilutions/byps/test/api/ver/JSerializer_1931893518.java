package com.wilutions.byps.test.api.ver;

/*
 * Serializer for com.wilutions.byps.test.api.ver.BResult_EvolveIF_sendEvolveToClient
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
public class JSerializer_1931893518 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1931893518();
	
	
	public JSerializer_1931893518() {
		super(1931893518);
	}
	
	public JSerializer_1931893518(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_EvolveIF_sendEvolveToClient obj = (BResult_EvolveIF_sendEvolveToClient)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_EvolveIF_sendEvolveToClient()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
