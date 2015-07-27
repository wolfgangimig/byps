package byps.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import byps.http.cotest.CoTest;
import byps.test.api.BApiDescriptor_Testser;

public class TestCompatibleApi {
  
  private final static Log log = LogFactory.getLog(TestCompatibleApi.class);
  private final static String logFileOther = "d:/temp/log/jclient-other.log";

  public TestCompatibleApi() {
  }
  
  @Test
  public void testCompatible_793() throws Exception {
    log.info("testCompatible_793(");
    CoTest.test(BApiDescriptor_Testser.instance(), "bypstest_793_incompatible.jar", 9051, logFileOther);
    log.info(")testCompatible_793");
  }

}
