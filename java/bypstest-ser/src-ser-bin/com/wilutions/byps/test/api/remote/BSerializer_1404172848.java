﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteReferences_setNode
 * 
 * THIS FILE HAS BEEN GENERATED BY class com.wilutions.byps.gen.j.GenSerStruct DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=1

@SuppressWarnings("all")
public class BSerializer_1404172848 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1404172848();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: v */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_1404172848() {
		super(1404172848);
	}
	
	public BSerializer_1404172848(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final long version) throws BException {
		final BRequest_RemoteReferences_setNode obj = (BRequest_RemoteReferences_setNode)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.v, false, null);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemoteReferences_setNode obj = (BRequest_RemoteReferences_setNode)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteReferences_setNode()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.v = (com.wilutions.byps.test.api.refs.Node)bin.readObj(false, null);
		
		return obj;
	}
	
}
