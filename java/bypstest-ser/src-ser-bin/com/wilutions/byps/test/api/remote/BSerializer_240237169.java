package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setActorArray1dim
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
public class BSerializer_240237169 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_240237169();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: actorArray */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_240237169() {
		super(240237169);
	}
	
	public BSerializer_240237169(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BRequest_RemoteInlineInstance_setActorArray1dim obj = (BRequest_RemoteInlineInstance_setActorArray1dim)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.actorArray, false, com.wilutions.byps.test.api.BSerializer_1784131613.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemoteInlineInstance_setActorArray1dim obj = (BRequest_RemoteInlineInstance_setActorArray1dim)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_setActorArray1dim()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.actorArray = (com.wilutions.byps.test.api.inl.Actor[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1784131613.instance);
		
		return obj;
	}
	
}
