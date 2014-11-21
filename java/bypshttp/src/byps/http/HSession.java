package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BApiDescriptor;
import byps.BClient;
import byps.BHashMap;
import byps.BServer;
import byps.BTargetId;
import byps.BTransportFactory;

/**
 * This class represents a session.
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

  protected final HServerContext serverContext;
  protected final HWriteResponseHelper writeHelper;
  protected HWireServer wireServer;
  protected HWireClientR wireClientR;
  protected volatile int maxInactiveSeconds;
  protected final String remoteUser;
  protected volatile long lastAccessTime;

  /**
   * Construtor
   * @param remoteUser Authenticated user, supplied from HttpSerlvetRequest.getRemoteUser(), can be null.
   * @param tempDir Temporary directory for storing streams, can be null.
   * @param serverRegistry Registry for BStub objects of all subscribers.
   * @param listener Listener for events triggered during processing.
   */
  public HSession(String remoteUser, HServerContext serverContext) {
    if (log.isDebugEnabled())
      log.debug("HSession(");
    this.serverContext = serverContext;
    
    this.remoteUser = remoteUser;

    // Shorten the lifetime of the HTTP session, 
    // if there is no authenticated user.
    maxInactiveSeconds = (remoteUser == null || remoteUser.length() == 0) ?
        HConstants.MAX_INACTIVE_SECONDS_BEFORE_AUTHENTICATED :
        HConstants.DEFAULT_INACTIVE_SECONDS_AUTHENTICATED;
    
    writeHelper = new HWriteResponseHelper(serverContext.getListener());

    wireServer = new HWireServer(serverContext.getActiveMessages(), writeHelper);

    wireClientR = new HWireClientR(wireServer);

    touch();
    
    if (log.isDebugEnabled()) log.debug(")HSession");
  }

  public void done() {
    if (log.isDebugEnabled()) log.debug("done(");
    
    BHashMap<String, HSession> sessions = HSessionListener.getAllSessions(); 
    sessions.remove(getTargetId().toSessionId());
    if (log.isDebugEnabled()) log.debug("remove sessionId=" + getTargetId().toSessionId());

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
  
  public void touch() {
    lastAccessTime = System.currentTimeMillis();
  }
  
  public boolean isExpired() {
    long now = System.currentTimeMillis();
    long maxIdleMillis = (long)maxInactiveSeconds * 1000;
    return lastAccessTime + maxIdleMillis < now;
  }
  
  protected BTransportFactory getTransportFactory(BApiDescriptor apiDesc) {
    BTransportFactory transportFactory = new HTransportFactoryServer(
        apiDesc, wireServer, wireClientR, serverContext.getServerRegistry());
    return transportFactory;
  }

  public void removeExpiredResources() {
    if (log.isDebugEnabled()) log.debug("removeExpiredResources(");
    boolean exp = isExpired();
    if (log.isDebugEnabled()) log.debug("sesionId=" + getTargetId().toSessionId() + ", expired=" + isExpired());
    if (exp) {
      done();
    }
    else {
      wireServer.cleanup();
      wireClientR.cleanup();
    }
    if (log.isDebugEnabled()) log.debug(")removeExpiredResources");
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
    BHashMap<String, HSession> sessions = HSessionListener.getAllSessions();
    return sessions.get(targetId.toSessionId());
  }

  public abstract BServer getServer();

  /**
   * Set session authenticated.
   * Extend the inactive interval of the session to the default value.
   */
  public void setSessionAuthenticated() {
    int n = maxInactiveSeconds;
    if (n != HConstants.DEFAULT_INACTIVE_SECONDS_AUTHENTICATED) {
      maxInactiveSeconds = HConstants.DEFAULT_INACTIVE_SECONDS_AUTHENTICATED;
    }
  }
  
  public BClient getClientR() {
    return getServer().getClientR();
  }
  
  public String toString() {
    BServer server = getServer();
    return "[user=" + remoteUser + ", targetId=" + server.getTargetId() + "]";
  }
  
  public String getRemoteUser() {
    return this.remoteUser;
  }

  public HServerContext getServerContext() {
    return serverContext;
  }
  
  private final static Log log = LogFactory.getLog(HSession.class);

}
