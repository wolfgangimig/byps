//
// Serializer for byps.test.api.BResult_1174971318
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1068483136 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1068483136();
		
		public BSerializer_1068483136()
			: base(1068483136) {}
		
		public BSerializer_1068483136(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1174971318 obj = (BResult_1174971318)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, byps.test.api.BSerializer_1174971318.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1174971318 obj = (BResult_1174971318)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1174971318()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (IList<byte[]>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
