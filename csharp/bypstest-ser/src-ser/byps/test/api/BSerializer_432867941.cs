//
// Serializer for byps.test.api.BResult_7
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_432867941 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_432867941();
		
		public BSerializer_432867941()
			: base(432867941) {}
		
		public BSerializer_432867941(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_7 obj = (BResult_7)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putFloat(obj.resultValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_7 obj = (BResult_7)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_7()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.resultValue = bbuf.getFloat();
			
			return obj;
		}
		
	}
} // namespace
