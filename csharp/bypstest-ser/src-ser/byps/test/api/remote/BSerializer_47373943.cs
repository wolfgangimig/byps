//
// Serializer for byps.test.api.remote.BRequest_RemoteListTypes_setByte1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_47373943 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_47373943();
		
		public BSerializer_47373943()
			: base(47373943) {}
		
		public BSerializer_47373943(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteListTypes_setByte1 obj = (BRequest_RemoteListTypes_setByte1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.byte1Value, false, byps.test.api.BSerializer_1059148284.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteListTypes_setByte1 obj = (BRequest_RemoteListTypes_setByte1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setByte1()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.byte1Value = (IList<byte>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
