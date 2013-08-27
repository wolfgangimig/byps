//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setInt4
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1360809952 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1360809952();
		
		public BSerializer_1360809952()
			: base(1360809952) {}
		
		public BSerializer_1360809952(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: int4 */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteListTypes_setInt4 obj = (BRequest_RemoteListTypes_setInt4)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._int4, false, com.wilutions.byps.test.api.BSerializer_1633500852.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteListTypes_setInt4 obj = (BRequest_RemoteListTypes_setInt4)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setInt4()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._int4 = (IList<IDictionary<int,IList<HashSet<int>>>>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
