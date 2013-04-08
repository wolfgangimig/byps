package com.wilutions.byps;

public interface BTransportFactory {
	BTransport createClientTransport();
	BTransport createServerTransport();
	BClient createClientR(BClient client);
	BServerR createServerR(BServer server);
}
