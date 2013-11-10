//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getDate
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_2033462920 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2033462920();
		
		public BSerializer_2033462920()
			: base(2033462920) {}
		
		public BSerializer_2033462920(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes1dim_getDate obj = (BRequest_RemoteArrayTypes1dim_getDate)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes1dim_getDate()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
