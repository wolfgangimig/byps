package com.wilutions.byps.test.api;

/*
 * Serializer for com.wilutions.byps.test.api.BResult_1851881336
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
public class JSerializer_1651982651 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1651982651();
	
	
	public JSerializer_1651982651() {
		super(1651982651);
	}
	
	public JSerializer_1651982651(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_1851881336 obj = (BResult_1851881336)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1851881336.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_1851881336 obj = (BResult_1851881336)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1851881336()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Point2D>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1851881336.instance);
		
		return obj;
	}
	
}
