//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getBool
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1874302495 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1874302495();
		
		public BSerializer_1874302495()
			: base(1874302495) {}
		
		public BSerializer_1874302495(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes4dim_getBool obj = (BRequest_RemoteArrayTypes4dim_getBool)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_getBool()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
