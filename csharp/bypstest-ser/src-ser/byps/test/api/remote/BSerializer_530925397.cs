//
// Serializer for byps.test.api.remote.BRequest_RemoteMapTypes_getFloat1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_530925397 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_530925397();
		
		public BSerializer_530925397()
			: base(530925397) {}
		
		public BSerializer_530925397(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteMapTypes_getFloat1 obj = (BRequest_RemoteMapTypes_getFloat1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_getFloat1()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
