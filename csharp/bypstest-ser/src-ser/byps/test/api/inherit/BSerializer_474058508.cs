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
	
	public class BSerializer_474058508 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_474058508();
		
		public BSerializer_474058508()
			: base(474058508) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_BioLemonService(transport);
		}
		
	}
} // namespace
