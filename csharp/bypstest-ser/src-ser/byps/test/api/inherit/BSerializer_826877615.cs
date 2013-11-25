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
	
	public class BSerializer_826877615 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_826877615();
		
		public BSerializer_826877615()
			: base(826877615) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_LemonService(transport);
		}
		
	}
} // namespace
