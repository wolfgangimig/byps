//
// Serializer for com.wilutions.byps.test.api.BResult_1178379224
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1911325389 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1911325389();
		
		public BSerializer_1911325389()
			: base(1911325389) {}
		
		public BSerializer_1911325389(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1178379224 obj = (BResult_1178379224)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1178379224 obj = (BResult_1178379224)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1178379224()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (com.wilutions.byps.test.api.ver.EvolveIF)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
