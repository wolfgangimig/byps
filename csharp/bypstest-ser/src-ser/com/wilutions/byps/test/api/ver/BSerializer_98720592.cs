//
// Serializer for com.wilutions.byps.test.api.ver.BRequest_EvolveIF_getClient
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.ver
{
	
	public class BSerializer_98720592 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_98720592();
		
		public BSerializer_98720592()
			: base(98720592) {}
		
		public BSerializer_98720592(int typeId)
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
