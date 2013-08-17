//
// Serializer for com.wilutions.byps.test.api.BResult_21
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_309901646 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_309901646();
		
		public BSerializer_309901646()
			: base(309901646) {}
		
		public BSerializer_309901646(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: result */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			BResult_21 obj = (BResult_21)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_21 obj = (BResult_21)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_21()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (Object)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
