//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setFloat
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1946101450 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1946101450();
		
		public BSerializer_1946101450()
			: base(1946101450) {}
		
		public BSerializer_1946101450(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteArrayTypes1dim_setFloat obj = (BRequest_RemoteArrayTypes1dim_setFloat)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._v, false, byps.test.api.BSerializer_766441794.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes1dim_setFloat obj = (BRequest_RemoteArrayTypes1dim_setFloat)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes1dim_setFloat()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._v = (float[])bin.readObj(false, byps.test.api.BSerializer_766441794.instance);
			
			return obj;
		}
		
	}
} // namespace
