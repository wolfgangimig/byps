//
// Serializer for byps.test.api.BResult_1050216688
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_70523627 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_70523627();
		
		public BSerializer_70523627()
			: base(70523627) {}
		
		public BSerializer_70523627(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1050216688 obj = (BResult_1050216688)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_1050216688.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1050216688 obj = (BResult_1050216688)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1050216688()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:445
			obj.resultValue = (IList<long>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
