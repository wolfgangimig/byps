package com.wilutions.byps.test.api.srvr;

/*
 * Serializer for com.wilutions.byps.test.api.srvr.BResult_ClientIF_incrementInt
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
public class BSerializer_1720916535 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1720916535();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: result */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_1720916535() {
		super(1720916535);
	}
	
	public BSerializer_1720916535(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BResult_ClientIF_incrementInt obj = (BResult_ClientIF_incrementInt)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putInt(obj.result);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BResult_ClientIF_incrementInt obj = (BResult_ClientIF_incrementInt)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_ClientIF_incrementInt()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.result = bbuf.getInt();
		
		return obj;
	}
	
}
