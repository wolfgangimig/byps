﻿package com.wilutions.byps.test.api.ver;

/*
 * Serializer for com.wilutions.byps.test.api.ver.BRequest_EvolveIF_setEvolve
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
public class BSerializer_246658450 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_246658450();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: obj */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_246658450() {
		super(246658450);
	}
	
	public BSerializer_246658450(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BRequest_EvolveIF_setEvolve obj = (BRequest_EvolveIF_setEvolve)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.obj, false, null);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_EvolveIF_setEvolve obj = (BRequest_EvolveIF_setEvolve)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_EvolveIF_setEvolve()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.obj = (com.wilutions.byps.test.api.ver.Evolve)bin.readObj(false, null);
		
		return obj;
	}
	
}