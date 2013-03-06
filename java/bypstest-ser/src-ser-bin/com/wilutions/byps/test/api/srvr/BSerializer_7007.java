package com.wilutions.byps.test.api.srvr;

/*
 * Serializer for com.wilutions.byps.test.api.srvr.ChatStructure
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=3

@SuppressWarnings("all")
public class BSerializer_7007 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_7007();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: msg */ + 4		
		       /* padding */ + 4		
		       /* pos=8: sentAt */ + 8		
		       /* pos=16: receivedAt */ + 8		
		       /* padding up to multiple of alignment */ + 0;		
	}
	
	public BSerializer_7007() {
		super(7007);
	}
	
	public BSerializer_7007(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final ChatStructure obj = (ChatStructure)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putString(obj.msg);
		bbuf.putDouble(obj.receivedAt);
		bbuf.putDouble(obj.sentAt);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final ChatStructure obj = (ChatStructure)(obj1 != null ? obj1 : bin.onObjectCreated(new ChatStructure()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.msg = bbuf.getString();
		obj.receivedAt = bbuf.getDouble();
		obj.sentAt = bbuf.getDouble();
		
		return obj;
	}
	
}
