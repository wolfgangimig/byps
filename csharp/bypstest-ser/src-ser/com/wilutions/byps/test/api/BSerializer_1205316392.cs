//
// Serializer for com.wilutions.byps.test.api.BResult_601099730
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1205316392 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1205316392();
		
		public BSerializer_1205316392()
			: base(1205316392) {}
		
		public BSerializer_1205316392(int typeId)
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
			BResult_601099730 obj = (BResult_601099730)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, com.wilutions.byps.test.api.BSerializer_601099730.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_601099730 obj = (BResult_601099730)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_601099730()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (IDictionary<long,short>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
