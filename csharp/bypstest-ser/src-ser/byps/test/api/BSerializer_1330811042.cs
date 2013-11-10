//
// Serializer for byps.test.api.BResult_1617670280
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1330811042 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1330811042();
		
		public BSerializer_1330811042()
			: base(1330811042) {}
		
		public BSerializer_1330811042(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1617670280 obj = (BResult_1617670280)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_1617670280.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1617670280 obj = (BResult_1617670280)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1617670280()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:445
			obj.resultValue = (IList<bool>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
