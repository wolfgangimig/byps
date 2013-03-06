package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_getActorListList
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
public class BSerializer_922798383 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_922798383();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: result */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_922798383() {
		super(922798383);
	}
	
	public BSerializer_922798383(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BResult_RemoteInlineInstance_getActorListList obj = (BResult_RemoteInlineInstance_getActorListList)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.result, false, com.wilutions.byps.test.api.BSerializer_1398598597.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BResult_RemoteInlineInstance_getActorListList obj = (BResult_RemoteInlineInstance_getActorListList)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteInlineInstance_getActorListList()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.result = (java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Actor>>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1398598597.instance);
		
		return obj;
	}
	
}
