//
// Serializer for byps.test.api.BResult_184101377
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_748770738 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_748770738();
		
		public BSerializer_748770738()
			: base(748770738) {}
		
		public BSerializer_748770738(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_184101377 obj = (BResult_184101377)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, byps.test.api.BSerializer_184101377.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_184101377 obj = (BResult_184101377)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_184101377()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (byps.test.api.inl.Point2D[])bin.readObj(false, byps.test.api.BSerializer_184101377.instance);
			
			return obj;
		}
		
	}
} // namespace
