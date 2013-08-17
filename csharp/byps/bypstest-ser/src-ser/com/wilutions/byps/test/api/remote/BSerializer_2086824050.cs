//
// Serializer for com.wilutions.byps.test.api.remote.BStub_RemoteReferences
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_2086824050 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_2086824050();
		
		public BSerializer_2086824050()
			: base(2086824050) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteReferences(transport);
		}
		
	}
} // namespace
