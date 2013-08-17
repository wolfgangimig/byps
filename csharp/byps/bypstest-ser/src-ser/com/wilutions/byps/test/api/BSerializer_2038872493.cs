//
// Serializer for com.wilutions.byps.test.api.BResult_1042475995
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_2038872493 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2038872493();
		
		public BSerializer_2038872493()
			: base(2038872493) {}
		
		public BSerializer_2038872493(int typeId)
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
			BResult_1042475995 obj = (BResult_1042475995)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putInt((int)obj._result);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1042475995 obj = (BResult_1042475995)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1042475995()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (com.wilutions.byps.test.api.enu.EnumPlanets)bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
