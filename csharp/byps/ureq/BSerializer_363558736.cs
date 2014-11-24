//
// Serializer for byps.ureq.BStub_UtilityRequests
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.ureq
{
	
	public class BSerializer_363558736 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_363558736();
		
		public BSerializer_363558736()
			: base(363558736) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_UtilityRequests(transport);
		}
		
	}
} // namespace
