//
// Serializer for byps.test.api.inherit.BRequest_BioFruitService_certify
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.inherit
{
	
	public class BSerializer_1435417025 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1435417025();
		
		public BSerializer_1435417025()
			: base(1435417025) {}
		
		public BSerializer_1435417025(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_BioFruitService_certify obj = (BRequest_BioFruitService_certify)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putString(obj._param);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_BioFruitService_certify obj = (BRequest_BioFruitService_certify)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_BioFruitService_certify()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._param = bbuf.getString();
			
			return obj;
		}
		
	}
} // namespace
