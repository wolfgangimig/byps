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
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putBoolean(obj.BoolVal);
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putByte(obj.ByteVal);
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putChar(obj.CharVal);
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putDouble(obj.DoubleVal);
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putFloat(obj.FloatVal);
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putInt(obj.IntVal);
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putLong(obj.LongVal);
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putInt(obj.PprotInt);
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putInt(obj.ProtInt);
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putShort(obj.ShortVal);
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putString(obj.StringVal);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.ArrBool, false, byps.test.api.BSerializer_2058423690.instance);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.ArrInt, false, byps.test.api.BSerializer_100361105.instance);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.ArrPrimitiveTypes, false, byps.test.api.BSerializer_2053507648.instance);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.ArrString, true, byps.test.api.BSerializer_1888107655.instance);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.ListBool, false, byps.test.api.BSerializer_1617670280.instance);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.ListInt, false, byps.test.api.BSerializer_181681714.instance);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.ListPrimitiveTypes, false, byps.test.api.BSerializer_1596367810.instance);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.ListString, false, byps.test.api.BSerializer_2123584667.instance);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.MapIntListString, false, byps.test.api.BSerializer_132175071.instance);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.PrimitiveTypes, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			PrivateMembers obj = (PrivateMembers)(obj1 != null ? obj1 : bin.onObjectCreated(new PrivateMembers()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:447
			obj.BoolVal = bbuf.getBoolean();
			// checkpoint byps.gen.cs.PrintContext:447
			obj.ByteVal = bbuf.getByte();
			// checkpoint byps.gen.cs.PrintContext:447
			obj.CharVal = bbuf.getChar();
			// checkpoint byps.gen.cs.PrintContext:447
			obj.DoubleVal = bbuf.getDouble();
			// checkpoint byps.gen.cs.PrintContext:447
			obj.FloatVal = bbuf.getFloat();
			// checkpoint byps.gen.cs.PrintContext:447
			obj.IntVal = bbuf.getInt();
			// checkpoint byps.gen.cs.PrintContext:447
			obj.LongVal = bbuf.getLong();
			// checkpoint byps.gen.cs.PrintContext:447
			obj.PprotInt = bbuf.getInt();
			// checkpoint byps.gen.cs.PrintContext:447
			obj.ProtInt = bbuf.getInt();
			// checkpoint byps.gen.cs.PrintContext:447
			obj.ShortVal = bbuf.getShort();
			// checkpoint byps.gen.cs.PrintContext:447
			obj.StringVal = bbuf.getString();
			// checkpoint byps.gen.cs.PrintContext:447
			obj.ArrBool = (bool[])bin.readObj(false, byps.test.api.BSerializer_2058423690.instance);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.ArrInt = (int[])bin.readObj(false, byps.test.api.BSerializer_100361105.instance);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.ArrPrimitiveTypes = (byps.test.api.prim.PrimitiveTypes[])bin.readObj(false, byps.test.api.BSerializer_2053507648.instance);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.ArrString = (String[])bin.readObj(false, byps.test.api.BSerializer_1888107655.instance);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.ListBool = (IList<bool>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.ListInt = (IList<int>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.ListPrimitiveTypes = (IList<byps.test.api.prim.PrimitiveTypes>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.ListString = (IList<String>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.MapIntListString = (IDictionary<int,IList<String>>)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.PrimitiveTypes = (byps.test.api.prim.PrimitiveTypes)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
