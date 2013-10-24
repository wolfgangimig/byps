//
// Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_getInt
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1582599686 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1582599686();
		
		public BSerializer_1582599686()
			: base(1582599686) {}
		
		public BSerializer_1582599686(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_getInt obj = (BRequest_RemotePrimitiveTypes_getInt)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_getInt()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
