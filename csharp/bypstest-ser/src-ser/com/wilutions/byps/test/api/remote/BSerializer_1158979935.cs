//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_getImages
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1158979935 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1158979935();
		
		public BSerializer_1158979935()
			: base(1158979935) {}
		
		public BSerializer_1158979935(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteStreams_getImages obj = (BRequest_RemoteStreams_getImages)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteStreams_getImages()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
