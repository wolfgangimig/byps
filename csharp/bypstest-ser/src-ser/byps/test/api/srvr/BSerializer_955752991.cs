//
// Serializer for byps.test.api.srvr.BStub_ClientIF
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.srvr
{
	
	public class BSerializer_955752991 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_955752991();
		
		public BSerializer_955752991()
			: base(955752991) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_ClientIF(transport);
		}
		
	}
} // namespace
