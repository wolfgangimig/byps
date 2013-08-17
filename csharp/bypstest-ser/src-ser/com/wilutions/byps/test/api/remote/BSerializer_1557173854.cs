//
// Serializer for com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes4dim
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1557173854 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1557173854();
		
		public BSerializer_1557173854()
			: base(1557173854) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteArrayTypes4dim(transport);
		}
		
	}
} // namespace
