//
// Serializer for com.wilutions.byps.test.api.remote.BStub_RemoteInlineInstance
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1206670536 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1206670536();
		
		public BSerializer_1206670536()
			: base(1206670536) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteInlineInstance(transport);
		}
		
	}
} // namespace
