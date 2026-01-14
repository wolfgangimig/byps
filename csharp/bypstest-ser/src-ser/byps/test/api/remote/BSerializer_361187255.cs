//
// Serializer for byps.test.api.remote.BRequest_RemotePrimitiveTypes_getStringsWithSpecialChars
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_361187255 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_361187255();
		
		public BSerializer_361187255()
			: base(361187255) {}
		
		public BSerializer_361187255(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemotePrimitiveTypes_getStringsWithSpecialChars obj = (BRequest_RemotePrimitiveTypes_getStringsWithSpecialChars)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_getStringsWithSpecialChars()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
