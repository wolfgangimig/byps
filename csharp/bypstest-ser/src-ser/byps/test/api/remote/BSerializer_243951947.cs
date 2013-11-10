//
// Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_setBool
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_243951947 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_243951947();
		
		public BSerializer_243951947()
			: base(243951947) {}
		
		public BSerializer_243951947(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemotePrimitiveTypes_setBool obj = (BRequest_RemotePrimitiveTypes_setBool)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:490
			bbuf.putBoolean(obj.vValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_setBool obj = (BRequest_RemotePrimitiveTypes_setBool)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_setBool()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:445
			obj.vValue = bbuf.getBoolean();
			
			return obj;
		}
		
	}
} // namespace
