//
// Serializer for byps.test.api.BResult_100361105
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api
{
	
	public class BSerializer_498939805 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_498939805();
		
		public BSerializer_498939805()
			: base(498939805) {}
		
		public BSerializer_498939805(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_100361105 obj = (BResult_100361105)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, byps.test.api.BSerializer_100361105.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_100361105 obj = (BResult_100361105)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_100361105()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (int[])bin.readObj(false, byps.test.api.BSerializer_100361105.instance);
			
			return obj;
		}
		
	}
} // namespace
