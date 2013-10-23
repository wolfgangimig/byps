//
// Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_setDouble
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1727949326 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1727949326();
		
		public BSerializer_1727949326()
			: base(1727949326) {}
		
		public BSerializer_1727949326(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemotePrimitiveTypes_setDouble obj = (BRequest_RemotePrimitiveTypes_setDouble)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putDouble(obj._v);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_setDouble obj = (BRequest_RemotePrimitiveTypes_setDouble)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_setDouble()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._v = bbuf.getDouble();
			
			return obj;
		}
		
	}
} // namespace
