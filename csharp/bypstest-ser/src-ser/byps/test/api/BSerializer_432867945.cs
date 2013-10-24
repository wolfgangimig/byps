//
// Serializer for byps.test.api.BResult_3
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_432867945 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_432867945();
		
		public BSerializer_432867945()
			: base(432867945) {}
		
		public BSerializer_432867945(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_3 obj = (BResult_3)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putShort(obj._result);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_3 obj = (BResult_3)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_3()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = bbuf.getShort();
			
			return obj;
		}
		
	}
} // namespace
