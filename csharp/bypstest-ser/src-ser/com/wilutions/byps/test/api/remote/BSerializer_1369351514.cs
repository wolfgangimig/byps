//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getFloat1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1369351514 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1369351514();
		
		public BSerializer_1369351514()
			: base(1369351514) {}
		
		public BSerializer_1369351514(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteSetTypes_getFloat1 obj = (BRequest_RemoteSetTypes_getFloat1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_getFloat1()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
