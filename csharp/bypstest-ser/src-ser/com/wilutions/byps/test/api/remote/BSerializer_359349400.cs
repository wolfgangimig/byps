//
// Serializer for com.wilutions.byps.test.api.remote.BStub_RemoteEnums
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_359349400 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_359349400();
		
		public BSerializer_359349400()
			: base(359349400) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteEnums(transport);
		}
		
	}
} // namespace
