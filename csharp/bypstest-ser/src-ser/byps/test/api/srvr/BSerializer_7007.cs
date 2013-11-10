//
// Serializer for byps.test.api.srvr.ChatStructure
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.srvr
{
	
	public class BSerializer_7007 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_7007();
		
		public BSerializer_7007()
			: base(7007) {}
		
		public BSerializer_7007(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			ChatStructure obj = (ChatStructure)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:490
			bbuf.putString(obj.Msg);
			// checkpoint byps.gen.cs.PrintContext:490
			bbuf.putDouble(obj.ReceivedAt);
			// checkpoint byps.gen.cs.PrintContext:490
			bbuf.putDouble(obj.SentAt);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			ChatStructure obj = (ChatStructure)(obj1 != null ? obj1 : bin.onObjectCreated(new ChatStructure()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:445
			obj.Msg = bbuf.getString();
			// checkpoint byps.gen.cs.PrintContext:445
			obj.ReceivedAt = bbuf.getDouble();
			// checkpoint byps.gen.cs.PrintContext:445
			obj.SentAt = bbuf.getDouble();
			
			return obj;
		}
		
	}
} // namespace
