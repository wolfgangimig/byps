//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getInt
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1325018648 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1325018648();
		
		public BSerializer_1325018648()
			: base(1325018648) {}
		
		public BSerializer_1325018648(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes4dim_getInt obj = (BRequest_RemoteArrayTypes4dim_getInt)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_getInt()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
