package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BHashMap;

public class HCleanupResources {
	
	protected final BHashMap<String, HSession> sessions;
	protected final MyCleanupThread cleanupThread;
	protected final HServerContext serverContext;
	
	public HCleanupResources(BHashMap<String, HSession> sessions, HServerContext serverContext) {
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
      Logger log = LoggerFactory.getLogger(HCleanupResources.class);
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
