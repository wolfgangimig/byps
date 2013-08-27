//
// Serializer for com.wilutions.byps.test.api.BResult_19
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_309901669 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_309901669();
		
		public BSerializer_309901669()
			: base(309901669) {}
		
		public BSerializer_309901669(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: result */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_19 obj = (BResult_19)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_19()));
			
			BBufferBin bbuf = bin.bbuf;
			// void result			
			return obj;
		}
		
	}
} // namespace
