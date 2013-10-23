//
// Serializer for byps.test.api.BResult_2067161310
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_925799231 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_925799231();
		
		public BSerializer_925799231()
			: base(925799231) {}
		
		public BSerializer_925799231(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_2067161310 obj = (BResult_2067161310)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, byps.test.api.BSerializer_2067161310.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_2067161310 obj = (BResult_2067161310)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_2067161310()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (short[])bin.readObj(false, byps.test.api.BSerializer_2067161310.instance);
			
			return obj;
		}
		
	}
} // namespace
