//
// Serializer for byps.test.api.srvr.BRequest_ClientIF_getStreams
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.srvr
{
	
	public class BSerializer_1654980071 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1654980071();
		
		public BSerializer_1654980071()
			: base(1654980071) {}
		
		public BSerializer_1654980071(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_ClientIF_getStreams obj = (BRequest_ClientIF_getStreams)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putInt(obj._ctrl);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_ClientIF_getStreams obj = (BRequest_ClientIF_getStreams)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ClientIF_getStreams()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._ctrl = bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
