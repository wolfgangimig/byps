package com.wilutions.byps.test.api;

/*
 * Serializer for com.wilutions.byps.test.api.BResult_1972793385
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
public class JSerializer_104960651 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_104960651();
	
	
	public JSerializer_104960651() {
		super(104960651);
	}
	
	public JSerializer_104960651(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_1972793385 obj = (BResult_1972793385)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1972793385.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_1972793385 obj = (BResult_1972793385)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1972793385()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.HashMap<java.lang.Double,java.lang.Byte>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1972793385.instance);
		
		return obj;
	}
	
}
