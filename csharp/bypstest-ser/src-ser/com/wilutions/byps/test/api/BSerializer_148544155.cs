//
// Serializer for com.wilutions.byps.test.api.BResult_8
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_148544155 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_148544155();
		
		public BSerializer_148544155()
			: base(148544155) {}
		
		public BSerializer_148544155(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_8 obj = (BResult_8)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putDouble(obj._result);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_8 obj = (BResult_8)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_8()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = bbuf.getDouble();
			
			return obj;
		}
		
	}
} // namespace
