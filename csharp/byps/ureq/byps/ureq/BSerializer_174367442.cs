//
// Serializer for byps.ureq.BStub_BUtilityRequests
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.ureq
{
	
	public class BSerializer_174367442 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_174367442();
		
		public BSerializer_174367442()
			: base(174367442) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_BUtilityRequests(transport);
		}
		
	}
} // namespace
