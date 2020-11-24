package byps.test;

import java.net.HttpCookie;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BAsyncResult;
import byps.BAuthentication;
import byps.BClient;
import byps.BSyncResult;
import byps.RemoteException;
import byps.http.HConstants;
import byps.http.HTestAdapter;
import byps.http.HWireClient;
import byps.http.client.HHttpRequest;
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
  private Logger log = LoggerFactory.getLogger(TestRemoteStreams.class);

  @Before
  public void setUp() throws RemoteException {

    BClient_Testser client1 = TestUtilsHttp.createClient();
    client1.getRemoteWithAuthentication().setUseAuthentication(true);
    client1.done();

    client = TestUtilsHttp.createClient(1);
    remote = client.getRemoteWithAuthentication();
  }

  @After
  public void tearDown() throws InterruptedException {
    if (client != null) {
      try {
        remote.setUseAuthentication(false);
      } catch (RemoteException e) {
      }
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
    log.info("sess={}", sess);

    HWireClient hwire = (HWireClient) client.getTransport().getWire();
    String jsessionId = hwire.getHttpSession();
    log.info("jsessionId={}", jsessionId);

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

    // This method call will fail internally the first time with a
    // BExceptionC.AUTHENTICATION_REQUIRED.
    // Then, BTranpsport invokes MyAuthentication.authenticate and retries the
    // method call.
    int ret = remote.doit(1);
    TestUtils.assertEquals(log, "ret", 2, ret);

    // BYPS-18: Test that a session cookie can be read and set.

    HWireClient hwire = (HWireClient) client.getTransport().getWire();
    HttpCookie sessionCookie = hwire.getHttpCookie(HConstants.HTTP_COOKIE_JSESSIONID);
    log.info("sessionCookie={}", sessionCookie);

    BClient_Testser client2 = TestUtilsHttp.createClientForSession(sessionCookie);
    HWireClient hwire2 = (HWireClient) client2.getTransport().getWire();

    HttpCookie sessionCookie2 = hwire2.getHttpCookie(HConstants.HTTP_COOKIE_JSESSIONID);
    log.info("sessionCookie2={}", sessionCookie2);
    TestUtils.assertEquals(log, "sessionCookie2", sessionCookie.getValue(), sessionCookie2.getValue());

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
    } catch (RemoteException e) {
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
    for (int i = 0; i < 3; i++) {

      // This method call will fail internally the first time with a
      // BExceptionO.AUTHENTICATION_REQUIRED.
      // Then, BTranpsport invokes MyAuthentication.authenticate and retries the
      // method call.
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
            } catch (Exception e) {

              // Im Server tritt hier eine ClassCastException von
              // BStub_RemoteWithAuthentication nach
              // RemoteWithAuthenticationAsync
              // auf, wenn sich die Client-TargetId während remote.doit durch
              // einen
              // gleichzeitiges Negotiate ändert.
              // Ich habe dafür noch keine Lösung.

              refExc.compareAndSet(null, e);
              log.error("Authentication failed: ", e);
            } finally {
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

    private Logger log = LoggerFactory.getLogger("MyAuthentication");
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
      ((BClient_Testser) client).getRemoteWithAuthentication().login(userName, pwd, outerResult);
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
    // Before BYPS-12, logout of this (other) session caused an exception in the
    // above request.
    BClient_Testser client2 = TestUtilsHttp.createClient();
    client2.setAuthentication(new MyAuthentication("Fritz", "abc"));
    client2.getRemoteWithAuthentication().doit(0);
    client2.done();

    // Wait for request result, should least 5s.
    int doitValue = doitResult.getResult(10000L);
    TestUtils.assertEquals(log, "doit value", BYPS_12_DOIT + 1, doitValue);

    log.info(")testLogoutDoesNotInterruptOtherMessages");
  }

  /**
   * The BClient object has to initiate a negotiate call if the HTTP session cookie is expired,
   * event if there is no BAuthentication associated with it.
   * This test requires to have the server run with {@link HConstants#HTTP_SESSION_COOKIE_REQUIRED}=true.
   * Otherwise it does not receive a 401 and does not need to negotiate.
   * This option can be set with -Dbyps.http.sessionCookieRequired=true
   * BYPS-33
   * @throws RemoteException
   */
  @Test
  public void testWithoutAuthenticationSessionExpired() throws RemoteException {
    
    HWireClient hwire = (HWireClient) client.getTransport().getWire();
    
    String bypsSession = client.getTransport().getSessionId();
    String httpSession = hwire.getHttpSession();

    // Invalidate current session cookie.
    // Call .../bypservlet?testAdapter=invalidate-http-session 
    BSyncResult<ByteBuffer> syncResult = new BSyncResult<>();
    HHttpRequest request = hwire.getHttpClient().get(1, TestUtilsHttp.url + "?" + HTestAdapter.KEY_PARAM + "=" + HTestAdapter.INVALIDATE_HTTP_SESSION, syncResult);
    request.run();
    syncResult.getResult();
    
    // This request should initiate a negotiate call to receive a new JSESSIONID cookie and BYPS-Session.
    client.getRemotePrimitiveTypes().getBool();
    
    String bypsSession2 = client.getTransport().getSessionId();
    String httpSession2 = hwire.getHttpSession();
    
    // Make sure that the servers runs with HConstants.HTTP_SESSION_COOKIE_REQUIRED=true 
    // E.g. set -Dbyps.http.sessionCookieRequired=true
    // Otherwise the BYPS sessions are the same.
    TestUtils.assertTrue(log, "BYPS sessions must be different", !bypsSession.contentEquals(bypsSession2));
    TestUtils.assertTrue(log, "HTTP sessions must be different", !httpSession.contentEquals(httpSession2));

  }
}
