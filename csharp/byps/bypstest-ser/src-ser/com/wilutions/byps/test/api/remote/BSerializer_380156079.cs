//
// Serializer for com.wilutions.byps.test.api.remote.BStub_RemoteListTypes
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_380156079 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_380156079();
		
		public BSerializer_380156079()
			: base(380156079) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteListTypes(transport);
		}
		
	}
} // namespace
