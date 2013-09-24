//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteServerCtrl_removePublishedRemote
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1302703010 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1302703010();
		
		public BSerializer_1302703010()
			: base(1302703010) {}
		
		public BSerializer_1302703010(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteServerCtrl_removePublishedRemote obj = (BRequest_RemoteServerCtrl_removePublishedRemote)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putString(obj._name);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteServerCtrl_removePublishedRemote obj = (BRequest_RemoteServerCtrl_removePublishedRemote)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteServerCtrl_removePublishedRemote()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._name = bbuf.getString();
			
			return obj;
		}
		
	}
} // namespace
