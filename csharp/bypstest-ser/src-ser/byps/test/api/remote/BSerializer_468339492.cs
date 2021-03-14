//
// Serializer for byps.test.api.remote.BRequest_RemoteStreams_putSharedStream
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_468339492 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_468339492();
		
		public BSerializer_468339492()
			: base(468339492) {}
		
		public BSerializer_468339492(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteStreams_putSharedStream obj = (BRequest_RemoteStreams_putSharedStream)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putLong(obj.idValue);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.streamValue, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteStreams_putSharedStream obj = (BRequest_RemoteStreams_putSharedStream)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteStreams_putSharedStream()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.idValue = bbuf.getLong();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.streamValue = (System.IO.Stream)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
