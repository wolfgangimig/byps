package byps.test.api.remote;

import byps.BRemote;
import byps.RemoteException;
import byps.test.api.enu.EnumPlanets;

/**
 * 
 */
public interface RemoteEnums extends BRemote {

	EnumPlanets getPlanet() throws RemoteException;
	
	void setPlanet(EnumPlanets planet) throws RemoteException;
	
}
