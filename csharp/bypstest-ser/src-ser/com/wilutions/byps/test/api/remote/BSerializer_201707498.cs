//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setLong
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_201707498 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_201707498();
		
		public BSerializer_201707498()
			: base(201707498) {}
		
		public BSerializer_201707498(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteArrayTypes4dim_setLong obj = (BRequest_RemoteArrayTypes4dim_setLong)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._v, false, com.wilutions.byps.test.api.BSerializer_846419204.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes4dim_setLong obj = (BRequest_RemoteArrayTypes4dim_setLong)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_setLong()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._v = (long[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_846419204.instance);
			
			return obj;
		}
		
	}
} // namespace
