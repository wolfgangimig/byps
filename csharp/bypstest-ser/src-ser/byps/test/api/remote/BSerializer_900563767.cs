//
// Serializer for byps.test.api.remote.BRequest_RemoteSetTypes_getDate1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_900563767 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_900563767();
		
		public BSerializer_900563767()
			: base(900563767) {}
		
		public BSerializer_900563767(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteSetTypes_getDate1 obj = (BRequest_RemoteSetTypes_getDate1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_getDate1()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
