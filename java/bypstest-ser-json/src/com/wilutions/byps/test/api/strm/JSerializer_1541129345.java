﻿package com.wilutions.byps.test.api.strm;

/*
 * Serializer for com.wilutions.byps.test.api.strm.Stream1
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=5

@SuppressWarnings("all")
public class JSerializer_1541129345 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1541129345();
	
	
	public JSerializer_1541129345() {
		super(1541129345);
	}
	
	public JSerializer_1541129345(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final Stream1 obj = (Stream1)obj1;		
		bbuf.putString("contentType", obj.getContentType());
		bout.writeObj("arrStream",obj.getArrStream(), false, com.wilutions.byps.test.api.JSerializer_1950626768.instance);
		bout.writeObj("is1",obj.is1, false, null);
		bout.writeObj("listStream",obj.getListStream(), false, com.wilutions.byps.test.api.JSerializer_1218831438.instance);
		bout.writeObj("mapStream",obj.mapStream, false, com.wilutions.byps.test.api.JSerializer_779528402.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final Stream1 obj = (Stream1)(obj1 != null ? obj1 : bin.onObjectCreated(new Stream1()));
		
		final BJsonObject js = bin.currentObject;
		obj.setContentType(js.getString("contentType"));
		obj.setArrStream((java.io.InputStream[])bin.readObj("arrStream", false, com.wilutions.byps.test.api.JSerializer_1950626768.instance));
		obj.is1 = (java.io.InputStream)bin.readObj("is1", false, null);
		obj.setListStream((java.util.List<java.io.InputStream>)bin.readObj("listStream", false, com.wilutions.byps.test.api.JSerializer_1218831438.instance));
		obj.mapStream = (java.util.Map<java.lang.Integer,java.io.InputStream>)bin.readObj("mapStream", false, com.wilutions.byps.test.api.JSerializer_779528402.instance);
		
		return obj;
	}
	
}