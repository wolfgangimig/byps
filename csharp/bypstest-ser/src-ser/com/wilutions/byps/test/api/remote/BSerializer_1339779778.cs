//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getLong1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1339779778 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1339779778();
		
		public BSerializer_1339779778()
			: base(1339779778) {}
		
		public BSerializer_1339779778(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteMapTypes_getLong1 obj = (BRequest_RemoteMapTypes_getLong1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_getLong1()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
