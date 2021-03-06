package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import byps.BApiDescriptor;
import byps.BClient;
import byps.BServer;
import byps.BServerR;
import byps.BTransport;
import byps.BTransportFactory;
import byps.BWire;

public class HTransportFactoryClient implements BTransportFactory {
	
	private final BTransport transport;
	private final int nbOfServerRConns;
	
	public HTransportFactoryClient(BApiDescriptor apiDesc, BWire wire, int nbOfServerRConns) {
		this.transport = new BTransport(apiDesc, wire, null);
		this.nbOfServerRConns = nbOfServerRConns;
	}

	@Override
	public BTransport createClientTransport() {
		return transport;
	}

	@Override
	public BTransport createServerTransport() {
		return transport;
	}

	@Override
	public BClient createClientR(BClient client) {
		return null;
	}

	@Override
	public BServerR createServerR(BServer server) {
		if (nbOfServerRConns == 0) return null;
		return new HServerR(transport, server, nbOfServerRConns);
	}
	
}
