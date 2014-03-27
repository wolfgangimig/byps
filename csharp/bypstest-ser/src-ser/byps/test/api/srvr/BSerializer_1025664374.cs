//
// Serializer for byps.test.api.srvr.BRequest_ServerIF_getPartner
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.srvr
{
	
	public class BSerializer_1025664374 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1025664374();
		
		public BSerializer_1025664374()
			: base(1025664374) {}
		
		public BSerializer_1025664374(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_ServerIF_getPartner obj = (BRequest_ServerIF_getPartner)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ServerIF_getPartner()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
