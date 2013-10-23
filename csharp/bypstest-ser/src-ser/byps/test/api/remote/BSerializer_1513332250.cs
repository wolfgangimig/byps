//
// Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_getDouble
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1513332250 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1513332250();
		
		public BSerializer_1513332250()
			: base(1513332250) {}
		
		public BSerializer_1513332250(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_getDouble obj = (BRequest_RemotePrimitiveTypes_getDouble)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_getDouble()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
