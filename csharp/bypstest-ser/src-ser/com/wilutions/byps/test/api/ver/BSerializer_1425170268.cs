//
// Serializer for com.wilutions.byps.test.api.ver.BRequest_EvolveIF_sendEvolveToClient
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.ver
{
	
	public class BSerializer_1425170268 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1425170268();
		
		public BSerializer_1425170268()
			: base(1425170268) {}
		
		public BSerializer_1425170268(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* padding up to multiple of alignment */ + 0;			
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_EvolveIF_sendEvolveToClient obj = (BRequest_EvolveIF_sendEvolveToClient)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_EvolveIF_sendEvolveToClient()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
