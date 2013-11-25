//
// Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_sendAllTypes
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_677876863 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_677876863();
		
		public BSerializer_677876863()
			: base(677876863) {}
		
		public BSerializer_677876863(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemotePrimitiveTypes_sendAllTypes obj = (BRequest_RemotePrimitiveTypes_sendAllTypes)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putBoolean(obj.bValue);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putChar(obj.cValue);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putDouble(obj.dValue);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putFloat(obj.fValue);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putInt(obj.iValue);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putLong(obj.lValue);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putShort(obj.sValue);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putString(obj.strValue);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.oValue, false, null);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.ptValue, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_sendAllTypes obj = (BRequest_RemotePrimitiveTypes_sendAllTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_sendAllTypes()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.bValue = bbuf.getBoolean();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.cValue = bbuf.getChar();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.dValue = bbuf.getDouble();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.fValue = bbuf.getFloat();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.iValue = bbuf.getInt();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.lValue = bbuf.getLong();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.sValue = bbuf.getShort();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.strValue = bbuf.getString();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.oValue = (Object)bin.readObj(false, null);
			// checkpoint byps.gen.cs.PrintContext:449
			obj.ptValue = (byps.test.api.prim.PrimitiveTypes)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
