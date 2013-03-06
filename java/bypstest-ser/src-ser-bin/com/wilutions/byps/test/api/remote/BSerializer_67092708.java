package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteException_throwException
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
public class BSerializer_67092708 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_67092708();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: what */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_67092708() {
		super(67092708);
	}
	
	public BSerializer_67092708(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BRequest_RemoteException_throwException obj = (BRequest_RemoteException_throwException)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putInt(obj.what);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemoteException_throwException obj = (BRequest_RemoteException_throwException)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteException_throwException()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.what = bbuf.getInt();
		
		return obj;
	}
	
}
