//
// Serializer for byps.test.api.remote.BRequest_RemoteListTypes_getInt4
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_2098036491 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2098036491();
		
		public BSerializer_2098036491()
			: base(2098036491) {}
		
		public BSerializer_2098036491(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteListTypes_getInt4 obj = (BRequest_RemoteListTypes_getInt4)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_getInt4()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
