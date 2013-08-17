//
// Serializer for com.wilutions.byps.test.api.srvr.BStub_ServerIF
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public class BSerializer_1313562065 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1313562065();
		
		public BSerializer_1313562065()
			: base(1313562065) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_ServerIF(transport);
		}
		
	}
} // namespace
