//
// Serializer for byps.test.api.remote.BStub_RemoteArrayTypes1dim
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_123123 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_123123();
		
		public BSerializer_123123()
			: base(123123) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteArrayTypes1dim(transport);
		}
		
	}
} // namespace
