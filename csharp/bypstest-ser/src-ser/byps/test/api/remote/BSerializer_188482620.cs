//
// Serializer for byps.test.api.remote.BRequest_RemoteInlineInstance_getPoint2DArray4dim
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_188482620 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_188482620();
		
		public BSerializer_188482620()
			: base(188482620) {}
		
		public BSerializer_188482620(int typeId)
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
