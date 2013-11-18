package byps.test.servlet;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

import byps.BAsyncResult;
import byps.BClient;
import byps.BRemote;
import byps.BServerRegistry;
import byps.RemoteException;
import byps.test.api.BClient_Testser;
import byps.test.api.remote.BSkeleton_RemoteServerCtrl;

public class MyRemoteServerCtrl extends BSkeleton_RemoteServerCtrl {
	
	private BServerRegistry serverRegistry;
	private final static ConcurrentHashMap<String, BRemote> publishedRemotes = new ConcurrentHashMap<String, BRemote>();
	
	public MyRemoteServerCtrl() {
	}
	
	public void setServerRegistry(BServerRegistry serverRegistry) {
		this.serverRegistry = serverRegistry;
	}

	@Override
	public void publishRemote(String name, BRemote remote, boolean forwardToOtherServers,
			final BAsyncResult<Object> asyncResult) {
		
	 
		try {
			publishedRemotes.put(name, remote);
			
			if (forwardToOtherServers) {
			
				final Collection<BClient> clients = serverRegistry.getForwardClientsToOtherServers();
				
				BAsyncResult<Object> outerResult = new BAsyncResult<Object>() {
					CountDownLatch cdl = new CountDownLatch(clients.size());
					public void setAsyncResult(Object obj, Throwable e) {
						cdl.countDown();
						if (cdl.getCount() == 0) {
							asyncResult.setAsyncResult(obj, e);
						}
					}
				};
				
				for (BClient client : clients) {
					BClient_Testser myclient = (BClient_Testser)client;
					myclient.remoteServerCtrl.publishRemote(name, remote, false, outerResult);
				}
			
			}
			else {
				asyncResult.setAsyncResult(null, null);
			}
			
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
		
		
	}

	@Override
	public BRemote getPublishedRemote(String name)
			throws RemoteException {
		return publishedRemotes.get(name);
	}

	public void removePublishedRemote(String name) {
		publishedRemotes.remove(name);
	}
}
