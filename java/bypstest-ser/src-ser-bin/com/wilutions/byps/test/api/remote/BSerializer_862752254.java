package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteConstants_compare_AllTypesC
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=17

@SuppressWarnings("all")
public class BSerializer_862752254 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_862752254();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: bool1s */ + 4		
		       /* pos=4: bool2s */ + 4		
		       /* pos=8: char1s */ + 2		
		       /* padding */ + 2		
		       /* pos=12: stringNull */ + 4		
		       /* pos=16: char2s */ + 2		
		       /* pos=18: short1s */ + 2		
		       /* pos=20: int1s */ + 4		
		       /* pos=24: long1s */ + 8		
		       /* pos=32: float1s */ + 4		
		       /* padding */ + 4		
		       /* pos=40: double1s */ + 8		
		       /* pos=48: string1s */ + 4		
		       /* pos=52: ALL */ + 4		
		       /* pos=56: arrInt */ + 4		
		       /* pos=60: arrInt4 */ + 4		
		       /* pos=64: arrStrings */ + 4		
		       /* pos=68: arrStrings4 */ + 4		
		       /* pos=72: arrAll */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_862752254() {
		super(862752254);
	}
	
	public BSerializer_862752254(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final BRequest_RemoteConstants_compare_AllTypesC obj = (BRequest_RemoteConstants_compare_AllTypesC)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putBoolean(obj.bool1s);
		bbuf.putBoolean(obj.bool2s);
		bbuf.putChar(obj.char1s);
		bbuf.putChar(obj.char2s);
		bbuf.putDouble(obj.double1s);
		bbuf.putFloat(obj.float1s);
		bbuf.putInt(obj.int1s);
		bbuf.putLong(obj.long1s);
		bbuf.putShort(obj.short1s);
		bbuf.putString(obj.string1s);
		bbuf.putString(obj.stringNull);
		bout.writeObj(obj.ALL, false, null);
		bout.writeObj(obj.arrAll, false, com.wilutions.byps.test.api.BSerializer_1981543076.instance);
		bout.writeObj(obj.arrInt, false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
		bout.writeObj(obj.arrInt4, false, com.wilutions.byps.test.api.BSerializer_39910537.instance);
		bout.writeObj(obj.arrStrings, true, com.wilutions.byps.test.api.BSerializer_1888107655.instance);
		bout.writeObj(obj.arrStrings4, true, com.wilutions.byps.test.api.BSerializer_588723219.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemoteConstants_compare_AllTypesC obj = (BRequest_RemoteConstants_compare_AllTypesC)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteConstants_compare_AllTypesC()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.bool1s = bbuf.getBoolean();
		obj.bool2s = bbuf.getBoolean();
		obj.char1s = bbuf.getChar();
		obj.char2s = bbuf.getChar();
		obj.double1s = bbuf.getDouble();
		obj.float1s = bbuf.getFloat();
		obj.int1s = bbuf.getInt();
		obj.long1s = bbuf.getLong();
		obj.short1s = bbuf.getShort();
		obj.string1s = bbuf.getString();
		obj.stringNull = bbuf.getString();
		obj.ALL = (com.wilutions.byps.test.api.cons.AllTypesZ)bin.readObj(false, null);
		obj.arrAll = (com.wilutions.byps.test.api.cons.AllTypesZ[][])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1981543076.instance);
		obj.arrInt = (int[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
		obj.arrInt4 = (int[][][][])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_39910537.instance);
		obj.arrStrings = (java.lang.String[])bin.readObj(true, com.wilutions.byps.test.api.BSerializer_1888107655.instance);
		obj.arrStrings4 = (java.lang.String[][][][])bin.readObj(true, com.wilutions.byps.test.api.BSerializer_588723219.instance);
		
		return obj;
	}
	
}
