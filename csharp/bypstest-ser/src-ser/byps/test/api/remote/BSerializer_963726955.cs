//
// Serializer for byps.test.api.remote.BStub_RemoteArrayTypes4dim
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_963726955 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_963726955();
		
		public BSerializer_963726955()
			: base(963726955) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteArrayTypes4dim(transport);
		}
		
	}
} // namespace
