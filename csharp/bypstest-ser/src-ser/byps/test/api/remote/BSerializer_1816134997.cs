//
// Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_getChar
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1816134997 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1816134997();
		
		public BSerializer_1816134997()
			: base(1816134997) {}
		
		public BSerializer_1816134997(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_getChar obj = (BRequest_RemotePrimitiveTypes_getChar)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_getChar()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
