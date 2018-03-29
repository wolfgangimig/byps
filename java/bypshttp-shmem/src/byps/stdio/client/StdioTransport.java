package byps.stdio.client;

import java.nio.ByteOrder;

import byps.BApiDescriptor;
import byps.BException;
import byps.BMessageHeader;
import byps.BProtocol;
import byps.BProtocolS;
import byps.BRegistry;
import byps.BTransport;
import byps.BWire;

public class StdioTransport {

  public static BTransport createTransport() {
    
    int bypsVersion = BMessageHeader.BYPS_VERSION_CURRENT;
    long version = 0;

    BWire wire = new BWire(BWire.FLAG_DEFAULT);
    
    BApiDescriptor apiDesc = new BApiDescriptor("StdioHttpHeaders", "byps", version, false);
    apiDesc.addRegistry(new BRegistry(BProtocolS.BINARY_MODEL) {
      @Override
      protected BRegisteredSerializer[] getSortedSerializers() throws BException {
        return new BRegisteredSerializer[0];
      }
    });
    
    BProtocol proto = new BProtocolS(apiDesc, bypsVersion, version, ByteOrder.LITTLE_ENDIAN);
    
    BTransport transport = new BTransport(apiDesc, wire, null);
    transport.setProtocol(proto);
  
    return transport;
  }

}
