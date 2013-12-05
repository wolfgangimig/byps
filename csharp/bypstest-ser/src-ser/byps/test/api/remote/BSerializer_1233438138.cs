//
// Serializer for byps.test.api.remote.BStub_RemoteListTypes
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1233438138 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1233438138();
		
		public BSerializer_1233438138()
			: base(1233438138) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteListTypes(transport);
		}
		
	}
} // namespace
