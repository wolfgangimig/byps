package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BServer {
	
	public final BTransport transport;
	public final BClient clientR;
	
	protected final Map<Integer, BSkeleton> remotes;
	
	public BServer(BTransport transport, BClient clientR) {
		this.transport = transport;
		this.clientR = clientR;
		this.remotes = new ConcurrentHashMap<Integer, BSkeleton>();
	}
	
	public BServer(BServer rhs) {
		this.transport = rhs.transport;
		this.clientR = rhs.clientR;
		this.remotes = rhs.remotes;
	}
	
  public void setTargetId(BTargetId targetId) {
    transport.setTargetId(targetId);
    if (clientR != null) clientR.transport.setTargetId(targetId);
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

			// Die Target-ID aus dem Header ist gleich der Target-ID des BServer-Objekts
			// für einen normalen Client-Server-Request
			if (clientTargetId.equals(serverTargetId)) {
				remote = remotes.get(remoteId);
				if (log.isDebugEnabled()) log.debug("client calls its server-side: remoteId=" + remoteId + ", remote=" + remote);
			}
			else if (this.transport.serverRegistry != null) { // should not be null for server-side transport
				
				// Es wird eine andere Target-ID angesteuert.
				// Ermittle hier die BRemote-Schnittstelle dieser Target-ID.
				// I.d.R. dürfte sie einem anderen Client gehören.
				
				remote = this.transport.serverRegistry.getRemote(clientTargetId, remoteId);
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

	private final Log log = LogFactory.getLog(BServer.class);
}
