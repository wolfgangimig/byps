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
	
	public class BSerializer_964138163 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_964138163();
		
		public BSerializer_964138163()
			: base(964138163) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteArrayTypes23(transport);
		}
		
	}
} // namespace
