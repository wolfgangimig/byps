//
// Serializer for byps.test.api.BResult_955752991
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_695494982 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_695494982();
		
		public BSerializer_695494982()
			: base(695494982) {}
		
		public BSerializer_695494982(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_955752991 obj = (BResult_955752991)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.resultValue, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_955752991 obj = (BResult_955752991)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_955752991()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.resultValue = (byps.test.api.srvr.ClientIF)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
