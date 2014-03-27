//
// Serializer for byps.test.api.srvr.BRequest_ServerIF_callClientIncrementInt
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.srvr
{
	
	public class BSerializer_389860173 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_389860173();
		
		public BSerializer_389860173()
			: base(389860173) {}
		
		public BSerializer_389860173(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_ServerIF_callClientIncrementInt obj = (BRequest_ServerIF_callClientIncrementInt)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putInt(obj.vValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_ServerIF_callClientIncrementInt obj = (BRequest_ServerIF_callClientIncrementInt)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ServerIF_callClientIncrementInt()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.vValue = bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
