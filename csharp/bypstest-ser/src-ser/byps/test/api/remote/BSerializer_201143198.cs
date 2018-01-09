//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setLong
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_201143198 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_201143198();
		
		public BSerializer_201143198()
			: base(201143198) {}
		
		public BSerializer_201143198(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteArrayTypes1dim_setLong obj = (BRequest_RemoteArrayTypes1dim_setLong)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.vValue, false, byps.test.api.BSerializer_1097129250.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes1dim_setLong obj = (BRequest_RemoteArrayTypes1dim_setLong)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes1dim_setLong()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.vValue = (long[])bin.readObj(false, byps.test.api.BSerializer_1097129250.instance);
			
			return obj;
		}
		
	}
} // namespace
