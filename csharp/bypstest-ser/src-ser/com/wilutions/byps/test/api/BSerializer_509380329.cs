//
// Serializer for com.wilutions.byps.test.api.BResult_1391985860
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_509380329 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_509380329();
		
		public BSerializer_509380329()
			: base(509380329) {}
		
		public BSerializer_509380329(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1391985860 obj = (BResult_1391985860)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1391985860 obj = (BResult_1391985860)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1391985860()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (com.wilutions.byps.test.api.ver.Evolve)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
