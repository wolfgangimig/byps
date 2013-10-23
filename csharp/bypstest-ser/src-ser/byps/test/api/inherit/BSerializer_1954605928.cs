//
// Serializer for byps.test.api.inherit.BStub_PlantService
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inherit
{
	
	public class BSerializer_1954605928 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1954605928();
		
		public BSerializer_1954605928()
			: base(1954605928) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_PlantService(transport);
		}
		
	}
} // namespace
