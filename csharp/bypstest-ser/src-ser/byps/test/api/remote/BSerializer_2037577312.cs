//
// Serializer for byps.test.api.remote.BStub_RemoteServerCtrl
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_2037577312 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_2037577312();
		
		public BSerializer_2037577312()
			: base(2037577312) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteServerCtrl(transport);
		}
		
	}
} // namespace
