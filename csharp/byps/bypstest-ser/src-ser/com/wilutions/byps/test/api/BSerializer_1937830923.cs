//
// Serializer for com.wilutions.byps.test.api.BResult_801243127
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1937830923 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1937830923();
		
		public BSerializer_1937830923()
			: base(1937830923) {}
		
		public BSerializer_1937830923(int typeId)
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
			BResult_801243127 obj = (BResult_801243127)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, com.wilutions.byps.test.api.BSerializer_801243127.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_801243127 obj = (BResult_801243127)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_801243127()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (com.wilutions.byps.test.api.prim.PrimitiveTypes[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_801243127.instance);
			
			return obj;
		}
		
	}
} // namespace
