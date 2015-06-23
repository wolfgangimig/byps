package byps.test;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import byps.BAsyncResult;
import byps.BAuthentication;
import byps.BClient;
import byps.BException;
import byps.BExceptionC;
import byps.BMessageHeader;
import byps.BTransport;
import byps.BWire;
import byps.RemoteException;
import byps.http.HConstants;
import byps.test.api.BApiDescriptor_Testser;
import byps.test.api.BClient_Testser;
import byps.test.api.auth.SessionInfo;
import byps.test.api.remote.RemoteWithAuthenticationAuth;

/**
 * The tests of this class test the authentication mechanism.
 *
 */
public class TestRemoteWithAuthentication {

  BClient_Testser client;
  RemoteWithAuthenticationAuth remote;
  private Log log = LogFactory.getLog(TestRemoteStreams.class);

  @Before
  public void setUp() throws RemoteException {
    BClient_Testser client1 = TestUtilsHttp.createClient();
    client1.getRemoteWithAuthentication().setUseAuthentication(true);
    client1.done();
    
    client = TestUtilsHttp.createClient();
    remote = client.getRemoteWithAuthentication();
  }
  
  @After
  public void tearDown() throws InterruptedException {
    if (client != null) {
      try {
        remote.setUseAuthentication(false);
      } catch (RemoteException e) {}
      client.done();
    }
  }
  
  /**
   * Test without initialized authentication.
   * If no BAuthentication object is supplied, the interface methods receive a null reference
   * in the SessionInfo parameter. 
   * This test just makes sure, that no NPE is thrown. The implementation has to deal with the null reference.
   * @throws RemoteException
   */
  @Test
  public void testNoAuthObjectSupplied() throws RemoteException {
    log.info("testNoAuthObjectSupplied(");
    
    SessionInfo sess = remote.login("Fritz", "abc");
    log.info("sess=" + sess);
    
    log.info(")testNoAuthObjectSupplied");
  }
  
  /**
   * Test authentication via a BAuthentication implementation.
   * @throws RemoteException
   */
  @Test
  public void testAuthenticate() throws RemoteException {
    log.info("testAuthenticate(");
    
    client.setAuthentication(new MyAuthentication("Fritz", "abc"));

    // This method call will fail internally the first time with a BExceptionC.AUTHENTICATION_REQUIRED.
    // Then, BTranpsport invokes MyAuthentication.authenticate and retries the method call.
    int ret = remote.doit(1);
    TestUtils.assertEquals(log, "ret", 2, ret);
    
    log.info(")testAuthenticate");
  }
  
  /**
   * Test failed authentication via a BAuthentication implementation.
   * @throws RemoteException
   */
  @Test
  public void testAuthenticateFails() throws RemoteException {
    log.info("testAuthenticateFails(");
    
    client.setAuthentication(new MyAuthentication("Unknownuser", ""));

    try {
      remote.doit(1);
      TestUtils.fail(log, "Method call must fail with login error");
    }
    catch (RemoteException e) {
      TestUtils.assertTrue(log, "Unexpected exception", e.toString().indexOf("Login failed") >= 0);
    }
    
    log.info(")testAuthenticateFails");
  }
  
  
  /**
   * Tests that a re-login is performed if the session was invalidated on the server.
   * @throws RemoteException
   */
  @Test
  public void testAuthenticateRelogin() throws RemoteException, InterruptedException {
    log.info("testAuthenticateRelogin(");
    
    client.setAuthentication(new MyAuthentication("Fritz", "abc"));

    // This method call will fail internally the first time with a BExceptionO.AUTHENTICATION_REQUIRED.
    // Then, BTranpsport invokes MyAuthentication.authenticate and retries the method call.
    int ret = remote.doit(1);
    TestUtils.assertEquals(log, "ret", 2, ret);
    
    // Invalidate session
    remote.expire();
    
    // Wait 1s, BTransport assumes that a session is at least 1s valid.
    Thread.sleep(1000);
    
    // Re-login
    ret = remote.doit(1);
    TestUtils.assertEquals(log, "ret", 2, ret);   
    
    log.info(")testAuthenticateRelogin");
  }
  
  /**
   * Test with an authentication class that calls a interface function
   * which requires authentication. 
   * This must not cause an endless loop or a stack overflow. 
   * It results in a 403 error.
   * @throws RemoteException
   */
  @Test
  public void testAuthenticateBlocksRecursion() throws RemoteException {
    log.info("testAuthenticateBlocksRecursion(");
    
    client.setAuthentication(new MyAuthenticationBlocksRecursion());

    try {
      remote.doit(1);
      TestUtils.fail(log, "exception expected");
    }
    catch (BException e) {
      TestUtils.assertEquals(log, "exception", BExceptionC.FORBIDDEN, e.code);
    }
    
    log.info(")testAuthenticateBlocksRecursion");
  }
  
