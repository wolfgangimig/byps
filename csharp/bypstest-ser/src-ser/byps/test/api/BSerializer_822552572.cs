//
// Serializer for byps.test.api.BResult_1488550492
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_822552572 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_822552572();
		
		public BSerializer_822552572()
			: base(822552572) {}
		
		public BSerializer_822552572(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1488550492 obj = (BResult_1488550492)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, byps.test.api.BSerializer_1488550492.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1488550492 obj = (BResult_1488550492)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1488550492()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (IDictionary<String,Object>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
