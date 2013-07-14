package com.wilutions.byps;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 */
public abstract class BClient {
	
	public final BTransport transport;
	protected final BServerR serverR;
	
	public BClient(BTransport transport, BServerR serverR) {
		this.transport = transport;
		this.serverR = serverR;
	}
	
	public abstract BRemote getStub(int remoteId);
	
	public void done() {
		
		if (serverR != null) {
			serverR.done();
		}
		
		transport.wire.done();
	}
	
	public void start(final BAsyncResult<BClient> asyncResult) throws BException, InterruptedException {
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
