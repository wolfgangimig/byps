package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.AsyncEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BContentStream;
import byps.BException;
import byps.BExceptionC;
import byps.BTargetId;

public class HActiveMessage {
  private final Log log = LogFactory.getLog(HActiveMessage.class);
  public final Long messageId;
  private long bestBefore;
  private HRequestContext rctxtMessage;
  private HashMap<Long, BContentStream> incomingStreams;
  private HashMap<Long, BContentStream> outgoingStreams;
  private Thread workerThread;
  private boolean canceled;
  private final File tempDir;

  HActiveMessage(Long messageId, File tempDir) {
    this.messageId = messageId;
    this.tempDir = tempDir;
  }

  public synchronized boolean isCanceled() {
    return canceled;
  }

  public synchronized boolean isExpired() {
    return isFinished() && System.currentTimeMillis() > bestBefore;
  }

  public synchronized boolean isLongPoll() {
    return this.workerThread == null;
  }

  public synchronized void setRequestContext(HRequestContext rctxt, Thread workerThread) {
    this.rctxtMessage = rctxt;
    this.workerThread = workerThread;
    if (log.isDebugEnabled()) log.debug("assigned rctxt=" + rctxt + ", workerThread=" + workerThread);
  }

  private synchronized boolean isFinished() {
//    if (log.isDebugEnabled()) log.debug("isFinished(" + messageId);
//    if (log.isDebugEnabled()) {
//      log.debug("longPoll=" + isLongPoll());
//      log.debug("rctxtMessage=" + rctxtMessage);
//      log.debug("workerThread=" + workerThread);
//      log.debug("incomingStreams=" + incomingStreams);
//      log.debug("outgoingStreams=" + outgoingStreams);
//    }
    boolean finished = rctxtMessage == null && workerThread == null && (incomingStreams == null || incomingStreams.size() == 0) && (outgoingStreams == null || outgoingStreams.size() == 0);

//    if (log.isDebugEnabled()) log.debug(")isFinished=" + finished);
    return finished;
  }

  private synchronized void checkFinished() {
    //if (log.isDebugEnabled()) log.debug("checkFinished(");

    cleanupIncomingStreams(canceled);
    cleanupOutgoingStreams(canceled);

    if (isFinished()) {
      // If message was not finished before this call,
      // then bestBefore == 0. Set bestBefore to the time
      // when the message does expire.
      if (bestBefore == 0) {
        bestBefore = System.currentTimeMillis() + HConstants.KEEP_MESSAGE_AFTER_FINISHED;
      }
    }
    else {
      // The message is not finished.
      // Make sure that bestBefore == 0 so that the message lifetime
      // is re-initialized when it goes to finished state.
      bestBefore = 0;
    }
    //if (log.isDebugEnabled()) log.debug(")checkFinished");
  }

  public synchronized void cleanupIncomingStreams(boolean all) {
    //if (log.isDebugEnabled()) log.debug("cleanupIncomingStreams(" + messageId + ", all=" + all);
    if (incomingStreams != null) {
      ArrayList<BContentStream> allStreams = new ArrayList<BContentStream>(incomingStreams.values());
      for (BContentStream istrm : allStreams) {
        if (all || istrm.isExpired()) {
          try {
            istrm.close();
          } catch (Throwable e) {
          }
        }
      }
    }
    //if (log.isDebugEnabled()) log.debug(")cleanupIncomingStreams");
  }

  private synchronized void cleanupOutgoingStreams(boolean all) {
    //if (log.isDebugEnabled()) log.debug("cleanupOutgoingStreams(" + messageId + ", all=" + all);
    if (outgoingStreams != null) {
      ArrayList<BContentStream> allStreams = new ArrayList<BContentStream>(outgoingStreams.values());
      for (BContentStream istrm : allStreams) {
        if (all || istrm.isExpired()) {
          try {
            istrm.close();
          } catch (Throwable e) {
          }
        }
      }
    }
    //if (log.isDebugEnabled()) log.debug(")cleanupOutgoingStreams");
  }

