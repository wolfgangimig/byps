//
// Serializer for byps.test.api.remote.BRequest_RemoteListTypes_getPrimitiveTypes1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1679973895 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1679973895();
		
		public BSerializer_1679973895()
			: base(1679973895) {}
		
		public BSerializer_1679973895(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteListTypes_getPrimitiveTypes1 obj = (BRequest_RemoteListTypes_getPrimitiveTypes1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_getPrimitiveTypes1()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
