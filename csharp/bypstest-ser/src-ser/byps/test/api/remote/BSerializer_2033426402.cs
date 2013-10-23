//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getByte
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_2033426402 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2033426402();
		
		public BSerializer_2033426402()
			: base(2033426402) {}
		
		public BSerializer_2033426402(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes1dim_getByte obj = (BRequest_RemoteArrayTypes1dim_getByte)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes1dim_getByte()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
