//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setObject
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1467997054 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1467997054();
		
		public BSerializer_1467997054()
			: base(1467997054) {}
		
		public BSerializer_1467997054(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteArrayTypes4dim_setObject obj = (BRequest_RemoteArrayTypes4dim_setObject)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.vValue, false, byps.test.api.BSerializer_124584219.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes4dim_setObject obj = (BRequest_RemoteArrayTypes4dim_setObject)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_setObject()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.vValue = (Object[,,,])bin.readObj(false, byps.test.api.BSerializer_124584219.instance);
			
			return obj;
		}
		
	}
} // namespace
