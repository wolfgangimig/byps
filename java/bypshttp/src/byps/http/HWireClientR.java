package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BAsyncResult;
import byps.BContentStream;
import byps.BException;
import byps.BExceptionC;
import byps.BMessage;
import byps.BMessageHeader;
import byps.BTargetId;
import byps.BWire;

public class HWireClientR extends BWire {
  
  public HWireClientR(BWire wireServer) {
    super(wireServer.getFlags());
    this.wireServer = wireServer;
  }

  public synchronized void done() {
    if (log.isDebugEnabled()) log.debug("done(");

    canceled = true;

    BException bex = new BException(BExceptionC.CANCELLED, "Longpoll canceled");

    // Notify the threads inside the server waiting for results that the
    // their calls are canceled.
    ArrayList<BAsyncResult<BMessage>> asyncResults = mapAsyncResults.getAndRemoveAll();
    for (BAsyncResult<BMessage> asyncResult : asyncResults) {
      // Gib iBuf an den Thread weiter, der auf das Resultat wartet.
      synchronized (asyncResult) {
        if (log.isDebugEnabled()) log.debug("pass cancel message to asyncResult, notify thread waiting in send()");
        try { 
          asyncResult.setAsyncResult(null, bex); 
        } catch (Throwable ex) {
          // just make sure, that all results are handled.
        }
        asyncResult.notifyAll();
      }
    }

    // Notify the client that the long-poll has finished.
    final ArrayList<AsyncRequestFromLongpoll> lrequests = lonpollRequests.getAndRemoveAll();
    for (AsyncRequestFromLongpoll lrequest : lrequests) {
      try {
        lrequest.request.setAsyncResult(null, bex);
      } catch (Throwable ignored) {
        // happens, if the HTTP session has already been invalidated
      }
    }
    if (log.isDebugEnabled()) log.debug(")done");
  }

  /**
   * Receive a long poll (reverse HTTP) request.
   * 
   * The HTTP request body (stored in ibuf) contains the response from the
   * client. The send() function is waiting for this response. As send() has
   * started the request, it has put an BAsyncResult object into the map
   * asyncResults_access_sync associated with the key messageId. This object is
   * found by the messageId and ibuf is passed to it by a call to
   * setAsyncResult.
   * 
   * The HTTP response has been encapsulated in parameter asyncRequest by the
   * caller. It will receive the next call when the server has to invoke the
   * client. Until the server needs the asyncRequest, it is stored in the map
   * asyncRequests_access_sync. The send() function takes the asyncRequest from
   * there and writes the request bytes into it.
   * 
   * @param messageId
   * @param ibuf
   * @param asyncRequest
   * @throws IOException
   */
  public void recvLongPoll(BMessage ibuf, final BAsyncResult<BMessage> nextRequest) throws IOException {
    if (log.isDebugEnabled()) log.debug(this + ".recvLongPoll(messageId=" + ibuf.header.messageId);

    if (log.isDebugEnabled()) log.debug("message buffer=" + ibuf);

    // Function send() has stored its parameter BAsyncResult mapped under the messageId.  
    if (log.isDebugEnabled()) log.debug("mapAsyncResults.keys=" + mapAsyncResults);
    BAsyncResult<BMessage> asyncResult = mapAsyncResults.remove(ibuf.header.messageId);
    if (log.isDebugEnabled()) log.debug("asyncResult for messageId: " + asyncResult);

    // If a BAsyncResult object is found ...
    if (asyncResult != null) {

      // ... pass ibuf as result.
      if (log.isDebugEnabled()) log.debug("pass message buffer to asyncResult");
      asyncResult.setAsyncResult(ibuf, null);

    }
    else {
      // Function send() has not been called before. 
    }

    // If function send() could not find a pending long-poll, it pushed 
    // the message into the queue of pending messages.
    PendingMessage pendingMessage = pendingMessages.poll(); 
    if (log.isDebugEnabled()) log.debug("pendingMessage=" + pendingMessage);
        
    // Pending message available? ...
    if (pendingMessage != null) {
      
      // ... send the pending message immediately to the client.
      nextRequest.setAsyncResult(pendingMessage.msg, null);
    }
    else {
      
      // ... push the long-poll into the queue.
      lonpollRequests.add(new AsyncRequestFromLongpoll(nextRequest, ibuf.header));
      if (log.isDebugEnabled()) log.debug("add longpoll to list, #polls=" + lonpollRequests.size());
    }
    
    if (log.isDebugEnabled()) log.debug(")recvLongPoll");
  }

