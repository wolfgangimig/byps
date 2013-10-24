//
// Serializer for byps.test.api.prim.PrimitiveTypes
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.prim
{
	
	public class BSerializer_1000 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1000();
		
		public BSerializer_1000()
			: base(1000) {}
		
		public BSerializer_1000(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			PrimitiveTypes obj = (PrimitiveTypes)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putBoolean(obj.BoolVal);
			bbuf.putByte(obj.ByteVal);
			bbuf.putChar(obj.CharVal);
			bbuf.putDouble(obj.DoubleVal);
			bbuf.putFloat(obj.FloatVal);
			bbuf.putInt(obj.IntVal);
			bbuf.putLong(obj.LongVal);
			bbuf.putShort(obj.ShortVal);
			bbuf.putString(obj.StringVal);
			bbuf.putBoolean(obj.Value);
			bout.writeObj(obj.ObjVal, false, null);
			bout.writeObj(obj.ObjVal2, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			PrimitiveTypes obj = (PrimitiveTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new PrimitiveTypes()));
			
			BBufferBin bbuf = bin.bbuf;
			obj.BoolVal = bbuf.getBoolean();
			obj.ByteVal = bbuf.getByte();
			obj.CharVal = bbuf.getChar();
			obj.DoubleVal = bbuf.getDouble();
			obj.FloatVal = bbuf.getFloat();
			obj.IntVal = bbuf.getInt();
			obj.LongVal = bbuf.getLong();
			obj.ShortVal = bbuf.getShort();
			obj.StringVal = bbuf.getString();
			obj.Value = bbuf.getBoolean();
			obj.ObjVal = (Object)bin.readObj(false, null);
			obj.ObjVal2 = (Object)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
