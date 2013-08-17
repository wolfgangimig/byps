//
// Serializer for com.wilutions.byps.test.api.ver.BRequest_EvolveIF_setEvolve
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.ver
{
	
	public class BSerializer_246658450 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_246658450();
		
		public BSerializer_246658450()
			: base(246658450) {}
		
		public BSerializer_246658450(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: obj */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			BRequest_EvolveIF_setEvolve obj = (BRequest_EvolveIF_setEvolve)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._obj, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_EvolveIF_setEvolve obj = (BRequest_EvolveIF_setEvolve)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_EvolveIF_setEvolve()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._obj = (com.wilutions.byps.test.api.ver.Evolve)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
