//
// Serializer for byps.test.api.inherit.BStub_BioLemonService
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inherit
{
	
	public class BSerializer_501819909 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_501819909();
		
		public BSerializer_501819909()
			: base(501819909) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_BioLemonService(transport);
		}
		
	}
} // namespace
