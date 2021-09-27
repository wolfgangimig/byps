//
// Serializer for byps.test.api.remote.BRequest_RemoteStreams_getSharedStream
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1652400477 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1652400477();
		
		public BSerializer_1652400477()
			: base(1652400477) {}
		
		public BSerializer_1652400477(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteStreams_getSharedStream obj = (BRequest_RemoteStreams_getSharedStream)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putLong(obj.idValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteStreams_getSharedStream obj = (BRequest_RemoteStreams_getSharedStream)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteStreams_getSharedStream()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.idValue = bbuf.getLong();
			
			return obj;
		}
		
	}
} // namespace
