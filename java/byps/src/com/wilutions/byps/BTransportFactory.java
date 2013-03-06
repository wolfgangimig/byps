package com.wilutions.byps;

public interface BTransportFactory {
	BTransport createClientTransport();
	BTransport createServerTransport();
	BClientR createClientR(BClient client);
	BServerR createServerR(BServer server);
}
