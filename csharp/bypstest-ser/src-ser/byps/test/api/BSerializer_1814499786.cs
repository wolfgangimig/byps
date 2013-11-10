//
// Serializer for byps.test.api.BResult_2053507648
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1814499786 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1814499786();
		
		public BSerializer_1814499786()
			: base(1814499786) {}
		
		public BSerializer_1814499786(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_2053507648 obj = (BResult_2053507648)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_2053507648.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_2053507648 obj = (BResult_2053507648)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_2053507648()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:447
			obj.resultValue = (byps.test.api.prim.PrimitiveTypes[])bin.readObj(false, byps.test.api.BSerializer_2053507648.instance);
			
			return obj;
		}
		
	}
} // namespace
