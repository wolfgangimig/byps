//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setDouble
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_1770586860 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_1770586860();
		
		public BSerializer_1770586860()
			: base(1770586860) {}
		
		public BSerializer_1770586860(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteArrayTypes4dim_setDouble obj = (BRequest_RemoteArrayTypes4dim_setDouble)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:490
			bout.writeObj(obj.vValue, false, byps.test.api.BSerializer_2087445849.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes4dim_setDouble obj = (BRequest_RemoteArrayTypes4dim_setDouble)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_setDouble()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:445
			obj.vValue = (double[,,,])bin.readObj(false, byps.test.api.BSerializer_2087445849.instance);
			
			return obj;
		}
		
	}
} // namespace
