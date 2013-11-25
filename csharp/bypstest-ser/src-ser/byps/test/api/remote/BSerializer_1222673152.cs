//
// Serializer for byps.test.api.remote.BStub_RemoteEnums
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1222673152 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1222673152();
		
		public BSerializer_1222673152()
			: base(1222673152) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteEnums(transport);
		}
		
	}
} // namespace
