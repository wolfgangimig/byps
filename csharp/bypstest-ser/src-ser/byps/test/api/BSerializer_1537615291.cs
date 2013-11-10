//
// Serializer for byps.test.api.BResult_588723219
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1537615291 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1537615291();
		
		public BSerializer_1537615291()
			: base(1537615291) {}
		
		public BSerializer_1537615291(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_588723219 obj = (BResult_588723219)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.resultValue, true, byps.test.api.BSerializer_588723219.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_588723219 obj = (BResult_588723219)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_588723219()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:447
			obj.resultValue = (String[,,,])bin.readObj(false, byps.test.api.BSerializer_588723219.instance);
			
			return obj;
		}
		
	}
} // namespace
