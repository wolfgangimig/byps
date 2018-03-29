using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
{
	
	public class BStub_RemoteEnums : BStub, RemoteEnums, BSerializable {	
		
		public readonly static long serialVersionUID = 485761455L;
		
		public BStub_RemoteEnums(BTransport transport)
			: base(transport) {}			
		
		public virtual byps.test.api.enu.EnumPlanets GetPlanet() {
			BSyncResult<byps.test.api.enu.EnumPlanets> asyncResult = new BSyncResult<byps.test.api.enu.EnumPlanets>();			
			GetPlanet(BAsyncResultHelper.ToDelegate<byps.test.api.enu.EnumPlanets>(asyncResult));
			return asyncResult.GetResult();			
		}
		public virtual void GetPlanet(BAsyncResult<byps.test.api.enu.EnumPlanets> asyncResult) {
			BRequest_RemoteEnums_getPlanet req = new BRequest_RemoteEnums_getPlanet();			
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task<byps.test.api.enu.EnumPlanets> GetPlanetAsync(){
			BRequest_RemoteEnums_getPlanet req = new BRequest_RemoteEnums_getPlanet();			
			Task<byps.test.api.enu.EnumPlanets> task = Task<byps.test.api.enu.EnumPlanets>.Factory.FromAsync(transport.BeginSend<byps.test.api.enu.EnumPlanets>, transport.EndSend<byps.test.api.enu.EnumPlanets>, req, null);
			return await task;
		}
		
		public virtual void SetPlanet(byps.test.api.enu.EnumPlanets planet) {
			BSyncResult<Object> asyncResult = new BSyncResult<Object>();			
			SetPlanet(planet, BAsyncResultHelper.ToDelegate<Object>(asyncResult));
			asyncResult.GetResult();			
		}
		public virtual void SetPlanet(byps.test.api.enu.EnumPlanets planet, BAsyncResult<Object> asyncResult) {
			BRequest_RemoteEnums_setPlanet req = new BRequest_RemoteEnums_setPlanet();			
			req.planetValue = planet;
			transport.sendMethod(req, asyncResult);
		}
		// checkpoint byps.gen.cs.GenRemoteStub:133
		public async Task SetPlanetAsync(byps.test.api.enu.EnumPlanets planet){
			BRequest_RemoteEnums_setPlanet req = new BRequest_RemoteEnums_setPlanet();			
			req.planetValue = planet;
			Task<Object> task = Task<Object>.Factory.FromAsync(transport.BeginSend<Object>, transport.EndSend<Object>, req, null);
			await task;
		}
		
		
	}
}
