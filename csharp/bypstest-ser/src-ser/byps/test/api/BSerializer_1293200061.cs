//
// Serializer for byps.test.api.BResult_1633750383
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1293200061 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1293200061();
		
		public BSerializer_1293200061()
			: base(1293200061) {}
		
		public BSerializer_1293200061(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1633750383 obj = (BResult_1633750383)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_1633750383.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1633750383 obj = (BResult_1633750383)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1633750383()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.resultValue = (IDictionary<int,int[]>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
