//
// Serializer for byps.ureq.BRequest_UtilityRequests_cancelMessage
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.ureq
{
	
	public class BSerializer_648161469 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_648161469();
		
		public BSerializer_648161469()
			: base(648161469) {}
		
		public BSerializer_648161469(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_UtilityRequests_cancelMessage obj = (BRequest_UtilityRequests_cancelMessage)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putLong(obj.messageIdValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_UtilityRequests_cancelMessage obj = (BRequest_UtilityRequests_cancelMessage)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_UtilityRequests_cancelMessage()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.messageIdValue = bbuf.getLong();
			
			return obj;
		}
		
	}
} // namespace
