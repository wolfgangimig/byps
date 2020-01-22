package byps.test;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import byps.BAsyncResult;
import byps.BAuthentication;
import byps.BClient;
import byps.BMessageHeader;
import byps.BSyncResult;
import byps.BWire;
import byps.RemoteException;
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

    // Login/Re-login
    for (int i = 0; i < 2; i++) {
   
      // This method call will fail internally the first time with a BExceptionO.AUTHENTICATION_REQUIRED.
      // Then, BTranpsport invokes MyAuthentication.authenticate and retries the method call.
      int ret = remote.doit(1);
      TestUtils.assertEquals(log, "ret", 2, ret);
      
      // Invalidate session
      remote.expire();
      
      // Wait 1s, BTransport assumes that a session is at least 1s valid.
      Thread.sleep(1000);
    }
    
    // Simultaneous Re-login
    {
      int nbOfThreads = 10;
      final CountDownLatch cdl = new CountDownLatch(nbOfThreads);
      final AtomicReference<Exception> refExc = new AtomicReference<Exception>();
      
      for (int i = 0; i < nbOfThreads; i++) {
        Runnable run = new Runnable() {
          public void run() {
            try {
              remote.doit(1);
            }
            catch (Exception e) {
              
              // Im Server tritt hier eine ClassCastException von 
              // BStub_RemoteWithAuthentication nach RemoteWithAuthenticationAsync
              // auf, wenn sich die Client-TargetId während remote.doit durch einen
              // gleichzeitiges Negotiate ändert.
              // Ich habe dafür noch keine Lösung.

              refExc.compareAndSet(null, e);
              log.error("Authentication failed: ", e);
            }
            finally {
              cdl.countDown();
            }
          }
        };
        new Thread(run).start();
      }
          
      cdl.await();
      if (refExc.get() != null) {
        
        
        TestUtils.fail(log, refExc.get().toString());
      }
    }
    
    log.info(")testAuthenticateRelogin");
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
  
  
  /**
   * Check that logout of one session does not interrupt other messages.
   * BYPS-12
   * @throws RemoteException
   */
  @Test
  public void testLogoutDoesNotInterruptOtherMessages() throws RemoteException {
    log.info("testLogoutDoesNotInterruptOtherMessages(");
    final int BYPS_12_DOIT = 12;
    
    // Start a request that is paused for 5s inside the server.
    BSyncResult<Integer> doitResult = new BSyncResult<>();
    client.setAuthentication(new MyAuthentication("Fritz", "abc"));
    client.getRemoteWithAuthentication().doit(BYPS_12_DOIT, doitResult);
    
    // During the above request, do a login/logout.
    // Before BYPS-12, logout of this (other) session caused an exception in the above request.
    BClient_Testser client2 = TestUtilsHttp.createClient();
    client2.setAuthentication(new MyAuthentication("Fritz", "abc"));
    client2.getRemoteWithAuthentication().doit(0);
    client2.done();
    
    // Wait for request result, should least 5s. 
    int doitValue = doitResult.getResult(10000L);
    TestUtils.assertEquals(log, "doit value", BYPS_12_DOIT + 1, doitValue);
    
    log.info(")testLogoutDoesNotInterruptOtherMessages");
  }
  

}
