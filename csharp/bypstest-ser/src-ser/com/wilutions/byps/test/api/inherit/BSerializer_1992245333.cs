//
// Serializer for com.wilutions.byps.test.api.inherit.BStub_BioLemonService
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	public class BSerializer_1992245333 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1992245333();
		
		public BSerializer_1992245333()
			: base(1992245333) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_BioLemonService(transport);
		}
		
	}
} // namespace
