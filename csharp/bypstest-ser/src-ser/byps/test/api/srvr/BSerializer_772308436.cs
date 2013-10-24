//
// Serializer for byps.test.api.srvr.BRequest_ServerIF_callClientParallel
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.srvr
{
	
	public class BSerializer_772308436 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_772308436();
		
		public BSerializer_772308436()
			: base(772308436) {}
		
		public BSerializer_772308436(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_ServerIF_callClientParallel obj = (BRequest_ServerIF_callClientParallel)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putInt(obj._v);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_ServerIF_callClientParallel obj = (BRequest_ServerIF_callClientParallel)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ServerIF_callClientParallel()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._v = bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
