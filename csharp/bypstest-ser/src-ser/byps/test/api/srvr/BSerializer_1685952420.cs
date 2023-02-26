//
// Serializer for byps.test.api.srvr.BRequest_ClientIF_incrementInt
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.srvr
{
	
	public class BSerializer_1685952420 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1685952420();
		
		public BSerializer_1685952420()
			: base(1685952420) {}
		
		public BSerializer_1685952420(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_ClientIF_incrementInt obj = (BRequest_ClientIF_incrementInt)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putInt(obj.aValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_ClientIF_incrementInt obj = (BRequest_ClientIF_incrementInt)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ClientIF_incrementInt()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.aValue = bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
