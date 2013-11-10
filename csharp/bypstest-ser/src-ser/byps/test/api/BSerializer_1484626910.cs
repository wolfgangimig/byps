//
// Serializer for byps.test.api.BResult_1374008726
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1484626910 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1484626910();
		
		public BSerializer_1484626910()
			: base(1484626910) {}
		
		public BSerializer_1484626910(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1374008726 obj = (BResult_1374008726)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_1374008726.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1374008726 obj = (BResult_1374008726)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1374008726()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:445
			obj.resultValue = (byte[])bin.readObj(false, byps.test.api.BSerializer_1374008726.instance);
			
			return obj;
		}
		
	}
} // namespace
