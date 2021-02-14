package byps.http;

import java.io.BufferedInputStream;
import java.io.File;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BAsyncResult;
import byps.BContentStream;
import byps.BContentStreamProperties;
import byps.BException;
import byps.BHashMap;
import byps.BMessage;
import byps.BMessageHeader;
import byps.BTargetId;
import byps.BWire;

public class HWireServer extends BWire {

  private final HWriteResponseHelper writeHelper;
  private final HActiveMessages activeMessages;
  private final BHashMap<Long, Long> activeMessageIds = new BHashMap<Long, Long>();
  private final HConfig hConfig;
  private final static Logger log = LoggerFactory.getLogger(HWireServer.class);
  
  public HWireServer(HConfig hConfig, HActiveMessages activeMessages, HWriteResponseHelper writeHelper) {
    super(FLAG_DEFAULT);
    this.hConfig = hConfig;
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
    
    // BYPS-12: cancel only messages running for this HWireServer. Before, with BYPS-9, 
    // all messages of all sessions were cancelled.
    
    ArrayList<Long> messageIds = new ArrayList<Long>(activeMessageIds.keys());
    for (Long messageId : messageIds) {
      cancelMessage(messageId);
    }
  }

  private class MyIncomingInputStream extends BWire.InputStreamWrapper {
    
    private AtomicBoolean hasProperties = new AtomicBoolean();

    public MyIncomingInputStream(BTargetId targetId) {
      super(targetId);
    }
    
    @Override
    public void ensureProperties() throws IOException {
      
      // BYPS-28: Get properties (contentLength, etc.) from inner stream.
      
      if (hasProperties.compareAndSet(false, true)) {
        BContentStream is = activeMessages.getIncomingStream(targetId);
        if (log.isDebugEnabled()) log.debug("stream for targetId={}, is={}", targetId, is);
        if (is == null) {
          throw new IOException("Timeout while waiting for stream");
        }
        this.copyProperties(is);
      }
    }
    
    @Override
    public BContentStreamProperties getProperties() {
      
      // BYPS-28: Ensure that properties (contentLength, etc.) are available.

      try {
        ensureProperties();
        return super.getProperties();
      }
      catch (IOException e) {
        throw new IllegalStateException(e);
      }
    }
    
    @Override
    protected InputStream openStream() throws IOException {
      if (log.isDebugEnabled()) log.debug("openStream(");

      InputStream ret = null;
      
      try {
        BContentStream is = activeMessages.getIncomingStream(targetId);
        if (log.isDebugEnabled()) log.debug("stream for targetId={}, is={}", targetId, is);
        if (is == null) {
          throw new IOException("Timeout while waiting for stream");
        }
        
        this.copyProperties(is);
        
        ret = is;
        if (!ret.markSupported()) {
          ret = new BufferedInputStream(ret);
        }

      }
      catch (InterruptedIOException e) {
        
        // An interrupt occurs, if the cancel message is sent by the client.
        // This message is sent, e.g. if the client runs in an error state 
        // while putting a stream. Then, the client sends a cancel message
        // that gives the server the chance to cleanup resources.
        
        throw e;
      }

      if (log.isDebugEnabled()) log.debug(")openStream=" + ret);
      return ret;
    }

    @Override
    public BContentStream materialize() throws IOException {
      if (log.isDebugEnabled()) log.debug("cloneInputStream(");
      InputStream stream = ensureStream();
      BContentStream ret = null;
      
      if (stream instanceof BContentStream) {
        ret = ((BContentStream)stream).materialize();
        ret.copyProperties(this);
      }
      else {
        File tempDir = hConfig.getTempDir();
        ret = new HIncomingStreamSync(this, 0, tempDir);
        ((HIncomingStreamSync)ret).assignStream(stream);
      }

      // Reset stream IDs. 
      // Otherwise the stream would not be sent, see BOutput.createStreamRequest.
      ret.setTargetId(BTargetId.ZERO);

      if (log.isDebugEnabled()) log.debug(")cloneInputStream=" + ret);
      return ret;
    }

  }

  public void cleanup() {
  }

  @Override
  public BContentStream getStream(long trackingId, BTargetId targetId) throws IOException {
    if (log.isDebugEnabled()) log.debug("getStream(" + targetId);
    MyIncomingInputStream is = new MyIncomingInputStream(targetId);
    if (log.isDebugEnabled()) log.debug(")getStream=" + is);
    return is;
  }

  @Override
  public void putStreams(long trackingId, List<BContentStream> streams, BAsyncResult<BMessage> asyncResult) {
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

    AsyncMessageResponse(BMessageHeader header) {
      this.header = header;
    }

    @Override
    public void setAsyncResult(BMessage msg, Throwable e) {
      if (log.isDebugEnabled()) log.debug("setAsyncResult(" + msg + ", e=" + e);

      try {
        ByteBuffer buf = null;
        if (msg != null) {
          long trackingId = msg.header.getTrackingId();
          putStreams(trackingId, msg.streams, null);
          buf = msg.buf;
        }
        writeResponse(header.messageId, buf, e);
      }
      catch (IOException ex) { 
        if (log.isDebugEnabled()) log.debug("Assume client has closed the connection.", ex);
        // Client has closed the connection, Tomcat: ClientAbortException
        // Need to re-throw in order to terminate the message in HWireClientR 
        // if a disconnected long-poll request is used.
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
    HRequestContext rctxt = activeMessages.getAndRemoveRequestContext(messageId, HRemoveMessageControl.FINISHED);
    if (log.isDebugEnabled()) log.debug("async context of messageId: " + rctxt);
    
    if (rctxt == null) {
      // An async request could be already completed if a timeout has occurred
      // or if the message has been cancelled.
      if (log.isDebugEnabled()) log.debug("No async context for messageId=" + messageId + ", message already written or an exception occured while it was beeing written before.");
      throw new IOException("Response already written.");
    }
    else {
      writeHelper.writeResponse(obuf, e, rctxt);
      rctxt.complete();
    }
    
    if (log.isDebugEnabled()) log.debug(")writeResponse");
  }

  public BAsyncResult<BMessage> addMessage(final BMessageHeader header, HRequestContext rctxt, Thread workerThread) {
    if (log.isDebugEnabled()) log.debug("addMessage(" + rctxt + ", messageId=" + header.messageId);

    BAsyncResult<BMessage> asyncResponse = null;
    
    try {
      activeMessages.addMessage(header, rctxt, workerThread);
      activeMessageIds.put(header.messageId, header.messageId);
      
      boolean pollProcessing = (header.flags & BMessageHeader.FLAG_POLL_PROCESSING) != 0;
      if (!pollProcessing) {
        asyncResponse = new AsyncMessageResponse(header);
      }
      
    }
    catch (BException e) {
      try {
        writeHelper.writeResponse(null, e, rctxt);
      }
      catch (IOException e1) {
        if (log.isWarnEnabled()) log.warn("Failed to write error response.", e1);
      }
      rctxt.complete();
    }

    if (log.isDebugEnabled()) log.debug(")addMessage=" + header.messageId);
    return asyncResponse;
  }
  
  @Override
  public void send(BMessage msg, BAsyncResult<BMessage> asyncResult) {
    throw new IllegalStateException("BWireServer.send must not be called");
  }

}
