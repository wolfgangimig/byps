package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_sendAllTypes
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=10

@SuppressWarnings("all")
public class BSerializer_1794219594 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1794219594();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: b */ + 4		
		       /* pos=4: c */ + 2		
		       /* pos=6: s */ + 2		
		       /* pos=8: i */ + 4		
		       /* padding */ + 4		
		       /* pos=16: l */ + 8		
		       /* pos=24: f */ + 4		
		       /* padding */ + 4		
		       /* pos=32: d */ + 8		
		       /* pos=40: str */ + 4		
		       /* pos=44: pt */ + 4		
		       /* pos=48: o */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_1794219594() {
		super(1794219594);
	}
	
	public BSerializer_1794219594(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BRequest_RemotePrimitiveTypes_sendAllTypes obj = (BRequest_RemotePrimitiveTypes_sendAllTypes)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putBoolean(obj.b);
		bbuf.putChar(obj.c);
		bbuf.putDouble(obj.d);
		bbuf.putFloat(obj.f);
		bbuf.putInt(obj.i);
		bbuf.putLong(obj.l);
		bbuf.putShort(obj.s);
		bbuf.putString(obj.str);
		bout.writeObj(obj.o, false, null);
		bout.writeObj(obj.pt, false, null);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemotePrimitiveTypes_sendAllTypes obj = (BRequest_RemotePrimitiveTypes_sendAllTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_sendAllTypes()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.b = bbuf.getBoolean();
		obj.c = bbuf.getChar();
		obj.d = bbuf.getDouble();
		obj.f = bbuf.getFloat();
		obj.i = bbuf.getInt();
		obj.l = bbuf.getLong();
		obj.s = bbuf.getShort();
		obj.str = bbuf.getString();
		obj.o = (java.lang.Object)bin.readObj(false, null);
		obj.pt = (com.wilutions.byps.test.api.prim.PrimitiveTypes)bin.readObj(false, null);
		
		return obj;
	}
	
}
