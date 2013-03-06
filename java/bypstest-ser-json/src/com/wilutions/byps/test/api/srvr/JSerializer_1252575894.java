package com.wilutions.byps.test.api.srvr;

/*
 * Serializer for com.wilutions.byps.test.api.srvr.BRequest_ServerIF_callClientIncrementInt
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
public class JSerializer_1252575894 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1252575894();
	
	
	public JSerializer_1252575894() {
		super(1252575894);
	}
	
	public JSerializer_1252575894(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_ServerIF_callClientIncrementInt obj = (BRequest_ServerIF_callClientIncrementInt)obj1;		
		bbuf.putInt("v", obj.v);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_ServerIF_callClientIncrementInt obj = (BRequest_ServerIF_callClientIncrementInt)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ServerIF_callClientIncrementInt()));
		
		final BJsonObject js = bin.currentObject;
		obj.v = js.getInt("v");
		
		return obj;
	}
	
}
