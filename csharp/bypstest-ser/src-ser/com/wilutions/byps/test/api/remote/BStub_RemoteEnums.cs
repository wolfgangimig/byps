using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BStub_RemoteEnums : BStub, RemoteEnums, BSerializable {	
		
		public readonly static long serialVersionUID = 359349400L;
		
		public BStub_RemoteEnums(BTransport transport)
			: base(transport) {}			
		
		public com.wilutions.byps.test.api.enu.EnumPlanets GetPlanet() {
			BSyncResult<com.wilutions.byps.test.api.enu.EnumPlanets> asyncResult = new BSyncResult<com.wilutions.byps.test.api.enu.EnumPlanets>();			
			GetPlanetAsync(asyncResult);
			return asyncResult.GetResult();			
		}
		public void GetPlanetAsync(BAsyncResult<com.wilutions.byps.test.api.enu.EnumPlanets> asyncResult) {
			BRequest_RemoteEnums_getPlanet req = new BRequest_RemoteEnums_getPlanet();			
			BAsyncResultReceiveMethod<com.wilutions.byps.test.api.enu.EnumPlanets> outerResult = new BAsyncResultReceiveMethod<com.wilutions.byps.test.api.enu.EnumPlanets>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginGetPlanet(AsyncCallback callback, object state){
			BAsyncProgModel<com.wilutions.byps.test.api.enu.EnumPlanets> _byps_ret = new BAsyncProgModel<com.wilutions.byps.test.api.enu.EnumPlanets>(callback, state);
			GetPlanetAsync(_byps_ret);
			return _byps_ret;
		}
		public 		com.wilutions.byps.test.api.enu.EnumPlanets EndGetPlanet(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<com.wilutions.byps.test.api.enu.EnumPlanets>)asyncResult).Result;
		}
		
		public void SetPlanet(com.wilutions.byps.test.api.enu.EnumPlanets planet) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPlanetAsync(planet, asyncResult);
			asyncResult.GetResult();			
		}
		public void SetPlanetAsync(com.wilutions.byps.test.api.enu.EnumPlanets planet, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteEnums_setPlanet req = new BRequest_RemoteEnums_setPlanet();			
			req._planet = planet;
			BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
			transport.send(req, outerResult);
		}
		public IAsyncResult BeginSetPlanet(com.wilutions.byps.test.api.enu.EnumPlanets planet, AsyncCallback callback, object state){
			BAsyncProgModel<Object> _byps_ret = new BAsyncProgModel<Object>(callback, state);
			SetPlanetAsync(planet, _byps_ret);
			return _byps_ret;
		}
		public 		Object EndSetPlanet(IAsyncResult asyncResult) {
			return ((BAsyncProgModel<Object>)asyncResult).Result;
		}
		
		
	}
}
