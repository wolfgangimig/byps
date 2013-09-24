//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getString1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_615539953 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_615539953();
		
		public BSerializer_615539953()
			: base(615539953) {}
		
		public BSerializer_615539953(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteSetTypes_getString1 obj = (BRequest_RemoteSetTypes_getString1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_getString1()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
