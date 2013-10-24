//
// Serializer for byps.test.api.BResult_1097129250
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_200721390 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_200721390();
		
		public BSerializer_200721390()
			: base(200721390) {}
		
		public BSerializer_200721390(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1097129250 obj = (BResult_1097129250)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, byps.test.api.BSerializer_1097129250.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1097129250 obj = (BResult_1097129250)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1097129250()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (long[])bin.readObj(false, byps.test.api.BSerializer_1097129250.instance);
			
			return obj;
		}
		
	}
} // namespace
