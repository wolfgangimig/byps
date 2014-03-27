using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
{
	
	// checkpoint byps.gen.cs.GenRemoteClass:93
	public interface RemoteEnums : BRemote {
	
		byps.test.api.enu.EnumPlanets GetPlanet();
		void GetPlanet(BAsyncResult<byps.test.api.enu.EnumPlanets> asyncResult) ;
		Task<byps.test.api.enu.EnumPlanets> GetPlanetAsync();
		
		void SetPlanet(byps.test.api.enu.EnumPlanets planet);
		void SetPlanet(byps.test.api.enu.EnumPlanets planet, BAsyncResult<Object> asyncResult) ;
		Task SetPlanetAsync(byps.test.api.enu.EnumPlanets planet);
		
		
	}
}  // end namespace
