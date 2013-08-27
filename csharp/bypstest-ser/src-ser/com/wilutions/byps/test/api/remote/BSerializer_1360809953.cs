//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setInt3
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1360809953 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1360809953();
		
		public BSerializer_1360809953()
			: base(1360809953) {}
		
		public BSerializer_1360809953(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: int3 */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteListTypes_setInt3 obj = (BRequest_RemoteListTypes_setInt3)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._int3, false, com.wilutions.byps.test.api.BSerializer_1746702954.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteListTypes_setInt3 obj = (BRequest_RemoteListTypes_setInt3)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setInt3()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._int3 = (IList<IList<int>>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
