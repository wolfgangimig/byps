package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.SecondException
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=1

@SuppressWarnings("all")
public class BSerializer_11001 extends BSerializer_20 {
	
	public final static BSerializer instance = new BSerializer_11001();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=8: msg */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_11001() {
		super(11001);
	}
	
	public BSerializer_11001(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final SecondException obj = (SecondException)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putString(obj.getMsg());
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final SecondException obj = (SecondException)(obj1 != null ? obj1 : bin.onObjectCreated(new SecondException()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.setMsg(bbuf.getString());
		
		return obj;
	}
	
}
