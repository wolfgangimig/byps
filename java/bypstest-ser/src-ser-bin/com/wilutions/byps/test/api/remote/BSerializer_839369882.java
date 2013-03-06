package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteEnums_getPlanet
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
public class BSerializer_839369882 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_839369882();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: result */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_839369882() {
		super(839369882);
	}
	
	public BSerializer_839369882(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BResult_RemoteEnums_getPlanet obj = (BResult_RemoteEnums_getPlanet)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putInt(obj.result!=null ? obj.result.ordinal() : 0);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BResult_RemoteEnums_getPlanet obj = (BResult_RemoteEnums_getPlanet)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteEnums_getPlanet()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.result = BEnumHelper.fromOrdinal(com.wilutions.byps.test.api.enu.EnumPlanets.values(), bbuf.getInt());
		
		return obj;
	}
	
}
