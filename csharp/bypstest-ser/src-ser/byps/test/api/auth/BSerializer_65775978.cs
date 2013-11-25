//
// Serializer for byps.test.api.auth.SessionInfo
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.auth
{
	
	public class BSerializer_65775978 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_65775978();
		
		public BSerializer_65775978()
			: base(65775978) {}
		
		public BSerializer_65775978(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			SessionInfo obj = (SessionInfo)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putString(obj.SessionID);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			SessionInfo obj = (SessionInfo)(obj1 != null ? obj1 : bin.onObjectCreated(new SessionInfo()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.SessionID = bbuf.getString();
			
			return obj;
		}
		
	}
} // namespace
