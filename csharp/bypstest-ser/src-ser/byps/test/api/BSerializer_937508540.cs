//
// Serializer for byps.test.api.BResult_2064980445
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_937508540 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_937508540();
		
		public BSerializer_937508540()
			: base(937508540) {}
		
		public BSerializer_937508540(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_2064980445 obj = (BResult_2064980445)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_2064980445.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_2064980445 obj = (BResult_2064980445)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_2064980445()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:445
			obj.resultValue = (IList<byps.test.api.inl.Point2D>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
