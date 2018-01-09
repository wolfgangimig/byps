package byps.test.servlet;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import byps.RemoteException;
import byps.test.api.enu.EnumPlanets;
import byps.test.api.remote.BSkeleton_RemoteEnums;

public class MyRemoteEnums extends BSkeleton_RemoteEnums {
	
	EnumPlanets planet;

	@Override
	public EnumPlanets getPlanet() throws RemoteException {
		return planet;
	}

	@Override
	public void setPlanet(EnumPlanets planet) throws RemoteException {
		this.planet = planet;
	}

}
