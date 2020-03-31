//
// Serializer for byps.test.api.cons.SordC
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.cons
{
	
	public class BSerializer_632707056 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_632707056();
		
		public BSerializer_632707056()
			: base(632707056) {}
		
		public BSerializer_632707056(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			SordC obj = (SordC)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			SordC obj = (SordC)(obj1 != null ? obj1 : bin.onObjectCreated(new SordC()));
			
			BBufferBin bbuf = bin.bbuf;
			
			return obj;
		}
		
	}
} // namespace
