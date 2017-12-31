//
// Serializer for byps.test.api.BResult_936607009
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_968248604 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_968248604();
		
		public BSerializer_968248604()
			: base(968248604) {}
		
		public BSerializer_968248604(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_936607009 obj = (BResult_936607009)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_936607009.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_936607009 obj = (BResult_936607009)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_936607009()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.resultValue = (HashSet<char>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
