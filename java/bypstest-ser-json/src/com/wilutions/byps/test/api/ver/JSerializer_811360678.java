package com.wilutions.byps.test.api.ver;

/*
 * Serializer for com.wilutions.byps.test.api.ver.BResult_EvolveIF_getClient
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
public class JSerializer_811360678 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_811360678();
	
	
	public JSerializer_811360678() {
		super(811360678);
	}
	
	public JSerializer_811360678(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_EvolveIF_getClient obj = (BResult_EvolveIF_getClient)obj1;		
		bout.writeObj("result",obj.result, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_EvolveIF_getClient obj = (BResult_EvolveIF_getClient)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_EvolveIF_getClient()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (com.wilutions.byps.test.api.ver.EvolveIF)bin.readObj("result", false, null);
		
		return obj;
	}
	
}
