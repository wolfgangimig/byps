using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	public class BStub_RemoteEnums : BStub, RemoteEnums, BSerializable {	
		
		public readonly static long serialVersionUID = 359349400L;
		
		public BStub_RemoteEnums(BTransport transport)
			: base(transport) {}			
		
		public com.wilutions.byps.test.api.enu.EnumPlanets GetPlanet() {
			BSyncResult<com.wilutions.byps.test.api.enu.EnumPlanets> asyncResult = new BSyncResult<com.wilutions.byps.test.api.enu.EnumPlanets>();			
			GetPlanet(BAsyncResultHelper.ToDelegate<com.wilutions.byps.test.api.enu.EnumPlanets>(asyncResult));
			return asyncResult.GetResult();			
		}
		public void GetPlanet(BAsyncResult<com.wilutions.byps.test.api.enu.EnumPlanets> asyncResult) {
			BRequest_RemoteEnums_getPlanet req = new BRequest_RemoteEnums_getPlanet();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task<com.wilutions.byps.test.api.enu.EnumPlanets> GetPlanetAsync(){
			BRequest_RemoteEnums_getPlanet req = new BRequest_RemoteEnums_getPlanet();			
			Task<com.wilutions.byps.test.api.enu.EnumPlanets> task = Task<com.wilutions.byps.test.api.enu.EnumPlanets>.Factory.FromAsync(transport.BeginSend<com.wilutions.byps.test.api.enu.EnumPlanets>, transport.EndSend<com.wilutions.byps.test.api.enu.EnumPlanets>, req, null);
			return await task;
		}
		
		public void SetPlanet(com.wilutions.byps.test.api.enu.EnumPlanets planet) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPlanet(planet, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public void SetPlanet(com.wilutions.byps.test.api.enu.EnumPlanets planet, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteEnums_setPlanet req = new BRequest_RemoteEnums_setPlanet();			
			req._planet = planet;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint com.wilutions.byps.gen.cs.GenRemoteStub:133
		public async Task SetPlanetAsync(com.wilutions.byps.test.api.enu.EnumPlanets planet){
			BRequest_RemoteEnums_setPlanet req = new BRequest_RemoteEnums_setPlanet();			
			req._planet = planet;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		
	}
}
