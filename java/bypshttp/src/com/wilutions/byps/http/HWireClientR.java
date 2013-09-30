package com.wilutions.byps.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BAsyncResult;
import com.wilutions.byps.BContentStream;
import com.wilutions.byps.BException;
import com.wilutions.byps.BExceptionC;
import com.wilutions.byps.BMessage;
import com.wilutions.byps.BStreamRequest;
import com.wilutions.byps.BSyncResult;
import com.wilutions.byps.BWire;

public class HWireClientR extends BWire {

  private final ArrayList<BAsyncResult<BMessage>> asyncRequests_access_sync = new ArrayList<BAsyncResult<BMessage>>();
  private final HashMap<Long, BAsyncResult<BMessage>> asyncResults_access_sync = new HashMap<Long, BAsyncResult<BMessage>>();
  private final ArrayList<BMessage> pendingMessages_access_sync = new ArrayList<BMessage>();
  private final BWire wireServer;
  private final Log log = LogFactory.getLog(HWireClientR.class);
  private final boolean processAsync = HConstants.PROCESS_LONGPOLL_ASYNC;
  private boolean canceled;

  public HWireClientR(BWire wireServer) {
    super(wireServer.getFlags());
    this.wireServer = wireServer;
  }

  @Override
  public synchronized void cancelAllRequests() {
    if (log.isDebugEnabled()) log.debug("cancelAllRequests(");

    canceled = true;

    BException bex = new BException(BExceptionC.CANCELLED, "Longpoll canceled");

    // Notify the threads inside the server waiting for results that the
    // their calls are canceled.
    for (BAsyncResult<BMessage> asyncResult : asyncResults_access_sync.values()) {
      // Gib iBuf an den Thread weiter, der auf das Resultat wartet.
      synchronized (asyncResult) {
        if (log.isDebugEnabled()) log.debug("pass cancel message to asyncResult, notify thread waiting in send()");
        asyncResult.setAsyncResult(null, bex);
        asyncResult.notifyAll();
      }
    }

    // Notify the client that the long-poll has finished.
    for (BAsyncResult<BMessage> asyncRequest : asyncRequests_access_sync) {
      try {
        asyncRequest.setAsyncResult(null, bex);
      } catch (Throwable ignored) {
        // happens, if the HTTP session has already been invalidated
      }
    }

    if (log.isDebugEnabled()) log.debug(")cancelAllRequests");
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
  public void recvLongPoll(BMessage ibuf, final BAsyncResult<BMessage> asyncRequest) throws IOException {
    if (log.isDebugEnabled()) log.debug("recvLongPoll(messageId=" + ibuf.header.messageId);

    if (log.isDebugEnabled()) log.debug("message buffer=" + ibuf);

    final BAsyncResult<BMessage> nextRequest = processAsync ? asyncRequest : new BSyncResult<BMessage>();
    boolean waitForSend = true;

    synchronized (this) {

      // Liegt das Resultat der vorigen Anfrage vor?
      // (bzw. ein Resultat einer vorigen Anfrage - falls mehrere Longpools
      // aktiv sind)
      BAsyncResult<BMessage> asyncResult = asyncResults_access_sync.remove(ibuf.header.messageId);
      if (log.isDebugEnabled()) log.debug("asyncResult for messageId: " + asyncResult);

      if (asyncResult != null) {

        // Gib iBuf an den Thread weiter, der auf das Resultat wartet.
        if (log.isDebugEnabled()) log.debug("pass message buffer to asyncResult, notify thread waiting in send()");
        asyncResult.setAsyncResult(ibuf, null);

      }
      else {
        // asyncResult == null für ersten Longpoll-Aufruf des Clients
      }

      // Wenn während send() ausgeführt wird kein Longpoll aktiv ist, dann
      // speichert es die Nachricht in pendingMessages_access_sync.
      if (pendingMessages_access_sync.size() != 0) {

        // Sende die wartende Nachricht
        BMessage msg = pendingMessages_access_sync.remove(0);
        internalSend(msg.header.messageId, msg, nextRequest);
        waitForSend = false;
      }
      else {
        // In den Parameter asyncRequest wird die nächte Anfrage an den Client
        // gespeichert. Halte ihn solange in der map fest, bis er in send()
        // benötigt wird.
        asyncRequests_access_sync.add(nextRequest);
        if (log.isDebugEnabled()) log.debug("add longpoll to list, #polls=" + asyncRequests_access_sync.size());
        this.notifyAll(); // notify send()
        waitForSend = true;
      }
    }

    if (!processAsync) {
      if (waitForSend) {
        if (log.isDebugEnabled()) log.debug("wait for next request to client");
        BSyncResult<BMessage> syncRequest = (BSyncResult<BMessage>) nextRequest;
        try {
          // (1) Wait until send() sends a request, see (2)
          BMessage msg = syncRequest.getResult();
          if (log.isDebugEnabled()) log.debug("got request=" + msg);
          asyncRequest.setAsyncResult(msg, null);
        } catch (Throwable e) {
          if (log.isDebugEnabled()) log.debug("request is exception response to client", e);
          asyncRequest.setAsyncResult(null, e);
        }
      }
    }

    if (log.isDebugEnabled()) log.debug(")recvLongPoll");
  }

  @Override
  public void send(BMessage msg, BAsyncResult<BMessage> asyncResult) {
    if (log.isDebugEnabled()) log.debug("send(" + msg + ", asyncResult=" + asyncResult);

    try {
      BAsyncResult<BMessage> asyncRequest = null;

      final BAsyncResult<BMessage> nextResult = processAsync ? asyncResult : new BSyncResult<BMessage>();
      final long messageId = msg.header.messageId;

      synchronized (this) {

        if (log.isDebugEnabled()) log.debug("canceled=" + canceled);
        if (canceled) {
          asyncResult.setAsyncResult(null, new BException(BExceptionC.CLIENT_DIED, "Client is dead."));
        }
        else {
          // Ergebnisobjekt für nächsten Longpoll merken
          if (log.isDebugEnabled()) log.debug("map messageId=" + messageId + " to nextResult=" + nextResult);
          asyncResults_access_sync.put(messageId, nextResult);

          if (asyncRequests_access_sync.size() != 0) {
            asyncRequest = asyncRequests_access_sync.remove(0);
            if (log.isDebugEnabled()) log.debug("send asyncRequest=" + asyncRequest);
          }
          else {
            pendingMessages_access_sync.add(msg);
          }
        }
      }

      if (asyncRequest != null) {

        // Send the message
        internalSend(messageId, msg, asyncRequest);

        if (!processAsync) {
          // Wait until a recvLongPoll() received the result
          BSyncResult<BMessage> syncResult = (BSyncResult<BMessage>) nextResult;
          try {
            BMessage rmsg = syncResult.getResult(HConstants.MAX_WAIT_FOR_LONGPOLL_MILLIS);
            asyncResult.setAsyncResult(rmsg, null);
          } catch (Throwable e) {
            asyncResults_access_sync.remove(messageId);
            asyncResult.setAsyncResult(null, e);
          }
        }
      }

    } catch (Throwable e) {
      if (log.isWarnEnabled()) log.warn("Failed to send reverse message.", e);
      asyncResult.setAsyncResult(null, e);
    }

    if (log.isDebugEnabled()) log.debug(")send");
  }

  @Override
  public void putStreams(List<BStreamRequest> streamRequests, BAsyncResult<BMessage> asyncResult) {
    wireServer.putStreams(streamRequests, asyncResult);
  };

  @Override
  public BContentStream getStream(long messageId, long strmId) throws IOException {
    return wireServer.getStream(messageId, strmId);
  }

  private void internalSend(final long messageId, BMessage msg, final BAsyncResult<BMessage> asyncRequest) throws IOException {

    if (log.isDebugEnabled()) log.debug("internalSend(" + messageId + ", msg=" + msg + ", asyncRequest=" + asyncRequest);

    // asyncRequest encapsulates the HttpServletResponse.
    // If an exception is thrown while writing the ByteBuffer into the
    // HttpServletResponse,
    // we assume that the client has closed the connection.
    // In this case, the caller of send() is informed by a call to
    // asyncResult.setException

    BAsyncResult<BMessage> wrapResultCatchSocketClosed = new BAsyncResult<BMessage>() {
      @Override
      public void setAsyncResult(BMessage obj, Throwable e) {
        if (log.isDebugEnabled()) log.debug("setAsyncResult - wrapped(" + obj + ", e=" + e);

        if (e == null) {
          // (2) Request to be sent is passed to the recvLongPoll function call.
          // This call waits at (1).
          try {
            asyncRequest.setAsyncResult(obj, null);
          } catch (Throwable ex) {
            e = ex;
          }
        }

        if (e != null) {

          // Get the asyncResult pushed from the send() method into the
          // asyncResults_access_sync map.
          BAsyncResult<BMessage> asyncResult = null;
          synchronized (HWireClientR.this) {
            asyncResult = asyncResults_access_sync.remove(messageId);
          }

          // Find the innermost exception cause
          Throwable innerException = e;
          while (e != null) {
            innerException = e;
            e = e.getCause();
          }

          // Notify the caller of send() with an exception.
          BException bex = new BException(BExceptionC.CLIENT_DIED, "", innerException);
          asyncResult.setAsyncResult(null, bex);

        }
        if (log.isDebugEnabled()) log.debug(")setAsyncResult - wrapped");
      }
    };

    // Send ByteBuffer
    if (log.isDebugEnabled()) log.debug("setAsyncResult" + msg);
    wrapResultCatchSocketClosed.setAsyncResult(msg, null);

    if (log.isDebugEnabled()) log.debug(")internalSend");
  }
}
