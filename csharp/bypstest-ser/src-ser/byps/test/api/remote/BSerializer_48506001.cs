//
// Serializer for byps.test.api.remote.BRequest_RemoteListTypes_setDate1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_48506001 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_48506001();
		
		public BSerializer_48506001()
			: base(48506001) {}
		
		public BSerializer_48506001(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteListTypes_setDate1 obj = (BRequest_RemoteListTypes_setDate1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.obj1Value, false, byps.test.api.BSerializer_1504867122.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteListTypes_setDate1 obj = (BRequest_RemoteListTypes_setDate1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setDate1()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.obj1Value = (IList<DateTime>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
