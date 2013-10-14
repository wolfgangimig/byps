//
// Serializer for com.wilutions.byps.test.api.inherit.BStub_PlantService
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	public class BSerializer_1117460801 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1117460801();
		
		public BSerializer_1117460801()
			: base(1117460801) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_PlantService(transport);
		}
		
	}
} // namespace