  public synchronized void addOutgoingStreams(List<BContentStream> streamRequests) throws BException {
    if (log.isDebugEnabled()) log.debug("addOutgoingStreams(");

    final HActiveMessage msg = this;

    if (outgoingStreams == null) {
      outgoingStreams = new HashMap<Long, BContentStream>();
    }

    for (BContentStream streamRequest : streamRequests) {
      if (log.isDebugEnabled()) log.debug("put outgoing stream=" + streamRequest);
      HOutgoingStream ish = new HOutgoingStream(streamRequest, HConstants.REQUEST_TIMEOUT_MILLIS, tempDir) {
        @Override
        public void close() throws IOException {
          if (log.isDebugEnabled()) log.debug("close outgoing stream " + targetId + "(");
          synchronized (msg) {
            if (log.isDebugEnabled()) log.debug("remove outgoing stream, streamId=" + targetId);
            if (outgoingStreams.remove(targetId.getStreamId()) != null) {
              checkFinished();
            }
          }
          super.close();
          if (log.isDebugEnabled()) log.debug(")close");
        }
      };
      outgoingStreams.put(streamRequest.getTargetId().getStreamId(), ish);
    }

    if (log.isDebugEnabled()) log.debug(")addOutgoingStreams");
  }

  public void addIncomingStream(final BTargetId targetId, final HRequestContext rctxt) throws BException {
    if (rctxt.isAsync()) {
      addIncomingStreamAsync(targetId, rctxt);
    }
    else {
      addIncomingStreamSync(targetId, rctxt);
    }
  }

  private synchronized void addIncomingStreamAsync(final BTargetId targetId, HRequestContext rctxt) throws BException {
    if (log.isDebugEnabled()) log.debug("addIncomingStreamAsync(targetId=" + targetId + ", rctxt=" + rctxt);

    try {
      final HActiveMessage msg = this;
      final HttpServletRequest request = (HttpServletRequest) (rctxt.getRequest());
      final String contentType = request.getContentType();
      final String contentDisposition = request.getHeader("Content-Disposition");
      final String contentLengthStr = request.getHeader("Content-Length");
      final long contentLength = contentLengthStr != null && contentLengthStr.length() != 0 ? Long.parseLong(contentLengthStr) : -1L;
      final String totalLengthStr = request.getParameter("total");
      final long totalLength = totalLengthStr != null && totalLengthStr.length() != 0 ? Long.parseLong(totalLengthStr) : -1L;
      final String partIdStr = request.getParameter("partid");
      final long partId = partIdStr != null && partIdStr.length() != 0 ? Long.parseLong(partIdStr) : -1L;
      final String lastPartStr = request.getParameter("last");
      final boolean isLastPart = lastPartStr != null && lastPartStr.length() != 0 ? (Integer.valueOf(lastPartStr) != 0) : true;

      HAsyncErrorListener alsn = new HAsyncErrorListener() {
        @Override
        public void onError(AsyncEvent arg0) throws IOException {
          if (log.isDebugEnabled()) log.debug("AsyncErrorListener.onError(" + arg0 + ")");
          InputStream is = null;
          synchronized (msg) {
            is = incomingStreams.remove(targetId.getStreamId());
          }
          if (is != null) is.close();
        }
      };
      rctxt.addListener(alsn);

      if (incomingStreams == null) {
        incomingStreams = new HashMap<Long, BContentStream>();
      }

      BContentStream istrm = null;

      // Is splitted stream?
      if (partId != -1L) {

        istrm = incomingStreams.get(targetId.getStreamId());

        if (istrm == null) {

          istrm = new HIncomingSplittedStreamAsync(targetId, contentType, totalLength, contentDisposition, HConstants.REQUEST_TIMEOUT_MILLIS, tempDir) {
            private Log log = LogFactory.getLog(HIncomingSplittedStreamAsync.class);

            public void close() throws IOException {
              if (log.isDebugEnabled()) log.debug("close incoming stream " + targetId + "(");

              synchronized (msg) {
                if (log.isDebugEnabled()) log.debug("remove incoming stream, targetId=" + targetId);
                if (incomingStreams.remove(targetId.getStreamId()) != null) {
                  checkFinished();
                }
              }

              super.close();

              if (log.isDebugEnabled()) log.debug(")close");
            }
          };

          incomingStreams.put(targetId.getStreamId(), istrm);
          
        }

        ((HIncomingSplittedStreamAsync) istrm).addStream(partId, contentLength, isLastPart, rctxt);

      }
      else {

        istrm = new HIncomingStreamAsync(targetId, contentType, contentLength, contentDisposition, HConstants.REQUEST_TIMEOUT_MILLIS, tempDir, rctxt) {
          private Log log = LogFactory.getLog(HIncomingStreamAsync.class);

          public void close() throws IOException {
            if (log.isDebugEnabled()) log.debug("close incoming stream " + targetId + "(");

            synchronized (msg) {
              if (log.isDebugEnabled()) log.debug("remove incoming stream, streamId=" + targetId);
              if (incomingStreams.remove(targetId.getStreamId()) != null) {
                checkFinished();
              }
              msg.notifyAll();
            }

            super.close();

            if (log.isDebugEnabled()) log.debug(")close");
          }
        };
        
        incomingStreams.put(targetId.getStreamId(), istrm);
        
      }

      notifyAll();

    } catch (Throwable e) {
      throw new BException(BExceptionC.IOERROR, "Failed to add incoming stream", e);
    }

    if (log.isDebugEnabled()) log.debug(")addIncomingStreamAsync");
  }

