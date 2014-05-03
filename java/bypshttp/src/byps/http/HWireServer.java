package byps.http;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BAsyncResult;
import byps.BContentStream;
import byps.BException;
import byps.BMessage;
import byps.BMessageHeader;
import byps.BWire;

public class HWireServer extends BWire {

  private final HWriteResponseHelper writeHelper;
  private final HActiveMessages activeMessages;
  private final ConcurrentHashMap<Long, Long> activeMessageIds = new ConcurrentHashMap<Long, Long>();
  private final Log log = LogFactory.getLog(HWireServer.class);

  public HWireServer(HActiveMessages activeMessages, HWriteResponseHelper writeHelper) {
    super(FLAG_DEFAULT);
    this.writeHelper = writeHelper;
    this.activeMessages = activeMessages;
  }

  public void done() {
    if (log.isDebugEnabled()) log.debug("done(");
    cancelAllMessages();
    if (log.isDebugEnabled()) log.debug(")done");
  }
  
  public void cancelMessage(long messageId) {
    activeMessages.cancelMessage(messageId);
    activeMessageIds.remove(messageId);
  }

  public void cancelAllMessages() {
    ArrayList<Long> messageIds = new ArrayList<Long>(activeMessageIds.keySet());
    for (Long messageId : messageIds) {
      cancelMessage(messageId);
    }
  }


  private class MyIncomingInputStream extends BWire.InputStreamWrapper {

    public MyIncomingInputStream(int serverId, long messageId, long streamId) {
      super(serverId, messageId, streamId);
    }

    @Override
    protected InputStream openStream() throws IOException {
      if (log.isDebugEnabled()) log.debug("openStream(");

      BContentStream is = null;
      try {
        is = activeMessages.getIncomingStream(messageId, streamId);
        if (log.isDebugEnabled()) log.debug("stream for messageId=" + messageId + ", streamId=" + streamId + ", is=" + is);

        if (is == null) {
          throw new IOException("Timeout while waiting for stream");
        }
        
        this.copyProperies(is);
      }
      catch (InterruptedIOException e) {
        
        // An interrupt occurs, if the cancel message is sent by the client.
        // This message is sent, e.g. if the client runs in an error state 
        // while putting a stream. Then, the client sends a cancel message
        // that gives the server the chance to cleanup resources.
        
        throw e;
      }

      if (log.isDebugEnabled()) log.debug(")openStream=" + is);
      return is;
    }

    @Override
    public BContentStream materialize() throws IOException {
      if (log.isDebugEnabled()) log.debug("cloneInputStream(");
      final BContentStream src = (BContentStream) ensureStream();
      final BContentStream ret = src.materialize();
      if (log.isDebugEnabled()) log.debug(")cloneInputStream=" + ret);
      return ret;
    }

  }

  public void cleanup() {
    if (log.isDebugEnabled()) log.debug("cleanup(");
    activeMessages.cleanup(false);
    if (log.isDebugEnabled()) log.debug(")cleanup");
  }

  @Override
  public BContentStream getStream(int serverId, long messageId, long streamId) throws IOException {
    if (log.isDebugEnabled()) log.debug("getStream(messageId=" + messageId + ", streamId=" + streamId);
    MyIncomingInputStream is = new MyIncomingInputStream(serverId, messageId, streamId);
    if (log.isDebugEnabled()) log.debug(")getStream=" + is);
    return is;
  }

  @Override
  public void putStreams(List<BContentStream> streams, BAsyncResult<BMessage> asyncResult) {
    if (log.isDebugEnabled()) log.debug("putStreams(");
    try {
      activeMessages.addOutgoingStreams(streams);
    }
    catch (BException e) {
      // An exception is thrown, if the message has been canceled.
      if (log.isDebugEnabled()) log.debug("Exception: " + e);
    }
    if (log.isDebugEnabled()) log.debug(")putStreams");
  }

  private class AsyncMessageResponse implements BAsyncResult<BMessage> {

