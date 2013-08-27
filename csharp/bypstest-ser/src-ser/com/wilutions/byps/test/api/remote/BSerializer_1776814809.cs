//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteServerCtrl_publishRemote
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1776814809 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1776814809();
		
		public BSerializer_1776814809()
			: base(1776814809) {}
		
		public BSerializer_1776814809(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: name */ + 4			
			       /* pos=4: remote */ + 4			
			       /* pos=8: fowardToOtherServers */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteServerCtrl_publishRemote obj = (BRequest_RemoteServerCtrl_publishRemote)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putBoolean(obj._fowardToOtherServers);
			bbuf.putString(obj._name);
			bout.writeObj(obj._remote, false, null);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteServerCtrl_publishRemote obj = (BRequest_RemoteServerCtrl_publishRemote)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteServerCtrl_publishRemote()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._fowardToOtherServers = bbuf.getBoolean();
			obj._name = bbuf.getString();
			obj._remote = (BRemote)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
