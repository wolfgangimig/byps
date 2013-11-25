//
// Serializer for byps.test.api.remote.BStub_RemoteStreams
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_2123238175 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_2123238175();
		
		public BSerializer_2123238175()
			: base(2123238175) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteStreams(transport);
		}
		
	}
} // namespace
