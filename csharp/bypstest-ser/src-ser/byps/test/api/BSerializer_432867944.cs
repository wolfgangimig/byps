//
// Serializer for byps.test.api.BResult_4
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_432867944 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_432867944();
		
		public BSerializer_432867944()
			: base(432867944) {}
		
		public BSerializer_432867944(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_4 obj = (BResult_4)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putChar(obj.resultValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_4 obj = (BResult_4)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_4()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.resultValue = bbuf.getChar();
			
			return obj;
		}
		
	}
} // namespace
