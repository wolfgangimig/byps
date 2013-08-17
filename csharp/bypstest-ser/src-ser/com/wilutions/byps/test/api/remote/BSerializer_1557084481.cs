//
// Serializer for com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes1dim
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1557084481 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1557084481();
		
		public BSerializer_1557084481()
			: base(1557084481) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteArrayTypes1dim(transport);
		}
		
	}
} // namespace
