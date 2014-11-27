//
// Serializer for byps.ureq.BRequest_BUtilityRequests_execute
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.ureq
{
	
	public class BSerializer_2048473051 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2048473051();
		
		public BSerializer_2048473051()
			: base(2048473051) {}
		
		public BSerializer_2048473051(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_BUtilityRequests_execute obj = (BRequest_BUtilityRequests_execute)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putString(obj.functionNameValue);
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.paramsValue, false, byps.ureq.BSerializer_1710660846.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_BUtilityRequests_execute obj = (BRequest_BUtilityRequests_execute)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_BUtilityRequests_execute()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.functionNameValue = bbuf.getString();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.paramsValue = (IDictionary<String,String>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
