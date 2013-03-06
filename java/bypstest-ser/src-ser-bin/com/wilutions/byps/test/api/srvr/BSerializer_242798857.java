package com.wilutions.byps.test.api.srvr;

/*
 * Serializer for com.wilutions.byps.test.api.srvr.BRequest_ClientIF_putStreams
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
public class BSerializer_242798857 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_242798857();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: strm */ + 4		
		       /* pos=4: ctrl */ + 4		
		       /* padding up to multiple of alignment */ + 0;		
	}
	
	public BSerializer_242798857() {
		super(242798857);
	}
	
	public BSerializer_242798857(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BRequest_ClientIF_putStreams obj = (BRequest_ClientIF_putStreams)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putInt(obj.ctrl);
		bout.writeObj(obj.strm, false, com.wilutions.byps.test.api.BSerializer_1218831438.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_ClientIF_putStreams obj = (BRequest_ClientIF_putStreams)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ClientIF_putStreams()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.ctrl = bbuf.getInt();
		obj.strm = (java.util.List<java.io.InputStream>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1218831438.instance);
		
		return obj;
	}
	
}
