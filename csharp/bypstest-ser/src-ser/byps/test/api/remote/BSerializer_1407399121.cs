//
// Serializer for byps.test.api.remote.BRequest_RemoteMapTypes_setInt2
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1407399121 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1407399121();
		
		public BSerializer_1407399121()
			: base(1407399121) {}
		
		public BSerializer_1407399121(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteMapTypes_setInt2 obj = (BRequest_RemoteMapTypes_setInt2)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.int2Value, false, byps.test.api.BSerializer_1633750383.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteMapTypes_setInt2 obj = (BRequest_RemoteMapTypes_setInt2)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_setInt2()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:447
			obj.int2Value = (IDictionary<int,int[]>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
