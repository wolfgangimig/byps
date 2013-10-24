//
// Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_setFloat
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1023819749 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1023819749();
		
		public BSerializer_1023819749()
			: base(1023819749) {}
		
		public BSerializer_1023819749(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemotePrimitiveTypes_setFloat obj = (BRequest_RemotePrimitiveTypes_setFloat)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putFloat(obj._v);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_setFloat obj = (BRequest_RemotePrimitiveTypes_setFloat)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_setFloat()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._v = bbuf.getFloat();
			
			return obj;
		}
		
	}
} // namespace
