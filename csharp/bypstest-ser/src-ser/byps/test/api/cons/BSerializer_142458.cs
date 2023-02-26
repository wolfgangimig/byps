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
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putBoolean(obj.Bool1);
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putByte(obj.Byte1);
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putChar(obj.Char1);
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putDouble(obj.Double1);
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putFloat(obj.Float1);
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putInt(obj.Int1);
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putLong(obj.Long1);
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putShort(obj.Short1);
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putString(obj.String1);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.Byte2, false, byps.test.api.BSerializer_1374008726.instance);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.Hebrew1, false, null);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.Hebrew2, false, byps.test.api.BSerializer_92445340.instance);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.Int2, false, byps.test.api.BSerializer_100361105.instance);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.String2, true, byps.test.api.BSerializer_1888107655.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			AllTypesZ obj = (AllTypesZ)(obj1 != null ? obj1 : bin.onObjectCreated(new AllTypesZ()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.Bool1 = bbuf.getBoolean();
			// checkpoint byps.gen.cs.PrintContext:453
			obj.Byte1 = bbuf.getByte();
			// checkpoint byps.gen.cs.PrintContext:453
			obj.Char1 = bbuf.getChar();
			// checkpoint byps.gen.cs.PrintContext:453
			obj.Double1 = bbuf.getDouble();
			// checkpoint byps.gen.cs.PrintContext:453
			obj.Float1 = bbuf.getFloat();
			// checkpoint byps.gen.cs.PrintContext:453
			obj.Int1 = bbuf.getInt();
			// checkpoint byps.gen.cs.PrintContext:453
			obj.Long1 = bbuf.getLong();
			// checkpoint byps.gen.cs.PrintContext:453
			obj.Short1 = bbuf.getShort();
			// checkpoint byps.gen.cs.PrintContext:453
			obj.String1 = bbuf.getString();
			// checkpoint byps.gen.cs.PrintContext:453
			obj.Byte2 = (byte[])bin.readObj(false, byps.test.api.BSerializer_1374008726.instance);
			// checkpoint byps.gen.cs.PrintContext:453
			obj.Hebrew1 = (byps.test.api.cons.HebrewZ)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:453
			obj.Hebrew2 = (byps.test.api.cons.HebrewZ[])bin.readObj(false, byps.test.api.BSerializer_92445340.instance);
			// checkpoint byps.gen.cs.PrintContext:453
			obj.Int2 = (int[])bin.readObj(false, byps.test.api.BSerializer_100361105.instance);
			// checkpoint byps.gen.cs.PrintContext:453
			obj.String2 = (String[])bin.readObj(false, byps.test.api.BSerializer_1888107655.instance);
			
			return obj;
		}
		
	}
} // namespace
