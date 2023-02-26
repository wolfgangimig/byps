//
// Serializer for byps.test.api.remote.BRequest_RemoteListTypes_setShort1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1939453607 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1939453607();
		
		public BSerializer_1939453607()
			: base(1939453607) {}
		
		public BSerializer_1939453607(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteListTypes_setShort1 obj = (BRequest_RemoteListTypes_setShort1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.short1Value, false, byps.test.api.BSerializer_1997002548.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteListTypes_setShort1 obj = (BRequest_RemoteListTypes_setShort1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setShort1()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.short1Value = (IList<short>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
