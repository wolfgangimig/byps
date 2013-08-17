//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setInt2
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1360809954 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1360809954();
		
		public BSerializer_1360809954()
			: base(1360809954) {}
		
		public BSerializer_1360809954(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: int2 */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			BRequest_RemoteListTypes_setInt2 obj = (BRequest_RemoteListTypes_setInt2)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._int2, false, com.wilutions.byps.test.api.BSerializer_1752158699.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteListTypes_setInt2 obj = (BRequest_RemoteListTypes_setInt2)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setInt2()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._int2 = (IList<int[]>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
