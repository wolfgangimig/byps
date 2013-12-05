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
	
	public class BSerializer_2045242510 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_2045242510();
		
		public BSerializer_2045242510()
			: base(2045242510) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteConstants(transport);
		}
		
	}
} // namespace
