//
// Serializer for com.wilutions.byps.test.api.BResult_1365696060
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1253977781 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1253977781();
		
		public BSerializer_1253977781()
			: base(1253977781) {}
		
		public BSerializer_1253977781(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1365696060 obj = (BResult_1365696060)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, com.wilutions.byps.test.api.BSerializer_1365696060.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1365696060 obj = (BResult_1365696060)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1365696060()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (ISet<bool>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
