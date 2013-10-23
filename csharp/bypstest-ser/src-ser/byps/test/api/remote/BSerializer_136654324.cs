//
// Serializer for byps.test.api.remote.BRequest_RemoteListTypes_setObj1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_136654324 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_136654324();
		
		public BSerializer_136654324()
			: base(136654324) {}
		
		public BSerializer_136654324(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteListTypes_setObj1 obj = (BRequest_RemoteListTypes_setObj1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._obj1, false, byps.BSerializer_12.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteListTypes_setObj1 obj = (BRequest_RemoteListTypes_setObj1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setObj1()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._obj1 = (IList<Object>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
