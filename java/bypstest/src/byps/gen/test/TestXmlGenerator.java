package byps.gen.test;

import org.junit.Test;

import byps.gen.Main;

public class TestXmlGenerator {
  
  @Test
  public void runAnnoationProcessor() {
    
    Main.setMode(Main.EMode.DETECT);
    Main.main(null);

  }

  @Test
  public void runJavaDoc() {
    
    Main.setMode(Main.EMode.JAVADOC);
    Main.main(null);

  }

}
