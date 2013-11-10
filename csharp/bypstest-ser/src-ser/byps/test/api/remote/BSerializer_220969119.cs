//
// Serializer for byps.test.api.remote.BRequest_RemoteEnums_setPlanet
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using byps;

namespace byps.test.api.remote
{
	
	public class BSerializer_220969119 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_220969119();
		
		public BSerializer_220969119()
			: base(220969119) {}
		
		public BSerializer_220969119(int typeId)
			: base(typeId) {}
		
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteEnums_setPlanet obj = (BRequest_RemoteEnums_setPlanet)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			// checkpoint byps.gen.cs.PrintContext:492
			bbuf.putInt((int)obj.planetValue);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteEnums_setPlanet obj = (BRequest_RemoteEnums_setPlanet)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteEnums_setPlanet()));
			
			BBufferBin bbuf = bin.bbuf;
			// checkpoint byps.gen.cs.PrintContext:447
			obj.planetValue = (byps.test.api.enu.EnumPlanets)bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
