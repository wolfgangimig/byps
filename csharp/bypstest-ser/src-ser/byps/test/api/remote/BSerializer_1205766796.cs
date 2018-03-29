//
// Serializer for byps.test.api.remote.BRequest_RemoteStreams_getStreamDeferedProperies
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1205766796 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1205766796();
		
		public BSerializer_1205766796()
			: base(1205766796) {}
		
		public BSerializer_1205766796(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteStreams_getStreamDeferedProperies obj = (BRequest_RemoteStreams_getStreamDeferedProperies)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteStreams_getStreamDeferedProperies()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
