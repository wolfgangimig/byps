package byps.test;

import java.nio.ByteBuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BSyncResult;
import byps.http.HWireClient;
import byps.http.client.HHttpClient;
import byps.log.LogConfigurator;

/**
 * SSO test program 
 *
 */
public class BypsSSO {
  
  private static Logger log = LoggerFactory.getLogger(BypsSSO.class);
  
  private static void printSystemProperty(String key) {
    log.info(key + "=" + System.getProperty(key));
  }
  
  private static void initLogger() {
    LogConfigurator.initConsole("info");
  }
  
  public static void main(String[] args) {
    
    initLogger();
    
    if (args.length < 1) {
      log.error("Missing Indexserver URL <ix-url>");
      log.error("Example: java -cp . BypsSSO http://srvpelo1:8080/ix-lldo_prod/ix"
          + " -Dbyps.http.client.factory=byps.http.client.asf.AsfClientFactory"
          + " -Dbyps.http.client.asf.auth=NTLM,SPNEGO"
          + " -Dbyps.http.client.asf.spn=srvp03.elo.local"
          + " -Dsun.security.krb5.debug=true");
      return;
    }
    
    log.info("System properties:");
    printSystemProperty("byps.http.client.factory");
    printSystemProperty("byps.http.client.asf.auth");
    printSystemProperty("byps.http.client.asf.spn");
    printSystemProperty("sun.security.krb5.debug");
    log.info("-------------");
    
//    System.setProperty("byps.http.client.factory", "byps.http.client.asf.AsfClientFactory");
//    System.setProperty("byps.http.client.asf.auth", "NTLM");
//    System.setProperty("byps.http.client.asf.spn", "srvp03.elo.local");
//    System.setProperty("sun.security.krb5.debug", "true");

    String url = args[0];
    String loginUrl = url;
    int p = loginUrl.lastIndexOf("/");
    loginUrl = loginUrl.substring(0, p+1);
    loginUrl += "ixlogin?streamversion=8&responseformat=text&logout=true";
    log.info("loginUrl="+ loginUrl);
        
    //String url = "http://localhost:8084/ix-elo100/ixlogin?streamversion=900990000000000&responseformat=html&logout=true";
    //String url = "http://srvpelo1:8080/ix-lldo_prod/ixlogin?streamversion=8&responseformat=html&logout=true";

    HWireClient wire = new HWireClient(url, 0, 120, null);
    HHttpClient client = wire.getHttpClient();
    log.info("httpClient=" + client);

    log.info("-------------");

    BSyncResult<ByteBuffer> result = new BSyncResult<ByteBuffer>();
    client.get(1, loginUrl, result).run();
    
    try {
      ByteBuffer ret = result.getResult();
      String sret = new String(ret.array(), "UTF-8");
      log.info("Succeeded: " + sret.substring(0, 50) + "...");
    } catch (Exception e) {
      log.error("Failed", e);
    }
    
  }

}
