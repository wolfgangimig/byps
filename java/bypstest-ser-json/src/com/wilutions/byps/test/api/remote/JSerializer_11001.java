package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.SecondException
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=1

@SuppressWarnings("all")
public class JSerializer_11001 extends JSerializer_20 {
	
	public final static BSerializer instance = new JSerializer_11001();
	
	
	public JSerializer_11001() {
		super(11001);
	}
	
	public JSerializer_11001(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final SecondException obj = (SecondException)obj1;		
		bbuf.putString("msg", obj.getMsg());
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final SecondException obj = (SecondException)(obj1 != null ? obj1 : bin.onObjectCreated(new SecondException()));
		
		final BJsonObject js = bin.currentObject;
		obj.setMsg(js.getString("msg"));
		
		return obj;
	}
	
}
