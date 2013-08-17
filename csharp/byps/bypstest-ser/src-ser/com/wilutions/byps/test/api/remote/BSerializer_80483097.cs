//
// Serializer for com.wilutions.byps.test.api.remote.BStub_RemoteMapTypes
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_80483097 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_80483097();
		
		public BSerializer_80483097()
			: base(80483097) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteMapTypes(transport);
		}
		
	}
} // namespace
