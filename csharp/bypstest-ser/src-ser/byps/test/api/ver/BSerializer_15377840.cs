//
// Serializer for byps.test.api.ver.BStub_EvolveIF
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.ver
{
	
	public class BSerializer_15377840 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_15377840();
		
		public BSerializer_15377840()
			: base(15377840) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_EvolveIF(transport);
		}
		
	}
} // namespace
