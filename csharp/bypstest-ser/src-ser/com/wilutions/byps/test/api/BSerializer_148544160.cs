//
// Serializer for com.wilutions.byps.test.api.BResult_3
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_148544160 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_148544160();
		
		public BSerializer_148544160()
			: base(148544160) {}
		
		public BSerializer_148544160(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: result */ + 2			
			       /* padding up to multiple of alignment */ + 6;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			BResult_3 obj = (BResult_3)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putShort(obj._result);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_3 obj = (BResult_3)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_3()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = bbuf.getShort();
			
			return obj;
		}
		
	}
} // namespace
