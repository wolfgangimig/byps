package com.wilutions.byps.test.api.prim;

/*
 * Serializer for com.wilutions.byps.test.api.prim.PrimitiveTypes
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=13

@SuppressWarnings("all")
public class BSerializer_1000 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1000();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: boolVal */ + 4		
		       /* pos=4: byteVal */ + 1		
		       /* padding */ + 1		
		       /* pos=6: charVal */ + 2		
		       /* pos=8: shortVal */ + 2		
		       /* padding */ + 2		
		       /* pos=12: intVal */ + 4		
		       /* pos=16: longVal */ + 8		
		       /* pos=24: floatVal */ + 4		
		       /* padding */ + 4		
		       /* pos=32: doubleVal */ + 8		
		       /* pos=40: stringVal */ + 4		
		       /* pos=44: objVal */ + 4		
		       /* pos=48: objVal2 */ + 4		
		       /* pos=52: value */ + 4		
		       /* pos=56: temp */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_1000() {
		super(1000);
	}
	
	public BSerializer_1000(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final PrimitiveTypes obj = (PrimitiveTypes)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putBoolean(obj.boolVal);
		bbuf.putByte(obj.byteVal);
		bbuf.putChar(obj.charVal);
		bbuf.putDouble(obj.doubleVal);
		bbuf.putFloat(obj.floatVal);
		bbuf.putInt(obj.intVal);
		bbuf.putLong(obj.longVal);
		bbuf.putShort(obj.shortVal);
		bbuf.putString(obj.stringVal);
		bbuf.putBoolean(obj.value);
		bout.writeObj(obj.objVal, false, null);
		bout.writeObj(obj.objVal2, false, null);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final PrimitiveTypes obj = (PrimitiveTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new PrimitiveTypes()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.boolVal = bbuf.getBoolean();
		obj.byteVal = bbuf.getByte();
		obj.charVal = bbuf.getChar();
		obj.doubleVal = bbuf.getDouble();
		obj.floatVal = bbuf.getFloat();
		obj.intVal = bbuf.getInt();
		obj.longVal = bbuf.getLong();
		obj.shortVal = bbuf.getShort();
		obj.stringVal = bbuf.getString();
		obj.value = bbuf.getBoolean();
		obj.objVal = (java.lang.Object)bin.readObj(false, null);
		obj.objVal2 = (java.lang.Object)bin.readObj(false, null);
		
		return obj;
	}
	
}
