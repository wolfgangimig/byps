//
// Serializer for com.wilutions.byps.test.api.remote.BStub_RemoteServerCtrl
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1124545992 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1124545992();
		
		public BSerializer_1124545992()
			: base(1124545992) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteServerCtrl(transport);
		}
		
	}
} // namespace
