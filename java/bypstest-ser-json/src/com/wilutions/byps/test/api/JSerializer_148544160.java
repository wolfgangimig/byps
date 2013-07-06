package com.wilutions.byps.test.api;

/*
 * Serializer for com.wilutions.byps.test.api.BResult_3
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
public class JSerializer_148544160 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_148544160();
	
	
	public JSerializer_148544160() {
		super(148544160);
	}
	
	public JSerializer_148544160(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_3 obj = (BResult_3)obj1;		
		bbuf.putShort("result", obj.result);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_3 obj = (BResult_3)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_3()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = js.getShort("result");
		
		return obj;
	}
	
}
