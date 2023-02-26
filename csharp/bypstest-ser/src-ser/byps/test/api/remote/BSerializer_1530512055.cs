//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setInt
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1530512055 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1530512055();
		
		public BSerializer_1530512055()
			: base(1530512055) {}
		
		public BSerializer_1530512055(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteArrayTypes1dim_setInt obj = (BRequest_RemoteArrayTypes1dim_setInt)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.vValue, false, byps.test.api.BSerializer_100361105.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes1dim_setInt obj = (BRequest_RemoteArrayTypes1dim_setInt)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes1dim_setInt()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.vValue = (int[])bin.readObj(false, byps.test.api.BSerializer_100361105.instance);
			
			return obj;
		}
		
	}
} // namespace