  @Override
  public void send(BMessage msg, BAsyncResult<BMessage> asyncResult) {
    if (log.isDebugEnabled()) log.debug(this + ".send(" + msg + ", asyncResult=" + asyncResult);

    final long messageId = msg.header.messageId;

    try {
      
      // Save result object for next long-poll
      if (log.isDebugEnabled()) log.debug("map messageId=" + messageId + " to asyncResult=" + asyncResult);
      mapAsyncResults.put(messageId, asyncResult);
      
      int retries = 100;
      while (--retries >= 0) {
        
        // If canceled, set BExceptionC.CLIENT_DIED to asyncResult 
        if (canceled) {
          if (log.isDebugEnabled()) log.debug("canceled=" + canceled);
          terminateMessage(messageId, null);
          break;
        }
        
        // Find valid long-poll request object
        BAsyncResult<BMessage> asyncRequest = getNextLongpollRequestOrPushMessage(msg);
        
        // No long-poll found?
        if (asyncRequest == null) {
          
          // The message was pushed into pendingMessages_access_sync.
          // It will be sent in the next call to recvLongPoll. 
          break;
        }

        // Send the message
        try {
          
          if (log.isDebugEnabled()) log.debug("asyncResult.setAsyncResult");
          asyncRequest.setAsyncResult(msg, null);
          break;
          
         } catch (Throwable e) {
           
          if (e.toString().indexOf("ClientAbortException") >= 0) {
            terminateMessage(messageId, e);
            break;
          }
          else {
            // The underlying long-poll request has already timed out.
            // Maybe there is another connection available.
            // -> retry
          }
          
        }

      }
      
      if (retries < 0) {
        // More than 100 longpolls which are not usable.
        // Maybe the cleanup thread has died.
        BException ex = new BException(BExceptionC.TOO_MANY_REQUESTS, "Too many unusable long poll requests.");
        terminateMessage(messageId, ex);
      }

    } catch (Throwable e) {
      if (log.isWarnEnabled()) log.warn("Failed to send reverse message.", e);
      terminateMessage(messageId, e);
    }

    if (log.isDebugEnabled()) log.debug(")send");
  }
  
  protected BAsyncResult<BMessage> getNextLongpollRequestOrPushMessage(BMessage msg) {
    if (log.isDebugEnabled()) log.debug("getNextLongpollRequestOrPushMessage(" + msg);
    
    // Get next long-poll request from queue.
    AsyncRequestFromLongpoll longpollRequest = lonpollRequests.poll();
    if (log.isDebugEnabled()) log.debug("longpollRequest=" + longpollRequest);

    // long-poll active? ...
    if (longpollRequest != null) {
      if (log.isDebugEnabled()) log.debug(")getNextLongpollRequestOrPushMessage=" + longpollRequest.request);
      return longpollRequest.request;
    }
    
    // Push message into the queue of pending messages.
    // This message will be immediately sent at the next time recvLongPoll is called.
    if (log.isDebugEnabled()) log.debug("pendingMessages.offer");
    if (!pendingMessages.offer(new PendingMessage(msg))) {
      
      // --- never executed  {
      
      // Queue is full, terminate message with error.
      if (log.isDebugEnabled()) log.debug("Failed to add pending msg=" + msg);
      BException ex = new BException(BExceptionC.TOO_MANY_REQUESTS, "Failed to add pending message.");
      terminateMessage(msg.header.messageId, ex);
      
      
      // }  --- never executed

    }
    
    if (log.isDebugEnabled()) log.debug(")getNextLongpollRequestOrPushMessage=null");
    return null;
  }

  @Override
  public void putStreams(long trackingId, List<BContentStream> streams, BAsyncResult<BMessage> asyncResult) {
    wireServer.putStreams(trackingId, streams, asyncResult);
  };

  @Override
  public BContentStream getStream(long trackingId, BTargetId targetId) throws IOException {
    return wireServer.getStream(trackingId, targetId);
  }

