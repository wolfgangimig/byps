//
// Serializer for byps.test.api.BResult_14
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_534004417 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_534004417();
		
		public BSerializer_534004417()
			: base(534004417) {}
		
		public BSerializer_534004417(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_14 obj = (BResult_14)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.resultValue, false, byps.BSerializer_14.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_14 obj = (BResult_14)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_14()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:445
			obj.resultValue = (ISet<Object>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
