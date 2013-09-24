//
// Serializer for com.wilutions.byps.test.api.BResult_100361105
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_848023142 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_848023142();
		
		public BSerializer_848023142()
			: base(848023142) {}
		
		public BSerializer_848023142(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_100361105 obj = (BResult_100361105)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_100361105 obj = (BResult_100361105)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_100361105()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (int[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
			
			return obj;
		}
		
	}
} // namespace
