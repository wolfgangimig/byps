package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getByte
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
public class BSerializer_1271030996 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1271030996();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: result */ + 1		
		       /* padding up to multiple of alignment */ + 7;		
	}
	
	public BSerializer_1271030996() {
		super(1271030996);
	}
	
	public BSerializer_1271030996(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BResult_RemotePrimitiveTypes_getByte obj = (BResult_RemotePrimitiveTypes_getByte)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putByte(obj.result);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BResult_RemotePrimitiveTypes_getByte obj = (BResult_RemotePrimitiveTypes_getByte)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemotePrimitiveTypes_getByte()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.result = bbuf.getByte();
		
		return obj;
	}
	
}
