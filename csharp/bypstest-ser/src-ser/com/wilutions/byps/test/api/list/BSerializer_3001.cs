﻿//
// Serializer for com.wilutions.byps.test.api.list.ListTypes
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.list
{
	
	public class BSerializer_3001 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_3001();
		
		public BSerializer_3001()
			: base(3001) {}
		
		public BSerializer_3001(int typeId)
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
			       /* pos=48: int4 */ + 4			
			       /* pos=52: obj1 */ + 4			
			       /* padding up to multiple of alignment */ + 0;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			ListTypes obj = (ListTypes)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj.Boolean1, false, com.wilutions.byps.test.api.BSerializer_1617670280.instance);
			bout.writeObj(obj.Byte1, false, com.wilutions.byps.test.api.BSerializer_1059148284.instance);
			bout.writeObj(obj.Byte2, false, com.wilutions.byps.test.api.BSerializer_1174971318.instance);
			bout.writeObj(obj.Char1, false, com.wilutions.byps.test.api.BSerializer_1661807911.instance);
			bout.writeObj(obj.Double1, false, com.wilutions.byps.test.api.BSerializer_1555345627.instance);
			bout.writeObj(obj.Float1, false, com.wilutions.byps.test.api.BSerializer_1628501332.instance);
			bout.writeObj(obj.Int1, false, com.wilutions.byps.test.api.BSerializer_181681714.instance);
			bout.writeObj(obj.Int2, false, com.wilutions.byps.test.api.BSerializer_1752158699.instance);
			bout.writeObj(obj.Int4, false, com.wilutions.byps.test.api.BSerializer_1088217157.instance);
			bout.writeObj(obj.Long1, false, com.wilutions.byps.test.api.BSerializer_1050216688.instance);
			bout.writeObj(obj.Obj1, false, com.wilutions.byps.BSerializer_12.instance);
			bout.writeObj(obj.PrimitiveTypes1, false, com.wilutions.byps.test.api.BSerializer_1544333227.instance);
			bout.writeObj(obj.Short1, false, com.wilutions.byps.test.api.BSerializer_1997002548.instance);
			bout.writeObj(obj.String1, false, com.wilutions.byps.test.api.BSerializer_2123584667.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			ListTypes obj = (ListTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new ListTypes()));
			
			BBufferBin bbuf = bin.bbuf;
			obj.Boolean1 = (IList<bool>)bin.readObj(false, null);
			obj.Byte1 = (IList<byte>)bin.readObj(false, null);
			obj.Byte2 = (IList<byte[]>)bin.readObj(false, null);
			obj.Char1 = (IList<char>)bin.readObj(false, null);
			obj.Double1 = (IList<double>)bin.readObj(false, null);
			obj.Float1 = (IList<float>)bin.readObj(false, null);
			obj.Int1 = (IList<int>)bin.readObj(false, null);
			obj.Int2 = (IList<int[]>)bin.readObj(false, null);
			obj.Int4 = (IList<int[,,,]>)bin.readObj(false, null);
			obj.Long1 = (IList<long>)bin.readObj(false, null);
			obj.Obj1 = (IList<Object>)bin.readObj(false, null);
			obj.PrimitiveTypes1 = (IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>)bin.readObj(false, null);
			obj.Short1 = (IList<short>)bin.readObj(false, null);
			obj.String1 = (IList<String>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace