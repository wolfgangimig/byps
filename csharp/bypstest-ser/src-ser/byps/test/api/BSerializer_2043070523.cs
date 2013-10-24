//
// Serializer for byps.test.api.BResult_1516687588
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_2043070523 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2043070523();
		
		public BSerializer_2043070523()
			: base(2043070523) {}
		
		public BSerializer_2043070523(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1516687588 obj = (BResult_1516687588)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, byps.test.api.BSerializer_1516687588.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1516687588 obj = (BResult_1516687588)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1516687588()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (float[,,,])bin.readObj(false, byps.test.api.BSerializer_1516687588.instance);
			
			return obj;
		}
		
	}
} // namespace
