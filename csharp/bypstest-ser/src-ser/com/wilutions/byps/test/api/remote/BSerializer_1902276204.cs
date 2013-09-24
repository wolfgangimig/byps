//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_getImage
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1902276204 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1902276204();
		
		public BSerializer_1902276204()
			: base(1902276204) {}
		
		public BSerializer_1902276204(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteStreams_getImage obj = (BRequest_RemoteStreams_getImage)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteStreams_getImage()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
