﻿package com.wilutions.byps.test.api.remote;

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
public class BSerializer_944362859 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_944362859();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: istrms */ + 4		
		       /* pos=4: doNotReadStreamAtKey */ + 4		
		       /* padding up to multiple of alignment */ + 0;		
	}
	
	public BSerializer_944362859() {
		super(944362859);
	}
	
	public BSerializer_944362859(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BRequest_RemoteStreams_setImages obj = (BRequest_RemoteStreams_setImages)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putInt(obj.doNotReadStreamAtKey);
		bout.writeObj(obj.istrms, false, com.wilutions.byps.test.api.BSerializer_779528402.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemoteStreams_setImages obj = (BRequest_RemoteStreams_setImages)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteStreams_setImages()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.doNotReadStreamAtKey = bbuf.getInt();
		obj.istrms = (java.util.Map<java.lang.Integer,java.io.InputStream>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_779528402.instance);
		
		return obj;
	}
	
}