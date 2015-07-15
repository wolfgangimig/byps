package byps.test;

import org.junit.Test;

import byps.BApiDescriptor;
import byps.RemoteException;
import byps.io.mem.BReferenceParam;
import byps.io.mem.BWireMemoryTransport;
import byps.test.api.BApiDescriptor_Testser;
import byps.test.api.BClient_Testser;
import byps.test.api.BServer_Testser;
import byps.test.api.remote.BSkeleton_RemotePrimitiveTypes;

public class TestCompatibleApi {

  @Test
  public void testCompatible() {

    try {
      BApiDescriptor apiDesc = BApiDescriptor_Testser.instance();
      BReferenceParam<BClient_Testser> rclient = new BReferenceParam<BClient_Testser>(BClient_Testser.class);
      BReferenceParam<BServer_Testser> rserver = new BReferenceParam<BServer_Testser>(BServer_Testser.class);
      BWireMemoryTransport.createClientAndServer(apiDesc, rclient, rserver);
      
      rserver.value.addRemote(new BSkeleton_RemotePrimitiveTypes() {
        @Override
        public void setBool(boolean v) throws RemoteException {
        }
        @Override
        public boolean getBool() throws RemoteException {
          return true;
        }
      });
      
      rclient.value.getRemotePrimitiveTypes().setBool(true);
      rclient.value.getRemotePrimitiveTypes().getBool();
      
      rclient.value.done();
      rserver.value.getTransport().getWire().done();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  

}
