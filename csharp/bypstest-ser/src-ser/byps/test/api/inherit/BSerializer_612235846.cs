//
// Serializer for byps.test.api.inherit.BStub_BioFruitService
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inherit
{
	
	public class BSerializer_612235846 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_612235846();
		
		public BSerializer_612235846()
			: base(612235846) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_BioFruitService(transport);
		}
		
	}
} // namespace
