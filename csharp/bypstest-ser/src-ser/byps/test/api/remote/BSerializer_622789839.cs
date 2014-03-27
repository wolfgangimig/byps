//
// Serializer for byps.test.api.remote.BRequest_RemoteStreams_setImage
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_622789839 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_622789839();
		
		public BSerializer_622789839()
			: base(622789839) {}
		
		public BSerializer_622789839(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteStreams_setImage obj = (BRequest_RemoteStreams_setImage)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.istrmValue, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteStreams_setImage obj = (BRequest_RemoteStreams_setImage)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteStreams_setImage()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.istrmValue = (System.IO.Stream)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
