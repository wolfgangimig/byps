//
// Serializer for byps.test.api.inherit.BRequest_FruitService_squeeze
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inherit
{
	
	public class BSerializer_1290167289 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1290167289();
		
		public BSerializer_1290167289()
			: base(1290167289) {}
		
		public BSerializer_1290167289(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_FruitService_squeeze obj = (BRequest_FruitService_squeeze)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_FruitService_squeeze()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
