//
// Serializer for com.wilutions.byps.test.api.remote.BStub_RemoteWithAuthentication
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1677934392 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1677934392();
		
		public BSerializer_1677934392()
			: base(1677934392) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteWithAuthentication(transport);
		}
		
	}
} // namespace
