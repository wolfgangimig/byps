//
// Serializer for byps.test.api.remote.BRequest_RemoteServerCtrl_publishRemote
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1543768912 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1543768912();
		
		public BSerializer_1543768912()
			: base(1543768912) {}
		
		public BSerializer_1543768912(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteServerCtrl_publishRemote obj = (BRequest_RemoteServerCtrl_publishRemote)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putBoolean(obj.fowardToOtherServersValue);
			// checkpoint byps.gen.cs.PrintContext:498
			bbuf.putString(obj.nameValue);
			// checkpoint byps.gen.cs.PrintContext:498
			bout.writeObj(obj.remoteValue, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteServerCtrl_publishRemote obj = (BRequest_RemoteServerCtrl_publishRemote)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteServerCtrl_publishRemote()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:453
			obj.fowardToOtherServersValue = bbuf.getBoolean();
			// checkpoint byps.gen.cs.PrintContext:453
			obj.nameValue = bbuf.getString();
			// checkpoint byps.gen.cs.PrintContext:453
			obj.remoteValue = (BRemote)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
