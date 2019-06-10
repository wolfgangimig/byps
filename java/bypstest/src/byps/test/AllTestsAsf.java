package byps.test;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
  AllTestsMEDIUM.class,
  //AllTestsJSON.class,
  })
public class AllTestsAsf {
  
  @BeforeClass
  public static void setProtocol() {
    System.setProperty("byps.http.client.factory", "byps.http.client.asf.AsfClientFactory");
  }

}
