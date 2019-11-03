//
// Serializer for byps.test.api.remote.BStub_RemoteProcessingEx
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_790485113 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_790485113();
		
		public BSerializer_790485113()
			: base(790485113) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteProcessingEx(transport);
		}
		
	}
} // namespace
