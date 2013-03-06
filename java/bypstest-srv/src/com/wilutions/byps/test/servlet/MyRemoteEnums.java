package com.wilutions.byps.test.servlet;

import com.wilutions.byps.BException;
import com.wilutions.byps.test.api.enu.EnumPlanets;
import com.wilutions.byps.test.api.remote.BSkeleton_RemoteEnums;

public class MyRemoteEnums extends BSkeleton_RemoteEnums {
	
	EnumPlanets planet;

	@Override
	public EnumPlanets getPlanet() throws BException, InterruptedException {
		return planet;
	}

	@Override
	public void setPlanet(EnumPlanets planet) throws BException,
			InterruptedException {
		this.planet = planet;
	}

}
