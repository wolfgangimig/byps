package byps.io.mem;

import byps.BApiDescriptor;
import byps.BClient;
import byps.BServer;
import byps.BServerR;
import byps.BTransport;
import byps.BTransportFactory;

public class BTransportFactoryServer implements BTransportFactory {
  
  private final BTransport transport;

  public BTransportFactoryServer(BApiDescriptor apiDesc, Object wmtImpl) throws Exception {
    BWireServer wireServer = new BWireServer(new BWireMemoryTransport(wmtImpl));
    this.transport = new BTransport(apiDesc, wireServer, null);
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
    return null;
  }

}
