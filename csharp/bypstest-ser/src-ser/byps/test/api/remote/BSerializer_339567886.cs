//
// Serializer for byps.test.api.remote.BRequest_RemoteListTypes_setString1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_339567886 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_339567886();
		
		public BSerializer_339567886()
			: base(339567886) {}
		
		public BSerializer_339567886(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteListTypes_setString1 obj = (BRequest_RemoteListTypes_setString1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.string1Value, false, byps.test.api.BSerializer_2123584667.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteListTypes_setString1 obj = (BRequest_RemoteListTypes_setString1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setString1()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.string1Value = (IList<String>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
