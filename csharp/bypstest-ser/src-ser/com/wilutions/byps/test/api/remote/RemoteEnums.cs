using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	// checkpoint com.wilutions.byps.gen.cs.GenRemoteClass:93
	public interface RemoteEnums : BRemote {
	
		com.wilutions.byps.test.api.enu.EnumPlanets GetPlanet();
		void GetPlanet(BAsyncResult<com.wilutions.byps.test.api.enu.EnumPlanets> asyncResult) ;
		Task<com.wilutions.byps.test.api.enu.EnumPlanets> GetPlanetAsync();
		
		void SetPlanet(com.wilutions.byps.test.api.enu.EnumPlanets planet);
		void SetPlanet(com.wilutions.byps.test.api.enu.EnumPlanets planet, BAsyncResult<Object> asyncResult) ;
		Task SetPlanetAsync(com.wilutions.byps.test.api.enu.EnumPlanets planet);
		
		
	}
}  // end namespace
