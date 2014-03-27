//
// Serializer for byps.test.api.remote.BRequest_RemoteListTypes_getString1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1597237350 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1597237350();
		
		public BSerializer_1597237350()
			: base(1597237350) {}
		
		public BSerializer_1597237350(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteListTypes_getString1 obj = (BRequest_RemoteListTypes_getString1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_getString1()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
