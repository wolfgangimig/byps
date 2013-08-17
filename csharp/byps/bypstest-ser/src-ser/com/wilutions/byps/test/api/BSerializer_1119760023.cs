//
// Serializer for com.wilutions.byps.test.api.BResult_1457164460
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_1119760023 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1119760023();
		
		public BSerializer_1119760023()
			: base(1119760023) {}
		
		public BSerializer_1119760023(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: result */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			BResult_1457164460 obj = (BResult_1457164460)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, com.wilutions.byps.test.api.BSerializer_1457164460.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1457164460 obj = (BResult_1457164460)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1457164460()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (ISet<long>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
