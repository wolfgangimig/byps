package com.wilutions.byps.test.api.srvr;

/*
 * Serializer for com.wilutions.byps.test.api.srvr.BResult_ClientIF_putStreams
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
public class JSerializer_1274042587 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1274042587();
	
	
	public JSerializer_1274042587() {
		super(1274042587);
	}
	
	public JSerializer_1274042587(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_ClientIF_putStreams obj = (BResult_ClientIF_putStreams)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_ClientIF_putStreams()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
