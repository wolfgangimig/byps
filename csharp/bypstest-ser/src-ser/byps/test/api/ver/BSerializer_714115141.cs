//
// Serializer for byps.test.api.ver.BRequest_EvolveIF_sendEvolveToClient
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.ver
{
	
	public class BSerializer_714115141 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_714115141();
		
		public BSerializer_714115141()
			: base(714115141) {}
		
		public BSerializer_714115141(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_EvolveIF_sendEvolveToClient obj = (BRequest_EvolveIF_sendEvolveToClient)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_EvolveIF_sendEvolveToClient()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
