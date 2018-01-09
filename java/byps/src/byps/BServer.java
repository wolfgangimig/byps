package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BServer {
	
	protected final BTransport transport;
	protected final BClient clientR;
	
	protected final Map<Integer, BSkeleton> remotes;
	
	public BServer(BTransport transport, BClient clientR) {
		this.transport = transport;
		this.clientR = clientR;
		this.remotes = Collections.synchronizedMap(new HashMap<Integer, BSkeleton>());
	}
	
	public BServer(BServer rhs) {
		this.transport = rhs.transport;
		this.clientR = rhs.clientR;
		this.remotes = rhs.remotes;
	}
	
  public void setTargetId(BTargetId targetId) {
    String sessionId = targetId.toSessionId();
    transport.setTargetId(targetId);
    transport.setSessionId(sessionId);
    if (clientR != null) {
      clientR.getTransport().setTargetId(targetId);
      clientR.getTransport().setSessionId(sessionId);
    }
  }
  
  public BTargetId getTargetId() {
    return transport.getTargetId();
  }
  
	public void addRemote(int remoteId, BSkeleton remoteImpl) {
		if (remoteImpl != null) {
			remotes.put(remoteId, remoteImpl);
			remoteImpl.BSkeleton_setTargetId(transport.getTargetId());
		}
	}
	
	public BSkeleton getRemote(int remoteId) {
	  return remotes.get(remoteId);
	}
	
	public BProtocol negotiate(BTargetId targetId, ByteBuffer in, final BAsyncResult<ByteBuffer> asyncResult) throws Throwable {
		if (log.isDebugEnabled()) log.debug("negotiate(");
		BProtocol protocol = transport.negotiateProtocolServer(targetId, in, asyncResult);
		if (log.isDebugEnabled()) log.debug(")negotiate=" + protocol);
		return protocol;
	}
	
	public void recv(BTargetId clientTargetId, Object methodObj, final BAsyncResult<Object> methodResult) {
		if (log.isDebugEnabled()) log.debug("recv(");
				
		try {
			BMethodRequest method = (BMethodRequest)methodObj;
			
			BRemote remote = null;
			final int remoteId = method.getRemoteId();
			final BTargetId serverTargetId = this.transport.getTargetId();
	
      if (log.isDebugEnabled()) {
        log.debug("my targetId=" + serverTargetId + ", remote targetId=" + clientTargetId);
      }
			
	     // Is client allowed to call the interface?
      if (clientTargetId.getRemoteId() != 0 && clientTargetId.getRemoteId() != remoteId) {
        throw new BException(BExceptionC.FORBIDDEN, "Access denied", "Client " + clientTargetId + " is not allowed to call interface of type=" + remoteId);
      }
      
			// For a normal request, the target IDs of client an server are equal.
			if (clientTargetId.equals(serverTargetId)) {
				remote = remotes.get(remoteId);
				if (log.isDebugEnabled()) log.debug("client calls its server-side: remoteId=" + remoteId + ", remote=" + remote);
			}
			else if (this.transport.getServerRegistry() != null) { // should not be null for server-side transport
				
			  // The target ID belongs to another server instance. 
			  // Get the remote interface of this server and forward the request
			  // when the method is executed.
			  
				remote = this.transport.getServerRegistry().getRemote(clientTargetId, remoteId);
				if (log.isDebugEnabled()) log.debug("client calls another client: remoteId=" + remoteId + ", remote=" + remote);
			}
			
			// Does the client support the interface?
			if (remote == null) {
				throw new BException(BExceptionC.SERVICE_NOT_IMPLEMENTED, "Service not implemented: remoteId=" + remoteId);
			}
			
			if (log.isDebugEnabled()) log.debug("execute ...");
			method.execute(remote, methodResult);
			if (log.isDebugEnabled()) log.debug("execute OK");
			
		}
		catch (Throwable e) {
			if (log.isDebugEnabled()) log.debug("execute failed. ", e);
			methodResult.setAsyncResult(null, e);
		}
		
		if (log.isDebugEnabled()) log.debug(")recv");
	}

  public BTransport getTransport() {
    return transport;
  }
  
  public BClient getClientR() {
    return clientR;
  }
  
	private final static Log log = LogFactory.getLog(BServer.class);

}
