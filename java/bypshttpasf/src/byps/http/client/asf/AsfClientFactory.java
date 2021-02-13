package byps.http.client.asf;

import byps.http.client.HHttpClient;
import byps.http.client.HHttpClientFactory;

/**
 * 
 * Supported system properties:
 * 
 * key=byps.http.client.asf.sso: one of the authentication schemas NTLM or SPNEGO.   
 * example: byps.http.client.asf.auth=NTLM
 * default: SPNEGO
 * 
 * If byps.http.client.asf.sso includes NTLM, additional JARs are required: httpclient-win-4.5.2.jar, jna-4.1.0.jar, jna-platform-4.1.0.jar.
 * 
 * key=byps.http.client.asf.spn: service principal name (DC name)
 * example: srvp03.elo.local
 * default: not set
 */
public class AsfClientFactory implements HHttpClientFactory {
  
  public final static String SSO_AUTHENTICATION_SCHEMAS = "byps.http.client.asf.auth";
  public final static String SSO_AUTHENTICATION_NTLM = "NTLM";
  public final static String SSO_AUTHENTICATION_SPNEGO = "SPNEGO";

  public final static String SSO_AUTHENTICATION_SPN = "byps.http.client.asf.spn";
  
  @Override
  public HHttpClient createHttpClient(String url, int timeoutSeconds) {
    return new AsfClient(url);
  }

}
