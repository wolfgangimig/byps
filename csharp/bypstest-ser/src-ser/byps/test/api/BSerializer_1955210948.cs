//
// Serializer for byps.test.api.BResult_1493282670
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1955210948 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1955210948();
		
		public BSerializer_1955210948()
			: base(1955210948) {}
		
		public BSerializer_1955210948(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1493282670 obj = (BResult_1493282670)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_1493282670.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1493282670 obj = (BResult_1493282670)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1493282670()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.resultValue = (ISet<int>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
