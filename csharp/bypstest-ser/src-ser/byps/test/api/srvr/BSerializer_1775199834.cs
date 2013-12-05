//
// Serializer for byps.test.api.srvr.BStub_ServerIF
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.srvr
{
	
	public class BSerializer_1775199834 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1775199834();
		
		public BSerializer_1775199834()
			: base(1775199834) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_ServerIF(transport);
		}
		
	}
} // namespace
