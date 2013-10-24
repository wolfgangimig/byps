//
// Serializer for byps.test.api.cons.AllTypesZ
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.cons
{
	
	public class BSerializer_142458 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_142458();
		
		public BSerializer_142458()
			: base(142458) {}
		
		public BSerializer_142458(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
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
			bout.writeObj(obj.Byte2, false, byps.test.api.BSerializer_1374008726.instance);
			bout.writeObj(obj.Hebrew1, false, null);
			bout.writeObj(obj.Hebrew2, false, byps.test.api.BSerializer_92445340.instance);
			bout.writeObj(obj.Int2, false, byps.test.api.BSerializer_100361105.instance);
			bout.writeObj(obj.String2, true, byps.test.api.BSerializer_1888107655.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
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
			obj.Byte2 = (byte[])bin.readObj(false, byps.test.api.BSerializer_1374008726.instance);
			obj.Hebrew1 = (byps.test.api.cons.HebrewZ)bin.readObj(false, null);
			obj.Hebrew2 = (byps.test.api.cons.HebrewZ[])bin.readObj(false, byps.test.api.BSerializer_92445340.instance);
			obj.Int2 = (int[])bin.readObj(false, byps.test.api.BSerializer_100361105.instance);
			obj.String2 = (String[])bin.readObj(false, byps.test.api.BSerializer_1888107655.instance);
			
			return obj;
		}
		
	}
} // namespace