  /**
   * Terminate the message to be sent to the client.
   * The caller receives a {@link BExceptionC#CLIENT_DIED}.
   * @param messageId
   * @param e Exception used for BException detail.
   */
  protected void terminateMessage(final long messageId, Throwable e) {
    if (log.isDebugEnabled()) log.debug("terminateMessage(" + messageId + ", ex=" + e);
    BException bex = null;
    
    // Get the asyncResult pushed from the send() method into the
    // asyncResults_access_sync map.
    BAsyncResult<BMessage> asyncResult = mapAsyncResults.remove(messageId);
    if (log.isDebugEnabled()) log.debug("asyncResult=" + asyncResult);
    if (asyncResult != null) {
  
      if (e instanceof BException) {
        bex = (BException)e;
      }
      else {
        // Find the innermost exception cause
        Throwable innerException = e;
        while (e != null) {
          innerException = e;
          e = e.getCause();
        }
      
        // Notify the caller of send() with an exception.
        bex = new BException(BExceptionC.CLIENT_DIED, "", innerException);
      }

      if (log.isDebugEnabled()) log.debug("asyncResult.setAsyncResult ex=" + bex);
      asyncResult.setAsyncResult(null, bex);
    }
    
    if (log.isDebugEnabled()) log.debug(")terminateMessage");
  }
  
  /**
   * This function releases expired long-polls and messages.
   * The client application receives a status code 204 for a long-poll. 
   */
  public void cleanup() {
    if (log.isDebugEnabled()) log.debug(this + ".cleanup(");
    
    ArrayList<AsyncRequestFromLongpoll> lpolls = removeExpiredLongpolls();
    if (log.isDebugEnabled()) log.debug("exprired lpolls=" + lpolls);
    
    ArrayList<PendingMessage> msgs = getExpiredMessages();
    if (log.isDebugEnabled()) log.debug("exprired messages=" + msgs);
    
    if (lpolls.size() != 0) {

      // The client should send a new long-poll.
      // HWriteResponseHelper will return HTTP status cod 204

      BException ex = new BException(BExceptionC.RESEND_LONG_POLL, "");
      for (AsyncRequestFromLongpoll lrequest : lpolls) {
        try {
          if (log.isDebugEnabled()) log.debug("lrequest.request.setAsyncResult ex=" + ex);
          lrequest.request.setAsyncResult(null, ex);
        }
        catch (Throwable e) {
          // catch "Response already written"
          if (log.isDebugEnabled()) log.debug("Failed to respond to longpoll=" + lrequest, e);
        }
      }
    }
    
    if (msgs.size() != 0) {
      
      BException ex = new BException(BExceptionC.TIMEOUT, "Timeout while waiting for reverse request.");
      for (PendingMessage msg : msgs) {
        try {
          terminateMessage(msg.msg.header.messageId, ex);
        }
        catch (Throwable e) {
          // just make sure that cleanup runs over all messages.
          if (log.isDebugEnabled()) log.debug("Failed to terminate pending message=" + msg, e);
        }
      }
    }

    if (log.isDebugEnabled()) log.debug(")cleanup");
  }
  
  /**
   * Remove expired long-poll requests from internal list.
   * @return Removed long-poll requests.
   */
  protected ArrayList<AsyncRequestFromLongpoll> removeExpiredLongpolls() {
    ArrayList<AsyncRequestFromLongpoll> ret = lonpollRequests.getAndRemoveExpired();
    return ret;
  }

  /**
   * Remove expired messages.
   * A message is terminated, if it has been waiting more than {@link HConstants#MAX_WAIT_FOR_LONGPOLL_MILLIS}
   * for a long-poll.
   */
  protected ArrayList<PendingMessage> getExpiredMessages() {
    ArrayList<PendingMessage> ret = pendingMessages.getAndRemoveExpired();
    return ret;
  }
  
  static class AsyncRequestFromLongpoll {
    final long bestBefore;
    //Date dt;
    final BAsyncResult<BMessage> request;
    final BMessageHeader header;
    
    AsyncRequestFromLongpoll(BAsyncResult<BMessage> request, BMessageHeader header) {
      this.request = request;
      this.header = header;
      long timeout = header.timeoutSeconds != 0 ? (header.timeoutSeconds*1000) : HConstants.TIMEOUT_LONGPOLL_MILLIS;
      this.bestBefore = System.currentTimeMillis() + timeout;
      //this.dt = new Date(bestBefore);
    }
    
    boolean isExpired() {
      return bestBefore < System.currentTimeMillis();
    }
    
    public String toString() {
      return "[" + header + ", expired=" + isExpired() + ", bestBefore=" + new Date(bestBefore) + "]";
    }
  }

