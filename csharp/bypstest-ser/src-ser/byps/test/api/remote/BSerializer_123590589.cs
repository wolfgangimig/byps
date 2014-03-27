//
// Serializer for byps.test.api.remote.BRequest_RemoteMapTypes_getDate1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_123590589 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_123590589();
		
		public BSerializer_123590589()
			: base(123590589) {}
		
		public BSerializer_123590589(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteMapTypes_getDate1 obj = (BRequest_RemoteMapTypes_getDate1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_getDate1()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
