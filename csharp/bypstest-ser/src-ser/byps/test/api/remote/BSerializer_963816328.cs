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
	
	public class BSerializer_963816328 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_963816328();
		
		public BSerializer_963816328()
			: base(963816328) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteArrayTypes1dim(transport);
		}
		
	}
} // namespace
