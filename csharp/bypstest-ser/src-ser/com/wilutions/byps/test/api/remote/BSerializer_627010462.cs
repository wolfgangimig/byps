//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteEnums_getPlanet
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_627010462 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_627010462();
		
		public BSerializer_627010462()
			: base(627010462) {}
		
		public BSerializer_627010462(int typeId)
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
