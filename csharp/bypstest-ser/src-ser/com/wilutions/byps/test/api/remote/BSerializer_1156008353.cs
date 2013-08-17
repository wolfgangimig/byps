//
// Serializer for com.wilutions.byps.test.api.remote.BStub_RemoteSetTypes
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1156008353 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1156008353();
		
		public BSerializer_1156008353()
			: base(1156008353) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteSetTypes(transport);
		}
		
	}
} // namespace
