package com.wilutions.byps.test.api.cons;

/*
 * Serializer for com.wilutions.byps.test.api.cons.AllTypesC
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=18

@SuppressWarnings("all")
public class JSerializer_619221761 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_619221761();
	
	
	public JSerializer_619221761() {
		super(619221761);
	}
	
	public JSerializer_619221761(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final AllTypesC obj = (AllTypesC)obj1;		
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final AllTypesC obj = (AllTypesC)(obj1 != null ? obj1 : bin.onObjectCreated(new AllTypesC()));
		
		final BJsonObject js = bin.currentObject;
		
		return obj;
	}
	
}
