//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setByte2
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_758429071 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_758429071();
		
		public BSerializer_758429071()
			: base(758429071) {}
		
		public BSerializer_758429071(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: byte2 */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			BRequest_RemoteListTypes_setByte2 obj = (BRequest_RemoteListTypes_setByte2)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._byte2, false, com.wilutions.byps.test.api.BSerializer_1174971318.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteListTypes_setByte2 obj = (BRequest_RemoteListTypes_setByte2)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setByte2()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._byte2 = (IList<byte[]>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
