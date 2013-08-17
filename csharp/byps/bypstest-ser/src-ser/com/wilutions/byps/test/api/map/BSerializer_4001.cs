//
// Serializer for com.wilutions.byps.test.api.map.MapTypes
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.map
{
	
	public class BSerializer_4001 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_4001();
		
		public BSerializer_4001()
			: base(4001) {}
		
		public BSerializer_4001(int typeId)
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
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			MapTypes obj = (MapTypes)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj.Boolean1, false, com.wilutions.byps.test.api.BSerializer_1279823631.instance);
			bout.writeObj(obj.Byte1, false, com.wilutions.byps.test.api.BSerializer_1972793385.instance);
			bout.writeObj(obj.Byte2, false, com.wilutions.byps.test.api.BSerializer_1799280818.instance);
			bout.writeObj(obj.Char1, false, com.wilutions.byps.test.api.BSerializer_8789515.instance);
			bout.writeObj(obj.Double1, false, com.wilutions.byps.test.api.BSerializer_1487265161.instance);
			bout.writeObj(obj.Float1, false, com.wilutions.byps.test.api.BSerializer_94341197.instance);
			bout.writeObj(obj.Int1, false, com.wilutions.byps.test.api.BSerializer_1347703734.instance);
			bout.writeObj(obj.Int2, false, com.wilutions.byps.test.api.BSerializer_1633750383.instance);
			bout.writeObj(obj.Long1, false, com.wilutions.byps.test.api.BSerializer_1973996106.instance);
			bout.writeObj(obj.Obj1, false, com.wilutions.byps.test.api.BSerializer_1488550492.instance);
			bout.writeObj(obj.PrimitiveTypes1, false, com.wilutions.byps.test.api.BSerializer_703065817.instance);
			bout.writeObj(obj.Short1, false, com.wilutions.byps.test.api.BSerializer_601099730.instance);
			bout.writeObj(obj.String1, false, com.wilutions.byps.test.api.BSerializer_1710660846.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			MapTypes obj = (MapTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new MapTypes()));
			
			BBufferBin bbuf = bin.bbuf;
			obj.Boolean1 = (IDictionary<String,bool>)bin.readObj(false, null);
			obj.Byte1 = (Dictionary<double,byte>)bin.readObj(false, null);
			obj.Byte2 = (IDictionary<int,byte[]>)bin.readObj(false, null);
			obj.Char1 = (Dictionary<float,char>)bin.readObj(false, null);
			obj.Double1 = (IDictionary<byte,double>)bin.readObj(false, null);
			obj.Float1 = (IDictionary<char,float>)bin.readObj(false, null);
			obj.Int1 = (IDictionary<int,int>)bin.readObj(false, null);
			obj.Int2 = (IDictionary<int,int[]>)bin.readObj(false, null);
			obj.Long1 = (IDictionary<short,long>)bin.readObj(false, null);
			obj.Obj1 = (IDictionary<String,Object>)bin.readObj(false, null);
			obj.PrimitiveTypes1 = (IDictionary<int,com.wilutions.byps.test.api.prim.PrimitiveTypes>)bin.readObj(false, null);
			obj.Short1 = (IDictionary<long,short>)bin.readObj(false, null);
			obj.String1 = (IDictionary<String,String>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
