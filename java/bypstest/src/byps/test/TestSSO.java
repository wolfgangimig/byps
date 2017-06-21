package byps.test;

import java.nio.ByteBuffer;

import org.junit.Test;

import byps.BSyncResult;
import byps.http.client.HHttpClient;
import byps.http.client.asf.AsfClientFactory;

public class TestSSO {
  
  @Test
  public void testSSOAsf() {
    System.setProperty("byps.http.client.factory", "byps.http.client.asf.AsfClientFactory");
    System.setProperty("sun.security.krb5.debug", "true");

    AsfClientFactory httpClientFactory = new AsfClientFactory();
    HHttpClient client = httpClientFactory.createHttpClient("");
    
    //String url = "http://localhost:8084/ix-elo100/ixlogin?streamversion=900990000000000&responseformat=html&logout=true";
    String url = "http://srvpelo1:8080/ix-lldo_prod/ixlogin?streamversion=8&responseformat=html&logout=true";
    
    BSyncResult<ByteBuffer> result = new BSyncResult<>();
    client.get(url, result).run();
    
    try {
      ByteBuffer ret = result.getResult();
      String sret = new String(ret.array(), "UTF-8");
      System.out.println(sret);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }

}
