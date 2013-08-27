//
// Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteEnums_setPlanet
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BSerializer_412393386 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_412393386();
		
		public BSerializer_412393386()
			: base(412393386) {}
		
		public BSerializer_412393386(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: planet */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			BRequest_RemoteEnums_setPlanet obj = (BRequest_RemoteEnums_setPlanet)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putInt((int)obj._planet);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			BRequest_RemoteEnums_setPlanet obj = (BRequest_RemoteEnums_setPlanet)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteEnums_setPlanet()));
			
			BBufferBin bbuf = bin.bbuf;
			obj._planet = (com.wilutions.byps.test.api.enu.EnumPlanets)bbuf.getInt();
			
			return obj;
		}
		
	}
} // namespace
