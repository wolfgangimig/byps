//
// Serializer for com.wilutions.byps.test.api.srvr.BRequest_ClientIF_sendChat
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public class BSerializer_1352392091 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1352392091();
		
		public BSerializer_1352392091()
			: base(1352392091) {}
		
		public BSerializer_1352392091(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: cs */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_ClientIF_sendChat obj = (BRequest_ClientIF_sendChat)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._cs, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_ClientIF_sendChat obj = (BRequest_ClientIF_sendChat)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ClientIF_sendChat()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._cs = (com.wilutions.byps.test.api.srvr.ChatStructure)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
