//
// Serializer for byps.test.api.ver.BRequest_EvolveIF_setEvolve
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.ver
{
	
	public class BSerializer_1064683365 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1064683365();
		
		public BSerializer_1064683365()
			: base(1064683365) {}
		
		public BSerializer_1064683365(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_EvolveIF_setEvolve obj = (BRequest_EvolveIF_setEvolve)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._obj, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_EvolveIF_setEvolve obj = (BRequest_EvolveIF_setEvolve)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_EvolveIF_setEvolve()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._obj = (byps.test.api.ver.Evolve)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
