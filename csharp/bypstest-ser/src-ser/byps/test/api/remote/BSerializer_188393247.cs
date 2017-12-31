//
// Serializer for byps.test.api.remote.BRequest_RemoteInlineInstance_getPoint2DArray1dim
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_188393247 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_188393247();
		
		public BSerializer_188393247()
			: base(188393247) {}
		
		public BSerializer_188393247(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteInlineInstance_getPoint2DArray1dim obj = (BRequest_RemoteInlineInstance_getPoint2DArray1dim)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_getPoint2DArray1dim()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
