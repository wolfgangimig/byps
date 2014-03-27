using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.ver
{
	
	// checkpoint byps.gen.cs.GenRemoteClass:93
	public interface EvolveIF : BRemote {
	
		void SetEvolve(Evolve obj);
		void SetEvolve(Evolve obj, BAsyncResult<Object> asyncResult) ;
		Task SetEvolveAsync(Evolve obj);
		
		Evolve GetEvolve();
		void GetEvolve(BAsyncResult<Evolve> asyncResult) ;
		Task<Evolve> GetEvolveAsync();
		
		void SetClient(EvolveIF partner);
		void SetClient(EvolveIF partner, BAsyncResult<Object> asyncResult) ;
		Task SetClientAsync(EvolveIF partner);
		
		EvolveIF GetClient();
		void GetClient(BAsyncResult<EvolveIF> asyncResult) ;
		Task<EvolveIF> GetClientAsync();
		
		void SendEvolveToClient();
		void SendEvolveToClient(BAsyncResult<Object> asyncResult) ;
		Task SendEvolveToClientAsync();
		
		
	}
}  // end namespace
