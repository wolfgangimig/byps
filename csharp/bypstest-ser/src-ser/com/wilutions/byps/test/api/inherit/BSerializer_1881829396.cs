//
// Serializer for com.wilutions.byps.test.api.inherit.BStub_BioFruitService
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	public class BSerializer_1881829396 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1881829396();
		
		public BSerializer_1881829396()
			: base(1881829396) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_BioFruitService(transport);
		}
		
	}
} // namespace
