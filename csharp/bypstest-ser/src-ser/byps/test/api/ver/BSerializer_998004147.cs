//
// Serializer for byps.test.api.ver.BRequest_EvolveIF_setClient
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.ver
{
	
	public class BSerializer_998004147 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_998004147();
		
		public BSerializer_998004147()
			: base(998004147) {}
		
		public BSerializer_998004147(int typeId)
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
			obj._partner = (byps.test.api.ver.EvolveIF)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
