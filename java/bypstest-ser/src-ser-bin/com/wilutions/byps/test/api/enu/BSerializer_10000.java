package com.wilutions.byps.test.api.enu;

/*
 * Serializer for com.wilutions.byps.test.api.enu.UsePlanets
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=false
// isInline=false
// #members=5

@SuppressWarnings("all")
public class BSerializer_10000 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_10000();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* pos=0: planet */ + 4		
		       /* pos=4: planet2 */ + 4		
		       /* pos=8: arrayOfPlanets */ + 4		
		       /* pos=12: listOfPlanets */ + 4		
		       /* pos=16: mapOfPlanets */ + 4		
		       /* padding up to multiple of alignment */ + 4;		
	}
	
	public BSerializer_10000() {
		super(10000);
	}
	
	public BSerializer_10000(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void write(final Object obj1, final BOutput bout1, final int version) throws BException {
		final UsePlanets obj = (UsePlanets)obj1;		
		final BOutputBin bout = (BOutputBin)bout1;
		final BBufferBin bbuf = bout.bbuf;
		bbuf.putInt(obj.planet!=null ? obj.planet.ordinal() : 0);
		bbuf.putInt(obj.getPlanet2()!=null ? obj.getPlanet2().ordinal() : 0);
		bout.writeObj(obj.arrayOfPlanets, false, com.wilutions.byps.test.api.BSerializer_1092048313.instance);
		bout.writeObj(obj.listOfPlanets, false, com.wilutions.byps.test.api.BSerializer_1590740862.instance);
		bout.writeObj(obj.mapOfPlanets, false, com.wilutions.byps.test.api.BSerializer_252873856.instance);
	}
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final UsePlanets obj = (UsePlanets)(obj1 != null ? obj1 : bin.onObjectCreated(new UsePlanets()));
		
		final BBufferBin bbuf = bin.bbuf;
		
		obj.planet = BEnumHelper.fromOrdinal(com.wilutions.byps.test.api.enu.EnumPlanets.values(), bbuf.getInt());
		obj.setPlanet2(BEnumHelper.fromOrdinal(com.wilutions.byps.test.api.enu.EnumPlanets.values(), bbuf.getInt()));
		obj.arrayOfPlanets = (com.wilutions.byps.test.api.enu.EnumPlanets[])bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1092048313.instance);
		obj.listOfPlanets = (java.util.ArrayList<com.wilutions.byps.test.api.enu.EnumPlanets>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_1590740862.instance);
		obj.mapOfPlanets = (java.util.Map<java.lang.String,com.wilutions.byps.test.api.enu.EnumPlanets>)bin.readObj(false, com.wilutions.byps.test.api.BSerializer_252873856.instance);
		
		return obj;
	}
	
}
