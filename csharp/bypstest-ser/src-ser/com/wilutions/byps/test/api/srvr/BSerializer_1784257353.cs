//
// Serializer for com.wilutions.byps.test.api.srvr.BStub_ClientIF
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public class BSerializer_1784257353 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1784257353();
		
		public BSerializer_1784257353()
			: base(1784257353) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_ClientIF(transport);
		}
		
	}
} // namespace
