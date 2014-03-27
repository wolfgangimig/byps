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
	
	public class BSerializer_1983670399 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1983670399();
		
		public BSerializer_1983670399()
			: base(1983670399) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteWithAuthentication(transport);
		}
		
	}
} // namespace
