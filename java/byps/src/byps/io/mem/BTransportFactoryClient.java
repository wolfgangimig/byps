package byps.io.mem;

import byps.BApiDescriptor;
import byps.BClient;
import byps.BServer;
import byps.BServerR;
import byps.BTransport;
import byps.BTransportFactory;

public class BTransportFactoryClient implements BTransportFactory {

  private final BTransport transport;
  
  public BTransportFactoryClient(BApiDescriptor apiDesc, Object wmtImpl) throws Exception {
    BWireClient wireClient = new BWireClient(new BWireMemoryTransport(wmtImpl));
    this.transport = new BTransport(apiDesc, wireClient, null);
  }

  @Override
  public BTransport createClientTransport() {
    return transport;
  }

  @Override
  public BTransport createServerTransport() {
    return null;
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
