using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.srvr
{
	
	// checkpoint byps.gen.cs.GenRemoteClass:93
	public interface ServerIF : BRemote {
	
		int CallClientIncrementInt(int v);
		void CallClientIncrementInt(int v, BAsyncResult<int> asyncResult) ;
		Task<int> CallClientIncrementIntAsync(int v);
		
		void SetPartner(ClientIF client);
		void SetPartner(ClientIF client, BAsyncResult<Object> asyncResult) ;
		Task SetPartnerAsync(ClientIF client);
		
		ClientIF GetPartner();
		void GetPartner(BAsyncResult<ClientIF> asyncResult) ;
		Task<ClientIF> GetPartnerAsync();
		
		IList<System.IO.Stream> GetStreamsFromClient();
		void GetStreamsFromClient(BAsyncResult<IList<System.IO.Stream>> asyncResult) ;
		Task<IList<System.IO.Stream>> GetStreamsFromClientAsync();
		
		void PutStreamsOnClient(IList<System.IO.Stream> streams);
		void PutStreamsOnClient(IList<System.IO.Stream> streams, BAsyncResult<Object> asyncResult) ;
		Task PutStreamsOnClientAsync(IList<System.IO.Stream> streams);
		
		void RegisterWithClientMap(int id);
		void RegisterWithClientMap(int id, BAsyncResult<Object> asyncResult) ;
		Task RegisterWithClientMapAsync(int id);
		
		ClientIF GetClient(int id);
		void GetClient(int id, BAsyncResult<ClientIF> asyncResult) ;
		Task<ClientIF> GetClientAsync(int id);
		
		ISet<int> GetClientIds();
		void GetClientIds(BAsyncResult<ISet<int>> asyncResult) ;
		Task<ISet<int>> GetClientIdsAsync();
		
		int CallClientParallel(int v);
		void CallClientParallel(int v, BAsyncResult<int> asyncResult) ;
		Task<int> CallClientParallelAsync(int v);
		
		
	}
}  // end namespace
