//
// Serializer for byps.test.api.BResult_1406664368
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_1980364794 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1980364794();
		
		public BSerializer_1980364794()
			: base(1980364794) {}
		
		public BSerializer_1980364794(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1406664368 obj = (BResult_1406664368)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.resultValue, false, byps.test.api.BSerializer_1406664368.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1406664368 obj = (BResult_1406664368)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1406664368()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:445
			obj.resultValue = (java.util.Date[])bin.readObj(false, byps.test.api.BSerializer_1406664368.instance);
			
			return obj;
		}
		
	}
} // namespace
