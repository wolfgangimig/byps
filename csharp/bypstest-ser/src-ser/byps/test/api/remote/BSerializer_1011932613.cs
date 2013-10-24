//
// Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_setShort
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1011932613 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1011932613();
		
		public BSerializer_1011932613()
			: base(1011932613) {}
		
		public BSerializer_1011932613(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemotePrimitiveTypes_setShort obj = (BRequest_RemotePrimitiveTypes_setShort)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putShort(obj._v);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_setShort obj = (BRequest_RemotePrimitiveTypes_setShort)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_setShort()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._v = bbuf.getShort();
			
			return obj;
		}
		
	}
} // namespace