  private void addIncomingStreamSync(final BTargetId targetId, final HRequestContext rctxt) throws BException {
    if (log.isDebugEnabled()) log.debug("addIncomingStreamSync(" + targetId);
    
    // Create or get HIncomingStream object in synchronized function.
    final HttpServletRequest request = (HttpServletRequest) (rctxt.getRequest());
    final HIncomingStreamSync istrm = addIncomingStreamSync2(targetId, request);
    
    final String partIdStr = request.getParameter("partid");
    final long partId = partIdStr != null && partIdStr.length() != 0 ? Long.parseLong(partIdStr) : 0;
    final String lastPartStr = request.getParameter("last");
    final boolean lastPart = lastPartStr == null || lastPartStr.length() == 0 || Integer.parseInt(lastPartStr) == 1;

    // Copy the stream into the buffer.
    // This is done synchronously.
    if (log.isDebugEnabled()) log.debug("start copying stream, targetId=" + targetId + ", partId=" + partId);
    istrm.addStream(rctxt, partId, lastPart);
    if (log.isDebugEnabled()) log.debug("end copying stream, targetId=" + targetId + ", partId=" + partId);
    
    if (log.isDebugEnabled()) log.debug(")addIncomingStreamSync");
  }
  
  private synchronized HIncomingStreamSync addIncomingStreamSync2(final BTargetId targetId, HttpServletRequest request) throws BException {
    if (log.isDebugEnabled()) log.debug("addIncomingStreamSync2(" + targetId);
    
    HIncomingStreamSync istrm = null;
    
    try {
      final HActiveMessage msg = this;
      final String contentType = request.getContentType();
      final String contentDisposition = request.getHeader("Content-Disposition");
      final String contentLengthStr = request.getHeader("Content-Length");
      final long contentLength = contentLengthStr != null && contentLengthStr.length() != 0 ? Long.parseLong(contentLengthStr) : -1L;
      final String totalLengthStr = request.getParameter("total");
      final long totalLength = totalLengthStr != null && totalLengthStr.length() != 0 ? Long.parseLong(totalLengthStr) : -1L;

      if (log.isDebugEnabled()) {
        log.debug("contentType=" + contentType + ", contentLength=" + contentLengthStr + ", totalLength=" + totalLength);
      }
      
      istrm = incomingStreams != null ? (HIncomingStreamSync) incomingStreams.get(targetId.getStreamId()) : null;

      if (istrm == null) {

        if (log.isDebugEnabled()) log.debug("create HInputStreamBuffer");
        long length = totalLength >= 0 ? totalLength : contentLength;
        istrm = new HIncomingStreamSync(targetId, contentType, length, contentDisposition, HConstants.REQUEST_TIMEOUT_MILLIS, tempDir) {

          @Override
          public void close() throws IOException {
            if (log.isDebugEnabled()) log.debug("close " + targetId + "(");

            synchronized (msg) {
              if (log.isDebugEnabled()) log.debug("remove incoming stream, streamId=" + targetId);
              if (incomingStreams.remove(targetId.getStreamId()) != null) {
                checkFinished();
              }
            }

            super.close();
            if (log.isDebugEnabled()) log.debug(")close");
          }
        };

        // synchronized (this) -- not needed: method is synchronized
        {
          if (log.isDebugEnabled()) log.debug("put incoming stream into map, targetId=" + targetId);
          if (incomingStreams == null) {
            incomingStreams = new HashMap<Long, BContentStream>();
          }
          incomingStreams.put(targetId.getStreamId(), istrm);
        }
      }

      // Notify threads waiting to read this stream
      notifyAll();

    } catch (Throwable e) {
      throw new BException(BExceptionC.IOERROR, "Failed to add incoming stream", e);
    }

    if (log.isDebugEnabled()) log.debug(")addIncomingStreamSync2=" + istrm);
    return istrm;
  }

