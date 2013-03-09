package com.wilutions.byps.http;

import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BTargetId;

public class HCleanupResources {
	
	protected final Map<BTargetId, HSession> sessions;
	protected final MyCleanupThread cleanupThread;
	
	public HCleanupResources(Map<BTargetId, HSession> sessions) {
		this.sessions = sessions;
		this.cleanupThread = new MyCleanupThread();
		this.cleanupThread.start();
	}
	
	public void done() {
		this.cleanupThread.interrupt();
	}
	
    private class MyCleanupThread extends Thread {
    	
    	public MyCleanupThread() {
    		setName("cleanup-resources");
    		setDaemon(true);
    	}
    	
    	@Override
    	public void run() {
    		Log log = LogFactory.getLog(HCleanupResources.class);
       		try {
	    		while (!Thread.interrupted()) {
	    			Thread.sleep(HConstants.CLEANUP_MILLIS);
	    			
	    			ArrayList<HSession> arrSessions = new ArrayList<HSession>(sessions.values());
	    			for (HSession sess : arrSessions) {
	    		    	sess.removeExpiredResources();
	    			}
	    			
	    		}
    		}
    		catch (InterruptedException e) {
    		}
    		catch (Throwable e) {
    			log.error("Unexpected exception in cleanup-thread: ", e);
    		}
    	}
    }

}