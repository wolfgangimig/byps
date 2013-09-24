//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getByte2
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_2125684551 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2125684551();
		
		public BSerializer_2125684551()
			: base(2125684551) {}
		
		public BSerializer_2125684551(int typeId)
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
