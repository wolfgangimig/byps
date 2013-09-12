using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public interface RemoteEnums : BRemote
	{
		com.wilutions.byps.test.api.enu.EnumPlanets GetPlanet();
		void GetPlanetAsync(BAsyncResult<com.wilutions.byps.test.api.enu.EnumPlanets> asyncResult) ;
		IAsyncResult BeginGetPlanet(AsyncCallback callback, object state);
		com.wilutions.byps.test.api.enu.EnumPlanets EndGetPlanet(IAsyncResult asyncResult);
		
		void SetPlanet(com.wilutions.byps.test.api.enu.EnumPlanets planet);
		void SetPlanetAsync(com.wilutions.byps.test.api.enu.EnumPlanets planet, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetPlanet(com.wilutions.byps.test.api.enu.EnumPlanets planet, AsyncCallback callback, object state);
		Object EndSetPlanet(IAsyncResult asyncResult);
		
		
	}
}  // end namespace
