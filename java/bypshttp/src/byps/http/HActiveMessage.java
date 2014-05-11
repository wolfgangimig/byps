package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BException;

public class HActiveMessage {
  private final static Log log = LogFactory.getLog(HActiveMessage.class);
  
  final Long messageId;
  
  private boolean waitingForRequestContext;
  private HRequestContext rctxtMessage;
//  private HashMap<Long, BContentStream> incomingStreams;
//  private HashMap<Long, BContentStream> outgoingStreams;
  private ArrayList<Long> incomingStreams = new ArrayList<Long>();
  private Thread workerThread;
  private volatile boolean canceled;

  HActiveMessage(Long messageId) {
    this.messageId = messageId;
    this.waitingForRequestContext = true;
  }

  public boolean isCanceled() {
    return canceled;
  }
  
  public synchronized boolean isLongPoll() {
    return workerThread == null && rctxtMessage != null;
  }

  public synchronized void setRequestContext(HRequestContext rctxt, Thread workerThread) {
    this.waitingForRequestContext = false;
    this.rctxtMessage = rctxt;
    this.workerThread = workerThread;
    if (log.isDebugEnabled()) log.debug("assigned rctxt=" + rctxt + ", workerThread=" + workerThread);
  }
  
  public synchronized void addIncomingStream(Long streamId) {
    incomingStreams.add(streamId);
  }
  
  public synchronized void removeAllIncomingStreams() {
    incomingStreams.clear();
    checkFinished();
  }
  
  private static ArrayList<Long> evalM1AndM2(Collection<Long> m1, Collection<Long> m2) {
    ArrayList<Long> arr = new ArrayList<Long>();
    for (Long streamId : m1) {
      if (m2.contains(streamId)) arr.add(streamId);
    }
    return arr;
  }
  
  public synchronized boolean checkReferencedStreamIds(HashSet<Long> allStreamIds, HashSet<Long> referencedStreamIds) {
    incomingStreams = evalM1AndM2(incomingStreams, allStreamIds);
    referencedStreamIds.addAll(incomingStreams);
    checkFinished();
    return isFinished();
  }

  public synchronized boolean isFinished() {
    boolean finished = !waitingForRequestContext && rctxtMessage == null;
    return finished;
  }

  private void checkFinished() {
  }

  public synchronized HRequestContext getAndRemoveRequestContext() throws BException {
    if (log.isDebugEnabled()) log.debug("getAndRemoveRequestContext(" + messageId);

    HRequestContext rctxt = rctxtMessage;
    rctxtMessage = null;

    checkFinished();

    if (log.isDebugEnabled()) log.debug(")getAndRemoveRequestContext=" + rctxt);
    return rctxt;
  }

  public synchronized void removeWorker() {
    if (log.isDebugEnabled()) log.debug("removeWorker(" + messageId);
    workerThread = null;
    checkFinished();
    if (log.isDebugEnabled()) log.debug(")removeWorker");
  }

  public synchronized void cancelMessage() {
    if (log.isDebugEnabled()) log.debug("cancelMessage(" + messageId);

    canceled = true;

    // Threads might wait in getIncomingStream()
    this.notifyAll();

    Thread thread = workerThread;
    if (log.isDebugEnabled()) log.debug("worker is still running: " + (thread != null));
    if (thread != null) {
      if (log.isDebugEnabled()) log.debug("interrupt thread=" + thread);
      thread.interrupt();

      // The worker thread will call RequestContext.complete
      // when it is finished.
    }
    else if (rctxtMessage != null) {

      if (log.isDebugEnabled()) log.debug("assume long-poll, complete response with HTTP 410");

      // Assume Longpoll request because a worker thread would have called
      // getAndRemoveRequestContext
      // before it has called removeWorker.

      // This block is executed, if the session is invalidated.
      // The response code is SC_GONE in order to stop HServerR on the
      // client side from
      // sending a new long-poll.

      HttpServletResponse resp = (HttpServletResponse) rctxtMessage.getResponse();
      resp.setStatus(HttpServletResponse.SC_GONE);
      rctxtMessage.complete();
      rctxtMessage = null;
    }

    incomingStreams.clear();
    
    checkFinished();

    if (log.isDebugEnabled()) log.debug(")cancelMessage");
  }

  @Override
  public String toString() {
    StringBuilder sbuf = new StringBuilder();
    sbuf.append("[").append(messageId);
    if (workerThread != null) sbuf.append(",").append(workerThread.getName());
    if (canceled) sbuf.append(",canceled");
    sbuf.append("]");
    return sbuf.toString();
  }

}
