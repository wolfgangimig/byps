package com.wilutions.byps.test.api;

/*
 * Serializer for com.wilutions.byps.test.api.BResult_1973996106
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
public class BSerializer_839888536 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_839888536();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: result */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_839888536() {
		super(839888536);
	}
	
	public BSerializer_839888536(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BResult_1973996106 obj = (BResult_1973996106)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.result, false, com.wilutions.byps.test.api.BSerializer_1973996106.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BResult_1973996106 obj = (BResult_1973996106)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1973996106()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.result = (java.util.Map<java.lang.Short,java.lang.Long>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1973996106.instance);
		
		return obj;
	}
	
}
