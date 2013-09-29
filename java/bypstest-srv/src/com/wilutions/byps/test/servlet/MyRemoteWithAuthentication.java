package com.wilutions.byps.test.servlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BException;
import com.wilutions.byps.BExceptionC;
import com.wilutions.byps.RemoteException;
import com.wilutions.byps.http.HSession;
import com.wilutions.byps.test.api.auth.SessionInfo;
import com.wilutions.byps.test.api.remote.BSkeleton_RemoteWithAuthentication;

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
  private Log log = LogFactory.getLog(MyRemoteWithAuthentication.class);

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
      mySession.setSessionAuthenticated(HSession.DEFAULT_INACTIVE_SECONDS);
      
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
      throw new BException(BExceptionC.AUTHENTICATION_REQUIRED, "Relogin requried");
    }
    
    // If login was successful, this function must be called with a SessionInfo object.
    // It has to be supplied by BTransport.send.
    if (sess == null) {
      log.info("throw sess=null");
      throw new RemoteException("Parameter sess must not be null.");
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
