package com.wilutions.byps.http;

import com.wilutions.byps.BApiDescriptor;
import com.wilutions.byps.BClient;
import com.wilutions.byps.BServer;
import com.wilutions.byps.BServerR;
import com.wilutions.byps.BTransport;
import com.wilutions.byps.BTransportFactory;
import com.wilutions.byps.BWire;

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
		return new HServerR(transport, server, nbOfServerRConns);
	}
	
}
