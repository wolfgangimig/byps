package com.wilutions.byps.test.api;

/*
 * Serializer for com.wilutions.byps.test.api.BResult_1888107655
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
public class JSerializer_427000 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_427000();
	
	
	public JSerializer_427000() {
		super(427000);
	}
	
	public JSerializer_427000(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_1888107655 obj = (BResult_1888107655)obj1;		
		bout.writeObj("result",obj.result, true, com.wilutions.byps.test.api.JSerializer_1888107655.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_1888107655 obj = (BResult_1888107655)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1888107655()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.lang.String[])bin.readObj("result", true, com.wilutions.byps.test.api.JSerializer_1888107655.instance);
		
		return obj;
	}
	
}
