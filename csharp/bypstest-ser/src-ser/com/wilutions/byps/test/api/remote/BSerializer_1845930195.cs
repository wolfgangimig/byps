//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_throwException
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1845930195 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1845930195();
		
		public BSerializer_1845930195()
			: base(1845930195) {}
		
		public BSerializer_1845930195(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_throwException obj = (BRequest_RemotePrimitiveTypes_throwException)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_throwException()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
