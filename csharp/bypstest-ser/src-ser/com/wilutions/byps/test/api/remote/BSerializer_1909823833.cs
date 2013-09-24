//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setByte2
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1909823833 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1909823833();
		
		public BSerializer_1909823833()
			: base(1909823833) {}
		
		public BSerializer_1909823833(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteMapTypes_setByte2 obj = (BRequest_RemoteMapTypes_setByte2)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._byte2, false, com.wilutions.byps.test.api.BSerializer_1799280818.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteMapTypes_setByte2 obj = (BRequest_RemoteMapTypes_setByte2)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_setByte2()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._byte2 = (IDictionary<int,byte[]>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
