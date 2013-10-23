package byps;

import byps.BException;


public class BServerR {
	
	public final BTransport transport;
	public final BServer server;

	public BServerR(BTransport transport, BServer server) {
		this.transport = transport;
		this.server = server; // new MyServer(server);
	}

	public void start() throws BException {
	}

	public void done() {
	}
	

}
