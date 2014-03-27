//
// Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_getLong
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1815859759 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1815859759();
		
		public BSerializer_1815859759()
			: base(1815859759) {}
		
		public BSerializer_1815859759(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_getLong obj = (BRequest_RemotePrimitiveTypes_getLong)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_getLong()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
