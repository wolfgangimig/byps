//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setInt
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1265927470 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1265927470();
		
		public BSerializer_1265927470()
			: base(1265927470) {}
		
		public BSerializer_1265927470(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteArrayTypes1dim_setInt obj = (BRequest_RemoteArrayTypes1dim_setInt)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._v, false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes1dim_setInt obj = (BRequest_RemoteArrayTypes1dim_setInt)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes1dim_setInt()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._v = (int[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_100361105.instance);
			
			return obj;
		}
		
	}
} // namespace
