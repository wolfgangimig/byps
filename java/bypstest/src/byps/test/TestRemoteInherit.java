package byps.test;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import byps.RemoteException;
import byps.test.api.BClient_Testser;

public class TestRemoteInherit {
  
  BClient_Testser client;
  private Logger log = LoggerFactory.getLogger(TestRemoteInherit.class);

  @Before
  public void setUp() throws RemoteException {
    client = TestUtilsHttp.createClient();
  }
  
  @After
  public void tearDown() {
    if (client != null) {
      client.done();
    }
  }
  
  @Test
  public void testRemoteBioLemonService() throws RemoteException {
    log.info("testRemoteBioLemonService(");
    

    
    log.info(")testRemoteBioLemonService");
  }

}
