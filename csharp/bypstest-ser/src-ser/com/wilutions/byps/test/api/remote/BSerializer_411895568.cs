//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getShort
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_411895568 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_411895568();
		
		public BSerializer_411895568()
			: base(411895568) {}
		
		public BSerializer_411895568(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_getShort obj = (BRequest_RemotePrimitiveTypes_getShort)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_getShort()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
