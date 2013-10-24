//
// Serializer for byps.test.api.BResult_2058423690
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1698849803 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1698849803();
		
		public BSerializer_1698849803()
			: base(1698849803) {}
		
		public BSerializer_1698849803(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_2058423690 obj = (BResult_2058423690)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, byps.test.api.BSerializer_2058423690.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_2058423690 obj = (BResult_2058423690)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_2058423690()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (bool[])bin.readObj(false, byps.test.api.BSerializer_2058423690.instance);
			
			return obj;
		}
		
	}
} // namespace
