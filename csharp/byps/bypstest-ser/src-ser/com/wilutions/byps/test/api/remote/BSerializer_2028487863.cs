//
// Serializer for com.wilutions.byps.test.api.remote.BStub_RemoteStreams
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_2028487863 : BSerializer_16 {
		
		public readonly static BSerializer instance = new BSerializer_2028487863();
		
		public BSerializer_2028487863()
			: base(2028487863) {}
		
		protected override BRemote internalCreate(BTransport transport) {
			return new BStub_RemoteStreams(transport);
		}
		
	}
} // namespace
