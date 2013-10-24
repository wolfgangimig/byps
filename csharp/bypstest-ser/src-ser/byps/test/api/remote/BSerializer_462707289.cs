//
// Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_getFloat
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_462707289 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_462707289();
		
		public BSerializer_462707289()
			: base(462707289) {}
		
		public BSerializer_462707289(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_getFloat obj = (BRequest_RemotePrimitiveTypes_getFloat)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_getFloat()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
