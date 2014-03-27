//
// Serializer for byps.test.api.BResult_1972793385
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1958357790 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1958357790();
		
		public BSerializer_1958357790()
			: base(1958357790) {}
		
		public BSerializer_1958357790(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1972793385 obj = (BResult_1972793385)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_1972793385.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1972793385 obj = (BResult_1972793385)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1972793385()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.resultValue = (Dictionary<double,byte>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
