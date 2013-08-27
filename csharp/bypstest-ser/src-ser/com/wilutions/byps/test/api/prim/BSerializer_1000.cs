//
// Serializer for com.wilutions.byps.test.api.prim.PrimitiveTypes
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.prim
{
	
	public class BSerializer_1000 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1000();
		
		public BSerializer_1000()
			: base(1000) {}
		
		public BSerializer_1000(int typeId)
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
			       /* pos=44: objVal */ + 4			
			       /* pos=48: objVal2 */ + 4			
			       /* pos=52: value */ + 4			
			       /* pos=56: temp */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
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
