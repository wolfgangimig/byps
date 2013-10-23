//
// Serializer for byps.test.api.remote.BRequest_RemoteSetTypes_getByte2
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_901695824 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_901695824();
		
		public BSerializer_901695824()
			: base(901695824) {}
		
		public BSerializer_901695824(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteSetTypes_getByte2 obj = (BRequest_RemoteSetTypes_getByte2)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_getByte2()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
