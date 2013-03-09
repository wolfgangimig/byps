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
public class BSerializer_1541129345 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1541129345();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: is1 */ + 4		
		       /* pos=4: contentType */ + 4		
		       /* pos=8: arrStream */ + 4		
		       /* pos=12: listStream */ + 4		
		       /* pos=16: mapStream */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_1541129345() {
		super(1541129345);
	}
	
	public BSerializer_1541129345(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final Stream1 obj = (Stream1)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putString(obj.getContentType());
		bout.writeObj(obj.getArrStream(), false, com.wilutions.byps.test.api.BSerializer_1950626768.instance);
		bout.writeObj(obj.is1, false, null);
		bout.writeObj(obj.getListStream(), false, com.wilutions.byps.test.api.BSerializer_1218831438.instance);
		bout.writeObj(obj.mapStream, false, com.wilutions.byps.test.api.BSerializer_779528402.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final Stream1 obj = (Stream1)(obj1 != null ? obj1 : bin.onObjectCreated(new Stream1()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.setContentType(bbuf.getString());
		obj.setArrStream((java.io.InputStream[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1950626768.instance));
		obj.is1 = (java.io.InputStream)bin.readObj(false, null);
		obj.setListStream((java.util.List<java.io.InputStream>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1218831438.instance));
		obj.mapStream = (java.util.Map<java.lang.Integer,java.io.InputStream>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_779528402.instance);
		
		return obj;
	}
	
}