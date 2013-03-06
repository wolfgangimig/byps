package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_setImage
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
public class BSerializer_1831578632 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1831578632();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: istrm */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_1831578632() {
		super(1831578632);
	}
	
	public BSerializer_1831578632(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BRequest_RemoteStreams_setImage obj = (BRequest_RemoteStreams_setImage)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bout.writeObj(obj.istrm, false, null);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemoteStreams_setImage obj = (BRequest_RemoteStreams_setImage)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteStreams_setImage()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.istrm = (java.io.InputStream)bin.readObj(false, null);
		
		return obj;
	}
	
}
