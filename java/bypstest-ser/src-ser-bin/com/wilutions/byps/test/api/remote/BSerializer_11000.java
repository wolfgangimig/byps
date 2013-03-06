package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.FirstException
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=2

@SuppressWarnings("all")
public class BSerializer_11000 extends BSerializer_20 {
	
	public final static BSerializer instance = new BSerializer_11000();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=8: listOfStrings */ + 4		
		       /* pos=12: cause */ + 4		
		       /* padding up to multiple of alignment */ + 0;		
	}
	
	public BSerializer_11000() {
		super(11000);
	}
	
	public BSerializer_11000(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final FirstException obj = (FirstException)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.getCause(), false, null);
		bout.writeObj(obj.listOfStrings, false, com.wilutions.byps.test.api.BSerializer_2123584667.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final FirstException obj = (FirstException)(obj1 != null ? obj1 : bin.onObjectCreated(new FirstException()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.setCause((java.lang.Throwable)bin.readObj(false, null));
		obj.listOfStrings = (java.util.List<java.lang.String>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_2123584667.instance);
		
		return obj;
	}
	
}
