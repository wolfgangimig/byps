//
// Serializer for byps.test.api.remote.BRequest_RemoteServerCtrl_removePublishedRemote
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_135366859 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_135366859();
		
		public BSerializer_135366859()
			: base(135366859) {}
		
		public BSerializer_135366859(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteServerCtrl_removePublishedRemote obj = (BRequest_RemoteServerCtrl_removePublishedRemote)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bbuf.putString(obj.nameValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteServerCtrl_removePublishedRemote obj = (BRequest_RemoteServerCtrl_removePublishedRemote)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteServerCtrl_removePublishedRemote()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.nameValue = bbuf.getString();
			
			return obj;
		}
		
	}
} // namespace
