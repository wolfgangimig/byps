//
// Serializer for byps.test.api.inherit.BRequest_BioLemonService_useParing
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inherit
{
	
	public class BSerializer_2108700976 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2108700976();
		
		public BSerializer_2108700976()
			: base(2108700976) {}
		
		public BSerializer_2108700976(int typeId)
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
