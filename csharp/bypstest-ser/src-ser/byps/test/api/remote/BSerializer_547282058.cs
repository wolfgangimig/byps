//
// Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_getDeferredValueFromServer
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_547282058 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_547282058();
		
		public BSerializer_547282058()
			: base(547282058) {}
		
		public BSerializer_547282058(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemotePrimitiveTypes_getDeferredValueFromServer obj = (BRequest_RemotePrimitiveTypes_getDeferredValueFromServer)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putInt(obj.param1Value);
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putString(obj.param2Value);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_getDeferredValueFromServer obj = (BRequest_RemotePrimitiveTypes_getDeferredValueFromServer)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_getDeferredValueFromServer()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.param1Value = bbuf.getInt();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.param2Value = bbuf.getString();
			
			return obj;
		}
		
	}
} // namespace
