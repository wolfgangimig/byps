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
	
	public class BSerializer_363642571 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_363642571();
		
		public BSerializer_363642571()
			: base(363642571) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_BioFruitService(transport);
		}
		
	}
} // namespace
