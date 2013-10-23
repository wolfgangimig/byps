//
// Serializer for byps.test.api.BResult_8789515
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_323111619 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_323111619();
		
		public BSerializer_323111619()
			: base(323111619) {}
		
		public BSerializer_323111619(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_8789515 obj = (BResult_8789515)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, byps.test.api.BSerializer_8789515.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_8789515 obj = (BResult_8789515)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_8789515()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (Dictionary<float,char>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
