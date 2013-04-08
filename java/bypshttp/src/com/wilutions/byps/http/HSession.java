package com.wilutions.byps.http;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BClient;
import com.wilutions.byps.BRemoteRegistry;
import com.wilutions.byps.BServer;
import com.wilutions.byps.BTargetId;

public abstract class HSession  {
	
	final HttpSession httpSess;
    final HWriteResponseHelper writeHelper;
    final HWireServer wireServer;
    final HWireClientR wireClientR;
    
	public HSession(HttpSession hsess, File tempDir, BRemoteRegistry stubRegistry) {
		if (log.isDebugEnabled()) log.debug("BSession(");
		this.httpSess = hsess;
		
		writeHelper = new HWriteResponseHelper();
		
	    wireServer = new HWireServer(writeHelper, tempDir);
	    
	    wireClientR = new HWireClientR(wireServer);
	    
    	hsess.setAttribute(HConstants.HTTP_SESSION_ATTRIBUTE_NAME, this);
    	if (log.isDebugEnabled()) log.debug(")BSession");
	}
	
	public void done() {
			
		httpSess.removeAttribute(HConstants.HTTP_SESSION_ATTRIBUTE_NAME);
		httpSess.invalidate();
		
		wireServer.done();
		wireClientR.done();
	}
	
	public void removeExpiredResources() {
		wireServer.cleanup();
	}
	
	public final HWireServer getWireServer() { 
		return wireServer;
	}
	
	public final HWireClientR getWireClientR() {
		return wireClientR;
	}

	public final void setTargetId(BTargetId v) {
		getServer().transport.setTargetId(v);
		getServer().clientR.transport.setTargetId(v);
	}
	
	public final String getId() {
		return httpSess.getId();
	}
	
	public static final HSession getSession(BTargetId targetId) {
		Map<BTargetId, HSession> sessions = HSessionListener.getAllSessions();
		return sessions.get(targetId);
	}
	
	public abstract BServer getServer();
	
	public BClient getClientR() {
		return getServer().clientR;
	}
	
	private final Log log = LogFactory.getLog(HSession.class);

	public BTargetId getTargetId() {
		return getServer().transport.getTargetId();
	}
	
}
