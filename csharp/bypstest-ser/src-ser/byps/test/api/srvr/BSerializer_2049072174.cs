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
	
	public class BSerializer_2049072174 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_2049072174();
		
		public BSerializer_2049072174()
			: base(2049072174) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_ClientIF(transport);
		}
		
	}
} // namespace
