//
// Serializer for com.wilutions.byps.test.api.ver.BRequest_EvolveIF_setClient
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.ver
{
	
	public class BSerializer_313337668 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_313337668();
		
		public BSerializer_313337668()
			: base(313337668) {}
		
		public BSerializer_313337668(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_EvolveIF_setClient obj = (BRequest_EvolveIF_setClient)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._partner, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_EvolveIF_setClient obj = (BRequest_EvolveIF_setClient)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_EvolveIF_setClient()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._partner = (com.wilutions.byps.test.api.ver.EvolveIF)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
