//
// Serializer for byps.test.api.BResult_1457164460
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1111888832 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1111888832();
		
		public BSerializer_1111888832()
			: base(1111888832) {}
		
		public BSerializer_1111888832(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1457164460 obj = (BResult_1457164460)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_1457164460.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1457164460 obj = (BResult_1457164460)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1457164460()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.resultValue = (ISet<long>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
