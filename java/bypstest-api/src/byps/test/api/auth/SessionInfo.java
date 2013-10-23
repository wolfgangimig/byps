package byps.test.api.auth;

import java.io.Serializable;


/**
 * Example for a session class.
 * @see byps.test.api.remote.RemoteWithAuthentication
 */
public class SessionInfo implements Serializable {
  private static final long serialVersionUID = 65775978;
  public String sessionID;
}
