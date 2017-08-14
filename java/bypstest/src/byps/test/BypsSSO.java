package byps.test;

import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

import byps.BSyncResult;
import byps.http.HWireClient;
import byps.http.client.HHttpClient;

/**
 * SSO test program 
 *
 */
public class BypsSSO {
  
  private static Log log = LogFactory.getLog(BypsSSO.class);
  
  private static void printSystemProperty(String key) {
    log.info(key + "=" + System.getProperty(key));
  }
  
  private static void initLogger() {
    StringBuilder log4jConsole = new StringBuilder();
    log4jConsole.append("log4j.rootLogger = info, A1")
      .append(System.lineSeparator())
      .append("log4j.appender.A1 = org.apache.log4j.ConsoleAppender")
      .append(System.lineSeparator())
      .append("log4j.appender.A1.layout = org.apache.log4j.PatternLayout")
      .append(System.lineSeparator())
      .append("log4j.appender.A1.layout.ConversionPattern = %d{ABSOLUTE} %1x %-5p (%F:%L) - %m%n")
      .append(System.lineSeparator());
    ByteArrayInputStream in = new ByteArrayInputStream(log4jConsole.toString().getBytes());
    PropertyConfigurator.configure(in);
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

    BSyncResult<ByteBuffer> result = new BSyncResult<>();
    client.get(loginUrl, result).run();
    
    try {
      ByteBuffer ret = result.getResult();
      String sret = new String(ret.array(), "UTF-8");
      log.info("Succeeded: " + sret.substring(0, 50) + "...");
    } catch (Exception e) {
      log.error("Failed", e);
    }
    
  }

}
