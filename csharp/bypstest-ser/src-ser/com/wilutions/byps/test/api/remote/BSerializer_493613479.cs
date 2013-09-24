//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setObject
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_493613479 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_493613479();
		
		public BSerializer_493613479()
			: base(493613479) {}
		
		public BSerializer_493613479(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteArrayTypes4dim_setObject obj = (BRequest_RemoteArrayTypes4dim_setObject)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._v, false, com.wilutions.byps.test.api.BSerializer_124584219.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes4dim_setObject obj = (BRequest_RemoteArrayTypes4dim_setObject)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_setObject()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._v = (Object[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_124584219.instance);
			
			return obj;
		}
		
	}
} // namespace
