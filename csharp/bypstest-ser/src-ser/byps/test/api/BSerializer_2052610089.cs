//
// Serializer for byps.test.api.BResult_1799280818
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_2052610089 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2052610089();
		
		public BSerializer_2052610089()
			: base(2052610089) {}
		
		public BSerializer_2052610089(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1799280818 obj = (BResult_1799280818)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, byps.test.api.BSerializer_1799280818.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1799280818 obj = (BResult_1799280818)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1799280818()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (IDictionary<int,byte[]>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
