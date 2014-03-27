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
	
	public class BSerializer_485761455 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_485761455();
		
		public BSerializer_485761455()
			: base(485761455) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteEnums(transport);
		}
		
	}
} // namespace
