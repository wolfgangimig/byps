//
// Serializer for byps.test.api.BResult_2028443792
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1664501789 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1664501789();
		
		public BSerializer_1664501789()
			: base(1664501789) {}
		
		public BSerializer_1664501789(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_2028443792 obj = (BResult_2028443792)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_2028443792.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_2028443792 obj = (BResult_2028443792)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_2028443792()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:445
			obj.resultValue = (ISet<short>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
