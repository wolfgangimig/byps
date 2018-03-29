//
// Serializer for byps.test.api.ver.BRequest_EvolveIF_getClient
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.ver
{
	
	public class BSerializer_1212621223 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1212621223();
		
		public BSerializer_1212621223()
			: base(1212621223) {}
		
		public BSerializer_1212621223(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_EvolveIF_getClient obj = (BRequest_EvolveIF_getClient)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_EvolveIF_getClient()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
