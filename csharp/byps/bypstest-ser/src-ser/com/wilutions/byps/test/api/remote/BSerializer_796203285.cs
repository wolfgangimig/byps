//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setDouble
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_796203285 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_796203285();
		
		public BSerializer_796203285()
			: base(796203285) {}
		
		public BSerializer_796203285(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: v */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, int version)
		{
			BRequest_RemoteArrayTypes4dim_setDouble obj = (BRequest_RemoteArrayTypes4dim_setDouble)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bout.writeObj(obj._v, false, com.wilutions.byps.test.api.BSerializer_2087445849.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, int version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes4dim_setDouble obj = (BRequest_RemoteArrayTypes4dim_setDouble)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_setDouble()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._v = (double[,,,])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_2087445849.instance);
			
			return obj;
		}
		
	}
} // namespace
