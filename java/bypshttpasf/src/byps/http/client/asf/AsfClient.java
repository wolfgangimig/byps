package byps.http.client.asf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.Principal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Lookup;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.impl.auth.SPNegoSchemeFactory;
import org.apache.http.impl.auth.win.WindowsCredentialsProvider;
import org.apache.http.impl.auth.win.WindowsNTLMSchemeFactory;
import org.apache.http.impl.auth.win.WindowsNegotiateSchemeFactory;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.SystemDefaultCredentialsProvider;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import byps.BAsyncResult;
import byps.BContentStream;
import byps.BSyncResult;
import byps.http.client.HHttpClient;
import byps.http.client.HHttpRequest;

/**
 * HHttpClient implementation using Apache HTTP Components.
 * 
 * SSO Auth: http://stackoverflow.com/questions/24633380/how-do-i-authenticate-with-spnego-kerberos-and-apaches-httpclient
 */
public class AsfClient implements HHttpClient {

  private static Log log = LogFactory.getLog(AsfClient.class);
  private volatile CloseableHttpClient httpclient;
  private volatile HttpClientContext context;

  public AsfClient(String url) {
    if (log.isDebugEnabled()) log.debug("AsfClient(");
    httpclient = internalCreateHttpClient();

    context = internalCreateSSOContext();
    
    // Braucht unter Notes sehr lang fï¿½r Aufrufe!
    // httpclient = HttpClients.createSystem();
    if (log.isDebugEnabled()) log.debug(")AsfClient");
  }
  
  /**
   * Detects system property byps.http.client.asf.sso.
   * @return true, if system property is set and NTLM is included.
   */
  private static boolean isNTLMAuthenticationEnabled() {
    String authSchemasSystemProperty = System.getProperty(AsfClientFactory.SSO_AUTHENTICATION_SCHEMAS);
    boolean ret = authSchemasSystemProperty != null && authSchemasSystemProperty.contains(AsfClientFactory.SSO_AUTHENTICATION_NTLM);
    if (log.isDebugEnabled()) log.debug("isNTLMAuthenticationEnabled=" + ret + ", authSchemas=" + authSchemasSystemProperty);
    return ret; 
  }

  /**
   * Detects system property byps.http.client.asf.sso.
   * @return true, if system property is not set or SPNEGO is included.
   */
  private static boolean isSPNEGOAuthenticationEnabled() {
    String authSchemasSystemProperty = System.getProperty(AsfClientFactory.SSO_AUTHENTICATION_SCHEMAS);
    boolean ret = authSchemasSystemProperty == null || authSchemasSystemProperty.contains(AsfClientFactory.SSO_AUTHENTICATION_SPNEGO);
    if (log.isDebugEnabled()) log.debug("isSPNEGOAuthenticationEnabled=" + ret + ", authSchemas=" + authSchemasSystemProperty);
    return ret; 
  }

  private static CloseableHttpClient internalCreateHttpClient() {
    if (log.isDebugEnabled()) log.debug("internalCreateHttpClient(");

    String maxConnStr = System.getProperty("http.maxConnections");
    int maxConnections = maxConnStr != null && maxConnStr.length() != 0 ? Integer.parseInt(maxConnStr) : 100;
    log.info("maxConnections=" + maxConnections);
    
    PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
    cm.setMaxTotal(maxConnections);
    cm.setDefaultMaxPerRoute(maxConnections);

    RegistryBuilder<AuthSchemeProvider> builder = RegistryBuilder.<AuthSchemeProvider>create();
    
    String authSchemasSystemProperty = System.getProperty(AsfClientFactory.SSO_AUTHENTICATION_SCHEMAS);
    log.info(AsfClientFactory.SSO_AUTHENTICATION_SCHEMAS + "=" + authSchemasSystemProperty);
    
    // Use special classes for Windows authentication schemas?
    if (isNTLMAuthenticationEnabled()) {

      // Service prinzipal name (DC name)
      String servicePrincipalName = System.getProperty(AsfClientFactory.SSO_AUTHENTICATION_SPN);
      log.info(AsfClientFactory.SSO_AUTHENTICATION_SPN + "=" + servicePrincipalName);
      
      // NTLM authentication works servicePrincipalName=null too.
      log.info("Register NTLM");
      builder.register(AuthSchemes.NTLM, new WindowsNTLMSchemeFactory(servicePrincipalName));
      
      // SPNEGO authentication works only with servicePrincipalName!=null in my test environment.
      if (servicePrincipalName != null && isSPNEGOAuthenticationEnabled()) 
      {
        log.info("Register SPNEGO (Negotiate)");
        builder.register(AuthSchemes.SPNEGO, new WindowsNegotiateSchemeFactory(servicePrincipalName));
      }
      else {
        log.info("For using SPNEGO (Negotiate), system property " + AsfClientFactory.SSO_AUTHENTICATION_SCHEMAS + " must include SPNEGO and " + AsfClientFactory.SSO_AUTHENTICATION_SPN + " must specify the FQN of an AD server.");
      }

    }
    else {
      // if the port does not match the kerberos database entry, skip it during the lookup
      log.info("Register SPNEGO (Negotate) over JAAS");
      boolean skipPortAtKerberosDatabaseLookup = true;
      builder.register(AuthSchemes.SPNEGO, new SPNegoSchemeFactory(skipPortAtKerberosDatabaseLookup));
      // SSO über SPNEGO/Kerberos funktioniert nur, wenn der Test unter einem Windows-Benutzerkonto läuft, dass nicht lokaler Administrator ist.
    }
    
    log.info("Ignore WARN Authentication scheme Negotiate not supported."); 
    log.info("Ignore WARN Authentication scheme Basic not supported."); 
    
    Lookup<AuthSchemeProvider> authSchemeRegistry = builder.build();

    CloseableHttpClient httpclient = HttpClients.custom()
            .setConnectionManager(cm)
            .setDefaultAuthSchemeRegistry(authSchemeRegistry)
            .build();

    if (log.isDebugEnabled()) log.debug(")internalCreateHttpClient");
    return httpclient;
  }
  
