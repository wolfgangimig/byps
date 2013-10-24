//
// Serializer for byps.test.api.remote.BRequest_RemoteEnums_getPlanet
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_6352043 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_6352043();
		
		public BSerializer_6352043()
			: base(6352043) {}
		
		public BSerializer_6352043(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteEnums_getPlanet obj = (BRequest_RemoteEnums_getPlanet)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteEnums_getPlanet()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
