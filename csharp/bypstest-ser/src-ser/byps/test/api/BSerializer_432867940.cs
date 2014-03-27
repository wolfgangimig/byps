//
// Serializer for byps.test.api.BResult_8
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_432867940 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_432867940();
		
		public BSerializer_432867940()
			: base(432867940) {}
		
		public BSerializer_432867940(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_8 obj = (BResult_8)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putDouble(obj.resultValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_8 obj = (BResult_8)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_8()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.resultValue = bbuf.getDouble();
			
			return obj;
		}
		
	}
} // namespace
