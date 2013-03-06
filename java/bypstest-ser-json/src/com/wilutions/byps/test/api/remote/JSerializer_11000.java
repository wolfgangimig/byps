package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.FirstException
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=2

@SuppressWarnings("all")
public class JSerializer_11000 extends JSerializer_20 {
	
	public final static BSerializer instance = new JSerializer_11000();
	
	
	public JSerializer_11000() {
		super(11000);
	}
	
	public JSerializer_11000(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final FirstException obj = (FirstException)obj1;		
		bout.writeObj("cause",obj.getCause(), false, null);
		bout.writeObj("listOfStrings",obj.listOfStrings, false, com.wilutions.byps.test.api.JSerializer_2123584667.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final FirstException obj = (FirstException)(obj1 != null ? obj1 : bin.onObjectCreated(new FirstException()));
		
		final BJsonObject js = bin.currentObject;
		obj.setCause((java.lang.Throwable)bin.readObj("cause", false, null));
		obj.listOfStrings = (java.util.List<java.lang.String>)bin.readObj("listOfStrings", false, com.wilutions.byps.test.api.JSerializer_2123584667.instance);
		
		return obj;
	}
	
}
