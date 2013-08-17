//
// Serializer for com.wilutions.byps.test.api.ver.BStub_EvolveIF
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.ver
{
	
	public class BSerializer_2078696281 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_2078696281();
		
		public BSerializer_2078696281()
			: base(2078696281) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_EvolveIF(transport);
		}
		
	}
} // namespace
