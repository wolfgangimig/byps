//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setLong1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_767360666 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_767360666();
		
		public BSerializer_767360666()
			: base(767360666) {}
		
		public BSerializer_767360666(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteListTypes_setLong1 obj = (BRequest_RemoteListTypes_setLong1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._long1, false, com.wilutions.byps.test.api.BSerializer_1050216688.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteListTypes_setLong1 obj = (BRequest_RemoteListTypes_setLong1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setLong1()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._long1 = (IList<long>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
