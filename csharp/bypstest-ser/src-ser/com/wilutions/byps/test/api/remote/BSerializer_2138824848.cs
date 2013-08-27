//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setFloat1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_2138824848 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2138824848();
		
		public BSerializer_2138824848()
			: base(2138824848) {}
		
		public BSerializer_2138824848(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: float1 */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteListTypes_setFloat1 obj = (BRequest_RemoteListTypes_setFloat1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._float1, false, com.wilutions.byps.test.api.BSerializer_1628501332.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteListTypes_setFloat1 obj = (BRequest_RemoteListTypes_setFloat1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setFloat1()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._float1 = (IList<float>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
