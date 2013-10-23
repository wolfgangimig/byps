//
// Serializer for byps.test.api.priv.PrivateMembers
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.priv
{
	
	public class BSerializer_8001 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_8001();
		
		public BSerializer_8001()
			: base(8001) {}
		
		public BSerializer_8001(int typeId)
			: base(typeId) {}
		
		
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
			bout.writeObj(obj.ArrBool, false, byps.test.api.BSerializer_2058423690.instance);
			bout.writeObj(obj.ArrInt, false, byps.test.api.BSerializer_100361105.instance);
			bout.writeObj(obj.ArrPrimitiveTypes, false, byps.test.api.BSerializer_2053507648.instance);
			bout.writeObj(obj.ArrString, true, byps.test.api.BSerializer_1888107655.instance);
			bout.writeObj(obj.ListBool, false, byps.test.api.BSerializer_1617670280.instance);
			bout.writeObj(obj.ListInt, false, byps.test.api.BSerializer_181681714.instance);
			bout.writeObj(obj.ListPrimitiveTypes, false, byps.test.api.BSerializer_1596367810.instance);
			bout.writeObj(obj.ListString, false, byps.test.api.BSerializer_2123584667.instance);
			bout.writeObj(obj.MapIntListString, false, byps.test.api.BSerializer_132175071.instance);
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
			obj.ArrBool = (bool[])bin.readObj(false, byps.test.api.BSerializer_2058423690.instance);
			obj.ArrInt = (int[])bin.readObj(false, byps.test.api.BSerializer_100361105.instance);
			obj.ArrPrimitiveTypes = (byps.test.api.prim.PrimitiveTypes[])bin.readObj(false, byps.test.api.BSerializer_2053507648.instance);
			obj.ArrString = (String[])bin.readObj(false, byps.test.api.BSerializer_1888107655.instance);
			obj.ListBool = (IList<bool>)bin.readObj(false, null);
			obj.ListInt = (IList<int>)bin.readObj(false, null);
			obj.ListPrimitiveTypes = (IList<byps.test.api.prim.PrimitiveTypes>)bin.readObj(false, null);
			obj.ListString = (IList<String>)bin.readObj(false, null);
			obj.MapIntListString = (IDictionary<int,IList<String>>)bin.readObj(false, null);
			obj.PrimitiveTypes = (byps.test.api.prim.PrimitiveTypes)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
