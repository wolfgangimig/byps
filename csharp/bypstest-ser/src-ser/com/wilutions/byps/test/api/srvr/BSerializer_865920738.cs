//
// Serializer for com.wilutions.byps.test.api.srvr.BRequest_ClientIF_getStreams
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public class BSerializer_865920738 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_865920738();
		
		public BSerializer_865920738()
			: base(865920738) {}
		
		public BSerializer_865920738(int typeId)
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
