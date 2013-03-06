package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setShort1
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
public class JSerializer_2039927862 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_2039927862();
	
	
	public JSerializer_2039927862() {
		super(2039927862);
	}
	
	public JSerializer_2039927862(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteSetTypes_setShort1 obj = (BResult_RemoteSetTypes_setShort1)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteSetTypes_setShort1()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
