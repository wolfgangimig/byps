//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getObject
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1253379978 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1253379978();
		
		public BSerializer_1253379978()
			: base(1253379978) {}
		
		public BSerializer_1253379978(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes4dim_getObject obj = (BRequest_RemoteArrayTypes4dim_getObject)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_getObject()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
