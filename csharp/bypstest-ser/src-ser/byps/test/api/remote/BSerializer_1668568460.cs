//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setInt
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1668568460 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1668568460();
		
		public BSerializer_1668568460()
			: base(1668568460) {}
		
		public BSerializer_1668568460(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteArrayTypes4dim_setInt obj = (BRequest_RemoteArrayTypes4dim_setInt)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.vValue, false, byps.test.api.BSerializer_39910537.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes4dim_setInt obj = (BRequest_RemoteArrayTypes4dim_setInt)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_setInt()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:445
			obj.vValue = (int[,,,])bin.readObj(false, byps.test.api.BSerializer_39910537.instance);
			
			return obj;
		}
		
	}
} // namespace
