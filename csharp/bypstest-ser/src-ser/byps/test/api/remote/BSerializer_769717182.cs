//
// Serializer for byps.test.api.remote.BStub_RemoteArrayTypes23
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_769717182 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_769717182();
		
		public BSerializer_769717182()
			: base(769717182) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteArrayTypes23(transport);
		}
		
	}
} // namespace
