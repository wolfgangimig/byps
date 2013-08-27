//
// Serializer for com.wilutions.byps.test.api.set.SetTypes
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.set
{
	
	public class BSerializer_5001 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_5001();
		
		public BSerializer_5001()
			: base(5001) {}
		
		public BSerializer_5001(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: boolean1 */ + 4			
			       /* pos=4: byte1 */ + 4			
			       /* pos=8: char1 */ + 4			
			       /* pos=12: short1 */ + 4			
			       /* pos=16: int1 */ + 4			
			       /* pos=20: long1 */ + 4			
			       /* pos=24: float1 */ + 4			
			       /* pos=28: double1 */ + 4			
			       /* pos=32: string1 */ + 4			
			       /* pos=36: primitiveTypes1 */ + 4			
			       /* pos=40: byte2 */ + 4			
			       /* pos=44: int2 */ + 4			
			       /* pos=48: obj1 */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			SetTypes obj = (SetTypes)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj.Boolean1, false, com.wilutions.byps.test.api.BSerializer_1365696060.instance);
			bout.writeObj(obj.Byte1, false, com.wilutions.byps.test.api.BSerializer_31512998.instance);
			bout.writeObj(obj.Byte2, false, com.wilutions.byps.test.api.BSerializer_2052431866.instance);
			bout.writeObj(obj.Char1, false, com.wilutions.byps.test.api.BSerializer_936607009.instance);
			bout.writeObj(obj.Double1, false, com.wilutions.byps.test.api.BSerializer_1320560671.instance);
			bout.writeObj(obj.Float1, false, com.wilutions.byps.test.api.BSerializer_1898022288.instance);
			bout.writeObj(obj.Int1, false, com.wilutions.byps.test.api.BSerializer_1493282670.instance);
			bout.writeObj(obj.Int2, false, com.wilutions.byps.test.api.BSerializer_1406124761.instance);
			bout.writeObj(obj.Long1, false, com.wilutions.byps.test.api.BSerializer_1457164460.instance);
			bout.writeObj(obj.Obj1, false, com.wilutions.byps.BSerializer_14.instance);
			bout.writeObj(obj.PrimitiveTypes1, false, com.wilutions.byps.test.api.BSerializer_1280571537.instance);
			bout.writeObj(obj.Short1, false, com.wilutions.byps.test.api.BSerializer_2028443792.instance);
			bout.writeObj(obj.String1, false, com.wilutions.byps.test.api.BSerializer_1888799711.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			SetTypes obj = (SetTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new SetTypes()));
			
			BBufferBin bbuf = bin.bbuf;
			obj.Boolean1 = (ISet<bool>)bin.readObj(false, null);
			obj.Byte1 = (HashSet<byte>)bin.readObj(false, null);
			obj.Byte2 = (ISet<byte[]>)bin.readObj(false, null);
			obj.Char1 = (HashSet<char>)bin.readObj(false, null);
			obj.Double1 = (ISet<double>)bin.readObj(false, null);
			obj.Float1 = (ISet<float>)bin.readObj(false, null);
			obj.Int1 = (ISet<int>)bin.readObj(false, null);
			obj.Int2 = (ISet<int[]>)bin.readObj(false, null);
			obj.Long1 = (ISet<long>)bin.readObj(false, null);
			obj.Obj1 = (ISet<Object>)bin.readObj(false, null);
			obj.PrimitiveTypes1 = (ISet<com.wilutions.byps.test.api.prim.PrimitiveTypes>)bin.readObj(false, null);
			obj.Short1 = (ISet<short>)bin.readObj(false, null);
			obj.String1 = (ISet<String>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
