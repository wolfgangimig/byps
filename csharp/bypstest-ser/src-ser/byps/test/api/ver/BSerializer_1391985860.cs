//
// Serializer for byps.test.api.ver.Evolve
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.ver
{
	
	public class BSerializer_1391985860 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1391985860();
		
		public BSerializer_1391985860()
			: base(1391985860) {}
		
		public BSerializer_1391985860(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			Evolve obj = (Evolve)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putBoolean(obj.Bool1);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putByte(obj.Byte1);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putChar(obj.Char1);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putDouble(obj.Double1);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putFloat(obj.Float1);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putInt(obj.Int1);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putLong(obj.Long1);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putShort(obj.Short1);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putString(obj.Str1);
			if (version >= 2L) {
				// checkpoint byps.gen.cs.PrintContext:494
				bbuf.putBoolean(obj.Bool2);
				// checkpoint byps.gen.cs.PrintContext:494
				bbuf.putByte(obj.Byte2);
				// checkpoint byps.gen.cs.PrintContext:494
				bbuf.putChar(obj.Char2);
				// checkpoint byps.gen.cs.PrintContext:494
				bbuf.putDouble(obj.Double2);
				// checkpoint byps.gen.cs.PrintContext:494
				bbuf.putFloat(obj.Float2);
				// checkpoint byps.gen.cs.PrintContext:494
				bbuf.putInt(obj.Int2);
				// checkpoint byps.gen.cs.PrintContext:494
				bbuf.putLong(obj.Long2);
				// checkpoint byps.gen.cs.PrintContext:494
				bbuf.putShort(obj.Short2);
				// checkpoint byps.gen.cs.PrintContext:494
				bbuf.putString(obj.Str2);
				if (version >= 3L) {
					// checkpoint byps.gen.cs.PrintContext:494
					bbuf.putBoolean(obj.Bool3);
					// checkpoint byps.gen.cs.PrintContext:494
					bbuf.putByte(obj.Byte3);
					// checkpoint byps.gen.cs.PrintContext:494
					bbuf.putChar(obj.Char3);
					// checkpoint byps.gen.cs.PrintContext:494
					bbuf.putDouble(obj.Double3);
					// checkpoint byps.gen.cs.PrintContext:494
					bbuf.putFloat(obj.Float3);
					// checkpoint byps.gen.cs.PrintContext:494
					bbuf.putInt(obj.Int3);
					// checkpoint byps.gen.cs.PrintContext:494
					bbuf.putLong(obj.Long3);
					// checkpoint byps.gen.cs.PrintContext:494
					bbuf.putShort(obj.Short3);
					// checkpoint byps.gen.cs.PrintContext:494
					bbuf.putString(obj.Str3);
				}
			}
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.Bools1, false, byps.test.api.BSerializer_2058423690.instance);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.Bytes1, false, byps.test.api.BSerializer_1374008726.instance);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.Chars1, false, byps.test.api.BSerializer_1361632968.instance);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.Doubles1, false, byps.test.api.BSerializer_1359468275.instance);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.Evo1, false, null);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.Floats1, false, byps.test.api.BSerializer_766441794.instance);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.Ints1, false, byps.test.api.BSerializer_100361105.instance);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.List1, false, byps.test.api.BSerializer_181681714.instance);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.Longs1, false, byps.test.api.BSerializer_1097129250.instance);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.Map1, false, byps.test.api.BSerializer_1347703734.instance);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.Obj1, false, null);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.Set1, false, byps.test.api.BSerializer_1493282670.instance);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.Shorts1, false, byps.test.api.BSerializer_2067161310.instance);
			if (version >= 2L) {
				// checkpoint byps.gen.cs.PrintContext:494
				bout.writeObj(obj.Bools2, false, byps.test.api.BSerializer_2058423690.instance);
				// checkpoint byps.gen.cs.PrintContext:494
				bout.writeObj(obj.Bytes2, false, byps.test.api.BSerializer_1374008726.instance);
				// checkpoint byps.gen.cs.PrintContext:494
				bout.writeObj(obj.Chars2, false, byps.test.api.BSerializer_1361632968.instance);
				// checkpoint byps.gen.cs.PrintContext:494
				bout.writeObj(obj.Doubles2, false, byps.test.api.BSerializer_1359468275.instance);
				// checkpoint byps.gen.cs.PrintContext:494
				bout.writeObj(obj.Evo2, false, null);
				// checkpoint byps.gen.cs.PrintContext:494
				bout.writeObj(obj.Floats2, false, byps.test.api.BSerializer_766441794.instance);
				// checkpoint byps.gen.cs.PrintContext:494
				bout.writeObj(obj.Ints2, false, byps.test.api.BSerializer_100361105.instance);
				// checkpoint byps.gen.cs.PrintContext:494
				bout.writeObj(obj.List2, false, byps.test.api.BSerializer_181681714.instance);
				// checkpoint byps.gen.cs.PrintContext:494
				bout.writeObj(obj.Longs2, false, byps.test.api.BSerializer_1097129250.instance);
				// checkpoint byps.gen.cs.PrintContext:494
				bout.writeObj(obj.Map2, false, byps.test.api.BSerializer_1347703734.instance);
				// checkpoint byps.gen.cs.PrintContext:494
				bout.writeObj(obj.Obj2, false, null);
				// checkpoint byps.gen.cs.PrintContext:494
				bout.writeObj(obj.Set2, false, byps.test.api.BSerializer_1493282670.instance);
				// checkpoint byps.gen.cs.PrintContext:494
				bout.writeObj(obj.Shorts2, false, byps.test.api.BSerializer_2067161310.instance);
				if (version >= 3L) {
					// checkpoint byps.gen.cs.PrintContext:494
					bout.writeObj(obj.Bools3, false, byps.test.api.BSerializer_2058423690.instance);
					// checkpoint byps.gen.cs.PrintContext:494
					bout.writeObj(obj.Bytes3, false, byps.test.api.BSerializer_1374008726.instance);
					// checkpoint byps.gen.cs.PrintContext:494
					bout.writeObj(obj.Chars3, false, byps.test.api.BSerializer_1361632968.instance);
					// checkpoint byps.gen.cs.PrintContext:494
					bout.writeObj(obj.Doubles3, false, byps.test.api.BSerializer_1359468275.instance);
					// checkpoint byps.gen.cs.PrintContext:494
					bout.writeObj(obj.Evo3, false, null);
					// checkpoint byps.gen.cs.PrintContext:494
					bout.writeObj(obj.Floats3, false, byps.test.api.BSerializer_766441794.instance);
					// checkpoint byps.gen.cs.PrintContext:494
					bout.writeObj(obj.Ints3, false, byps.test.api.BSerializer_100361105.instance);
					// checkpoint byps.gen.cs.PrintContext:494
					bout.writeObj(obj.List3, false, byps.test.api.BSerializer_181681714.instance);
					// checkpoint byps.gen.cs.PrintContext:494
					bout.writeObj(obj.Longs3, false, byps.test.api.BSerializer_1097129250.instance);
					// checkpoint byps.gen.cs.PrintContext:494
					bout.writeObj(obj.Map3, false, byps.test.api.BSerializer_1347703734.instance);
					// checkpoint byps.gen.cs.PrintContext:494
					bout.writeObj(obj.Obj3, false, null);
					// checkpoint byps.gen.cs.PrintContext:494
					bout.writeObj(obj.Set3, false, byps.test.api.BSerializer_1493282670.instance);
					// checkpoint byps.gen.cs.PrintContext:494
					bout.writeObj(obj.Shorts3, false, byps.test.api.BSerializer_2067161310.instance);
				}
			}
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			Evolve obj = (Evolve)(obj1 != null ? obj1 : bin.onObjectCreated(new Evolve()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Bool1 = bbuf.getBoolean();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Byte1 = bbuf.getByte();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Char1 = bbuf.getChar();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Double1 = bbuf.getDouble();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Float1 = bbuf.getFloat();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Int1 = bbuf.getInt();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Long1 = bbuf.getLong();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Short1 = bbuf.getShort();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Str1 = bbuf.getString();
			if (version >= 2L) {
				// checkpoint byps.gen.cs.PrintContext:449
				obj.Bool2 = bbuf.getBoolean();
				// checkpoint byps.gen.cs.PrintContext:449
				obj.Byte2 = bbuf.getByte();
				// checkpoint byps.gen.cs.PrintContext:449
				obj.Char2 = bbuf.getChar();
				// checkpoint byps.gen.cs.PrintContext:449
				obj.Double2 = bbuf.getDouble();
				// checkpoint byps.gen.cs.PrintContext:449
				obj.Float2 = bbuf.getFloat();
				// checkpoint byps.gen.cs.PrintContext:449
				obj.Int2 = bbuf.getInt();
				// checkpoint byps.gen.cs.PrintContext:449
				obj.Long2 = bbuf.getLong();
				// checkpoint byps.gen.cs.PrintContext:449
				obj.Short2 = bbuf.getShort();
				// checkpoint byps.gen.cs.PrintContext:449
				obj.Str2 = bbuf.getString();
				if (version >= 3L) {
					// checkpoint byps.gen.cs.PrintContext:449
					obj.Bool3 = bbuf.getBoolean();
					// checkpoint byps.gen.cs.PrintContext:449
					obj.Byte3 = bbuf.getByte();
					// checkpoint byps.gen.cs.PrintContext:449
					obj.Char3 = bbuf.getChar();
					// checkpoint byps.gen.cs.PrintContext:449
					obj.Double3 = bbuf.getDouble();
					// checkpoint byps.gen.cs.PrintContext:449
					obj.Float3 = bbuf.getFloat();
					// checkpoint byps.gen.cs.PrintContext:449
					obj.Int3 = bbuf.getInt();
					// checkpoint byps.gen.cs.PrintContext:449
					obj.Long3 = bbuf.getLong();
					// checkpoint byps.gen.cs.PrintContext:449
					obj.Short3 = bbuf.getShort();
					// checkpoint byps.gen.cs.PrintContext:449
					obj.Str3 = bbuf.getString();
				}
			}
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Bools1 = (bool[])bin.readObj(false, byps.test.api.BSerializer_2058423690.instance);
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Bytes1 = (byte[])bin.readObj(false, byps.test.api.BSerializer_1374008726.instance);
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Chars1 = (char[])bin.readObj(false, byps.test.api.BSerializer_1361632968.instance);
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Doubles1 = (double[])bin.readObj(false, byps.test.api.BSerializer_1359468275.instance);
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Evo1 = (byps.test.api.ver.Evolve2)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Floats1 = (float[])bin.readObj(false, byps.test.api.BSerializer_766441794.instance);
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Ints1 = (int[])bin.readObj(false, byps.test.api.BSerializer_100361105.instance);
			// checkpoint byps.gen.cs.PrintContext:449
			obj.List1 = (IList<int>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Longs1 = (long[])bin.readObj(false, byps.test.api.BSerializer_1097129250.instance);
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Map1 = (IDictionary<int,int>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Obj1 = (Object)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Set1 = (ISet<int>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:449
			obj.Shorts1 = (short[])bin.readObj(false, byps.test.api.BSerializer_2067161310.instance);
			if (version >= 2L) {
				// checkpoint byps.gen.cs.PrintContext:449
				obj.Bools2 = (bool[])bin.readObj(false, byps.test.api.BSerializer_2058423690.instance);
				// checkpoint byps.gen.cs.PrintContext:449
				obj.Bytes2 = (byte[])bin.readObj(false, byps.test.api.BSerializer_1374008726.instance);
				// checkpoint byps.gen.cs.PrintContext:449
				obj.Chars2 = (char[])bin.readObj(false, byps.test.api.BSerializer_1361632968.instance);
				// checkpoint byps.gen.cs.PrintContext:449
				obj.Doubles2 = (double[])bin.readObj(false, byps.test.api.BSerializer_1359468275.instance);
				// checkpoint byps.gen.cs.PrintContext:449
				obj.Evo2 = (byps.test.api.ver.Evolve2)bin.readObj(false, null);
				// checkpoint byps.gen.cs.PrintContext:449
				obj.Floats2 = (float[])bin.readObj(false, byps.test.api.BSerializer_766441794.instance);
				// checkpoint byps.gen.cs.PrintContext:449
				obj.Ints2 = (int[])bin.readObj(false, byps.test.api.BSerializer_100361105.instance);
				// checkpoint byps.gen.cs.PrintContext:449
				obj.List2 = (IList<int>)bin.readObj(false, null);
				// checkpoint byps.gen.cs.PrintContext:449
				obj.Longs2 = (long[])bin.readObj(false, byps.test.api.BSerializer_1097129250.instance);
				// checkpoint byps.gen.cs.PrintContext:449
				obj.Map2 = (IDictionary<int,int>)bin.readObj(false, null);
				// checkpoint byps.gen.cs.PrintContext:449
				obj.Obj2 = (Object)bin.readObj(false, null);
				// checkpoint byps.gen.cs.PrintContext:449
				obj.Set2 = (ISet<int>)bin.readObj(false, null);
				// checkpoint byps.gen.cs.PrintContext:449
				obj.Shorts2 = (short[])bin.readObj(false, byps.test.api.BSerializer_2067161310.instance);
				if (version >= 3L) {
					// checkpoint byps.gen.cs.PrintContext:449
					obj.Bools3 = (bool[])bin.readObj(false, byps.test.api.BSerializer_2058423690.instance);
					// checkpoint byps.gen.cs.PrintContext:449
					obj.Bytes3 = (byte[])bin.readObj(false, byps.test.api.BSerializer_1374008726.instance);
					// checkpoint byps.gen.cs.PrintContext:449
					obj.Chars3 = (char[])bin.readObj(false, byps.test.api.BSerializer_1361632968.instance);
					// checkpoint byps.gen.cs.PrintContext:449
					obj.Doubles3 = (double[])bin.readObj(false, byps.test.api.BSerializer_1359468275.instance);
					// checkpoint byps.gen.cs.PrintContext:449
					obj.Evo3 = (byps.test.api.ver.Evolve2)bin.readObj(false, null);
					// checkpoint byps.gen.cs.PrintContext:449
					obj.Floats3 = (float[])bin.readObj(false, byps.test.api.BSerializer_766441794.instance);
					// checkpoint byps.gen.cs.PrintContext:449
					obj.Ints3 = (int[])bin.readObj(false, byps.test.api.BSerializer_100361105.instance);
					// checkpoint byps.gen.cs.PrintContext:449
					obj.List3 = (IList<int>)bin.readObj(false, null);
					// checkpoint byps.gen.cs.PrintContext:449
					obj.Longs3 = (long[])bin.readObj(false, byps.test.api.BSerializer_1097129250.instance);
					// checkpoint byps.gen.cs.PrintContext:449
					obj.Map3 = (IDictionary<int,int>)bin.readObj(false, null);
					// checkpoint byps.gen.cs.PrintContext:449
					obj.Obj3 = (Object)bin.readObj(false, null);
					// checkpoint byps.gen.cs.PrintContext:449
					obj.Set3 = (ISet<int>)bin.readObj(false, null);
					// checkpoint byps.gen.cs.PrintContext:449
					obj.Shorts3 = (short[])bin.readObj(false, byps.test.api.BSerializer_2067161310.instance);
				}
			}
			
			return obj;
		}
		
	}
} // namespace
