package com.wilutions.byps.test.api.remote;

import com.wilutions.byps.BException;
import com.wilutions.byps.BRemote;
import com.wilutions.byps.test.api.enu.EnumPlanets;

/**
 * 
 */
public interface RemoteEnums extends BRemote {

	EnumPlanets getPlanet() throws BException, InterruptedException;
	
	void setPlanet(EnumPlanets planet) throws BException, InterruptedException;
}
