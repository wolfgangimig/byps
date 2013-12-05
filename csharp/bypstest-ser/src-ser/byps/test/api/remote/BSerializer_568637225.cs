//
// Serializer for byps.test.api.remote.BStub_RemoteReferences
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_568637225 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_568637225();
		
		public BSerializer_568637225()
			: base(568637225) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteReferences(transport);
		}
		
	}
} // namespace
