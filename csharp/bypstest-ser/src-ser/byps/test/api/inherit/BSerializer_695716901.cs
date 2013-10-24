//
// Serializer for byps.test.api.inherit.BRequest_PlantService_grow
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inherit
{
	
	public class BSerializer_695716901 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_695716901();
		
		public BSerializer_695716901()
			: base(695716901) {}
		
		public BSerializer_695716901(int typeId)
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
