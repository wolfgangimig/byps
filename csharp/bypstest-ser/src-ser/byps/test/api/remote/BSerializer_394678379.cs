//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getString
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_394678379 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_394678379();
		
		public BSerializer_394678379()
			: base(394678379) {}
		
		public BSerializer_394678379(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes1dim_getString obj = (BRequest_RemoteArrayTypes1dim_getString)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes1dim_getString()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
