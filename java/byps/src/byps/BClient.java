package byps;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	 * Start server for reverse requests after protocol is negotiated.
	 */
	protected volatile boolean startR;
	
	/**
	 * An interface to support lazy loading of object elements.
	 */
	protected volatile BLazyLoad lazyLoad;
		
	/**
	 * Constructor used by generated derived classes.
	 * @param transport
	 * @param serverR
	 */
	protected BClient(BTransport transport, BServerR serverR) {
		this.transport = transport;
		this.serverR = serverR;
		this.setAuthentication(null);
		
		// Deserialization injects this weak reference into BValueClass.bypsClient
		// to allow deferred loading of elements in getter functions of BValueClass objects.
		this.transport.setClientHelperToInjectInBValueClass(new WeakReference<BClient>(this));
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
	 * Get interface to lazy load elements.
	 * @return BLazyLoad
	 */
	public BLazyLoad getLazyLoad() {
    return lazyLoad;
  }
	
  /**
   * Set interface to lazy load elements.
   * @param lazyLoad BLazyLoad
   */
	public void setLazyLoad(BLazyLoad lazyLoad) {
    this.lazyLoad = lazyLoad;
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
		start(asyncResult, true);
		if (log.isDebugEnabled()) log.debug(")negotiateTransportProtocol");
	}
	
	/**
	 * Start communication and maybe start reverse server.
	 * @param asyncResult
	 * @param startR
	 */
	public void start(final BAsyncResult<Boolean> asyncResult, boolean startR) {
	  this.startR = startR;
    // Negotiate the protocol and authenticate.
    // This function will call ClientAuthentication.authenticate()
    // which starts the BServerR.
    transport.negotiateProtocolClient(asyncResult);
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
   * Start server for reverse requests, if it is not already started.
   * @throws RemoteException
   */
  public void startR() throws RemoteException {
    if (!this.startR) {
      this.startR = true;
      internalStartR();
    }
  }

  /**
   * Start server for reverse requests.
   * @throws RemoteException
   */
  private void internalStartR() throws BException {
    String sessionId = getTransport().getSessionId();
    BTargetId targetId = getTransport().getTargetId();
    serverR.transport.setSessionId(sessionId);
    serverR.transport.setTargetId(targetId);
    serverR.start();
  }
  
	/**
	 * Assign authentication functionality.
	 * This function should be called immediately after the BClient object was created 
	 * and before the client is started by {@link BClient#start(BAsyncResult)}.
	 * @param authentication
	 */
	public void setAuthentication(BAuthentication authentication) {
	  transport.setAuthentication(new ClientAuthentication(authentication)); 
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
              if (startR) { // start server automatically?
                try {
                  internalStartR();
                } catch (BException ex2) {
                  ex = ex2;
                }
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

	/**
	 * Call API method via reflection.
	 * @param remoteId ID of a remote interface (serialVersionUID)
	 * @param methodName Method name.
	 * @param params Method params.
	 * @return Method result.
	 */
  @SuppressWarnings("unused")
  private Object call(long remoteId, String methodName, Object ... params) {
    Object ret = null;
    
    try {
      long typeMask = transport.getOutput().registry.getMaxTypeId(); // Integer.MAX_VALUE
      
      BRemote remote = getStub((int)(remoteId & typeMask));
      if (remote == null) throw new IllegalArgumentException("Missing stub for remoteId=" + remoteId);

      Method methodToCall = null;
      
      for (Method method : remote.getClass().getDeclaredMethods()) {
        if (!method.getName().equals(methodName)) continue;
        int paramCount = method.getParameterCount();
        if (params.length != paramCount) continue;
        
        boolean fit = true;
        int paramIndex = 0; 
        for (Class<?> declaredParamClass : method.getParameterTypes()) {
          Object param = params[paramIndex]; 
          if (param != null) {
            Class<?> paramClass = param.getClass();
            Class<?> paramClassW = getWrapperOf(paramClass);
            Class<?> declaredParamClassW = getWrapperOf(declaredParamClass);
            fit = declaredParamClassW.isAssignableFrom(paramClassW);
            if (!fit) break;
          }
          paramIndex++;
        }
        
        if (!fit) continue;
        
        methodToCall = method;
        break;
      }
      
      if (methodToCall == null) {
        throw new IllegalArgumentException("Method not found, remote=" + remote + ", methodName=" + methodName);
      }
      
      ret = methodToCall.invoke(remote, params);

    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
    
    return ret;
  }
  
  private static Class<?> getWrapperOf(Class<?> clazz) {
    if (!clazz.isPrimitive()) return clazz;
    if (clazz.equals(boolean.class)) return Boolean.class;
    if (clazz.equals(char.class)) return Character.class;
    if (clazz.equals(byte.class)) return Byte.class;
    if (clazz.equals(short.class)) return Short.class;
    if (clazz.equals(int.class)) return Integer.class;
    if (clazz.equals(long.class)) return Long.class;
    if (clazz.equals(float.class)) return Float.class;
    if (clazz.equals(double.class)) return Double.class;
    throw new IllegalArgumentException("No wrapper class for primitive type=" + clazz);
  }
  
  /**
   * Lazy load an object's element.
   * @param bclientRef Reference to BClient object.
   * @param obj A member of this object should be read.
   * @param members This value can be used to specify which element has to be loaded.
   */
  public static void lazyLoadMember(WeakReference<BClient> bclientRef, Object obj, long member) {
    
    // Service reference supplied?
    if (bclientRef != null) {

      // Service reference valid?
      BClient bclient = bclientRef.get();
      if (bclient != null) {
        
        BLazyLoad lazyLoad = bclient.getLazyLoad();
        if (lazyLoad == null) {
          throw new UnsupportedOperationException("Lazy load member for object=" + obj + " is not supported.");
        }
        
        lazyLoad.lazyLoadMembers(bclient, obj, member);
      }
      else {
        // Service has already been garbage collected. 
        // Assume that this object and the member to load is not relevant anymore.
        // Hence, just do nothing.
      }
      
    }
    
  }

  public String toString() {
    return "[" + getClass().getSimpleName() + ", transport=" + transport.toString() + "]";
  }
	
  private final static Logger log = LoggerFactory.getLogger(BClient.class);

}
