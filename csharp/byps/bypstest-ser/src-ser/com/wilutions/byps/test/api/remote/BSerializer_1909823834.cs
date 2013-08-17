//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setByte1
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_1909823834 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1909823834();
		
		public BSerializer_1909823834()
			: base(1909823834) {}
		
		public BSerializer_1909823834(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: byte1 */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			BRequest_RemoteMapTypes_setByte1 obj = (BRequest_RemoteMapTypes_setByte1)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._byte1, false, com.wilutions.byps.test.api.BSerializer_1972793385.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteMapTypes_setByte1 obj = (BRequest_RemoteMapTypes_setByte1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_setByte1()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._byte1 = (Dictionary<double,byte>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
