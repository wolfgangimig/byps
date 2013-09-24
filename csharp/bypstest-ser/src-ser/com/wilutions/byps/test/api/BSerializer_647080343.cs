//
// Serializer for com.wilutions.byps.test.api.BResult_124584219
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_647080343 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_647080343();
		
		public BSerializer_647080343()
			: base(647080343) {}
		
		public BSerializer_647080343(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_124584219 obj = (BResult_124584219)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, com.wilutions.byps.test.api.BSerializer_124584219.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_124584219 obj = (BResult_124584219)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_124584219()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (Object[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_124584219.instance);
			
			return obj;
		}
		
	}
} // namespace
