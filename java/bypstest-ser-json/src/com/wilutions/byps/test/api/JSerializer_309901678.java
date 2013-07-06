package com.wilutions.byps.test.api;

/*
 * Serializer for com.wilutions.byps.test.api.BResult_10
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
public class JSerializer_309901678 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_309901678();
	
	
	public JSerializer_309901678() {
		super(309901678);
	}
	
	public JSerializer_309901678(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_10 obj = (BResult_10)obj1;		
		bbuf.putString("result", obj.result);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_10 obj = (BResult_10)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_10()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = js.getString("result");
		
		return obj;
	}
	
}
