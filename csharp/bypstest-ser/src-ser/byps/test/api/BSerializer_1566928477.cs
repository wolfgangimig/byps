//
// Serializer for byps.test.api.BResult_2052431866
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1566928477 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1566928477();
		
		public BSerializer_1566928477()
			: base(1566928477) {}
		
		public BSerializer_1566928477(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_2052431866 obj = (BResult_2052431866)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, byps.test.api.BSerializer_2052431866.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_2052431866 obj = (BResult_2052431866)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_2052431866()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (ISet<byte[]>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
