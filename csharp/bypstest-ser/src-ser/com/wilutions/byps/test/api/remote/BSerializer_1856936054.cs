//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_voidFunctionVoid
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1856936054 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1856936054();
		
		public BSerializer_1856936054()
			: base(1856936054) {}
		
		public BSerializer_1856936054(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_voidFunctionVoid obj = (BRequest_RemotePrimitiveTypes_voidFunctionVoid)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_voidFunctionVoid()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
