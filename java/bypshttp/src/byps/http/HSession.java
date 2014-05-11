package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BApiDescriptor;
import byps.BClient;
import byps.BServer;
import byps.BTargetId;
import byps.BTransportFactory;

/**
 * This class represents a session.
 * Objects of this class are added to the application server session under the key
 * {@link HConstants#HTTP_SESSION_ATTRIBUTE_NAME}
 * 
 * A HSession object is already created for negotiation, but it keeps alive only
 * for a short time {@link HConstants#MAX_INACTIVE_SECONDS_BEFORE_AUTHENTICATED} 
 * if the negotiate request does not contain a remote user attribute. If your session class
 * does not make use of authentication, call {@link #setSessionAuthenticated()} in the constructor.
 * Otherwise, call setSessionAuthenticated somewhere in your implementation.
 *
 */
public abstract class HSession 
//implements Serializable, don't know how to serialize this class. Don't know how to resolve the dependencies to other objects.
{

  protected HttpSession httpSess;
  protected final HServerContext serverContext;
  protected final HWriteResponseHelper writeHelper;
  protected HWireServer wireServer;
  protected HWireClientR wireClientR;
  protected final int defaultInactiveSeconds;
  protected final String remoteUser;

  /**
   * Construtor
   * @param hsess HTTP session object, can be null.
   * @param remoteUser Authenticated user, supplied from HttpSerlvetRequest.getRemoteUser(), can be null.
   * @param tempDir Temporary directory for storing streams, can be null.
   * @param serverRegistry Registry for BStub objects of all subscribers.
   * @param listener Listener for events triggered during processing.
   */
  public HSession(HttpSession hsess, String remoteUser, HServerContext serverContext) {
    if (log.isDebugEnabled())
      log.debug("HSession(");
    this.httpSess = hsess;
    this.serverContext = serverContext;
    
    this.remoteUser = remoteUser;
    this.defaultInactiveSeconds = hsess.getMaxInactiveInterval();

    // Shorten the lifetime of the HTTP session, 
    // if there is no authenticated user.
    if (remoteUser == null || remoteUser.length() == 0) {
      hsess.setMaxInactiveInterval(HConstants.MAX_INACTIVE_SECONDS_BEFORE_AUTHENTICATED);
    }
    
    writeHelper = new HWriteResponseHelper(serverContext.getListener());

    wireServer = new HWireServer(serverContext.getActiveMessages(), writeHelper);

    wireClientR = new HWireClientR(wireServer);

    if (hsess != null) {
      hsess.setAttribute(HConstants.HTTP_SESSION_ATTRIBUTE_NAME, this);
    }
    
    if (log.isDebugEnabled()) log.debug(")HSession");
  }

  public void done() {
    if (log.isDebugEnabled()) log.debug("done(");

    HttpSession hsess = httpSess;
    if (hsess != null) {
      
      // HttpSession.invalidate() will call via HSessionListener done() again.
      // To avoid recursion, set the httpSess reference as null.
      httpSess = null;
      hsess.invalidate();
    }

    // HWireServer.done() could interrupt the current thread.
    // Delete the interrupt signal that might be set in this function.
    // If the thread has already been interrupted before, interrupt it after 
    // done() again.
        
    boolean intrp = Thread.currentThread().isInterrupted();
    try { 
      wireServer.done(); 
      synchronized(wireServer) { wireServer.wait(1); }
    } catch (InterruptedException ignored) {
    }
    
    if (intrp) { 
      Thread.currentThread().interrupt();
    }
    
    wireClientR.done();

    if (log.isDebugEnabled()) log.debug(")done");
  }
  
  protected BTransportFactory getTransportFactory(BApiDescriptor apiDesc) {
    BTransportFactory transportFactory = new HTransportFactoryServer(
        apiDesc, wireServer, wireClientR, serverContext.getServerRegistry());
    return transportFactory;
  }

  public void removeExpiredResources() {
    wireServer.cleanup();
    wireClientR.cleanup();
  }
  
//  public Collection<BClient> getForwardClientsToOtherServers() throws RemoteException {
//    return serverContext.getServerRegistry().getForwardClientsToOtherServers();
//  } unused?
//
  public void setTargetId(BTargetId v) {
    getServer().setTargetId(v);
  }
  
  public BTargetId getTargetId() {
    return getServer().getTargetId();
  }


  public static final HSession getSession(BTargetId targetId) {
    Map<BTargetId, HSession> sessions = HSessionListener.getAllSessions();
    return sessions.get(targetId);
  }

  public abstract BServer getServer();

  /**
   * Set session authenticated.
   * Extend the inactive interval of the session to the default value.
   */
  public void setSessionAuthenticated() {
    if (httpSess != null) {
      int n = httpSess.getMaxInactiveInterval();
      if (n != defaultInactiveSeconds) {
        httpSess.setMaxInactiveInterval(defaultInactiveSeconds);
      }
    }
  }
  
  public BClient getClientR() {
    return getServer().getClientR();
  }
  
  public String toString() {
    BServer server = getServer();
    return "[user=" + remoteUser + ", targetId=" + server.getTargetId() + ", JSESSIONID=" + (httpSess != null ? httpSess.getId() : "null") + "]";
  }
  
  public String getRemoteUser() {
    return this.remoteUser;
  }

  private final static Log log = LogFactory.getLog(HSession.class);

}
