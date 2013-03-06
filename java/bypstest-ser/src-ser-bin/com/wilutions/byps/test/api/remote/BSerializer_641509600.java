package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteException_throwBException
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=2

@SuppressWarnings("all")
public class BSerializer_641509600 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_641509600();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: code */ + 4		
		       /* pos=4: msg */ + 4		
		       /* padding up to multiple of alignment */ + 0;		
	}
	
	public BSerializer_641509600() {
		super(641509600);
	}
	
	public BSerializer_641509600(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BRequest_RemoteException_throwBException obj = (BRequest_RemoteException_throwBException)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putInt(obj.code);
		bbuf.putString(obj.msg);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemoteException_throwBException obj = (BRequest_RemoteException_throwBException)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteException_throwBException()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.code = bbuf.getInt();
		obj.msg = bbuf.getString();
		
		return obj;
	}
	
}
