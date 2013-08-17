//
// Serializer for com.wilutions.byps.test.api.BResult_1972793385
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api
{
	
	public class BSerializer_104960651 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_104960651();
		
		public BSerializer_104960651()
			: base(104960651) {}
		
		public BSerializer_104960651(int typeId)
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
			BResult_1972793385 obj = (BResult_1972793385)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._result, false, com.wilutions.byps.test.api.BSerializer_1972793385.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BResult_1972793385 obj = (BResult_1972793385)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_1972793385()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._result = (Dictionary<double,byte>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
