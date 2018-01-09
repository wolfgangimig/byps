//
// Serializer for byps.test.api.BResult_17
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_534004414 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_534004414();
		
		public BSerializer_534004414()
			: base(534004414) {}
		
		public BSerializer_534004414(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_17 obj = (BResult_17)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putDate(obj.resultValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_17 obj = (BResult_17)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_17()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.resultValue = bbuf.getDate();
			
			return obj;
		}
		
	}
} // namespace
