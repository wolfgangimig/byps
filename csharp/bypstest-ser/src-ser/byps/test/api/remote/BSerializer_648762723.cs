//
// Serializer for byps.test.api.remote.BRequest_RemoteServerCtrl_getPublishedRemote
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_648762723 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_648762723();
		
		public BSerializer_648762723()
			: base(648762723) {}
		
		public BSerializer_648762723(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteServerCtrl_getPublishedRemote obj = (BRequest_RemoteServerCtrl_getPublishedRemote)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putString(obj._name);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteServerCtrl_getPublishedRemote obj = (BRequest_RemoteServerCtrl_getPublishedRemote)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteServerCtrl_getPublishedRemote()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._name = bbuf.getString();
			
			return obj;
		}
		
	}
} // namespace
