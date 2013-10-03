//
// Serializer for com.wilutions.byps.test.api.inherit.BStub_LemonService
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	public class BSerializer_617356599 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_617356599();
		
		public BSerializer_617356599()
			: base(617356599) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_LemonService(transport);
		}
		
	}
} // namespace
