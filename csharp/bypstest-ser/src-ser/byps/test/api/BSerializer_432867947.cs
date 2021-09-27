//
// Serializer for byps.test.api.BResult_1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_432867947 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_432867947();
		
		public BSerializer_432867947()
			: base(432867947) {}
		
		public BSerializer_432867947(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1 obj = (BResult_1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putBoolean(obj.resultValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1 obj = (BResult_1)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.resultValue = bbuf.getBoolean();
			
			return obj;
		}
		
	}
} // namespace
