//
// Serializer for byps.test.api.inherit.BStub_FruitService
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inherit
{
	
	public class BSerializer_937293552 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_937293552();
		
		public BSerializer_937293552()
			: base(937293552) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_FruitService(transport);
		}
		
	}
} // namespace
