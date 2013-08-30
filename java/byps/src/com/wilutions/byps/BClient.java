package com.wilutions.byps;

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
	public final BTransport transport;
	
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
	 * This method closes all connections to the provider.
	 * It stops the server side of the subscriber.
	 */
	public void done() {
		
		if (serverR != null) {
			serverR.done();
		}
		
		transport.wire.done();
	}
	
	/**
	 * Start communication with provider.
	 * This method has to be called before any API methods can be invoked. 
	 * It returns immediately. The result is submitted to the supplied asyncResult object.
	 * If an authentication object was supplied, the authenticate method is called after 
	 * the protocol version has been negotiated.
	 * @param asyncResult 
	 * @throws RemoteException
	 * @see {@link #setAuthentication(BAuthentication)}
	 */
	public void start(final BAsyncResult<BClient> asyncResult) throws RemoteException {
		if (log.isDebugEnabled()) log.debug("negotiateTransportProtocol(");
		
		BAsyncResult<Boolean> outerResult = new BAsyncResult<Boolean>() {

			@Override
			public void setAsyncResult(Boolean ignored, Throwable e) {
				if (log.isDebugEnabled()) log.debug("setAsyncResult(");
				try {
					if (e == null && serverR != null) {
						serverR.start();
					}
					asyncResult.setAsyncResult(BClient.this, e);
				}
				catch (BException ex) {
					asyncResult.setAsyncResult(null, e);
				}
				if (log.isDebugEnabled()) log.debug(")setAsyncResult");
			}

		};
		
		transport.negotiateProtocolClient(outerResult);
				
		if (log.isDebugEnabled()) log.debug(")negotiateTransportProtocol");
	}
	
  private final Log log = LogFactory.getLog(BClient.class);

}
