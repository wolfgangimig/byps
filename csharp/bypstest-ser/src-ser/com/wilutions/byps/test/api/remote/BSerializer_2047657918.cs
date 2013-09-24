//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteStreams_throwLastException
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_2047657918 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2047657918();
		
		public BSerializer_2047657918()
			: base(2047657918) {}
		
		public BSerializer_2047657918(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteStreams_throwLastException obj = (BRequest_RemoteStreams_throwLastException)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteStreams_throwLastException()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
