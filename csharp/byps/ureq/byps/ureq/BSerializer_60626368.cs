//
// Serializer for byps.ureq.BResult_1710660846
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.ureq
{
	
	public class BSerializer_60626368 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_60626368();
		
		public BSerializer_60626368()
			: base(60626368) {}
		
		public BSerializer_60626368(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1710660846 obj = (BResult_1710660846)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.resultValue, false, byps.ureq.BSerializer_1710660846.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1710660846 obj = (BResult_1710660846)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1710660846()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.resultValue = (IDictionary<String,String>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
