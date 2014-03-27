using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using byps;

namespace byps.test.api.remote
{
	
	// checkpoint byps.gen.cs.GenRemoteClass:93
	public interface RemoteServerCtrl : BRemote {
	
		void PublishRemote(String name, BRemote remote, bool fowardToOtherServers);
		void PublishRemote(String name, BRemote remote, bool fowardToOtherServers, BAsyncResult<Object> asyncResult) ;
		Task PublishRemoteAsync(String name, BRemote remote, bool fowardToOtherServers);
		
		BRemote GetPublishedRemote(String name);
		void GetPublishedRemote(String name, BAsyncResult<BRemote> asyncResult) ;
		Task<BRemote> GetPublishedRemoteAsync(String name);
		
		void RemovePublishedRemote(String name);
		void RemovePublishedRemote(String name, BAsyncResult<Object> asyncResult) ;
		Task RemovePublishedRemoteAsync(String name);
		
		
	}
}  // end namespace
