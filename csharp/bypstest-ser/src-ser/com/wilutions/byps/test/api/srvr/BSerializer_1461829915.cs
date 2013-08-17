//
// Serializer for com.wilutions.byps.test.api.srvr.BRequest_ClientIF_incrementInt
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.srvr
{
	
	public class BSerializer_1461829915 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1461829915();
		
		public BSerializer_1461829915()
			: base(1461829915) {}
		
		public BSerializer_1461829915(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: a */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			BRequest_ClientIF_incrementInt obj = (BRequest_ClientIF_incrementInt)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putInt(obj._a);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_ClientIF_incrementInt obj = (BRequest_ClientIF_incrementInt)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ClientIF_incrementInt()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._a = bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
