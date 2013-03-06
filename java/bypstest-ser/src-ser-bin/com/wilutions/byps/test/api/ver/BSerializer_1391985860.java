package com.wilutions.byps.test.api.ver;

/*
 * Serializer for com.wilutions.byps.test.api.ver.Evolve
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=66

@SuppressWarnings("all")
public class BSerializer_1391985860 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1391985860();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: bool1 */ + 4		
		       /* pos=4: byte1 */ + 1		
		       /* padding */ + 1		
		       /* pos=6: char1 */ + 2		
		       /* pos=8: short1 */ + 2		
		       /* padding */ + 2		
		       /* pos=12: int1 */ + 4		
		       /* pos=16: long1 */ + 8		
		       /* pos=24: float1 */ + 4		
		       /* padding */ + 4		
		       /* pos=32: double1 */ + 8		
		       /* pos=40: bools1 */ + 4		
		       /* pos=44: bytes1 */ + 4		
		       /* pos=48: chars1 */ + 4		
		       /* pos=52: shorts1 */ + 4		
		       /* pos=56: ints1 */ + 4		
		       /* pos=60: longs1 */ + 4		
		       /* pos=64: floats1 */ + 4		
		       /* pos=68: doubles1 */ + 4		
		       /* pos=72: str1 */ + 4		
		       /* pos=76: obj1 */ + 4		
		       /* pos=80: evo1 */ + 4		
		       /* pos=84: list1 */ + 4		
		       /* pos=88: set1 */ + 4		
		       /* pos=92: map1 */ + 4		
		       /* pos=96: bool2 */ + 4		
		       /* pos=100: byte2 */ + 1		
		       /* padding */ + 1		
		       /* pos=102: char2 */ + 2		
		       /* pos=104: short2 */ + 2		
		       /* padding */ + 2		
		       /* pos=108: int2 */ + 4		
		       /* pos=112: long2 */ + 8		
		       /* pos=120: float2 */ + 4		
		       /* padding */ + 4		
		       /* pos=128: double2 */ + 8		
		       /* pos=136: bools2 */ + 4		
		       /* pos=140: bytes2 */ + 4		
		       /* pos=144: chars2 */ + 4		
		       /* pos=148: shorts2 */ + 4		
		       /* pos=152: ints2 */ + 4		
		       /* pos=156: longs2 */ + 4		
		       /* pos=160: floats2 */ + 4		
		       /* pos=164: doubles2 */ + 4		
		       /* pos=168: str2 */ + 4		
		       /* pos=172: obj2 */ + 4		
		       /* pos=176: evo2 */ + 4		
		       /* pos=180: list2 */ + 4		
		       /* pos=184: set2 */ + 4		
		       /* pos=188: map2 */ + 4		
		       /* pos=192: bool3 */ + 4		
		       /* pos=196: byte3 */ + 1		
		       /* padding */ + 1		
		       /* pos=198: char3 */ + 2		
		       /* pos=200: short3 */ + 2		
		       /* padding */ + 2		
		       /* pos=204: int3 */ + 4		
		       /* pos=208: long3 */ + 8		
		       /* pos=216: float3 */ + 4		
		       /* padding */ + 4		
		       /* pos=224: double3 */ + 8		
		       /* pos=232: bools3 */ + 4		
		       /* pos=236: bytes3 */ + 4		
		       /* pos=240: chars3 */ + 4		
		       /* pos=244: shorts3 */ + 4		
		       /* pos=248: ints3 */ + 4		
		       /* pos=252: longs3 */ + 4		
		       /* pos=256: floats3 */ + 4		
		       /* pos=260: doubles3 */ + 4		
		       /* pos=264: str3 */ + 4		
		       /* pos=268: obj3 */ + 4		
		       /* pos=272: evo3 */ + 4		
		       /* pos=276: list3 */ + 4		
		       /* pos=280: set3 */ + 4		
		       /* pos=284: map3 */ + 4		
		       /* padding up to multiple of alignment */ + 0;		
	}
	
	public BSerializer_1391985860() {
		super(1391985860);
	}
	
	public BSerializer_1391985860(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final Evolve obj = (Evolve)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putBoolean(obj.bool1);
		bbuf.putByte(obj.byte1);
		bbuf.putChar(obj.char1);
		bbuf.putDouble(obj.double1);
		bbuf.putFloat(obj.float1);
		bbuf.putInt(obj.int1);
		bbuf.putLong(obj.long1);
		bbuf.putShort(obj.short1);
		bbuf.putString(obj.str1);
		if (version >= 2) {
			bbuf.putBoolean(obj.bool2);
			bbuf.putByte(obj.byte2);
			bbuf.putChar(obj.char2);
			bbuf.putDouble(obj.double2);
			bbuf.putFloat(obj.float2);
			bbuf.putInt(obj.int2);
			bbuf.putLong(obj.long2);
			bbuf.putShort(obj.short2);
			bbuf.putString(obj.str2);
			if (version >= 3) {
				bbuf.putBoolean(obj.bool3);
				bbuf.putByte(obj.byte3);
				bbuf.putChar(obj.char3);
				bbuf.putDouble(obj.double3);
				bbuf.putFloat(obj.float3);
				bbuf.putInt(obj.int3);
				bbuf.putLong(obj.long3);
				bbuf.putShort(obj.short3);
				bbuf.putString(obj.str3);
			}
		}
		bout.writeObj(obj.bools1, false, com.wilutions.byps.test.api.BSerializer_2058423690.instance);
		bout.writeObj(obj.bytes1, false, com.wilutions.byps.test.api.BSerializer_1374008726.instance);
		bout.writeObj(obj.chars1, false, com.wilutions.byps.test.api.BSerializer_1361632968.instance);
		bout.writeObj(obj.doubles1, false, com.wilutions.byps.test.api.BSerializer_1359468275.instance);
		bout.writeObj(obj.evo1, false, null);
		bout.writeObj(obj.floats1, false, com.wilutions.byps.test.api.BSerializer_766441794.instance);
		bout.writeObj(obj.ints1, false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
		bout.writeObj(obj.list1, false, com.wilutions.byps.test.api.BSerializer_181681714.instance);
		bout.writeObj(obj.longs1, false, com.wilutions.byps.test.api.BSerializer_1097129250.instance);
		bout.writeObj(obj.map1, false, com.wilutions.byps.test.api.BSerializer_1347703734.instance);
		bout.writeObj(obj.obj1, false, null);
		bout.writeObj(obj.set1, false, com.wilutions.byps.test.api.BSerializer_1493282670.instance);
		bout.writeObj(obj.shorts1, false, com.wilutions.byps.test.api.BSerializer_2067161310.instance);
		if (version >= 2) {
			bout.writeObj(obj.bools2, false, com.wilutions.byps.test.api.BSerializer_2058423690.instance);
			bout.writeObj(obj.bytes2, false, com.wilutions.byps.test.api.BSerializer_1374008726.instance);
			bout.writeObj(obj.chars2, false, com.wilutions.byps.test.api.BSerializer_1361632968.instance);
			bout.writeObj(obj.doubles2, false, com.wilutions.byps.test.api.BSerializer_1359468275.instance);
			bout.writeObj(obj.evo2, false, null);
			bout.writeObj(obj.floats2, false, com.wilutions.byps.test.api.BSerializer_766441794.instance);
			bout.writeObj(obj.ints2, false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
			bout.writeObj(obj.list2, false, com.wilutions.byps.test.api.BSerializer_181681714.instance);
			bout.writeObj(obj.longs2, false, com.wilutions.byps.test.api.BSerializer_1097129250.instance);
			bout.writeObj(obj.map2, false, com.wilutions.byps.test.api.BSerializer_1347703734.instance);
			bout.writeObj(obj.obj2, false, null);
			bout.writeObj(obj.set2, false, com.wilutions.byps.test.api.BSerializer_1493282670.instance);
			bout.writeObj(obj.shorts2, false, com.wilutions.byps.test.api.BSerializer_2067161310.instance);
			if (version >= 3) {
				bout.writeObj(obj.bools3, false, com.wilutions.byps.test.api.BSerializer_2058423690.instance);
				bout.writeObj(obj.bytes3, false, com.wilutions.byps.test.api.BSerializer_1374008726.instance);
				bout.writeObj(obj.chars3, false, com.wilutions.byps.test.api.BSerializer_1361632968.instance);
				bout.writeObj(obj.doubles3, false, com.wilutions.byps.test.api.BSerializer_1359468275.instance);
				bout.writeObj(obj.evo3, false, null);
				bout.writeObj(obj.floats3, false, com.wilutions.byps.test.api.BSerializer_766441794.instance);
				bout.writeObj(obj.ints3, false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
				bout.writeObj(obj.list3, false, com.wilutions.byps.test.api.BSerializer_181681714.instance);
				bout.writeObj(obj.longs3, false, com.wilutions.byps.test.api.BSerializer_1097129250.instance);
				bout.writeObj(obj.map3, false, com.wilutions.byps.test.api.BSerializer_1347703734.instance);
				bout.writeObj(obj.obj3, false, null);
				bout.writeObj(obj.set3, false, com.wilutions.byps.test.api.BSerializer_1493282670.instance);
				bout.writeObj(obj.shorts3, false, com.wilutions.byps.test.api.BSerializer_2067161310.instance);
			}
		}
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final Evolve obj = (Evolve)(obj1 != null ? obj1 : bin.onObjectCreated(new Evolve()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.bool1 = bbuf.getBoolean();
		obj.byte1 = bbuf.getByte();
		obj.char1 = bbuf.getChar();
		obj.double1 = bbuf.getDouble();
		obj.float1 = bbuf.getFloat();
		obj.int1 = bbuf.getInt();
		obj.long1 = bbuf.getLong();
		obj.short1 = bbuf.getShort();
		obj.str1 = bbuf.getString();
		if (version >= 2) {
			obj.bool2 = bbuf.getBoolean();
			obj.byte2 = bbuf.getByte();
			obj.char2 = bbuf.getChar();
			obj.double2 = bbuf.getDouble();
			obj.float2 = bbuf.getFloat();
			obj.int2 = bbuf.getInt();
			obj.long2 = bbuf.getLong();
			obj.short2 = bbuf.getShort();
			obj.str2 = bbuf.getString();
			if (version >= 3) {
				obj.bool3 = bbuf.getBoolean();
				obj.byte3 = bbuf.getByte();
				obj.char3 = bbuf.getChar();
				obj.double3 = bbuf.getDouble();
				obj.float3 = bbuf.getFloat();
				obj.int3 = bbuf.getInt();
				obj.long3 = bbuf.getLong();
				obj.short3 = bbuf.getShort();
				obj.str3 = bbuf.getString();
			}
		}
		obj.bools1 = (boolean[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_2058423690.instance);
		obj.bytes1 = (byte[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1374008726.instance);
		obj.chars1 = (char[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1361632968.instance);
		obj.doubles1 = (double[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1359468275.instance);
		obj.evo1 = (com.wilutions.byps.test.api.ver.Evolve2)bin.readObj(false, null);
		obj.floats1 = (float[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_766441794.instance);
		obj.ints1 = (int[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
		obj.list1 = (java.util.List<java.lang.Integer>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_181681714.instance);
		obj.longs1 = (long[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1097129250.instance);
		obj.map1 = (java.util.Map<java.lang.Integer,java.lang.Integer>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1347703734.instance);
		obj.obj1 = (java.lang.Object)bin.readObj(false, null);
		obj.set1 = (java.util.Set<java.lang.Integer>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1493282670.instance);
		obj.shorts1 = (short[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_2067161310.instance);
		if (version >= 2) {
			obj.bools2 = (boolean[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_2058423690.instance);
			obj.bytes2 = (byte[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1374008726.instance);
			obj.chars2 = (char[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1361632968.instance);
			obj.doubles2 = (double[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1359468275.instance);
			obj.evo2 = (com.wilutions.byps.test.api.ver.Evolve2)bin.readObj(false, null);
			obj.floats2 = (float[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_766441794.instance);
			obj.ints2 = (int[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
			obj.list2 = (java.util.List<java.lang.Integer>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_181681714.instance);
			obj.longs2 = (long[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1097129250.instance);
			obj.map2 = (java.util.Map<java.lang.Integer,java.lang.Integer>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1347703734.instance);
			obj.obj2 = (java.lang.Object)bin.readObj(false, null);
			obj.set2 = (java.util.Set<java.lang.Integer>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1493282670.instance);
			obj.shorts2 = (short[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_2067161310.instance);
			if (version >= 3) {
				obj.bools3 = (boolean[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_2058423690.instance);
				obj.bytes3 = (byte[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1374008726.instance);
				obj.chars3 = (char[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1361632968.instance);
				obj.doubles3 = (double[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1359468275.instance);
				obj.evo3 = (com.wilutions.byps.test.api.ver.Evolve2)bin.readObj(false, null);
				obj.floats3 = (float[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_766441794.instance);
				obj.ints3 = (int[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
				obj.list3 = (java.util.List<java.lang.Integer>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_181681714.instance);
				obj.longs3 = (long[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1097129250.instance);
				obj.map3 = (java.util.Map<java.lang.Integer,java.lang.Integer>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1347703734.instance);
				obj.obj3 = (java.lang.Object)bin.readObj(false, null);
				obj.set3 = (java.util.Set<java.lang.Integer>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1493282670.instance);
				obj.shorts3 = (short[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_2067161310.instance);
			}
		}
		
		return obj;
	}
	
}
