//
// Serializer for com.wilutions.byps.test.api.BResult_945713488
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_2092891102 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2092891102();
		
		public BSerializer_2092891102()
			: base(2092891102) {}
		
		public BSerializer_2092891102(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_945713488 obj = (BResult_945713488)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, com.wilutions.byps.test.api.BSerializer_945713488.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_945713488 obj = (BResult_945713488)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_945713488()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (bool[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_945713488.instance);
			
			return obj;
		}
		
	}
} // namespace
