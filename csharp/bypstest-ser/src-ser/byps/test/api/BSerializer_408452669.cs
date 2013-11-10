//
// Serializer for byps.test.api.BResult_1746702954
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_408452669 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_408452669();
		
		public BSerializer_408452669()
			: base(408452669) {}
		
		public BSerializer_408452669(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1746702954 obj = (BResult_1746702954)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_1746702954.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1746702954 obj = (BResult_1746702954)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1746702954()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:445
			obj.resultValue = (IList<IList<int>>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
