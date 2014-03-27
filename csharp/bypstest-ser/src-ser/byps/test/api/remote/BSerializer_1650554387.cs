//
// Serializer for byps.test.api.remote.BRequest_RemoteInlineInstance_getPoint2DListList
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1650554387 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1650554387();
		
		public BSerializer_1650554387()
			: base(1650554387) {}
		
		public BSerializer_1650554387(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteInlineInstance_getPoint2DListList obj = (BRequest_RemoteInlineInstance_getPoint2DListList)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_getPoint2DListList()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
