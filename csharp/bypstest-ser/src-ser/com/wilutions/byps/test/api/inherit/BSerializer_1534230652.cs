//
// Serializer for com.wilutions.byps.test.api.inherit.BRequest_PlantService_grow
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	public class BSerializer_1534230652 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1534230652();
		
		public BSerializer_1534230652()
			: base(1534230652) {}
		
		public BSerializer_1534230652(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_PlantService_grow obj = (BRequest_PlantService_grow)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_PlantService_grow()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
