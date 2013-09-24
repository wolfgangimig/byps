//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getShort1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1610481740 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1610481740();
		
		public BSerializer_1610481740()
			: base(1610481740) {}
		
		public BSerializer_1610481740(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteMapTypes_getShort1 obj = (BRequest_RemoteMapTypes_getShort1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_getShort1()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
