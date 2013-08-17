//
// Serializer for com.wilutions.byps.test.api.remote.BStub_RemoteArrayTypes23
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_2081058997 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_2081058997();
		
		public BSerializer_2081058997()
			: base(2081058997) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteArrayTypes23(transport);
		}
		
	}
} // namespace
