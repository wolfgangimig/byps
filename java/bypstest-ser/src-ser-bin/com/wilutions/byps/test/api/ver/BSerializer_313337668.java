﻿package com.wilutions.byps.test.api.ver;

/*
 * Serializer for com.wilutions.byps.test.api.ver.BRequest_EvolveIF_setClient
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
public class BSerializer_313337668 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_313337668();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: partner */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_313337668() {
		super(313337668);
	}
	
	public BSerializer_313337668(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BRequest_EvolveIF_setClient obj = (BRequest_EvolveIF_setClient)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.partner, false, null);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_EvolveIF_setClient obj = (BRequest_EvolveIF_setClient)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_EvolveIF_setClient()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.partner = (com.wilutions.byps.test.api.ver.EvolveIF)bin.readObj(false, null);
		
		return obj;
	}
	
}