  static class PendingMessage {
    long bestBefore;
    BMessage msg;
    
    PendingMessage(BMessage msg) {
      this.msg = msg;
      this.bestBefore = System.currentTimeMillis() + HConstants.MAX_WAIT_FOR_LONGPOLL_MILLIS;
    }
    
    boolean isExpired() {
      return bestBefore < System.currentTimeMillis();
    }

    public String toString() {
      return "[" + msg + ", expired=" + isExpired() + ", bestBefore=" + new Date(bestBefore) + "]";
    }
  }

  private final LongPollRequests lonpollRequests = new LongPollRequests();
  private final MapAsyncResults mapAsyncResults = new MapAsyncResults();
  private final PendingMessages pendingMessages = new PendingMessages();
  private final BWire wireServer;
  private final static Log log = LogFactory.getLog(HWireClientR.class);
  private volatile boolean canceled;

  private static class PendingMessages {
    private final ArrayList<PendingMessage> arr = new ArrayList<PendingMessage>();

    public synchronized PendingMessage poll() {
      PendingMessage ret = null;
      if (arr.size() != 0) {
        ret = arr.remove(0);
      }
      return ret;
    }

    public synchronized boolean offer(PendingMessage pendingMessage) {
      arr.add(pendingMessage);
      return true;
    }
    
    public synchronized ArrayList<PendingMessage> getAndRemoveExpired() {
      ArrayList<PendingMessage> ret = new ArrayList<PendingMessage>();

      boolean foundOne = true;
      while (foundOne) {
        foundOne = false;
        for (Iterator<PendingMessage> it = arr.iterator(); it.hasNext(); ) {
          PendingMessage pendingMessage = it.next();
          if (pendingMessage.isExpired()) {
            it.remove();
            ret.add(pendingMessage);
            foundOne = true;
            break;
          }
        }    
      }
      
      return ret;
    }
    
    public synchronized String toString() {
      return arr.toString();
    }
    
  }
  
  private static class MapAsyncResults {
    private final HashMap<Long, BAsyncResult<BMessage>> map = new HashMap<Long, BAsyncResult<BMessage>>();
    
    public synchronized ArrayList<BAsyncResult<BMessage>> getAndRemoveAll() {
      ArrayList<BAsyncResult<BMessage>> ret = new ArrayList<BAsyncResult<BMessage>>(map.values());
      map.clear();
      return ret;
    }

    public synchronized void put(long messageId, BAsyncResult<BMessage> asyncResult) {
      map.put(messageId, asyncResult);
    }

    public synchronized BAsyncResult<BMessage> remove(long messageId) {
      return map.remove(messageId);
    }
    
    public synchronized String toString() {
      return map.keySet().toString();
    }
  }
  
  private static class LongPollRequests {
    private final ArrayList<AsyncRequestFromLongpoll> arr = new ArrayList<AsyncRequestFromLongpoll>();
    
    public synchronized ArrayList<AsyncRequestFromLongpoll> getAndRemoveAll() {
      ArrayList<AsyncRequestFromLongpoll> ret = new ArrayList<AsyncRequestFromLongpoll>(arr);
      arr.clear();
      return ret;
    }

    public synchronized AsyncRequestFromLongpoll poll() {
      AsyncRequestFromLongpoll lrequest = null;
      if (arr.size() != 0) {
        lrequest = arr.remove(0);
      }
      return lrequest;
    }

    public synchronized int size() {
      return arr.size();
    }

    public synchronized void add(AsyncRequestFromLongpoll asyncRequestFromLongpoll) {
      arr.add(asyncRequestFromLongpoll);
    }
    
    public synchronized ArrayList<AsyncRequestFromLongpoll> getAndRemoveExpired() {
      ArrayList<AsyncRequestFromLongpoll> ret = new ArrayList<AsyncRequestFromLongpoll>();
      boolean found = true;
      while (found) {
        found = false;
        for (Iterator<AsyncRequestFromLongpoll> it = arr.iterator(); it.hasNext(); ) {
          AsyncRequestFromLongpoll lrequest = it.next();
          if (lrequest.isExpired()) {
            ret.add(lrequest);
            it.remove();
            found = true;
            break;
          }
        }
      }
      return ret;
    }
    
    public synchronized String toString() {
      return arr.toString();
    }

  }
}
