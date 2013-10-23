//
// Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_voidFunctionVoid
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_2033139391 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2033139391();
		
		public BSerializer_2033139391()
			: base(2033139391) {}
		
		public BSerializer_2033139391(int typeId)
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
