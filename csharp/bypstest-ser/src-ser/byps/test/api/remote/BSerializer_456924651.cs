//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setPrimitiveTypes
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_456924651 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_456924651();
		
		public BSerializer_456924651()
			: base(456924651) {}
		
		public BSerializer_456924651(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteArrayTypes4dim_setPrimitiveTypes obj = (BRequest_RemoteArrayTypes4dim_setPrimitiveTypes)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._v, false, byps.test.api.BSerializer_758319514.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes4dim_setPrimitiveTypes obj = (BRequest_RemoteArrayTypes4dim_setPrimitiveTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_setPrimitiveTypes()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._v = (byps.test.api.prim.PrimitiveTypes[,,,])bin.readObj(false, byps.test.api.BSerializer_758319514.instance);
			
			return obj;
		}
		
	}
} // namespace
