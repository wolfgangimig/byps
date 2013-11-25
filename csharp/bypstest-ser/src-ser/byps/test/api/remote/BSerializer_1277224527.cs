//
// Serializer for byps.test.api.remote.BStub_RemoteMapTypes
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1277224527 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1277224527();
		
		public BSerializer_1277224527()
			: base(1277224527) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteMapTypes(transport);
		}
		
	}
} // namespace
