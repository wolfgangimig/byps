//
// Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_getByte
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1816147875 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1816147875();
		
		public BSerializer_1816147875()
			: base(1816147875) {}
		
		public BSerializer_1816147875(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_getByte obj = (BRequest_RemotePrimitiveTypes_getByte)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_getByte()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
