//
// Serializer for byps.test.api.BResult_2087445849
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1650981375 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1650981375();
		
		public BSerializer_1650981375()
			: base(1650981375) {}
		
		public BSerializer_1650981375(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_2087445849 obj = (BResult_2087445849)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, byps.test.api.BSerializer_2087445849.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_2087445849 obj = (BResult_2087445849)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_2087445849()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (double[,,,])bin.readObj(false, byps.test.api.BSerializer_2087445849.instance);
			
			return obj;
		}
		
	}
} // namespace
