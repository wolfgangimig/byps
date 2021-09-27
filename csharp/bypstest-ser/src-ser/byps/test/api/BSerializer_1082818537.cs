//
// Serializer for byps.test.api.BResult_1997002548
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1082818537 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1082818537();
		
		public BSerializer_1082818537()
			: base(1082818537) {}
		
		public BSerializer_1082818537(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1997002548 obj = (BResult_1997002548)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_1997002548.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1997002548 obj = (BResult_1997002548)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1997002548()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.resultValue = (IList<short>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
