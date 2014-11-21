package byps.http;

import byps.BApiDescriptor;
import byps.BMessageHeader;
import byps.BProtocol;
import byps.BProtocolJson;
import byps.BProtocolS;
import byps.BServer;
import byps.BTransportFactory;
import byps.ureq.BApiDescriptor_UtilityRequests;
import byps.ureq.BRegistry_UtilityRequests;
import byps.ureq.BServer_UtilityRequests;
import byps.ureq.JRegistry_UtilityRequests;

/**
 * 
 * unused
 *
 */
public class HSessionForUtilityRequests extends HSession {
  
  final BTransportFactory transportFactory;
  final BApiDescriptor apiDesc = BApiDescriptor_UtilityRequests.instance();
  
  public HSessionForUtilityRequests(HServerContext serverContext) {
    super("Remote user is HSessionForUtilityRequests", serverContext);

    apiDesc.addRegistry(new JRegistry_UtilityRequests());
    apiDesc.addRegistry(new BRegistry_UtilityRequests());

    // Create BTransportFacotry without serverRegistry.
    // This prevents BTransport from forwarding the requests to other servers. 
    transportFactory = new HTransportFactoryServer(apiDesc, wireServer, wireClientR, null);
  }
  
  public HSession createForTarget(BMessageHeader header) {
    
    final BServer server = BServer_UtilityRequests.createServer(transportFactory);
    
    BProtocol protocol = null;
    
    if (header.magic == BMessageHeader.MAGIC_JSON) {
      protocol = new BProtocolJson(apiDesc);
    }
    else {
      protocol = new BProtocolS(apiDesc, BMessageHeader.BYPS_VERSION_CURRENT, apiDesc.version, header.byteOrder);
    }
    
    server.getTransport().setProtocol(protocol);
    server.setTargetId(header.targetId);
    
    HSession sess = new HSession("Remote user is HSessionForUtilityRequests", serverContext) {
      @Override
      public BServer getServer() {
        return server;
      }
    };
    
    return sess;
  }

  @Override
  public BServer getServer() {
    throw new UnsupportedOperationException();
  }

}
