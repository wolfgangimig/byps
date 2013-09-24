//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getBool
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_2090997206 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2090997206();
		
		public BSerializer_2090997206()
			: base(2090997206) {}
		
		public BSerializer_2090997206(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_getBool obj = (BRequest_RemotePrimitiveTypes_getBool)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_getBool()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
