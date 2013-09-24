//
// Serializer for com.wilutions.byps.test.api.BResult_7007
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1462588845 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1462588845();
		
		public BSerializer_1462588845()
			: base(1462588845) {}
		
		public BSerializer_1462588845(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_7007 obj = (BResult_7007)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_7007 obj = (BResult_7007)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_7007()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (com.wilutions.byps.test.api.srvr.ChatStructure)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
