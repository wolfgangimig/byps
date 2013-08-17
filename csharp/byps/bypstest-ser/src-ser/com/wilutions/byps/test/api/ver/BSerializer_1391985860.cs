//
// Serializer for com.wilutions.byps.test.api.ver.Evolve
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.ver
{
	
	public class BSerializer_1391985860 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1391985860();
		
		public BSerializer_1391985860()
			: base(1391985860) {}
		
		public BSerializer_1391985860(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
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
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			Evolve obj = (Evolve)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putBoolean(obj.Bool1);
			bbuf.putByte(obj.Byte1);
			bbuf.putChar(obj.Char1);
			bbuf.putDouble(obj.Double1);
			bbuf.putFloat(obj.Float1);
			bbuf.putInt(obj.Int1);
			bbuf.putLong(obj.Long1);
			bbuf.putShort(obj.Short1);
			bbuf.putString(obj.Str1);
			if (version >= 2) {
				bbuf.putBoolean(obj.Bool2);
				bbuf.putByte(obj.Byte2);
				bbuf.putChar(obj.Char2);
				bbuf.putDouble(obj.Double2);
				bbuf.putFloat(obj.Float2);
				bbuf.putInt(obj.Int2);
				bbuf.putLong(obj.Long2);
				bbuf.putShort(obj.Short2);
				bbuf.putString(obj.Str2);
				if (version >= 3) {
					bbuf.putBoolean(obj.Bool3);
					bbuf.putByte(obj.Byte3);
					bbuf.putChar(obj.Char3);
					bbuf.putDouble(obj.Double3);
					bbuf.putFloat(obj.Float3);
					bbuf.putInt(obj.Int3);
					bbuf.putLong(obj.Long3);
					bbuf.putShort(obj.Short3);
					bbuf.putString(obj.Str3);
				}
			}
			bout.writeObj(obj.Bools1, false, com.wilutions.byps.test.api.BSerializer_2058423690.instance);
			bout.writeObj(obj.Bytes1, false, com.wilutions.byps.test.api.BSerializer_1374008726.instance);
			bout.writeObj(obj.Chars1, false, com.wilutions.byps.test.api.BSerializer_1361632968.instance);
			bout.writeObj(obj.Doubles1, false, com.wilutions.byps.test.api.BSerializer_1359468275.instance);
			bout.writeObj(obj.Evo1, false, null);
			bout.writeObj(obj.Floats1, false, com.wilutions.byps.test.api.BSerializer_766441794.instance);
			bout.writeObj(obj.Ints1, false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
			bout.writeObj(obj.List1, false, com.wilutions.byps.test.api.BSerializer_181681714.instance);
			bout.writeObj(obj.Longs1, false, com.wilutions.byps.test.api.BSerializer_1097129250.instance);
			bout.writeObj(obj.Map1, false, com.wilutions.byps.test.api.BSerializer_1347703734.instance);
			bout.writeObj(obj.Obj1, false, null);
			bout.writeObj(obj.Set1, false, com.wilutions.byps.test.api.BSerializer_1493282670.instance);
			bout.writeObj(obj.Shorts1, false, com.wilutions.byps.test.api.BSerializer_2067161310.instance);
			if (version >= 2) {
				bout.writeObj(obj.Bools2, false, com.wilutions.byps.test.api.BSerializer_2058423690.instance);
				bout.writeObj(obj.Bytes2, false, com.wilutions.byps.test.api.BSerializer_1374008726.instance);
				bout.writeObj(obj.Chars2, false, com.wilutions.byps.test.api.BSerializer_1361632968.instance);
				bout.writeObj(obj.Doubles2, false, com.wilutions.byps.test.api.BSerializer_1359468275.instance);
				bout.writeObj(obj.Evo2, false, null);
				bout.writeObj(obj.Floats2, false, com.wilutions.byps.test.api.BSerializer_766441794.instance);
				bout.writeObj(obj.Ints2, false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
				bout.writeObj(obj.List2, false, com.wilutions.byps.test.api.BSerializer_181681714.instance);
				bout.writeObj(obj.Longs2, false, com.wilutions.byps.test.api.BSerializer_1097129250.instance);
				bout.writeObj(obj.Map2, false, com.wilutions.byps.test.api.BSerializer_1347703734.instance);
				bout.writeObj(obj.Obj2, false, null);
				bout.writeObj(obj.Set2, false, com.wilutions.byps.test.api.BSerializer_1493282670.instance);
				bout.writeObj(obj.Shorts2, false, com.wilutions.byps.test.api.BSerializer_2067161310.instance);
				if (version >= 3) {
					bout.writeObj(obj.Bools3, false, com.wilutions.byps.test.api.BSerializer_2058423690.instance);
					bout.writeObj(obj.Bytes3, false, com.wilutions.byps.test.api.BSerializer_1374008726.instance);
					bout.writeObj(obj.Chars3, false, com.wilutions.byps.test.api.BSerializer_1361632968.instance);
					bout.writeObj(obj.Doubles3, false, com.wilutions.byps.test.api.BSerializer_1359468275.instance);
					bout.writeObj(obj.Evo3, false, null);
					bout.writeObj(obj.Floats3, false, com.wilutions.byps.test.api.BSerializer_766441794.instance);
					bout.writeObj(obj.Ints3, false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
					bout.writeObj(obj.List3, false, com.wilutions.byps.test.api.BSerializer_181681714.instance);
					bout.writeObj(obj.Longs3, false, com.wilutions.byps.test.api.BSerializer_1097129250.instance);
					bout.writeObj(obj.Map3, false, com.wilutions.byps.test.api.BSerializer_1347703734.instance);
					bout.writeObj(obj.Obj3, false, null);
					bout.writeObj(obj.Set3, false, com.wilutions.byps.test.api.BSerializer_1493282670.instance);
					bout.writeObj(obj.Shorts3, false, com.wilutions.byps.test.api.BSerializer_2067161310.instance);
				}
			}
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			Evolve obj = (Evolve)(obj1 != null ? obj1 : bin.onObjectCreated(new Evolve()));
			
			BBufferBin bbuf = bin.bbuf;
			obj.Bool1 = bbuf.getBoolean();
			obj.Byte1 = bbuf.getByte();
			obj.Char1 = bbuf.getChar();
			obj.Double1 = bbuf.getDouble();
			obj.Float1 = bbuf.getFloat();
			obj.Int1 = bbuf.getInt();
			obj.Long1 = bbuf.getLong();
			obj.Short1 = bbuf.getShort();
			obj.Str1 = bbuf.getString();
			if (version >= 2) {
				obj.Bool2 = bbuf.getBoolean();
				obj.Byte2 = bbuf.getByte();
				obj.Char2 = bbuf.getChar();
				obj.Double2 = bbuf.getDouble();
				obj.Float2 = bbuf.getFloat();
				obj.Int2 = bbuf.getInt();
				obj.Long2 = bbuf.getLong();
				obj.Short2 = bbuf.getShort();
				obj.Str2 = bbuf.getString();
				if (version >= 3) {
					obj.Bool3 = bbuf.getBoolean();
					obj.Byte3 = bbuf.getByte();
					obj.Char3 = bbuf.getChar();
					obj.Double3 = bbuf.getDouble();
					obj.Float3 = bbuf.getFloat();
					obj.Int3 = bbuf.getInt();
					obj.Long3 = bbuf.getLong();
					obj.Short3 = bbuf.getShort();
					obj.Str3 = bbuf.getString();
				}
			}
			obj.Bools1 = (bool[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_2058423690.instance);
			obj.Bytes1 = (byte[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1374008726.instance);
			obj.Chars1 = (char[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1361632968.instance);
			obj.Doubles1 = (double[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1359468275.instance);
			obj.Evo1 = (com.wilutions.byps.test.api.ver.Evolve2)bin.readObj(false, null);
			obj.Floats1 = (float[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_766441794.instance);
			obj.Ints1 = (int[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
			obj.List1 = (IList<int>)bin.readObj(false, null);
			obj.Longs1 = (long[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1097129250.instance);
			obj.Map1 = (IDictionary<int,int>)bin.readObj(false, null);
			obj.Obj1 = (Object)bin.readObj(false, null);
			obj.Set1 = (ISet<int>)bin.readObj(false, null);
			obj.Shorts1 = (short[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_2067161310.instance);
			if (version >= 2) {
				obj.Bools2 = (bool[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_2058423690.instance);
				obj.Bytes2 = (byte[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1374008726.instance);
				obj.Chars2 = (char[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1361632968.instance);
				obj.Doubles2 = (double[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1359468275.instance);
				obj.Evo2 = (com.wilutions.byps.test.api.ver.Evolve2)bin.readObj(false, null);
				obj.Floats2 = (float[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_766441794.instance);
				obj.Ints2 = (int[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
				obj.List2 = (IList<int>)bin.readObj(false, null);
				obj.Longs2 = (long[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1097129250.instance);
				obj.Map2 = (IDictionary<int,int>)bin.readObj(false, null);
				obj.Obj2 = (Object)bin.readObj(false, null);
				obj.Set2 = (ISet<int>)bin.readObj(false, null);
				obj.Shorts2 = (short[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_2067161310.instance);
				if (version >= 3) {
					obj.Bools3 = (bool[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_2058423690.instance);
					obj.Bytes3 = (byte[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1374008726.instance);
					obj.Chars3 = (char[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1361632968.instance);
					obj.Doubles3 = (double[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1359468275.instance);
					obj.Evo3 = (com.wilutions.byps.test.api.ver.Evolve2)bin.readObj(false, null);
					obj.Floats3 = (float[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_766441794.instance);
					obj.Ints3 = (int[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
					obj.List3 = (IList<int>)bin.readObj(false, null);
					obj.Longs3 = (long[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1097129250.instance);
					obj.Map3 = (IDictionary<int,int>)bin.readObj(false, null);
					obj.Obj3 = (Object)bin.readObj(false, null);
					obj.Set3 = (ISet<int>)bin.readObj(false, null);
					obj.Shorts3 = (short[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_2067161310.instance);
				}
			}
			
			return obj;
		}
		
	}
} // namespace