  private static HttpClientContext internalCreateSSOContext() {
    
    if (log.isDebugEnabled()) log.debug("internalCreateSSOContext(");

    //System.setProperty("java.security.krb5.conf", "C:\\Windows\\krb5.ini");
    //System.setProperty("sun.security.krb5.debug", "true");
    System.setProperty("javax.security.auth.useSubjectCredsOnly","false");

    HttpClientContext context = HttpClientContext.create();
    
    if (isNTLMAuthenticationEnabled()) {
      if (log.isDebugEnabled()) log.debug("set WindowsCredentialsProvider");
      final CredentialsProvider credsProvider = new WindowsCredentialsProvider(new SystemDefaultCredentialsProvider());
      context.setCredentialsProvider(credsProvider);
    }
    else {

      if (log.isDebugEnabled()) log.debug("set JAAS credential provider");

      // This may seem odd, but specifying 'null' as principal tells java to use the logged in user's credentials
      Credentials useJaasCreds = new Credentials() {
        public String getPassword() { return null; }
        public Principal getUserPrincipal() { return null; }
      };

      BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
      credentialsProvider.setCredentials( new AuthScope(null, -1, null), useJaasCreds );
      context.setCredentialsProvider(credentialsProvider);
    }
    
    if (log.isDebugEnabled()) log.debug(")internalCreateSSOContext");
    return context;
  }

  @Override
  public void clearHttpSession() {
    done();
    httpclient = internalCreateHttpClient();
  }

  @Override
  public void done() {
    try {
      httpclient.close();
    }
    catch (IOException e) {
    }
  }

  @Override
  public HHttpRequest get(String url, BAsyncResult<ByteBuffer> asyncResult) {
    return new AsfGet(url, asyncResult, httpclient, context);
  }

  @Override
  public HHttpRequest getStream(String url,
      BAsyncResult<BContentStream> asyncResult) {
    return new AsfGetStream(url, asyncResult, httpclient, context);
  }

  @Override
  public HHttpRequest post(String url, ByteBuffer buf,
      BAsyncResult<ByteBuffer> asyncResult) {
    return new AsfPost(url, buf, asyncResult, httpclient, context);
  }

  @Override
  public HHttpRequest putStream(String url, InputStream stream,
      BAsyncResult<ByteBuffer> asyncResult) {
    return new AsfPutStream(url, stream, asyncResult, httpclient, context);
  }

  public static void main(String[] args)  {
    try {
      //String url = "http://srvtdev03:6020/ix-elo90";
      String url = "http://srvpelo1:6080/ix-lldo_prod";
      //String url = "http://localhost:8084/ix-elo90";
      AsfClient client = new AsfClient(url + "/ix");
      BSyncResult<ByteBuffer> asyncResult = new BSyncResult<ByteBuffer>();
      client.get(url + "/bypsauth/auth?streamversion=8&responseformat=html&logout=true", asyncResult).run();
      ByteBuffer bbuf = asyncResult.getResult();
      System.out.println(new String(bbuf.array(), "UTF-8"));
    }
    catch (Throwable e) {
      e.printStackTrace();
    }
  }
  
}
