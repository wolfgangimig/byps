package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setObj1
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
public class BSerializer_1047136253 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1047136253();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: obj1 */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_1047136253() {
		super(1047136253);
	}
	
	public BSerializer_1047136253(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BRequest_RemoteMapTypes_setObj1 obj = (BRequest_RemoteMapTypes_setObj1)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.obj1, false, com.wilutions.byps.test.api.BSerializer_1488550492.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemoteMapTypes_setObj1 obj = (BRequest_RemoteMapTypes_setObj1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_setObj1()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.obj1 = (java.util.Map<java.lang.String,java.lang.Object>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1488550492.instance);
		
		return obj;
	}
	
}
