//
// Serializer for byps.test.api.BResult_51898890
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_905019472 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_905019472();
		
		public BSerializer_905019472()
			: base(905019472) {}
		
		public BSerializer_905019472(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_51898890 obj = (BResult_51898890)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_51898890.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_51898890 obj = (BResult_51898890)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_51898890()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.resultValue = (DateTime[,,,])bin.readObj(false, byps.test.api.BSerializer_51898890.instance);
			
			return obj;
		}
		
	}
} // namespace
