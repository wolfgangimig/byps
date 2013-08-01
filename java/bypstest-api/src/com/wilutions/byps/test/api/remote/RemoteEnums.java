package com.wilutions.byps.test.api.remote;

import com.wilutions.byps.BRemote;
import com.wilutions.byps.RemoteException;
import com.wilutions.byps.test.api.enu.EnumPlanets;

/**
 * 
 */
public interface RemoteEnums extends BRemote {

	EnumPlanets getPlanet() throws RemoteException;
	
	void setPlanet(EnumPlanets planet) throws RemoteException;
}
