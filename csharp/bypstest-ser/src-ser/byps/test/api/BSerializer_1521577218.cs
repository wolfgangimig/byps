//
// Serializer for byps.test.api.BResult_1201775504
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1521577218 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1521577218();
		
		public BSerializer_1521577218()
			: base(1521577218) {}
		
		public BSerializer_1521577218(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1201775504 obj = (BResult_1201775504)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, byps.test.api.BSerializer_1201775504.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1201775504 obj = (BResult_1201775504)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1201775504()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (byte[,,,])bin.readObj(false, byps.test.api.BSerializer_1201775504.instance);
			
			return obj;
		}
		
	}
} // namespace
