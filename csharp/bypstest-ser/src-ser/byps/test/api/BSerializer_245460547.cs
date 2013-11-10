//
// Serializer for byps.test.api.BResult_39910537
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_245460547 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_245460547();
		
		public BSerializer_245460547()
			: base(245460547) {}
		
		public BSerializer_245460547(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_39910537 obj = (BResult_39910537)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_39910537.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_39910537 obj = (BResult_39910537)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_39910537()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:445
			obj.resultValue = (int[,,,])bin.readObj(false, byps.test.api.BSerializer_39910537.instance);
			
			return obj;
		}
		
	}
} // namespace
