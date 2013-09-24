//
// Serializer for com.wilutions.byps.test.api.BResult_1503107601
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_72308967 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_72308967();
		
		public BSerializer_72308967()
			: base(72308967) {}
		
		public BSerializer_72308967(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1503107601 obj = (BResult_1503107601)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, com.wilutions.byps.test.api.BSerializer_1503107601.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1503107601 obj = (BResult_1503107601)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1503107601()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (com.wilutions.byps.test.api.prim.PrimitiveTypes[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1503107601.instance);
			
			return obj;
		}
		
	}
} // namespace
