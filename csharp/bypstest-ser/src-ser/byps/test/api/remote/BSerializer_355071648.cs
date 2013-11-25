//
// Serializer for byps.test.api.remote.BStub_RemoteInlineInstance
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_355071648 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_355071648();
		
		public BSerializer_355071648()
			: base(355071648) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteInlineInstance(transport);
		}
		
	}
} // namespace
