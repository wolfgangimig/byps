package byps.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import byps.BAsyncResult;
import byps.BAuthentication;
import byps.BClient;
import byps.RemoteException;
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
    client1.remoteWithAuthentication.setUseAuthentication(true);
    client1.done();
    
    client = TestUtilsHttp.createClient();
    remote = client.remoteWithAuthentication;
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
  

  private static class MyAuthentication implements BAuthentication {
    
    private Log log = LogFactory.getLog(MyAuthentication.class);
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
      
      ((BClient_Testser)client).remoteWithAuthentication.login(userName, pwd, outerResult);
      log.info(")authenticate");
    }

    @Override
    public boolean isReloginException(BClient client, Throwable ex, int typeId) {
      return client.transport.isReloginException(ex, typeId);
    }
    
    @Override
    public void getSession(BClient client, int typeId, BAsyncResult<Object> asyncResult) {
      asyncResult.setAsyncResult(sess, null);
    }

  }

}
