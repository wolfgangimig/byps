//
// Serializer for com.wilutions.byps.test.api.srvr.BRequest_ServerIF_getClientIds
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public class BSerializer_2063368540 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2063368540();
		
		public BSerializer_2063368540()
			: base(2063368540) {}
		
		public BSerializer_2063368540(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_ServerIF_getClientIds obj = (BRequest_ServerIF_getClientIds)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ServerIF_getClientIds()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
