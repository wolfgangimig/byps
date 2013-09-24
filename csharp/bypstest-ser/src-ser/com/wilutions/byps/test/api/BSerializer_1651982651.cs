//
// Serializer for com.wilutions.byps.test.api.BResult_1851881336
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1651982651 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1651982651();
		
		public BSerializer_1651982651()
			: base(1651982651) {}
		
		public BSerializer_1651982651(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1851881336 obj = (BResult_1851881336)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, com.wilutions.byps.test.api.BSerializer_1851881336.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1851881336 obj = (BResult_1851881336)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1851881336()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (IDictionary<int,com.wilutions.byps.test.api.inl.Point2D>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
