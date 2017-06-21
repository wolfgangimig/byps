package byps.http.client.asf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.Principal;

import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Lookup;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.impl.auth.NTLMSchemeFactory;
import org.apache.http.impl.auth.SPNegoSchemeFactory;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
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

  private volatile CloseableHttpClient httpclient;
  private volatile HttpClientContext context;

  public AsfClient(String url) {

    httpclient = internalCreateHttpClient();

    context = internalCreateSSOContext();
    
    // Braucht unter Notes sehr lang f�r Aufrufe!
    // httpclient = HttpClients.createSystem();

  }

  private static CloseableHttpClient internalCreateHttpClient() {

    String maxConnStr = System.getProperty("http.maxConnections");
    int maxConnections = maxConnStr != null && maxConnStr.length() != 0 ? Integer.parseInt(maxConnStr) : 100;
    
    PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
    cm.setMaxTotal(maxConnections);
    cm.setDefaultMaxPerRoute(maxConnections);

    // if the port does not match the kerberos database entry, skip it during the lookup
    boolean skipPortAtKerberosDatabaseLookup = true;
    Lookup<AuthSchemeProvider> authSchemeRegistry = RegistryBuilder.<AuthSchemeProvider>create()
        .register(AuthSchemes.SPNEGO, new SPNegoSchemeFactory(skipPortAtKerberosDatabaseLookup))
        .register(AuthSchemes.NTLM, new NTLMSchemeFactory())
        .build();
    
    CloseableHttpClient httpclient = HttpClients.custom()
            .setConnectionManager(cm)
            .setDefaultAuthSchemeRegistry(authSchemeRegistry)
            .build();

    return httpclient;
    
    //return HttpClients.createSystem();
  }
  
  private HttpClientContext internalCreateSSOContext() {

    //System.setProperty("java.security.krb5.conf", "C:\\Windows\\krb5.ini");
    //System.setProperty("sun.security.krb5.debug", "true");
    System.setProperty("javax.security.auth.useSubjectCredsOnly","false");

    HttpClientContext context = HttpClientContext.create();
    BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();

    // This may seem odd, but specifying 'null' as principal tells java to use the logged in user's credentials
    // Use NTCredentials to allow NTLM for SSO
    Credentials useJaasCreds = new NTCredentials("username", "password", "workstation", "domain") {
        public String getPassword() {
            return null;
        }
        public Principal getUserPrincipal() {
            return null;
        }
    };
    credentialsProvider.setCredentials( new AuthScope(null, -1, null), useJaasCreds );
    context.setCredentialsProvider(credentialsProvider);
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
