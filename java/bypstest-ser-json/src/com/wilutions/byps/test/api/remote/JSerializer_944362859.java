package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_setImages
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=2

@SuppressWarnings("all")
public class JSerializer_944362859 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_944362859();
	
	
	public JSerializer_944362859() {
		super(944362859);
	}
	
	public JSerializer_944362859(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteStreams_setImages obj = (BRequest_RemoteStreams_setImages)obj1;		
		bbuf.putInt("doNotReadStreamAtKey", obj.doNotReadStreamAtKey);
		bout.writeObj("istrms",obj.istrms, false, com.wilutions.byps.test.api.JSerializer_779528402.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteStreams_setImages obj = (BRequest_RemoteStreams_setImages)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteStreams_setImages()));
		
		final BJsonObject js = bin.currentObject;
		obj.doNotReadStreamAtKey = js.getInt("doNotReadStreamAtKey");
		obj.istrms = (java.util.Map<java.lang.Integer,java.io.InputStream>)bin.readObj("istrms", false, com.wilutions.byps.test.api.JSerializer_779528402.instance);
		
		return obj;
	}
	
}
