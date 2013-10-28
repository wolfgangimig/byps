package byps.http;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BAsyncResult;
import byps.BException;
import byps.BExceptionC;
import byps.BMessage;
import byps.BMessageHeader;
import byps.BOutput;
import byps.BServer;
import byps.BServerR;
import byps.BTransport;

/**
 * LongPoll-Nachricht:
 * 
 */
public class HServerR extends BServerR {

  public HServerR(BTransport transport, BServer server, int nbOfConns) {
    super(transport, server);
    this.nbOfConns = nbOfConns;
    this.sleepMillisBeforeRetry = 30 * 1000;
  }

  @Override
  public void start() throws BException {
    if (log.isDebugEnabled()) log.debug("start(");
    for (int i = 0; i < nbOfConns; i++) {
      sendLongPoll(null);
    }
    if (log.isDebugEnabled()) log.debug(")start");
  }

  @Override
  public void done() {
    if (log.isDebugEnabled()) log.debug("done(");

    synchronized (refDone) {
      refDone[0] = true;
      refDone.notifyAll();
    }

    // Wird von HWireClient.done() aufgerufen.
    // Dort werden die Long-Polls vom Server beendet.

    // workerThread.interrupt();
    //
    // try {
    // workerThread.join(1000);
    // }
    // catch (InterruptedException ignored) {}

    if (log.isDebugEnabled()) log.debug(")done");
  }

  protected class LongPoll implements Runnable {

    private final Log log = LogFactory.getLog("LongPoll");
    protected BMessage methodResult;

    protected LongPoll(BMessage methodResult) throws BException {
      if (log.isDebugEnabled()) log.debug("LongPoll(" + methodResult);
      if (methodResult != null) {
        this.methodResult = methodResult;
      }
      else {
        BOutput outp = transport.getOutput();
        outp.header.flags |= BMessageHeader.FLAG_RESPONSE;
        outp.store(null); // irgendwas, damit auch der Header in den ByteBuffer
                          // geschrieben wird.
        this.methodResult = outp.toMessage();
      }
      if (log.isDebugEnabled()) log.debug(")LongPoll");
    }

    public void run() {
      if (log.isDebugEnabled()) log.debug("run(");

      final BAsyncResult<BMessage> asyncResult = new BAsyncResult<BMessage>() {

        @Override
        public void setAsyncResult(BMessage msg, Throwable e) {
          if (log.isDebugEnabled()) log.debug("setAsyncResult(" + msg);
          try {
            if (e != null) {
              BOutput out = transport.getOutput();
              out.header.flags = BMessageHeader.FLAG_RESPONSE;
              out.setException(e);
              msg = out.toMessage();
            }
            sendLongPoll(msg);
          } catch (BException e1) {
            if (log.isErrorEnabled()) log.error("Failed to send longpoll for obj=" + msg, e1);
          }
          if (log.isDebugEnabled()) log.debug(")setAsyncResult");
        }

      };

      BAsyncResult<BMessage> nextAsyncMethod = new BAsyncResult<BMessage>() {

        @Override
        public void setAsyncResult(BMessage msg, Throwable e) {
          if (log.isDebugEnabled()) log.debug("asyncMethod.setAsyncResult(" + msg + ", e=" + e);
          try {
            
            if (e == null) {
              // Execute the method received from server.
              transport.recv(server, msg, asyncResult);
            }
            else {
              BException ex = (BException) e;
              if (ex.code == BExceptionC.CONNECTION_TO_SERVER_FAILED) {
                // Session was invalidated.
                // Stop long-poll
                if (log.isDebugEnabled()) log.debug("Session is dead.");
              }
              else if (ex.code == BExceptionC.UNAUTHORIZED) {
                // Relogin is required
                if (log.isDebugEnabled()) log.debug("Forbidden. Re-login required.");
              }
              else if (ex.code == BExceptionC.TIMEOUT) {
                // HWireClientR has released the expried long-poll.
                // Ignore the error and send a new long-poll.
                asyncResult.setAsyncResult(null, null);
              }
              else if (waitBeforeRetry()) { // Connection refused or connection timeout
                asyncResult.setAsyncResult(null, null);
              }

            }
            
          } catch (Throwable ex) {
            // transport.recv failed
            if (log.isDebugEnabled()) log.debug("recv failed.", e);
            asyncResult.setAsyncResult(null, ex);
          }
          if (log.isDebugEnabled()) log.debug(")asyncMethod.setAsyncResult");
        }

        private boolean waitBeforeRetry() {
          synchronized (refDone) {
            // Server still running?
            if (!refDone[0]) {
              try {
                // Wait some seconds before next retry
                refDone.wait(sleepMillisBeforeRetry);
              } catch (InterruptedException e1) {
              }
            }
            return !refDone[0];
          }
        }
        
      };

      // Sende den longPoll-Request
      // Im Body befindet sich die Antwort auf die vorige vom Server gestellte
      // Anfrage.
      // Als Ergebnis des longPoll kommt eine neue Serveranfrage (Methode).

      transport.wire.sendR(methodResult, nextAsyncMethod);

      if (log.isDebugEnabled()) log.debug(")run");
    }

  }

  protected void sendLongPoll(BMessage obj) throws BException {
    if (log.isDebugEnabled()) log.debug("sendLongPollInWorkerThread(" + obj);
    synchronized (refDone) {
      if (!refDone[0]) {
        LongPoll lp = new LongPoll(obj);
        lp.run();
      }
    }
    // synchronized(this) {
    // if (log.isDebugEnabled()) log.debug("execute in worker thread");
    // currentLongPoll_access_sync = lp;
    // this.notifyAll();
    // }
    if (log.isDebugEnabled()) log.debug(")sendLongPollInWorkerThread");
  }

  // protected class WorkerThread extends Thread {
  // WorkerThread() {
  // setName("longpoll-" + c_longPollCounter.incrementAndGet());
  // }
  //
  // public void run() {
  // if (log.isDebugEnabled()) log.debug("LongPoll.run(");
  // try {
  // while (!isInterrupted()) {
  // LongPoll lp = null;
  // synchronized(HServerR.this) {
  // while (currentLongPoll_access_sync == null) {
  // if (log.isDebugEnabled()) log.debug("wait for LongPoll");
  // HServerR.this.wait();
  // }
  // lp = currentLongPoll_access_sync;
  // currentLongPoll_access_sync = null;
  // }
  //
  // try {
  // if (log.isDebugEnabled()) log.debug("execute LongPoll");
  // lp.run();
  // }
  // catch (Throwable e) {
  // log.error("LongPoll worker thread received uncaught exception.", e);
  // }
  // }
  // if (log.isDebugEnabled()) log.debug("Worker interrupted");
  // }
  // catch (InterruptedException e) {
  // if (log.isDebugEnabled()) log.debug("Recevied "+ e);
  // }
  // if (log.isDebugEnabled()) log.debug(")LongPoll.run");
  // }
  // }

  protected int nbOfConns;
  protected boolean[] refDone = new boolean[1];
  protected final long sleepMillisBeforeRetry;
  // protected final Thread workerThread = new WorkerThread();
  // protected LongPoll currentLongPoll_access_sync;
  private final Log log = LogFactory.getLog(HServerR.class);
}
