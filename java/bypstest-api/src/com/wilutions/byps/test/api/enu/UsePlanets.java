package com.wilutions.byps.test.api.enu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class UsePlanets implements Serializable {

	private static final long serialVersionUID = 10000L;

	public EnumPlanets planet;

	private EnumPlanets planet2;
	
	public EnumPlanets[] arrayOfPlanets;
	
	public ArrayList<EnumPlanets> listOfPlanets;

	public Map<String, EnumPlanets> mapOfPlanets;
	
	// public Map<EnumPlanets, String> mapKeyPlanets; JavaScript erlaubt nur Number und String als Key-Typen
}
