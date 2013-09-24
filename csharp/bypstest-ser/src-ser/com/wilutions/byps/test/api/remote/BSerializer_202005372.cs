//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setBool
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_202005372 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_202005372();
		
		public BSerializer_202005372()
			: base(202005372) {}
		
		public BSerializer_202005372(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteArrayTypes4dim_setBool obj = (BRequest_RemoteArrayTypes4dim_setBool)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._v, false, com.wilutions.byps.test.api.BSerializer_945713488.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes4dim_setBool obj = (BRequest_RemoteArrayTypes4dim_setBool)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_setBool()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._v = (bool[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_945713488.instance);
			
			return obj;
		}
		
	}
} // namespace
