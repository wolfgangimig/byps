//
// Serializer for byps.ureq.BRequest_BUtilityRequests_testAdapter
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.ureq
{
	
	public class BSerializer_421787891 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_421787891();
		
		public BSerializer_421787891()
			: base(421787891) {}
		
		public BSerializer_421787891(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_BUtilityRequests_testAdapter obj = (BRequest_BUtilityRequests_testAdapter)obj1;			
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
			BRequest_BUtilityRequests_testAdapter obj = (BRequest_BUtilityRequests_testAdapter)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_BUtilityRequests_testAdapter()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.functionNameValue = bbuf.getString();
			// checkpoint byps.gen.cs.PrintContext:449
			obj.paramsValue = (IDictionary<String,String>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
