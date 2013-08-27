//
// Serializer for com.wilutions.byps.test.api.BResult_39910537
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1682941350 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1682941350();
		
		public BSerializer_1682941350()
			: base(1682941350) {}
		
		public BSerializer_1682941350(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: result */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BResult_39910537 obj = (BResult_39910537)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, com.wilutions.byps.test.api.BSerializer_39910537.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_39910537 obj = (BResult_39910537)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_39910537()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (int[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_39910537.instance);
			
			return obj;
		}
		
	}
} // namespace
