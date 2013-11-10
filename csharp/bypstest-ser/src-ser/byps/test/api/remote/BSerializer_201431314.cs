//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setByte
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_201431314 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_201431314();
		
		public BSerializer_201431314()
			: base(201431314) {}
		
		public BSerializer_201431314(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteArrayTypes1dim_setByte obj = (BRequest_RemoteArrayTypes1dim_setByte)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.vValue, false, byps.test.api.BSerializer_1374008726.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes1dim_setByte obj = (BRequest_RemoteArrayTypes1dim_setByte)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes1dim_setByte()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:445
			obj.vValue = (byte[])bin.readObj(false, byps.test.api.BSerializer_1374008726.instance);
			
			return obj;
		}
		
	}
} // namespace
