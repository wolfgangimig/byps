//
// Serializer for byps.test.api.remote.BStub_RemotePrimitiveTypes
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1391241180 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1391241180();
		
		public BSerializer_1391241180()
			: base(1391241180) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemotePrimitiveTypes(transport);
		}
		
	}
} // namespace
