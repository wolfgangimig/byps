//
// Serializer for byps.test.api.BResult_476459792
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_255681041 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_255681041();
		
		public BSerializer_255681041()
			: base(255681041) {}
		
		public BSerializer_255681041(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_476459792 obj = (BResult_476459792)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_476459792.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_476459792 obj = (BResult_476459792)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_476459792()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:447
			obj.resultValue = (Dictionary<int,System.IO.Stream>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
