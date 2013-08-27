//
// Serializer for com.wilutions.byps.test.api.priv.PrivateMembers
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.priv
{
	
	public class BSerializer_8001 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_8001();
		
		public BSerializer_8001()
			: base(8001) {}
		
		public BSerializer_8001(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
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
			       /* pos=44: primitiveTypes */ + 4			
			       /* pos=48: arrBool */ + 4			
			       /* pos=52: arrInt */ + 4			
			       /* pos=56: arrString */ + 4			
			       /* pos=60: arrPrimitiveTypes */ + 4			
			       /* pos=64: listBool */ + 4			
			       /* pos=68: listInt */ + 4			
			       /* pos=72: listString */ + 4			
			       /* pos=76: listPrimitiveTypes */ + 4			
			       /* pos=80: mapIntListString */ + 4			
			       /* pos=84: protInt */ + 4			
			       /* pos=88: pprotInt */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			PrivateMembers obj = (PrivateMembers)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putBoolean(obj.BoolVal);
			bbuf.putByte(obj.ByteVal);
			bbuf.putChar(obj.CharVal);
			bbuf.putDouble(obj.DoubleVal);
			bbuf.putFloat(obj.FloatVal);
			bbuf.putInt(obj.IntVal);
			bbuf.putLong(obj.LongVal);
			bbuf.putInt(obj.PprotInt);
			bbuf.putInt(obj.ProtInt);
			bbuf.putShort(obj.ShortVal);
			bbuf.putString(obj.StringVal);
			bout.writeObj(obj.ArrBool, false, com.wilutions.byps.test.api.BSerializer_2058423690.instance);
			bout.writeObj(obj.ArrInt, false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
			bout.writeObj(obj.ArrPrimitiveTypes, false, com.wilutions.byps.test.api.BSerializer_801243127.instance);
			bout.writeObj(obj.ArrString, true, com.wilutions.byps.test.api.BSerializer_1888107655.instance);
			bout.writeObj(obj.ListBool, false, com.wilutions.byps.test.api.BSerializer_1617670280.instance);
			bout.writeObj(obj.ListInt, false, com.wilutions.byps.test.api.BSerializer_181681714.instance);
			bout.writeObj(obj.ListPrimitiveTypes, false, com.wilutions.byps.test.api.BSerializer_1544333227.instance);
			bout.writeObj(obj.ListString, false, com.wilutions.byps.test.api.BSerializer_2123584667.instance);
			bout.writeObj(obj.MapIntListString, false, com.wilutions.byps.test.api.BSerializer_132175071.instance);
			bout.writeObj(obj.PrimitiveTypes, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			PrivateMembers obj = (PrivateMembers)(obj1 != null ? obj1 : bin.onObjectCreated(new PrivateMembers()));
			
			BBufferBin bbuf = bin.bbuf;
			obj.BoolVal = bbuf.getBoolean();
			obj.ByteVal = bbuf.getByte();
			obj.CharVal = bbuf.getChar();
			obj.DoubleVal = bbuf.getDouble();
			obj.FloatVal = bbuf.getFloat();
			obj.IntVal = bbuf.getInt();
			obj.LongVal = bbuf.getLong();
			obj.PprotInt = bbuf.getInt();
			obj.ProtInt = bbuf.getInt();
			obj.ShortVal = bbuf.getShort();
			obj.StringVal = bbuf.getString();
			obj.ArrBool = (bool[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_2058423690.instance);
			obj.ArrInt = (int[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
			obj.ArrPrimitiveTypes = (com.wilutions.byps.test.api.prim.PrimitiveTypes[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_801243127.instance);
			obj.ArrString = (String[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1888107655.instance);
			obj.ListBool = (IList<bool>)bin.readObj(false, null);
			obj.ListInt = (IList<int>)bin.readObj(false, null);
			obj.ListPrimitiveTypes = (IList<com.wilutions.byps.test.api.prim.PrimitiveTypes>)bin.readObj(false, null);
			obj.ListString = (IList<String>)bin.readObj(false, null);
			obj.MapIntListString = (IDictionary<int,IList<String>>)bin.readObj(false, null);
			obj.PrimitiveTypes = (com.wilutions.byps.test.api.prim.PrimitiveTypes)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
