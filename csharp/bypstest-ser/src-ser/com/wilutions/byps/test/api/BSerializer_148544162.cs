//
// Serializer for com.wilutions.byps.test.api.BResult_1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_148544162 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_148544162();
		
		public BSerializer_148544162()
			: base(148544162) {}
		
		public BSerializer_148544162(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: result */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1 obj = (BResult_1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putBoolean(obj._result);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1 obj = (BResult_1)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = bbuf.getBoolean();
			
			return obj;
		}
		
	}
} // namespace
