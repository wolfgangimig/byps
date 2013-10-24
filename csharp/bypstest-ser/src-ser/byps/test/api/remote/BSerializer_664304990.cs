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
	
	public class BSerializer_664304990 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_664304990();
		
		public BSerializer_664304990()
			: base(664304990) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteMapTypes(transport);
		}
		
	}
} // namespace
