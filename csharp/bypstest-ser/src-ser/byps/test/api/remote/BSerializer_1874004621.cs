//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getLong
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1874004621 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1874004621();
		
		public BSerializer_1874004621()
			: base(1874004621) {}
		
		public BSerializer_1874004621(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes4dim_getLong obj = (BRequest_RemoteArrayTypes4dim_getLong)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_getLong()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
