package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This is the base class for the client side of a subscriber.
 * The generator creates a derived class of BClient named BClient_{your-API-name}.
 * This derived class holds the stubs of your interfaces in public members.
 * In order to start using a BClient object, the method start() has to be called.
 * It negotiates the protocol and version and starts the server side of the subscriber.
 * @see #start(BAsyncResult)
 */
public abstract class BClient {
	
	/**
	 * Transport object.
	 */
	protected final BTransport transport;
	
	/**
	 * Server side of the subscriber.
	 */
	protected final BServerR serverR;
		
	/**
	 * Constructor used by generated derived classes.
	 * @param transport
	 * @param serverR
	 */
	protected BClient(BTransport transport, BServerR serverR) {
		this.transport = transport;
		this.serverR = serverR;
	}
	
	/**
	 * Get the stub for the given interface ID.
	 * This method can be used to obtain an interface for the client side of the subscriber 
	 * from within the provider.
	 * @param remoteId Interface ID.
	 * @return Interface object.
	 */
	public abstract BRemote getStub(int remoteId);
	
	/**
	 * Get transport object.
	 * @return BTransport object
	 */
	public BTransport getTransport() {
	  return transport;
	}
	
	
	/**
	 * Handler that is called when a reverse connection is interrupted.
	 * @param lostConnectionHandler
	 */
	public void setLostReverseConnectionHandler(BLostConnectionHandler lostConnectionHandler) {
	  if (serverR != null)  {
	    serverR.setLostConnectionHandler(lostConnectionHandler);
	  }
	}
	
	/**
	 * This method closes all connections to the provider.
	 * It stops the server side of the subscriber.
	 */
	public void done() {
		
		if (serverR != null) {
			serverR.done();
		}
		
		transport.getWire().done();
	}
	
	/**
	 * Asynchronously start communication.
	 * This method has to be called before any API methods can be invoked. 
	 * It returns immediately. The result is submitted to the supplied asyncResult object.
	 * If an authentication object was supplied, the authenticate method is called after 
	 * the protocol version has been negotiated.
	 * @param asyncResult 
	 * @see {@link #setAuthentication(BAuthentication)}
	 */
	public void start(final BAsyncResult<Boolean> asyncResult) {
		if (log.isDebugEnabled()) log.debug("negotiateTransportProtocol(");

    setAuthentication(null);
    
		
		// Negotiate the protocol and authenticate.
		// This function will call ClientAuthentication.authenticate()
		// which starts the BServerR.
		transport.negotiateProtocolClient(asyncResult);
				
		if (log.isDebugEnabled()) log.debug(")negotiateTransportProtocol");
	}
	
	/**
	 * Synchronously start communication.
	 * @see #start(BAsyncResult)
	 * @throws RemoteException
	 */
	public void start() throws RemoteException {
	  BSyncResult<Boolean> asyncResult = new BSyncResult<Boolean>();
	  start(asyncResult);
	  asyncResult.getResult();
	}
	
	/**
	 * Assign authentication functionality.
	 * This function should be called immediately after the BClient object was created 
	 * and before the client is started by {@link BClient#start(BAsyncResult)}.
	 * @param authentication
	 */
	public void setAuthentication(BAuthentication authentication) {
	  transport.setAuthentication(
	      new ClientAuthentication(authentication), 
	      authentication == null); // onylIfNull
	}
	
	/**
	 * Get authentication object.
	 * Returns the authentication object previously set by {@link #setAuthentication(BAuthentication)}.
	 * @return Authentication object or null.
	 */
  public BAuthentication getAuthentication() {
    BAuthentication auth = transport.authentication;
    if (auth != null) {
      ClientAuthentication clientAuth = (ClientAuthentication)auth;
      auth = clientAuth.innerAuth;
    }
    return auth;
  }
	
	/**
	 * Wrapper class to supply BClient object in authentication.
	 */
	private class ClientAuthentication implements BAuthentication {
	
	  public final BAuthentication innerAuth;
	  
	  public ClientAuthentication(BAuthentication innerAuth) {
	    this.innerAuth = innerAuth;
	  }

    @Override
    public void authenticate(BClient ignored, final BAsyncResult<Boolean> asyncResult) {
      
      // The purpose of this outerResult is to start the long-polls
      // after re-login.
      
      BAsyncResult<Boolean> outerResult = new BAsyncResult<Boolean>() {
        public void setAsyncResult(Boolean ignored, Throwable ex) {
          
          if (ex == null) {
            if (serverR != null) {
              try {
                serverR.start();
              } catch (BException ex2) {
                ex = ex2;
              }
            }
          }
          
          asyncResult.setAsyncResult(ignored, ex);
        }
      };
      
      if (innerAuth != null) {
        innerAuth.authenticate(BClient.this, outerResult);
      }
      else {
        outerResult.setAsyncResult(Boolean.TRUE, null);
      }
    }

    @Override
    public boolean isReloginException(BClient ignored, Throwable ex, int typeId) {
      boolean ret = false;
      if (innerAuth != null) {
        ret = innerAuth.isReloginException(BClient.this, ex, typeId);
      }
      else {
        ret = transport.isReloginException(ex, typeId);
      }
      return ret;
    }

    @Override
    public void getSession(BClient client, int typeId, BAsyncResult<Object> asyncResult) {
      if (innerAuth != null) {
        innerAuth.getSession(BClient.this, typeId, asyncResult);
      }
      else {
        asyncResult.setAsyncResult(null, null);
      }
    }

	}

  public String toString() {
    return "[" + getClass().getSimpleName() + ", transport=" + transport.toString() + "]";
  }
	
  private final Log log = LogFactory.getLog(BClient.class);

}