  /**
   * Test with an authentication class that performs too slow,
   * so that the application server session gets invalid during
   * authentication.
   * This must not cause an endless loop or a stack overflow. 
   * It results in a 403 error.
   * @throws RemoteException
   */
  @Test
  public void testAuthenticateTooSlow() throws RemoteException {
    log.info("testAuthenticateTooSlow(");
    
    long waitMillis = 11 * 1000; // see BypsServlet constructor: authentication timeout reduced to 10s.
    MyAuthenticationTooSlow auth = new MyAuthenticationTooSlow("Fritz", "abc", waitMillis);
    client.setAuthentication(auth);

    try {
      log.info("remote.doit 1");
      remote.doit(1);
      TestUtils.fail(log, "exception expected");
    }
    catch (BException e) {
      TestUtils.assertEquals(log, "exception", BExceptionC.FORBIDDEN, e.code);
    }
    
    // Try again without sleeping -> authentication should work correctly
    try {
      
      // Wait until BTransport will allow to proceed the next authentication
      Thread.sleep(BTransport.RETRY_AUTHENTICATION_AFTER_MILLIS);
      
      log.info("remote.doit 2");
      auth.waitMillis = 0;
      remote.doit(2);
    }
    catch (Throwable e) {
      TestUtils.fail(log, e.toString());
    }
    
    log.info(")testAuthenticateTooSlow");
  }
  
  private static class MyAuthentication implements BAuthentication {
    
    private Log log = LogFactory.getLog("MyAuthentication");
    private String userName;
    private String pwd;
    private SessionInfo sess;
    
    public MyAuthentication(String userName, String pwd) {
      this.userName = userName;
      this.pwd = pwd;
    }

    @Override
    public void authenticate(BClient client, final BAsyncResult<Boolean> asyncResult) {
      log.info("authenticate(");
      
      BAsyncResult<SessionInfo> outerResult = new BAsyncResult<SessionInfo>() {
        @Override
        public void setAsyncResult(SessionInfo sess, Throwable exception) {
          log.info("authenticate sess=" + sess + ", exception=" + exception);
          MyAuthentication.this.sess = sess;
          asyncResult.setAsyncResult(Boolean.TRUE, exception);
        }
      };
      
      log.info("login, " + userName + ", " + pwd);
      ((BClient_Testser)client).getRemoteWithAuthentication().login(userName, pwd, outerResult);
      log.info(")authenticate");
    }

    @Override
    public boolean isReloginException(BClient client, Throwable ex, int typeId) {
      return client.getTransport().isReloginException(ex, typeId);
    }
    
    @Override
    public void getSession(BClient client, int typeId, BAsyncResult<Object> asyncResult) {
      asyncResult.setAsyncResult(sess, null);
    }

  }

  class MyAuthenticationBlocksRecursion implements BAuthentication {

    @Override
    public void authenticate(BClient client, final BAsyncResult<Boolean> asyncResult) {
      remote.doit(1, new BAsyncResult<Integer>() {
        public void setAsyncResult(Integer result, Throwable exception) {
          asyncResult.setAsyncResult(Boolean.FALSE, exception);
        }
      });
    };

    @Override
    public boolean isReloginException(BClient client, Throwable ex, int typeId) {
      return client.getTransport().isReloginException(ex, typeId);
    }

    @Override
    public void getSession(BClient client, int typeId, BAsyncResult<Object> asyncResult) {
      asyncResult.setAsyncResult(null, null);
    }
  }  
  
  class MyAuthenticationTooSlow extends MyAuthentication {
    
    public volatile long waitMillis;
    private Log log = LogFactory.getLog("MyAuthenticationTooSlow");

    public MyAuthenticationTooSlow(String userName, String pwd, long waitMillis) {
      super(userName, pwd);
      this.waitMillis = waitMillis;
    }

    @Override
    public void authenticate(BClient client, final BAsyncResult<Boolean> asyncResult) {
      log.info("authenticate(");
      try {
        log.info("waitMillis=" + waitMillis);
        Thread.sleep(waitMillis);
        super.authenticate(client, asyncResult);
      }
      catch (Throwable e) {
        asyncResult.setAsyncResult(null, e);
      }
      log.info(")authenticate");
    };

  }
  
  /**
   * Check that clients are still supported that do not send a sessionId in the message header.
   */
  @Test
  public void testBypsVersionWithoutSessionId() {
    log.info("testBypsVersionWithoutSessionId(");
    
    try {
      BMessageHeader.BYPS_VERSION_CURRENT = BMessageHeader.BYPS_VERSION_WITH_SESSIONID-1;
      
      BClient_Testser client = TestUtilsHttp.createClient(TestUtils.protocol, BWire.FLAG_DEFAULT, BMessageHeader.BYPS_VERSION_ENCRYPTED_TARGETID, BApiDescriptor_Testser.VERSION, 1);
      client.start();
      
      client.getRemotePrimitiveTypes().setInt(5);
      int value = client.getRemotePrimitiveTypes().getInt();
      TestUtils.assertEquals(log, "int value", 5, value);
      
    }
    catch (Throwable e) {
      TestUtils.fail(log, e.toString());
    }

    log.info(")testBypsVersionWithoutSessionId");
  }
}
