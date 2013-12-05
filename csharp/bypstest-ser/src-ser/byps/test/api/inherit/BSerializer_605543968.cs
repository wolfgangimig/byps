//
// Serializer for byps.test.api.inherit.BStub_LemonService
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inherit
{
	
	public class BSerializer_605543968 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_605543968();
		
		public BSerializer_605543968()
			: base(605543968) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_LemonService(transport);
		}
		
	}
} // namespace
