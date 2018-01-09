//
// Serializer for byps.test.api.remote.BRequest_RemoteStreams_getStreamDoNotClone
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_692369677 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_692369677();
		
		public BSerializer_692369677()
			: base(692369677) {}
		
		public BSerializer_692369677(int typeId)
			: base(typeId) {}
		
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteStreams_getStreamDoNotClone obj = (BRequest_RemoteStreams_getStreamDoNotClone)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteStreams_getStreamDoNotClone()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
