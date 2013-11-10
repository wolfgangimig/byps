//
// Serializer for byps.test.api.BResult_846419204
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_167272824 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_167272824();
		
		public BSerializer_167272824()
			: base(167272824) {}
		
		public BSerializer_167272824(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_846419204 obj = (BResult_846419204)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_846419204.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_846419204 obj = (BResult_846419204)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_846419204()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:445
			obj.resultValue = (long[,,,])bin.readObj(false, byps.test.api.BSerializer_846419204.instance);
			
			return obj;
		}
		
	}
} // namespace
