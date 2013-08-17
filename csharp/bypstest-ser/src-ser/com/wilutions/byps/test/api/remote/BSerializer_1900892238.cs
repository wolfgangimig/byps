//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setLong1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1900892238 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1900892238();
		
		public BSerializer_1900892238()
			: base(1900892238) {}
		
		public BSerializer_1900892238(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: long1 */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			BRequest_RemoteMapTypes_setLong1 obj = (BRequest_RemoteMapTypes_setLong1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._long1, false, com.wilutions.byps.test.api.BSerializer_1973996106.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteMapTypes_setLong1 obj = (BRequest_RemoteMapTypes_setLong1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_setLong1()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._long1 = (IDictionary<short,long>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
