//
// Serializer for com.wilutions.byps.test.api.enu.UsePlanets
// 
// THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
//

using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.enu
{
	
	public class BSerializer_10000 : BSerializer {
		
		public readonly static BSerializer instance = new BSerializer_10000();
		
		public BSerializer_10000()
			: base(10000) {}
		
		public BSerializer_10000(int typeId)
			: base(typeId) {}
		
		
		public override int size(Object obj, BBinaryModel bmodel)
		{
			return 0
			       /* size of base class */ + 0
			       /* pos=0: planet */ + 4			
			       /* pos=4: planet2 */ + 4			
			       /* pos=8: arrayOfPlanets */ + 4			
			       /* pos=12: listOfPlanets */ + 4			
			       /* pos=16: mapOfPlanets */ + 4			
			       /* padding up to multiple of alignment */ + 4;			
		}
		
		public override void write(Object obj1, BOutput bout1, long version)
		{
			UsePlanets obj = (UsePlanets)obj1;			
			BOutputBin bout = (BOutputBin)bout1;
			BBufferBin bbuf = bout.bbuf;
			bbuf.putInt((int)obj.Planet);
			bbuf.putInt((int)obj.Planet2);
			bout.writeObj(obj.ArrayOfPlanets, false, com.wilutions.byps.test.api.BSerializer_1092048313.instance);
			bout.writeObj(obj.ListOfPlanets, false, com.wilutions.byps.test.api.BSerializer_1590740862.instance);
			bout.writeObj(obj.MapOfPlanets, false, com.wilutions.byps.test.api.BSerializer_252873856.instance);
		}
		
		public override Object read(Object obj1, BInput bin1, long version)
		{
			BInputBin bin = (BInputBin)bin1;
			UsePlanets obj = (UsePlanets)(obj1 != null ? obj1 : bin.onObjectCreated(new UsePlanets()));
			
			BBufferBin bbuf = bin.bbuf;
			obj.Planet = (com.wilutions.byps.test.api.enu.EnumPlanets)bbuf.getInt();
			obj.Planet2 = (com.wilutions.byps.test.api.enu.EnumPlanets)bbuf.getInt();
			obj.ArrayOfPlanets = (com.wilutions.byps.test.api.enu.EnumPlanets[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1092048313.instance);
			obj.ListOfPlanets = (List<com.wilutions.byps.test.api.enu.EnumPlanets>)bin.readObj(false, null);
			obj.MapOfPlanets = (IDictionary<String,com.wilutions.byps.test.api.enu.EnumPlanets>)bin.readObj(false, null);
			
			return obj;
		}
		
	}
} // namespace
