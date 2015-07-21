//
// Serializer for byps.test.api.remote.BRequest_RemoteStreams_getVideoCheckSupportByteRange
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1006919505 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1006919505();
		
		public BSerializer_1006919505()
			: base(1006919505) {}
		
		public BSerializer_1006919505(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteStreams_getVideoCheckSupportByteRange obj = (BRequest_RemoteStreams_getVideoCheckSupportByteRange)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteStreams_getVideoCheckSupportByteRange()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
