//
// Serializer for byps.test.api.BResult_1365696060
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_809340660 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_809340660();
		
		public BSerializer_809340660()
			: base(809340660) {}
		
		public BSerializer_809340660(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1365696060 obj = (BResult_1365696060)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, byps.test.api.BSerializer_1365696060.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1365696060 obj = (BResult_1365696060)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1365696060()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (ISet<bool>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
