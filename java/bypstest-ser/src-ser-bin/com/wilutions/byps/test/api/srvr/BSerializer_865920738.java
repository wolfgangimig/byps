﻿package com.wilutions.byps.test.api.srvr;

/*
 * Serializer for com.wilutions.byps.test.api.srvr.BRequest_ClientIF_getStreams
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
public class BSerializer_865920738 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_865920738();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: ctrl */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_865920738() {
		super(865920738);
	}
	
	public BSerializer_865920738(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BRequest_ClientIF_getStreams obj = (BRequest_ClientIF_getStreams)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putInt(obj.ctrl);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_ClientIF_getStreams obj = (BRequest_ClientIF_getStreams)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ClientIF_getStreams()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.ctrl = bbuf.getInt();
		
		return obj;
	}
	
}