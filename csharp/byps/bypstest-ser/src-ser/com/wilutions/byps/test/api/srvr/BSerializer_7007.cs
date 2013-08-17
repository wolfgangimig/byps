//
// Serializer for com.wilutions.byps.test.api.srvr.ChatStructure
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public class BSerializer_7007 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_7007();
		
		public BSerializer_7007()
			: base(7007) {}
		
		public BSerializer_7007(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: msg */ + 4			
			       /* padding */ + 4			
			       /* pos=8: sentAt */ + 8			
			       /* pos=16: receivedAt */ + 8			
			       /* padding up to multiple of alignment */ + 0;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			ChatStructure obj = (ChatStructure)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putString(obj.Msg);
			bbuf.putDouble(obj.ReceivedAt);
			bbuf.putDouble(obj.SentAt);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			ChatStructure obj = (ChatStructure)(obj1 != null ? obj1 : bin.onObjectCreated(new ChatStructure()));
			
			BBufferBin bbuf = bin.bbuf;
			obj.Msg = bbuf.getString();
			obj.ReceivedAt = bbuf.getDouble();
			obj.SentAt = bbuf.getDouble();
			
			return obj;
		}
		
	}
} // namespace
