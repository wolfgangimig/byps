//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setDouble1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_99940797 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_99940797();
		
		public BSerializer_99940797()
			: base(99940797) {}
		
		public BSerializer_99940797(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: double1 */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			BRequest_RemoteMapTypes_setDouble1 obj = (BRequest_RemoteMapTypes_setDouble1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._double1, false, com.wilutions.byps.test.api.BSerializer_1487265161.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteMapTypes_setDouble1 obj = (BRequest_RemoteMapTypes_setDouble1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_setDouble1()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._double1 = (IDictionary<byte,double>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
