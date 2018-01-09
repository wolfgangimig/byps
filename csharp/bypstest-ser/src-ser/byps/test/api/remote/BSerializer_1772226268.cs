//
// Serializer for byps.test.api.remote.BRequest_RemoteSetTypes_getInt1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1772226268 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1772226268();
		
		public BSerializer_1772226268()
			: base(1772226268) {}
		
		public BSerializer_1772226268(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteSetTypes_getInt1 obj = (BRequest_RemoteSetTypes_getInt1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_getInt1()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
