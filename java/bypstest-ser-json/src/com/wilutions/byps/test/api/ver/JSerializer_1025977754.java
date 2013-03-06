package com.wilutions.byps.test.api.ver;

/*
 * Serializer for com.wilutions.byps.test.api.ver.BResult_EvolveIF_setClient
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
public class JSerializer_1025977754 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1025977754();
	
	
	public JSerializer_1025977754() {
		super(1025977754);
	}
	
	public JSerializer_1025977754(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_EvolveIF_setClient obj = (BResult_EvolveIF_setClient)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_EvolveIF_setClient()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
