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
public class JSerializer_10000 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_10000();
	
	
	public JSerializer_10000() {
		super(10000);
	}
	
	public JSerializer_10000(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final UsePlanets obj = (UsePlanets)obj1;		
		bbuf.putInt("planet", obj.planet!=null ? obj.planet.ordinal() : 0);
		bbuf.putInt("planet2", obj.getPlanet2()!=null ? obj.getPlanet2().ordinal() : 0);
		bout.writeObj("arrayOfPlanets",obj.arrayOfPlanets, false, com.wilutions.byps.test.api.JSerializer_1092048313.instance);
		bout.writeObj("listOfPlanets",obj.listOfPlanets, false, com.wilutions.byps.test.api.JSerializer_1590740862.instance);
		bout.writeObj("mapOfPlanets",obj.mapOfPlanets, false, com.wilutions.byps.test.api.JSerializer_252873856.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final UsePlanets obj = (UsePlanets)(obj1 != null ? obj1 : bin.onObjectCreated(new UsePlanets()));
		
		final BJsonObject js = bin.currentObject;
		obj.planet = BEnumHelper.fromOrdinal(com.wilutions.byps.test.api.enu.EnumPlanets.values(), js.getInt("planet"));
		obj.setPlanet2(BEnumHelper.fromOrdinal(com.wilutions.byps.test.api.enu.EnumPlanets.values(), js.getInt("planet2")));
		obj.arrayOfPlanets = (com.wilutions.byps.test.api.enu.EnumPlanets[])bin.readObj("arrayOfPlanets", false, com.wilutions.byps.test.api.JSerializer_1092048313.instance);
		obj.listOfPlanets = (java.util.ArrayList<com.wilutions.byps.test.api.enu.EnumPlanets>)bin.readObj("listOfPlanets", false, com.wilutions.byps.test.api.JSerializer_1590740862.instance);
		obj.mapOfPlanets = (java.util.Map<java.lang.String,com.wilutions.byps.test.api.enu.EnumPlanets>)bin.readObj("mapOfPlanets", false, com.wilutions.byps.test.api.JSerializer_252873856.instance);
		
		return obj;
	}
	
}
