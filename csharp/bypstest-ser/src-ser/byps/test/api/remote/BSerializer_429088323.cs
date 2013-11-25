//
// Serializer for byps.test.api.remote.BStub_RemoteConstants
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_429088323 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_429088323();
		
		public BSerializer_429088323()
			: base(429088323) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteConstants(transport);
		}
		
	}
} // namespace
