package byps.test.api.enu;

import java.util.ArrayList;
import java.util.Map;

import java.io.Serializable;

public class UsePlanets implements Serializable {

	private static final long serialVersionUID = 10000L;

	public EnumPlanets planet;

	private EnumPlanets planet2;
	
	public EnumPlanets[] arrayOfPlanets;
	
	public ArrayList<EnumPlanets> listOfPlanets;

	public Map<String, EnumPlanets> mapOfPlanets;

	public EnumPlanets getPlanet2() {
		return planet2;
	}

	public void setPlanet2(EnumPlanets planet2) {
		this.planet2 = planet2;
	}
	
	// public Map<EnumPlanets, String> mapKeyPlanets; JavaScript erlaubt nur Number und String als Key-Typen
	
	
}
