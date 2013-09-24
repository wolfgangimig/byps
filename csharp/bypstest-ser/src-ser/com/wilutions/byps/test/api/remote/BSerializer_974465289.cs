//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setInt
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_974465289 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_974465289();
		
		public BSerializer_974465289()
			: base(974465289) {}
		
		public BSerializer_974465289(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemotePrimitiveTypes_setInt obj = (BRequest_RemotePrimitiveTypes_setInt)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putInt(obj._v);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_setInt obj = (BRequest_RemotePrimitiveTypes_setInt)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_setInt()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._v = bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
