//
// Serializer for byps.test.api.remote.BStub_RemoteWithAuthentication
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1532028880 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1532028880();
		
		public BSerializer_1532028880()
			: base(1532028880) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteWithAuthentication(transport);
		}
		
	}
} // namespace
