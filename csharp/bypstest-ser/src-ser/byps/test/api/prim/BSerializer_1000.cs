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
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putBoolean(obj.BoolVal);
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putByte(obj.ByteVal);
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putChar(obj.CharVal);
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putDate(obj.DateVal);
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putDouble(obj.DoubleVal);
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putFloat(obj.FloatVal);
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putInt(obj.IntVal);
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putLong(obj.LongVal);
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putShort(obj.ShortVal);
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putString(obj.StringVal);
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putBoolean(obj.Value);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.ObjVal, false, null);
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.ObjVal2, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			PrimitiveTypes obj = (PrimitiveTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new PrimitiveTypes()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:447
			obj.BoolVal = bbuf.getBoolean();
			// checkpoint byps.gen.cs.PrintContext:447
			obj.ByteVal = bbuf.getByte();
			// checkpoint byps.gen.cs.PrintContext:447
			obj.CharVal = bbuf.getChar();
			// checkpoint byps.gen.cs.PrintContext:447
			obj.DateVal = bbuf.getDate();
			// checkpoint byps.gen.cs.PrintContext:447
			obj.DoubleVal = bbuf.getDouble();
			// checkpoint byps.gen.cs.PrintContext:447
			obj.FloatVal = bbuf.getFloat();
			// checkpoint byps.gen.cs.PrintContext:447
			obj.IntVal = bbuf.getInt();
			// checkpoint byps.gen.cs.PrintContext:447
			obj.LongVal = bbuf.getLong();
			// checkpoint byps.gen.cs.PrintContext:447
			obj.ShortVal = bbuf.getShort();
			// checkpoint byps.gen.cs.PrintContext:447
			obj.StringVal = bbuf.getString();
			// checkpoint byps.gen.cs.PrintContext:447
			obj.Value = bbuf.getBoolean();
			// checkpoint byps.gen.cs.PrintContext:447
			obj.ObjVal = (Object)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:447
			obj.ObjVal2 = (Object)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
