//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getInt2
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1013140230 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1013140230();
		
		public BSerializer_1013140230()
			: base(1013140230) {}
		
		public BSerializer_1013140230(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteMapTypes_getInt2 obj = (BRequest_RemoteMapTypes_getInt2)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_getInt2()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
