package com.wilutions.byps.test.api.cons;

/*
 * Serializer for com.wilutions.byps.test.api.cons.HebrewC
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=4

@SuppressWarnings("all")
public class BSerializer_1039162054 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1039162054();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: aleph */ + 4		
		       /* pos=4: beth */ + 4		
		       /* pos=8: ALEPH */ + 4		
		       /* pos=12: BETH */ + 4		
		       /* padding up to multiple of alignment */ + 0;		
	}
	
	public BSerializer_1039162054() {
		super(1039162054);
	}
	
	public BSerializer_1039162054(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final HebrewC obj = (HebrewC)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final HebrewC obj = (HebrewC)(obj1 != null ? obj1 : bin.onObjectCreated(new HebrewC()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		
		return obj;
	}
	
}
