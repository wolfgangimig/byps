package byps.ureq;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class byps.gen.j.GenServer DO NOT MODIFY.
 */

import byps.*;

@SuppressWarnings("all")
public class BServer_BUtilityRequests extends BServer { 

	public static BServer_BUtilityRequests createServer(BTransportFactory transportFactory) {
		return new BServer_BUtilityRequests(transportFactory);
	}
	
	public static BServer_BUtilityRequests createServerR(BTransport transport) {
		return new BServer_BUtilityRequests(transport);
	}
	
	public BServer_BUtilityRequests(BTransport transport) {
		super(transport, null);
	}
	
	public BServer_BUtilityRequests(BTransportFactory transportFactory) {
		super(
			transportFactory.createServerTransport(),
			transportFactory.createClientR(
				BClient_BUtilityRequests.createClientR(
					transportFactory.createClientTransport()
				)
			)
		);
	}
	
	public BServer_BUtilityRequests addRemote(BSkeleton_BUtilityRequests remoteSkeleton) {
		addRemote(174367442, remoteSkeleton);
		return this;
	}
	
}
