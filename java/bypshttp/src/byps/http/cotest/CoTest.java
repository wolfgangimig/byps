package byps.http.cotest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BApiDescriptor;


public class CoTest {
  
  private final static Log log = LogFactory.getLog(CoTest.class);
  
  public static void test(final BApiDescriptor apiDesc, String bypstest_jar, int port, String logFile) throws Exception {
    CoTestParams params = new CoTestParams();
    params.initTestSite(apiDesc, bypstest_jar, port, logFile);
    
    // Starting client and server in this process can be useful for debugging.
    internalTestLocalClientAndServer(params);
    
    internalTestOtherClient(params);

    internalTestOtherServer(params);
  }

  private static void internalTestLocalClientAndServer(CoTestParams params) throws Exception {
    log.info("internalTestLocalClientAndServer(");
    CoTestProcess.startServer(params, CoTestProcess.THIS_PROCESS);
    CoTestProcess.startClient(params, CoTestProcess.THIS_PROCESS);
    log.info(")internalTestLocalClientAndServer");
  }
  
  private static void internalTestOtherServer(CoTestParams params) throws Exception {
    log.info("internalTestOtherServer(");
    CoTestProcess.startServer(params, CoTestProcess.OTHER_PROCESS);
    CoTestProcess.startClient(params, CoTestProcess.THIS_PROCESS);
    log.info(")internalTestOtherServer");
  }
  
  private static void internalTestOtherClient(CoTestParams params) throws Exception {
    log.info("internalTestOtherClient(");
    CoTestProcess.startServer(params, CoTestProcess.THIS_PROCESS);
    CoTestProcess.startClient(params, CoTestProcess.OTHER_PROCESS);
    log.info(")internalTestOtherClient");
  }

}