  public synchronized BContentStream getIncomingOrOutgoingStream(Long streamId) throws IOException, BException {
    if (log.isDebugEnabled()) log.debug("getIncomingStream(streamId=" + streamId);
    long t1 = System.currentTimeMillis();
    BContentStream stream = null;
    long timeoutMillis = HConstants.REQUEST_TIMEOUT_MILLIS;

    while (timeoutMillis > 0) {

      if (canceled) {
        if (log.isDebugEnabled()) log.debug("Message has been canceled.");
        throw new BException(BExceptionC.CANCELLED, "Message canceled");
      }

      stream = incomingStreams != null ? incomingStreams.get(streamId) : null;
      if (stream != null) break;

      stream = outgoingStreams != null ? outgoingStreams.get(streamId) : null;
      if (stream != null) break;

      // Wait until the requested stream is received
      long t2 = System.currentTimeMillis();
      timeoutMillis = timeoutMillis - (t2 - t1);
      if (timeoutMillis <= 0) {
        if (log.isDebugEnabled()) log.debug("Timeout");
        throw new BException(BExceptionC.TIMEOUT, "Timeout while waiting for streamId=" + streamId);
      }

      // Wait not more than 10s to make sure,
      // that we never will hang here because of a lost notify().
      long to = Math.min(timeoutMillis, 10 * 1000);
      if (log.isDebugEnabled()) log.debug("wait for stream, timeout=" + to);
      try {
        wait(to);
      } catch (InterruptedException e) {
        throw new InterruptedIOException("Wait for stream=" + streamId + " interrupted.");
      }
    }

    if (log.isDebugEnabled()) log.debug(")getIncomingStream=" + stream);
    return stream;
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

    cleanupIncomingStreams(true);
    cleanupOutgoingStreams(true);

    checkFinished();

    if (log.isDebugEnabled()) log.debug(")cancelMessage");
  }

  public synchronized boolean cleanup(boolean all) {
    //if (log.isDebugEnabled()) log.debug("cleanup(messageId=" + messageId + ", all=" + all);
    if (all) {
      cancelMessage();
    }
    else {
      //if (log.isDebugEnabled()) log.debug("cleanup expired members");
      cleanupIncomingStreams(false);
      cleanupOutgoingStreams(false);
      checkFinished();
    }

    boolean exp = isExpired();
    //if (log.isDebugEnabled()) log.debug(")cleanup=" + exp);
    return exp;
  }

  @Override
  public String toString() {
    return "[" + messageId + "," + canceled + "," + workerThread + "," + new Date(bestBefore) + "]";
  }

}
