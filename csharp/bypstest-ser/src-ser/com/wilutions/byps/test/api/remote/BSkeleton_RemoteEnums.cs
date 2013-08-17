using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.remote
{
	
	/// <summary>
	/// This class provides a skeleton implementation of the interface RemoteEnums.
	/// </summary>
	/// <remark>
	/// Your interface implementation class has to be derived from this skeleton.
	/// Either provide an asynchronous or a synchronous function in your subclass.
	/// The framework calls only the asynchronous function.
	/// </remark>
	public class BSkeleton_RemoteEnums : BSkeleton, RemoteEnums {	
		
		public readonly static long serialVersionUID = 359349400L;
		
		public virtual com.wilutions.byps.test.api.enu.EnumPlanets GetPlanet() {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_GetPlanet(BAsyncResult<com.wilutions.byps.test.api.enu.EnumPlanets> asyncResult) {
			try {
				com.wilutions.byps.test.api.enu.EnumPlanets ret = GetPlanet();
				asyncResult.setAsyncResult(ret, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(0, e);
			}
		}
		public IAsyncResult BeginGetPlanet(AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public com.wilutions.byps.test.api.enu.EnumPlanets EndGetPlanet(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		public virtual void SetPlanet(com.wilutions.byps.test.api.enu.EnumPlanets planet) {
			throw new BException(BException.UNSUPPORTED_METHOD, "");
		}
		public virtual void async_SetPlanet(com.wilutions.byps.test.api.enu.EnumPlanets planet, BAsyncResult<Object> asyncResult) {
			try {
				SetPlanet(planet);
				asyncResult.setAsyncResult(null, null);
			} catch (Exception e) {
				asyncResult.setAsyncResult(null, e);
			}
		}
		public IAsyncResult BeginSetPlanet(com.wilutions.byps.test.api.enu.EnumPlanets planet, AsyncCallback callback, object state) {
			throw new BException(BException.INTERNAL, "");
		}
		public Object EndSetPlanet(IAsyncResult asyncResult) {
			throw new BException(BException.INTERNAL, "");
		}
		
		
	}
}
