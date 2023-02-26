//
// Serializer for byps.test.api.cons.SordZ
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.cons
{
	
	public class BSerializer_691830 : byps.BSerializer_22 {
		
		public readonly static new BSerializer instance = new BSerializer_691830();
		
		public BSerializer_691830()
			: base(691830) {}
		
		public BSerializer_691830(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			base.write(obj1, bout1, version);			
			SordZ obj = (SordZ)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putLong(obj.Bset);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			SordZ obj = (SordZ)(obj1 != null ? obj1 : bin.onObjectCreated(new SordZ()));
			
			base.read(obj, bin1, version);			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.Bset = bbuf.getLong();
			
			return obj;
		}
		
	}
} // namespace
