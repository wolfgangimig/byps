package com.wilutions.byps.test.api.ver;

/*
 * Serializer for com.wilutions.byps.test.api.ver.BRequest_EvolveIF_setEvolve
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
public class JSerializer_246658450 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_246658450();
	
	
	public JSerializer_246658450() {
		super(246658450);
	}
	
	public JSerializer_246658450(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_EvolveIF_setEvolve obj = (BRequest_EvolveIF_setEvolve)obj1;		
		bout.writeObj("obj",obj.obj, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_EvolveIF_setEvolve obj = (BRequest_EvolveIF_setEvolve)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_EvolveIF_setEvolve()));
		
		final BJsonObject js = bin.currentObject;
		obj.obj = (com.wilutions.byps.test.api.ver.Evolve)bin.readObj("obj", false, null);
		
		return obj;
	}
	
}
