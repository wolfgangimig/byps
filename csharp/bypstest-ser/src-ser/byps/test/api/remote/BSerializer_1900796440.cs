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
	
	public class BSerializer_1900796440 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1900796440();
		
		public BSerializer_1900796440()
			: base(1900796440) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteSetTypes(transport);
		}
		
	}
} // namespace
