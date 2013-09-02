package com.wilutions.byps.http;

import com.wilutions.byps.BApiDescriptor;
import com.wilutions.byps.BClient;
import com.wilutions.byps.BServerRegistry;
import com.wilutions.byps.BServer;
import com.wilutions.byps.BServerR;
import com.wilutions.byps.BTransport;
import com.wilutions.byps.BTransportFactory;

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
