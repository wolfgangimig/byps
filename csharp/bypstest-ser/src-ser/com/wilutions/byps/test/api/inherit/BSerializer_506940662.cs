//
// Serializer for com.wilutions.byps.test.api.inherit.BStub_FruitService
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	public class BSerializer_506940662 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_506940662();
		
		public BSerializer_506940662()
			: base(506940662) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_FruitService(transport);
		}
		
	}
} // namespace
