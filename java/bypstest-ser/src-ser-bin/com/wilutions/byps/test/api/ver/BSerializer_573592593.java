package com.wilutions.byps.test.api.ver;

/*
 * Serializer for com.wilutions.byps.test.api.ver.Evolve2
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=1

@SuppressWarnings("all")
public class BSerializer_573592593 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_573592593();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: n1 */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_573592593() {
		super(573592593);
	}
	
	public BSerializer_573592593(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final Evolve2 obj = (Evolve2)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putInt(obj.n1);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final Evolve2 obj = (Evolve2)(obj1 != null ? obj1 : bin.onObjectCreated(new Evolve2()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.n1 = bbuf.getInt();
		
		return obj;
	}
	
}
