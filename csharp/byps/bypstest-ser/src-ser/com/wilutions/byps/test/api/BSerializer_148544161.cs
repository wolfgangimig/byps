//
// Serializer for com.wilutions.byps.test.api.BResult_2
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_148544161 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_148544161();
		
		public BSerializer_148544161()
			: base(148544161) {}
		
		public BSerializer_148544161(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: result */ + 1			
			       /* padding up to multiple of alignment */ + 7;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			BResult_2 obj = (BResult_2)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putByte(obj._result);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_2 obj = (BResult_2)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_2()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = bbuf.getByte();
			
			return obj;
		}
		
	}
} // namespace
