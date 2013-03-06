package com.wilutions.byps.test.api.srvr;

/*
 * Serializer for com.wilutions.byps.test.api.srvr.BResult_ServerIF_getPartner
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
public class JSerializer_282841617 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_282841617();
	
	
	public JSerializer_282841617() {
		super(282841617);
	}
	
	public JSerializer_282841617(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_ServerIF_getPartner obj = (BResult_ServerIF_getPartner)obj1;		
		bout.writeObj("result",obj.result, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_ServerIF_getPartner obj = (BResult_ServerIF_getPartner)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_ServerIF_getPartner()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (com.wilutions.byps.test.api.srvr.ClientIF)bin.readObj("result", false, null);
		
		return obj;
	}
	
}
