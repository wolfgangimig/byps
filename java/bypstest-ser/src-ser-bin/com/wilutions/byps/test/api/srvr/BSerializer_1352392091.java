﻿package com.wilutions.byps.test.api.srvr;

/*
 * Serializer for com.wilutions.byps.test.api.srvr.BRequest_ClientIF_sendChat
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
public class BSerializer_1352392091 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1352392091();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: cs */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_1352392091() {
		super(1352392091);
	}
	
	public BSerializer_1352392091(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BRequest_ClientIF_sendChat obj = (BRequest_ClientIF_sendChat)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.cs, false, null);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_ClientIF_sendChat obj = (BRequest_ClientIF_sendChat)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ClientIF_sendChat()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.cs = (com.wilutions.byps.test.api.srvr.ChatStructure)bin.readObj(false, null);
		
		return obj;
	}
	
}