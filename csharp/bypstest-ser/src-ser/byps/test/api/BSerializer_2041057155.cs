//
// Serializer for byps.test.api.BResult_1320560671
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_2041057155 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2041057155();
		
		public BSerializer_2041057155()
			: base(2041057155) {}
		
		public BSerializer_2041057155(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1320560671 obj = (BResult_1320560671)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_1320560671.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1320560671 obj = (BResult_1320560671)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1320560671()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.resultValue = (ISet<double>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