    final BMessageHeader header;
    private final Log log = LogFactory.getLog("AsyncMessageResponse");

    AsyncMessageResponse(BMessageHeader header) {
      this.header = header;
    }

    @Override
    public void setAsyncResult(BMessage msg, Throwable e) {
      if (log.isDebugEnabled()) log.debug("setAsyncResult(" + msg + ", e=" + e);

      try {
        ByteBuffer buf = null;
        if (msg != null) {
          putStreams(msg.streams, null);
          buf = msg.buf;
        }
        writeResponse(header.messageId, buf, e);
      }
      catch (IOException ex) { // Tomcat: Client abort Exception
        if (log.isDebugEnabled()) log.debug("ClientAbortException");
        // Client has closed the connection.
        throw new IllegalStateException(ex);
      }
      catch (Throwable ex) {
        // Seen under high load:
        //   called from HWireClientR.cancelAllRequests:
        //     java.lang.IllegalStateException: Calling [asyncComplete()] is not valid for a request with Async state [DISPATCHED]
        //     java.lang.IllegalStateException: The request associated with the AsyncContext has already completed processing.
        //   called from HWireClientR.cleanup
        //     java.lang.IllegalStateException: The request associated with the AsyncContext has already completed processing.
        if (log.isDebugEnabled()) log.debug("Failed to write response.", ex);
        throw new IllegalStateException(ex);
      }
      finally {
        // Close all incoming streams of this message.
        // This is especially important if the server-side has not completely 
        // read all incoming streams. Since the client waits until all requests
        // of a message are returned, all incoming streams must be closed and 
        // the associated requests must return.
        activeMessages.closeMessageIncomingStreams(header.messageId);
      }
      if (log.isDebugEnabled()) log.debug(")setAsyncResult");
    }

    @Override
    public String toString() {
      return "[" + header.messageId + "]";
    }
  };

  private void writeResponse(Long messageId, ByteBuffer obuf, Throwable e) throws IOException {
    if (log.isDebugEnabled()) {
      log.debug("writeResponse(messageId=" + messageId + ", obuf=" + obuf + ", exception=" + e);
    }
    
    activeMessageIds.remove(messageId);
    HRequestContext rctxt = activeMessages.getAndRemoveRequestContext(messageId);
    if (log.isDebugEnabled()) log.debug("async context of messageId: " + rctxt);
    if (rctxt == null) {
      // An async request could be already completed if a timeout has occurred. 
      if (log.isDebugEnabled()) log.debug("No async context for messageId=" + messageId + ", message already written or an exception occured while it was beeing written before.");
      throw new IOException("Response already written.");
    }
    else {
      writeHelper.writeResponse(obuf, e, (HttpServletResponse) rctxt.getResponse(), rctxt.isAsync());
      rctxt.complete();
    }
    if (log.isDebugEnabled()) log.debug(")writeResponse");
  }

  public BAsyncResult<BMessage> addMessage(final BMessageHeader header, HRequestContext rctxt, Thread workerThread) {
    if (log.isDebugEnabled()) log.debug("addMessage(" + rctxt + ", messageId=" + header.messageId);

    BAsyncResult<BMessage> asyncResponse = new AsyncMessageResponse(header);
    try {
      activeMessages.addMessage(header, rctxt, workerThread);
      activeMessageIds.put(header.messageId, header.messageId);
    }
    catch (BException e) {
      try {
        writeHelper.writeResponse(null, e, (HttpServletResponse) rctxt.getResponse(), true);
      }
      catch (IOException e1) {
        if (log.isWarnEnabled()) log.warn("Failed to write error response.", e1);
      }
      rctxt.complete();
      asyncResponse = null;
    }

    if (log.isDebugEnabled()) log.debug(")addMessage=" + header.messageId);
    return asyncResponse;
  }
  
  @Override
  public void send(BMessage msg, BAsyncResult<BMessage> asyncResult) {
    throw new IllegalStateException("BWireServer.send must not be called");
  }

}
