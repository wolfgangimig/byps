//
// Serializer for byps.test.api.remote.BStub_RemoteArrayTypes4dim
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1176051258 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1176051258();
		
		public BSerializer_1176051258()
			: base(1176051258) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteArrayTypes4dim(transport);
		}
		
	}
} // namespace
