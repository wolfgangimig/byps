package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

public interface BTransportFactory {
	BTransport createClientTransport();
	BTransport createServerTransport();
	BClient createClientR(BClient client);
	BServerR createServerR(BServer server);
}
