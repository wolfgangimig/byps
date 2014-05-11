package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BTargetId;

public class HCleanupResources {
	
	protected final Map<BTargetId, HSession> sessions;
	protected final MyCleanupThread cleanupThread;
	protected final HServerContext serverContext;
	
	public HCleanupResources(Map<BTargetId, HSession> sessions, HServerContext serverContext) {
		this.sessions = sessions;
		this.serverContext = serverContext;
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
          
          try {
            ArrayList<HSession> arrSessions = new ArrayList<HSession>(sessions.values());
            for (HSession sess : arrSessions) {
              sess.removeExpiredResources();
            }
            
            serverContext.getActiveMessages().cleanup(false);
          }
          catch (Throwable e) {
            log.error("Unexpected exception in cleanup-thread: ", e);
          }

        }
      }
      catch (InterruptedException e) {
      }
    }
  }

}
