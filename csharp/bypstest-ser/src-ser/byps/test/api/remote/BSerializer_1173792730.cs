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
	
	public class BSerializer_1173792730 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1173792730();
		
		public BSerializer_1173792730()
			: base(1173792730) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteReferences(transport);
		}
		
	}
} // namespace
