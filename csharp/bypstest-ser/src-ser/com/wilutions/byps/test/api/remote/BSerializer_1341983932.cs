//
// Serializer for com.wilutions.byps.test.api.remote.BStub_RemotePrimitiveTypes
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1341983932 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_1341983932();
		
		public BSerializer_1341983932()
			: base(1341983932) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemotePrimitiveTypes(transport);
		}
		
	}
} // namespace
