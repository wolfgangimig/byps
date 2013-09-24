//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getPoint2DArray4dim
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1012059475 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1012059475();
		
		public BSerializer_1012059475()
			: base(1012059475) {}
		
		public BSerializer_1012059475(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteInlineInstance_getPoint2DArray4dim obj = (BRequest_RemoteInlineInstance_getPoint2DArray4dim)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_getPoint2DArray4dim()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
