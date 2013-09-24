//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getActor
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_261822861 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_261822861();
		
		public BSerializer_261822861()
			: base(261822861) {}
		
		public BSerializer_261822861(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteInlineInstance_getActor obj = (BRequest_RemoteInlineInstance_getActor)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_getActor()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
