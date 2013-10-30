package byps.http;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BApiDescriptor;
import byps.BClient;
import byps.BServer;
import byps.BServerRegistry;
import byps.BTargetId;
import byps.BTransportFactory;

public abstract class HSession {

  public final static int DEFAULT_INACTIVE_SECONDS = -1;
  
  protected HttpSession httpSess;
  protected final BServerRegistry serverRegistry;
  protected final HWriteResponseHelper writeHelper;
  protected HWireServer wireServer;
  protected HWireClientR wireClientR;
  protected final int defaultInactiveSeconds;
  protected final String remoteUser;

  /**
   * Construtor
   * @param hsess HTTP session object, can be null.
   * @param remoteUser Authenticated user, supplied from HttpSerlvetRequest.getRemoteUser()
   * @param tempDir Temporary directory for storing streams.
   * @param serverRegistry Registry for BStub objects of all subscribers.
   * @param listener Listener for events triggered during processing.
   */
  public HSession(HttpSession hsess, String remoteUser, File tempDir, BServerRegistry serverRegistry, HServerListener listener) {
    if (log.isDebugEnabled())
      log.debug("HSession(");
    this.httpSess = hsess;
    this.serverRegistry = serverRegistry;
    
    this.remoteUser = remoteUser;
    this.defaultInactiveSeconds = hsess.getMaxInactiveInterval();

    // Shorten the lifetime of the HTTP session, 
    // if there is no authenticated user.
    if (remoteUser == null || remoteUser.length() == 0) {
      hsess.setMaxInactiveInterval(HConstants.MAX_INACTIVE_SECONDS_BEFORE_AUTHENTICATED);
    }
    
    writeHelper = new HWriteResponseHelper(listener);

    wireServer = new HWireServer(writeHelper, tempDir);

    wireClientR = new HWireClientR(wireServer);

    if (hsess != null) {
      hsess.setAttribute(HConstants.HTTP_SESSION_ATTRIBUTE_NAME, this);
    }
    
    if (log.isDebugEnabled()) log.debug(")HSession");
  }

  /**
   * Construtor
   * @param hsess HTTP session object
   * @param remoteUser Authenticated user, supplied from HttpSerlvetRequest.getRemoteUser()
   * @param tempDir Temporary directory for storing streams.
   * @param stubRegistry Registry for BStub objects of all subscribers.
   */
  public HSession(HttpSession hsess, String remoteUser, File tempDir, BServerRegistry stubRegistry) {
    this(hsess, remoteUser, tempDir, stubRegistry,
        new HServerListener() {
          public boolean onBeforeWriteHttpResponse(ByteBuffer obuf, Throwable e, HttpServletResponse resp, boolean isAsync) throws IOException {
            return false;
          }
          public void onAfterWriteHttpResponse(int nbOfBytesWritten) {
          }
    });
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

    wireServer.done();
    wireClientR.done();

    if (log.isDebugEnabled()) log.debug(")done");
  }
  
  protected BTransportFactory getTransportFactory(BApiDescriptor apiDesc) {
    BTransportFactory transportFactory = new HTransportFactoryServer(
        apiDesc, wireServer, wireClientR, serverRegistry);
    return transportFactory;
  }

  public void removeExpiredResources() {
    wireServer.cleanup();
    wireClientR.cleanup();
  }

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
   * @param inactiveSeconds Number of inactive seconds until the session is invalidated by the server.
   */
  public void setSessionAuthenticated(int inactiveSeconds) {
    if (httpSess != null) {
      if (inactiveSeconds == DEFAULT_INACTIVE_SECONDS) inactiveSeconds = defaultInactiveSeconds;
      httpSess.setMaxInactiveInterval(inactiveSeconds);
    }
  }
  
  public BClient getClientR() {
    return getServer().clientR;
  }

  private final Log log = LogFactory.getLog(HSession.class);

}
