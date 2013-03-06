package com.wilutions.byps.test.api.srvr;

/*
 * Serializer for com.wilutions.byps.test.api.srvr.BResult_ClientIF_sendChat
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
public class JSerializer_1101039945 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1101039945();
	
	
	public JSerializer_1101039945() {
		super(1101039945);
	}
	
	public JSerializer_1101039945(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_ClientIF_sendChat obj = (BResult_ClientIF_sendChat)obj1;		
		bout.writeObj("result",obj.result, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_ClientIF_sendChat obj = (BResult_ClientIF_sendChat)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_ClientIF_sendChat()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (com.wilutions.byps.test.api.srvr.ChatStructure)bin.readObj("result", false, null);
		
		return obj;
	}
	
}
