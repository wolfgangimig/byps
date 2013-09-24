//
// Serializer for com.wilutions.byps.test.api.BResult_183594037
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_333265053 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_333265053();
		
		public BSerializer_333265053()
			: base(333265053) {}
		
		public BSerializer_333265053(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_183594037 obj = (BResult_183594037)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, com.wilutions.byps.test.api.BSerializer_183594037.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_183594037 obj = (BResult_183594037)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_183594037()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (Object[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_183594037.instance);
			
			return obj;
		}
		
	}
} // namespace
