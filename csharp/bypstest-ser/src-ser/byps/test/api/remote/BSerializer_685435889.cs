//
// Serializer for byps.test.api.remote.BRequest_RemoteMapTypes_setChar1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_685435889 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_685435889();
		
		public BSerializer_685435889()
			: base(685435889) {}
		
		public BSerializer_685435889(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteMapTypes_setChar1 obj = (BRequest_RemoteMapTypes_setChar1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._char1, false, byps.test.api.BSerializer_8789515.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteMapTypes_setChar1 obj = (BRequest_RemoteMapTypes_setChar1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_setChar1()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._char1 = (Dictionary<float,char>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
