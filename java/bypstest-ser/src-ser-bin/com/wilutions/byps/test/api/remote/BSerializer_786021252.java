package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getShort1
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
public class BSerializer_786021252 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_786021252();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: result */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_786021252() {
		super(786021252);
	}
	
	public BSerializer_786021252(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BResult_RemoteMapTypes_getShort1 obj = (BResult_RemoteMapTypes_getShort1)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.result, false, com.wilutions.byps.test.api.BSerializer_601099730.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BResult_RemoteMapTypes_getShort1 obj = (BResult_RemoteMapTypes_getShort1)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteMapTypes_getShort1()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.result = (java.util.Map<java.lang.Long,java.lang.Short>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_601099730.instance);
		
		return obj;
	}
	
}
