//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setObject
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_48678821 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_48678821();
		
		public BSerializer_48678821()
			: base(48678821) {}
		
		public BSerializer_48678821(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteArrayTypes1dim_setObject obj = (BRequest_RemoteArrayTypes1dim_setObject)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._v, false, byps.test.api.BSerializer_183594037.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes1dim_setObject obj = (BRequest_RemoteArrayTypes1dim_setObject)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes1dim_setObject()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._v = (Object[])bin.readObj(false, byps.test.api.BSerializer_183594037.instance);
			
			return obj;
		}
		
	}
} // namespace
