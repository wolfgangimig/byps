//
// Serializer for byps.test.api.ver.BRequest_EvolveIF_getEvolve
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.ver
{
	
	public class BSerializer_1279300441 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1279300441();
		
		public BSerializer_1279300441()
			: base(1279300441) {}
		
		public BSerializer_1279300441(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_EvolveIF_getEvolve obj = (BRequest_EvolveIF_getEvolve)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_EvolveIF_getEvolve()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
