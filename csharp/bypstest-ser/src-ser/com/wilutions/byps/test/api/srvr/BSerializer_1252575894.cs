//
// Serializer for com.wilutions.byps.test.api.srvr.BRequest_ServerIF_callClientIncrementInt
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public class BSerializer_1252575894 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1252575894();
		
		public BSerializer_1252575894()
			: base(1252575894) {}
		
		public BSerializer_1252575894(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_ServerIF_callClientIncrementInt obj = (BRequest_ServerIF_callClientIncrementInt)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putInt(obj._v);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_ServerIF_callClientIncrementInt obj = (BRequest_ServerIF_callClientIncrementInt)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ServerIF_callClientIncrementInt()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._v = bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
