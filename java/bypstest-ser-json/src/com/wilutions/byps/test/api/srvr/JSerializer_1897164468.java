package com.wilutions.byps.test.api.srvr;

/*
 * Serializer for com.wilutions.byps.test.api.srvr.BResult_ClientIF_getStreams
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
public class JSerializer_1897164468 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1897164468();
	
	
	public JSerializer_1897164468() {
		super(1897164468);
	}
	
	public JSerializer_1897164468(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_ClientIF_getStreams obj = (BResult_ClientIF_getStreams)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1218831438.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_ClientIF_getStreams obj = (BResult_ClientIF_getStreams)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_ClientIF_getStreams()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.List<java.io.InputStream>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1218831438.instance);
		
		return obj;
	}
	
}
