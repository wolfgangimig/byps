//
// Serializer for com.wilutions.byps.test.api.BResult_1059148284
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1532920911 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1532920911();
		
		public BSerializer_1532920911()
			: base(1532920911) {}
		
		public BSerializer_1532920911(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_1059148284 obj = (BResult_1059148284)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, com.wilutions.byps.test.api.BSerializer_1059148284.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1059148284 obj = (BResult_1059148284)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1059148284()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (IList<byte>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
