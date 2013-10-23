//
// Serializer for byps.test.api.BResult_183594037
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_15818284 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_15818284();
		
		public BSerializer_15818284()
			: base(15818284) {}
		
		public BSerializer_15818284(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_183594037 obj = (BResult_183594037)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, byps.test.api.BSerializer_183594037.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_183594037 obj = (BResult_183594037)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_183594037()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (Object[])bin.readObj(false, byps.test.api.BSerializer_183594037.instance);
			
			return obj;
		}
		
	}
} // namespace
