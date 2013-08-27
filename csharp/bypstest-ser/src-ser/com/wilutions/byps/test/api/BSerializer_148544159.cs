//
// Serializer for com.wilutions.byps.test.api.BResult_4
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_148544159 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_148544159();
		
		public BSerializer_148544159()
			: base(148544159) {}
		
		public BSerializer_148544159(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: result */ + 2			
			       /* padding up to multiple of alignment */ + 6;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_4 obj = (BResult_4)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putChar(obj._result);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_4 obj = (BResult_4)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_4()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = bbuf.getChar();
			
			return obj;
		}
		
	}
} // namespace
