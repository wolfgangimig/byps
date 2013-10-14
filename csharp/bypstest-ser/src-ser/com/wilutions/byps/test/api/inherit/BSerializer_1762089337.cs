//
// Serializer for com.wilutions.byps.test.api.inherit.BRequest_BioLemonService_useParing
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.inherit
{
	
	public class BSerializer_1762089337 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1762089337();
		
		public BSerializer_1762089337()
			: base(1762089337) {}
		
		public BSerializer_1762089337(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_BioLemonService_useParing obj = (BRequest_BioLemonService_useParing)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_BioLemonService_useParing()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
