//
// Serializer for byps.test.api.remote.BStub_RemoteSetTypes
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1781251319 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1781251319();
		
		public BSerializer_1781251319()
			: base(1781251319) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteSetTypes(transport);
		}
		
	}
} // namespace
