package com.wilutions.byps.http;

import com.wilutions.byps.BApiDescriptor;
import com.wilutions.byps.BClient;
import com.wilutions.byps.BClientR;
import com.wilutions.byps.BServer;
import com.wilutions.byps.BServerR;
import com.wilutions.byps.BTransport;
import com.wilutions.byps.BTransportFactory;
import com.wilutions.byps.BWire;

public class HTransportFactoryClient implements BTransportFactory {
	
	private final BTransport transport;
	
	public HTransportFactoryClient(BApiDescriptor apiDesc, BWire wire) {
		this.transport = new BTransport(apiDesc, wire, null);
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
	public BClientR createClientR(BClient client) {
		return null;
	}

	@Override
	public BServerR createServerR(BServer server) {
		return new HServerR(transport, server);
	}
	
}
