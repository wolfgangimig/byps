//
// Serializer for byps.test.api.srvr.BStub_ServerIF
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.srvr
{
	
	public class BSerializer_1426448279 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1426448279();
		
		public BSerializer_1426448279()
			: base(1426448279) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_ServerIF(transport);
		}
		
	}
} // namespace
