//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_getTextStream
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1083407988 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1083407988();
		
		public BSerializer_1083407988()
			: base(1083407988) {}
		
		public BSerializer_1083407988(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteStreams_getTextStream obj = (BRequest_RemoteStreams_getTextStream)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteStreams_getTextStream()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
