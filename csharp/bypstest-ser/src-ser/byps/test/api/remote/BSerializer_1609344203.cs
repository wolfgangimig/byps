//
// Serializer for byps.test.api.remote.BRequest_RemoteConstants_compare_AllTypesC
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1609344203 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1609344203();
		
		public BSerializer_1609344203()
			: base(1609344203) {}
		
		public BSerializer_1609344203(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteConstants_compare_AllTypesC obj = (BRequest_RemoteConstants_compare_AllTypesC)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putBoolean(obj.bool1sValue);
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putBoolean(obj.bool2sValue);
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putChar(obj.char1sValue);
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putChar(obj.char2sValue);
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putDouble(obj.double1sValue);
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putFloat(obj.float1sValue);
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putInt(obj.int1sValue);
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putLong(obj.long1sValue);
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putShort(obj.short1sValue);
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putString(obj.string1sValue);
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putString(obj.stringNullValue);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.ALLValue, false, null);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.arrAllValue, false, byps.test.api.BSerializer_81775365.instance);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.arrIntValue, false, byps.test.api.BSerializer_100361105.instance);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.arrInt4Value, false, byps.test.api.BSerializer_39910537.instance);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.arrStringsValue, true, byps.test.api.BSerializer_1888107655.instance);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.arrStrings4Value, true, byps.test.api.BSerializer_588723219.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteConstants_compare_AllTypesC obj = (BRequest_RemoteConstants_compare_AllTypesC)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteConstants_compare_AllTypesC()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.bool1sValue = bbuf.getBoolean();
			// checkpoint byps.gen.cs.PrintContext:453
			obj.bool2sValue = bbuf.getBoolean();
			// checkpoint byps.gen.cs.PrintContext:453
			obj.char1sValue = bbuf.getChar();
			// checkpoint byps.gen.cs.PrintContext:453
			obj.char2sValue = bbuf.getChar();
			// checkpoint byps.gen.cs.PrintContext:453
			obj.double1sValue = bbuf.getDouble();
			// checkpoint byps.gen.cs.PrintContext:453
			obj.float1sValue = bbuf.getFloat();
			// checkpoint byps.gen.cs.PrintContext:453
			obj.int1sValue = bbuf.getInt();
			// checkpoint byps.gen.cs.PrintContext:453
			obj.long1sValue = bbuf.getLong();
			// checkpoint byps.gen.cs.PrintContext:453
			obj.short1sValue = bbuf.getShort();
			// checkpoint byps.gen.cs.PrintContext:453
			obj.string1sValue = bbuf.getString();
			// checkpoint byps.gen.cs.PrintContext:453
			obj.stringNullValue = bbuf.getString();
			// checkpoint byps.gen.cs.PrintContext:453
			obj.ALLValue = (byps.test.api.cons.AllTypesZ)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:453
			obj.arrAllValue = (byps.test.api.cons.AllTypesZ[,])bin.readObj(false, byps.test.api.BSerializer_81775365.instance);
			// checkpoint byps.gen.cs.PrintContext:453
			obj.arrIntValue = (int[])bin.readObj(false, byps.test.api.BSerializer_100361105.instance);
			// checkpoint byps.gen.cs.PrintContext:453
			obj.arrInt4Value = (int[,,,])bin.readObj(false, byps.test.api.BSerializer_39910537.instance);
			// checkpoint byps.gen.cs.PrintContext:453
			obj.arrStringsValue = (String[])bin.readObj(false, byps.test.api.BSerializer_1888107655.instance);
			// checkpoint byps.gen.cs.PrintContext:453
			obj.arrStrings4Value = (String[,,,])bin.readObj(false, byps.test.api.BSerializer_588723219.instance);
			
			return obj;
		}
		
	}
} // namespace
