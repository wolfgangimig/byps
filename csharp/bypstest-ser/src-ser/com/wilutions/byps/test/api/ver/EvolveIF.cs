using System;
using System.Collections.Generic;
using com.wilutions.byps;

namespace com.wilutions.byps.test.api.ver
{
	
	public interface EvolveIF : BRemote
	{
		void SetEvolve(Evolve obj);
		void SetEvolveAsync(Evolve obj, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetEvolve(Evolve obj, AsyncCallback callback, object state);
		Object EndSetEvolve(IAsyncResult asyncResult);
		
		Evolve GetEvolve();
		void GetEvolveAsync(BAsyncResult<Evolve> asyncResult) ;
		IAsyncResult BeginGetEvolve(AsyncCallback callback, object state);
		Evolve EndGetEvolve(IAsyncResult asyncResult);
		
		void SetClient(EvolveIF partner);
		void SetClientAsync(EvolveIF partner, BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSetClient(EvolveIF partner, AsyncCallback callback, object state);
		Object EndSetClient(IAsyncResult asyncResult);
		
		EvolveIF GetClient();
		void GetClientAsync(BAsyncResult<EvolveIF> asyncResult) ;
		IAsyncResult BeginGetClient(AsyncCallback callback, object state);
		EvolveIF EndGetClient(IAsyncResult asyncResult);
		
		void SendEvolveToClient();
		void SendEvolveToClientAsync(BAsyncResult<Object> asyncResult) ;
		IAsyncResult BeginSendEvolveToClient(AsyncCallback callback, object state);
		Object EndSendEvolveToClient(IAsyncResult asyncResult);
		
		
	}
}  // end namespace
