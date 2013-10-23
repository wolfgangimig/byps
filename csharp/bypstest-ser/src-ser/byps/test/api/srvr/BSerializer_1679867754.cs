//
// Serializer for byps.test.api.srvr.BRequest_ServerIF_getStreamsFromClient
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.srvr
{
	
	public class BSerializer_1679867754 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1679867754();
		
		public BSerializer_1679867754()
			: base(1679867754) {}
		
		public BSerializer_1679867754(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_ServerIF_getStreamsFromClient obj = (BRequest_ServerIF_getStreamsFromClient)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ServerIF_getStreamsFromClient()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
