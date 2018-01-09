//
// Serializer for byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setChar
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_185829721 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_185829721();
		
		public BSerializer_185829721()
			: base(185829721) {}
		
		public BSerializer_185829721(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteArrayTypes4dim_setChar obj = (BRequest_RemoteArrayTypes4dim_setChar)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:494
			bout.writeObj(obj.vValue, false, byps.test.api.BSerializer_769021986.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteArrayTypes4dim_setChar obj = (BRequest_RemoteArrayTypes4dim_setChar)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_setChar()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:449
			obj.vValue = (char[,,,])bin.readObj(false, byps.test.api.BSerializer_769021986.instance);
			
			return obj;
		}
		
	}
} // namespace
