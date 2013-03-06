package com.wilutions.byps.test.api.ver;

/*
 * Serializer for com.wilutions.byps.test.api.ver.BResult_EvolveIF_getEvolve
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
public class JSerializer_744681460 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_744681460();
	
	
	public JSerializer_744681460() {
		super(744681460);
	}
	
	public JSerializer_744681460(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_EvolveIF_getEvolve obj = (BResult_EvolveIF_getEvolve)obj1;		
		bout.writeObj("result",obj.result, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_EvolveIF_getEvolve obj = (BResult_EvolveIF_getEvolve)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_EvolveIF_getEvolve()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (com.wilutions.byps.test.api.ver.Evolve)bin.readObj("result", false, null);
		
		return obj;
	}
	
}
