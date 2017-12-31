//
// Serializer for byps.test.api.remote.BRequest_RemoteListTypes_getByte2
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_608486404 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_608486404();
		
		public BSerializer_608486404()
			: base(608486404) {}
		
		public BSerializer_608486404(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteListTypes_getByte2 obj = (BRequest_RemoteListTypes_getByte2)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_getByte2()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
