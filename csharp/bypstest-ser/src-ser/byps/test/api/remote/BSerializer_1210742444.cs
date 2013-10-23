//
// Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_getObject
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1210742444 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1210742444();
		
		public BSerializer_1210742444()
			: base(1210742444) {}
		
		public BSerializer_1210742444(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_getObject obj = (BRequest_RemotePrimitiveTypes_getObject)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_getObject()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
