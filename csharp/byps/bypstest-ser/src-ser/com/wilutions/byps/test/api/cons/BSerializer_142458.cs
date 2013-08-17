//
// Serializer for com.wilutions.byps.test.api.cons.AllTypesZ
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.cons
{
	
	public class BSerializer_142458 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_142458();
		
		public BSerializer_142458()
			: base(142458) {}
		
		public BSerializer_142458(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: bool1 */ + 4			
			       /* pos=4: byte1 */ + 1			
			       /* padding */ + 1			
			       /* pos=6: char1 */ + 2			
			       /* pos=8: short1 */ + 2			
			       /* padding */ + 2			
			       /* pos=12: int1 */ + 4			
			       /* pos=16: long1 */ + 8			
			       /* pos=24: float1 */ + 4			
			       /* padding */ + 4			
			       /* pos=32: double1 */ + 8			
			       /* pos=40: string1 */ + 4			
			       /* pos=44: hebrew1 */ + 4			
			       /* pos=48: byte2 */ + 4			
			       /* pos=52: int2 */ + 4			
			       /* pos=56: string2 */ + 4			
			       /* pos=60: hebrew2 */ + 4			
			       /* padding up to multiple of alignment */ + 0;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			AllTypesZ obj = (AllTypesZ)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putBoolean(obj.Bool1);
			bbuf.putByte(obj.Byte1);
			bbuf.putChar(obj.Char1);
			bbuf.putDouble(obj.Double1);
			bbuf.putFloat(obj.Float1);
			bbuf.putInt(obj.Int1);
			bbuf.putLong(obj.Long1);
			bbuf.putShort(obj.Short1);
			bbuf.putString(obj.String1);
			bout.writeObj(obj.Byte2, false, com.wilutions.byps.test.api.BSerializer_1374008726.instance);
			bout.writeObj(obj.Hebrew1, false, null);
			bout.writeObj(obj.Hebrew2, false, com.wilutions.byps.test.api.BSerializer_2092671091.instance);
			bout.writeObj(obj.Int2, false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
			bout.writeObj(obj.String2, true, com.wilutions.byps.test.api.BSerializer_1888107655.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			AllTypesZ obj = (AllTypesZ)(obj1 != null ? obj1 : bin.onObjectCreated(new AllTypesZ()));
			
			BBufferBin bbuf = bin.bbuf;
			obj.Bool1 = bbuf.getBoolean();
			obj.Byte1 = bbuf.getByte();
			obj.Char1 = bbuf.getChar();
			obj.Double1 = bbuf.getDouble();
			obj.Float1 = bbuf.getFloat();
			obj.Int1 = bbuf.getInt();
			obj.Long1 = bbuf.getLong();
			obj.Short1 = bbuf.getShort();
			obj.String1 = bbuf.getString();
			obj.Byte2 = (byte[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1374008726.instance);
			obj.Hebrew1 = (com.wilutions.byps.test.api.cons.HebrewZ)bin.readObj(false, null);
			obj.Hebrew2 = (com.wilutions.byps.test.api.cons.HebrewZ[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_2092671091.instance);
			obj.Int2 = (int[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
			obj.String2 = (String[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1888107655.instance);
			
			return obj;
		}
		
	}
} // namespace
