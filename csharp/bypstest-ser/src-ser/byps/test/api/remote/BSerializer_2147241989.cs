//
// Serializer for byps.test.api.remote.BRequest_RemoteListTypes_setBoolean1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_2147241989 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_2147241989();
		
		public BSerializer_2147241989()
			: base(2147241989) {}
		
		public BSerializer_2147241989(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteListTypes_setBoolean1 obj = (BRequest_RemoteListTypes_setBoolean1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:492
			bout.writeObj(obj.boolean1Value, false, byps.test.api.BSerializer_1617670280.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteListTypes_setBoolean1 obj = (BRequest_RemoteListTypes_setBoolean1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setBoolean1()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:447
			obj.boolean1Value = (IList<bool>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
