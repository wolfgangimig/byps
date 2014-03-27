//
// Serializer for byps.test.api.BResult_766441794
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1167917980 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1167917980();
		
		public BSerializer_1167917980()
			: base(1167917980) {}
		
		public BSerializer_1167917980(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_766441794 obj = (BResult_766441794)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_766441794.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_766441794 obj = (BResult_766441794)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_766441794()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.resultValue = (float[])bin.readObj(false, byps.test.api.BSerializer_766441794.instance);
			
			return obj;
		}
		
	}
} // namespace
