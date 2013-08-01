package com.wilutions.byps.test.servlet;

import com.wilutions.byps.RemoteException;
import com.wilutions.byps.test.api.enu.EnumPlanets;
import com.wilutions.byps.test.api.remote.BSkeleton_RemoteEnums;

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
