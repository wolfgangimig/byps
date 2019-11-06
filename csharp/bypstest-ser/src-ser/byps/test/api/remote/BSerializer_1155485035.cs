//
// Serializer for byps.test.api.remote.BRequest_RemoteProcessingEx_getValueAfterProcessingExceptions
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1155485035 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1155485035();
		
		public BSerializer_1155485035()
			: base(1155485035) {}
		
		public BSerializer_1155485035(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteProcessingEx_getValueAfterProcessingExceptions obj = (BRequest_RemoteProcessingEx_getValueAfterProcessingExceptions)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putInt(obj.sleepSecondsValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteProcessingEx_getValueAfterProcessingExceptions obj = (BRequest_RemoteProcessingEx_getValueAfterProcessingExceptions)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteProcessingEx_getValueAfterProcessingExceptions()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.sleepSecondsValue = bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
