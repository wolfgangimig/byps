//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setShort
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1934214314 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1934214314();
		
		public BSerializer_1934214314()
			: base(1934214314) {}
		
		public BSerializer_1934214314(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteArrayTypes1dim_setShort obj = (BRequest_RemoteArrayTypes1dim_setShort)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._v, false, byps.test.api.BSerializer_2067161310.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes1dim_setShort obj = (BRequest_RemoteArrayTypes1dim_setShort)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes1dim_setShort()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._v = (short[])bin.readObj(false, byps.test.api.BSerializer_2067161310.instance);
			
			return obj;
		}
		
	}
} // namespace
