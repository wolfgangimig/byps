//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setFloat
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1963594750 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1963594750();
		
		public BSerializer_1963594750()
			: base(1963594750) {}
		
		public BSerializer_1963594750(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteArrayTypes4dim_setFloat obj = (BRequest_RemoteArrayTypes4dim_setFloat)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._v, false, com.wilutions.byps.test.api.BSerializer_1516687588.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes4dim_setFloat obj = (BRequest_RemoteArrayTypes4dim_setFloat)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_setFloat()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._v = (float[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1516687588.instance);
			
			return obj;
		}
		
	}
} // namespace
