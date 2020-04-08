package byps.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;

import byps.http.cotest.CoTest;
import byps.test.api.BApiDescriptor_Testser;

public class TestCompatibleApi {
  
  private final static Logger log = LoggerFactory.getLogger(TestCompatibleApi.class);
  private final static String logFileOther = "c:/temp/log/jclient-other.log";

  public TestCompatibleApi() {
  }
  
  @Test
  public void testCompatible_793() throws Exception {
    log.info("testCompatible_793(");
    CoTest.test(BApiDescriptor_Testser.instance(), "bypstest_793.jar", 4040, logFileOther);
    log.info(")testCompatible_793");
  }

}
