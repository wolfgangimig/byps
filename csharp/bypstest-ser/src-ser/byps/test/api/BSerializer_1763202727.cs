//
// Serializer for byps.test.api.BResult_181681714
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1763202727 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1763202727();
		
		public BSerializer_1763202727()
			: base(1763202727) {}
		
		public BSerializer_1763202727(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_181681714 obj = (BResult_181681714)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_181681714.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_181681714 obj = (BResult_181681714)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_181681714()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.resultValue = (IList<int>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
