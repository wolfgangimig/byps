package byps.test.servlet;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.Collection;
import java.util.concurrent.CountDownLatch;

import byps.BAsyncResult;
import byps.BClient;
import byps.BHashMap;
import byps.BRemote;
import byps.BServerRegistry;
import byps.RemoteException;
import byps.test.api.BClient_Testser;
import byps.test.api.remote.BSkeleton_RemoteServerCtrl;

public class MyRemoteServerCtrl extends BSkeleton_RemoteServerCtrl {
	
	private BServerRegistry serverRegistry;
	private final static BHashMap<String, BRemote> publishedRemotes = new BHashMap<String, BRemote>();
	
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
					myclient.getRemoteServerCtrl().publishRemote(name, remote, false, outerResult);
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
