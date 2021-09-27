//
// Serializer for byps.test.api.BResult_124584219
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_996163680 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_996163680();
		
		public BSerializer_996163680()
			: base(996163680) {}
		
		public BSerializer_996163680(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_124584219 obj = (BResult_124584219)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_124584219.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_124584219 obj = (BResult_124584219)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_124584219()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.resultValue = (Object[,,,])bin.readObj(false, byps.test.api.BSerializer_124584219.instance);
			
			return obj;
		}
		
	}
} // namespace
