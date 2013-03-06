package com.wilutions.byps.test.api.srvr;

/*
 * Serializer for com.wilutions.byps.test.api.srvr.BResult_ServerIF_setPartner
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
public class JSerializer_2075320443 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_2075320443();
	
	
	public JSerializer_2075320443() {
		super(2075320443);
	}
	
	public JSerializer_2075320443(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_ServerIF_setPartner obj = (BResult_ServerIF_setPartner)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_ServerIF_setPartner()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
