//
// Serializer for byps.test.api.comp.BStub_IncompatibleChangeIF
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.comp
{
	
	public class BSerializer_88979576 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_88979576();
		
		public BSerializer_88979576()
			: base(88979576) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_IncompatibleChangeIF(transport);
		}
		
	}
} // namespace
