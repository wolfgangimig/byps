package byps.test.servlet;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BException;
import byps.BExceptionC;
import byps.RemoteException;
import byps.http.HSession;
import byps.test.api.auth.SessionInfo;
import byps.test.api.remote.BSkeleton_RemoteWithAuthentication;

/**
 * For this example, each Tomcat session has its own MyRemoteWithAuthentication object in MySession.
 * Thus, Tomcat has already validated the session before one of this functions are called. 
 * So it is not required here to check the SessionInfo.session ID. It is sufficient
 * to test, whether the caller is authenticated against the MyRemoteWithAuthentication object or not. 
 */
public class MyRemoteWithAuthentication extends BSkeleton_RemoteWithAuthentication {
  
  enum EState { INVALID, AUTHENTICATED };
  private EState state = EState.INVALID;
  private MySession mySession;
  private Logger log = LoggerFactory.getLogger(MyRemoteWithAuthentication.class);

  public MyRemoteWithAuthentication(MySession mySession) {
    this.mySession = mySession;
  }
  
  @Override
  public void setUseAuthentication(boolean useAuth) throws RemoteException {
    log.info("setUseAuthentication(" + useAuth);
    MySession.useAuthentication = useAuth;
    state = EState.INVALID;
    log.info(")setUseAuthentication");
  }

  @Override
  public SessionInfo login(SessionInfo sess, String userName, String userPwd)
      throws RemoteException {
    log.info("login(" + userName);
    if (userName.equals("Fritz")) {
      
      // Extend the session lifetime. 
      // The inactive interval is initialized with a short value in the negotiate request.
      // On successful authentication, the interval has to be extended.
      mySession.setSessionAuthenticated();
      
      state = EState.AUTHENTICATED;
      sess = new SessionInfo();
      sess.sessionID = "123";
    }
    else {
      // This exception is not recognized as a re-login exception in 
      // BAuthentication.isReloginException(). 
      // It results in an error in the caller.
      throw new RemoteException("Login failed");
    }
    log.info(")login=" + sess);
    return sess;
  }

  @Override
  public int doit(SessionInfo sess, int value) throws RemoteException {
    log.info("doit(sess=" + sess + ", value=" + value);
    
    if (state == EState.INVALID) {
      log.info("throw Relogin required");
      // This exception is checked in the BAuthentication class and causes a re-login.
      throw new BException(BExceptionC.UNAUTHORIZED, "Relogin requried");
    }
    
    // If login was successful, this function must be called with a SessionInfo object.
    // It has to be supplied by BTransport.send.
    if (sess == null) {
      log.info("throw sess=null");
      throw new RemoteException("Parameter sess must not be null.");
    }
   
    // Pause the request to check BYPS-12.
    // BYPS-12: Logout killed all messages.
    final int BYPS_12_DOIT = 12;
    if (value == BYPS_12_DOIT) {
      try {
        Thread.sleep(5000L);
      } catch (InterruptedException e) {
        // Do not Thread.currentThread().interrupt(); 
        // If this message is cancelled, TestRemoteWithAuthentication.testLogoutDoesNotInterruptOtherMessages 
        // should receive an exception. 
        throw new RemoteException(e.toString());
      }
    }
    
    int ret = value+1;
    log.info(")doit=" + ret);
    return ret;
  }

  @Override
  public void expire(SessionInfo sess) throws RemoteException {
    log.info("expire(" + sess);
    state = EState.INVALID;
    log.info(")exprie");
  }
  
}
