package com.wilutions.byps.test.api.enu;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public class UsePlanets implements BSerializable {

	public EnumPlanets planet;
	private EnumPlanets planet2;
	public EnumPlanets[] arrayOfPlanets;
	public java.util.ArrayList<EnumPlanets> listOfPlanets;
	public java.util.Map<java.lang.String,EnumPlanets> mapOfPlanets;
	
	private final static long serialVersionUID = 10000L;
	
	public UsePlanets() {
	}	
	
	public UsePlanets(EnumPlanets planet, EnumPlanets planet2, EnumPlanets[] arrayOfPlanets, java.util.ArrayList<EnumPlanets> listOfPlanets, java.util.Map<java.lang.String,EnumPlanets> mapOfPlanets) {
		this.planet = planet;
		this.planet2 = planet2;
		this.arrayOfPlanets = arrayOfPlanets;
		this.listOfPlanets = listOfPlanets;
		this.mapOfPlanets = mapOfPlanets;
	}	
	
	public EnumPlanets getPlanet2(){
		return planet2;
	}
	
	public void setPlanet2(EnumPlanets v) {
		planet2 = v;
	}
	
	
}
