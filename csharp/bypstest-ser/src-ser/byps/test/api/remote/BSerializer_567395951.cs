//
// Serializer for byps.test.api.remote.BStub_RemoteInlineInstance
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_567395951 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_567395951();
		
		public BSerializer_567395951()
			: base(567395951) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteInlineInstance(transport);
		}
		
	}
} // namespace
