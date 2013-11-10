//
// Serializer for byps.test.api.BResult_21
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_534004389 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_534004389();
		
		public BSerializer_534004389()
			: base(534004389) {}
		
		public BSerializer_534004389(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_21 obj = (BResult_21)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.resultValue, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_21 obj = (BResult_21)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_21()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:447
			obj.resultValue = (Object)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
