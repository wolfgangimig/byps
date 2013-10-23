//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getInt
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1874061867 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1874061867();
		
		public BSerializer_1874061867()
			: base(1874061867) {}
		
		public BSerializer_1874061867(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes1dim_getInt obj = (BRequest_RemoteArrayTypes1dim_getInt)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes1dim_getInt()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
