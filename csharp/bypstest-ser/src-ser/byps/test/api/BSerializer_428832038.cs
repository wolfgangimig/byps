//
// Serializer for byps.test.api.BResult_1097919350
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_428832038 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_428832038();
		
		public BSerializer_428832038()
			: base(428832038) {}
		
		public BSerializer_428832038(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1097919350 obj = (BResult_1097919350)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_1097919350.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1097919350 obj = (BResult_1097919350)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1097919350()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:447
			obj.resultValue = (ISet<DateTime>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
