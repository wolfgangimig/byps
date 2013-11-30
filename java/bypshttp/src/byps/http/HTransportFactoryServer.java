package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import byps.BApiDescriptor;
import byps.BClient;
import byps.BServer;
import byps.BServerR;
import byps.BServerRegistry;
import byps.BTransport;
import byps.BTransportFactory;

public class HTransportFactoryServer implements BTransportFactory {
	
	public final BTransport transportServer;
	public final BTransport transportClientR;
	
	public HTransportFactoryServer(BApiDescriptor apiDesc, HWireServer wireServer, HWireClientR wireClientR, BServerRegistry serverRegistry) {
		transportServer = new BTransport(apiDesc, wireServer, serverRegistry);
		transportClientR = new BTransport(apiDesc, wireClientR, null);
	}

	@Override
	public BTransport createClientTransport() {
		return transportClientR;
	}

	@Override
	public BTransport createServerTransport() {
		return transportServer;
	}

	@Override
	public BClient createClientR(BClient client) {
		return client;
	}

	@Override
	public BServerR createServerR(BServer server) {
		return null;
	}
	

}
