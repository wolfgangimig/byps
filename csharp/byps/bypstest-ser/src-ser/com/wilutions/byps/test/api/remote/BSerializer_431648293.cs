//
// Serializer for com.wilutions.byps.test.api.remote.BStub_RemoteConstants
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_431648293 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_431648293();
		
		public BSerializer_431648293()
			: base(431648293) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteConstants(transport);
		}
		
	}
} // namespace
