//
// Serializer for byps.test.api.BResult_758319514
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1168951451 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1168951451();
		
		public BSerializer_1168951451()
			: base(1168951451) {}
		
		public BSerializer_1168951451(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_758319514 obj = (BResult_758319514)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, byps.test.api.BSerializer_758319514.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_758319514 obj = (BResult_758319514)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_758319514()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (byps.test.api.prim.PrimitiveTypes[,,,])bin.readObj(false, byps.test.api.BSerializer_758319514.instance);
			
			return obj;
		}
		
	}
} // namespace
