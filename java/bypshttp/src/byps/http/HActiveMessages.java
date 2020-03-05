package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.servlet.AsyncEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BContentStream;
import byps.BContentStreamWrapper;
import byps.BException;
import byps.BExceptionC;
import byps.BHashMap;
import byps.BMessageHeader;
import byps.BTargetId;

public class HActiveMessages {
	
  /**
   * Messages currently in process.
   * Includes the long-polls.
   */
  private final BHashMap<Long, HActiveMessage> activeMessages = new BHashMap<Long,HActiveMessage>();
  
	/**
	 * Streams posted by HTML file upload.
	 * Streams uploaded by HTML are received independent from a message. 
	 */
	private final BHashMap<Long, BContentStream> incomingStreams = new BHashMap<Long, BContentStream>();
	private final BHashMap<Long, BContentStream> outgoingStreams = new BHashMap<Long, BContentStream>();
	
	private final static Logger log = LoggerFactory.getLogger(HActiveMessages.class);
	private final File tempDir;
	
	public HActiveMessages(File tempDir) {
	  this.tempDir = tempDir;
	}
	
	public void done() {
		if (log.isDebugEnabled()) log.debug("done(");
		cleanup(true);
		if (log.isDebugEnabled()) log.debug(")done");
	}
	
	private HActiveMessage getOrCreateActiveMessage(final Long messageId) throws BException {
		HActiveMessage msg = new HActiveMessage(messageId);
		HActiveMessage msg1 = activeMessages.putIfAbsent(messageId, msg);
		if (msg1 != null) msg = msg1;
		if (msg.isCanceled()) {
			if (log.isDebugEnabled()) log.debug("Message was canceled");
			throw new BException(BExceptionC.CANCELLED, "Message was canceled");
		}
		if (msg.isFinished()) {
      if (log.isDebugEnabled()) log.debug("Message was finished");
      throw new BException(BExceptionC.CANCELLED, "Message was finished");
		}
		return msg;
	}
	
	/**
	 * This function is called when a new message arrives in onPost
	 * @param header
	 * @param rctxt
	 * @param workerThread 
	 * @throws BException
	 */
	public void addMessage(final BMessageHeader header, final HRequestContext rctxt, final Thread workerThread) throws BException {
		if (log.isDebugEnabled()) log.debug("addMessage(" + header + ", rctxt=" + rctxt);
		
		final HActiveMessage msg = getOrCreateActiveMessage(header.messageId);
		msg.setSessionid(header.sessionId);
		
		HAsyncErrorListener alsn = new HAsyncErrorListener() {
		  
			@Override
			public void onTimeout(AsyncEvent arg0) throws IOException {
			  
			  // A timeout can occur for a long-poll request or a request that requires 
			  // a long time to execute (e.g. upload of a large InputStream that is received in HHttpServlet.putStream).
			  
			  // If we are in a long-poll, the message is completed with HTTP 204 which
			  // instructs the client to send a new long-poll (with a new message ID).
			  
			  // If this is not a long-poll, a HTTP 202 is sent which lets the client 
			  // re-new the request by sending an empty message with the same message ID.
			  // This empty message has BMessageHeader.FLAG_POLL_PROCESSING.
			  // BYPS-9: Avoid socket exception while uploading large files.
			  
			  boolean isLongPoll = (header.flags & BMessageHeader.FLAG_LONGPOLL) != 0;
			  HRemoveMessageControl removeControl = isLongPoll ? HRemoveMessageControl.FINISHED : HRemoveMessageControl.PROCESSING;
			      
			  HRequestContext rctxt = getAndRemoveRequestContext(header.messageId, removeControl);
	      if (rctxt == null) return;
	      
	      if (log.isInfoEnabled()) {
	        if (isLongPoll) {
	          log.info("Client is notified to refresh long-poll.");
	        }
	        else {
	          log.info("Timeout for message processed by " + msg.getWorkerThread() + ", client is notified to send a new request to receive the message result.");
	        }
	      }
	       
				HttpServletResponse resp = (HttpServletResponse)arg0.getSuppliedResponse();
				
				int status = isLongPoll ? BExceptionC.RESEND_LONG_POLL : BExceptionC.PROCESSING;
				resp.setStatus(status);
				  
				resp.getOutputStream().close(); 
				
        if (log.isDebugEnabled()) log.debug("AsyncErrorListener.onTimeout(" + arg0 + ") status=" + status);
			}
			
			@Override
			public void onError(AsyncEvent arg0) throws IOException {
				if (log.isDebugEnabled()) log.debug("AsyncErrorListener.onError(" + arg0 + ")");
				getAndRemoveRequestContext(header.messageId, HRemoveMessageControl.FINISHED);
			}
		};
		rctxt.addListener(alsn);

		boolean pollProcessingMessage = (header.flags & BMessageHeader.FLAG_POLL_PROCESSING) != 0;
		Thread modifyWorkerThread = pollProcessingMessage ? null : workerThread;
		msg.setRequestContext(rctxt, modifyWorkerThread);
		
		if (log.isDebugEnabled()) log.debug(")addMessage");
	}

	/**
	 * This function is called when an incoming stream is received from a HTML file upload.
	 * @param streamId
	 * @param rctxt
	 * @throws BException
	 */
	public void addIncomingUploadStream(BContentStream is) throws BException {
		if (log.isDebugEnabled()) log.debug("addIncomingStream(is=" + is);
		
		// Added to outgoing streams, since those streams are cleaned up 
		// merely if they are expired. An incoming stream is also cleaned up, 
		// if it is not referenced by an active message.
		outgoingStreams.put(is.getTargetId().getStreamId(), new BContentStreamWrapper(is, HConstants.REQUEST_TIMEOUT_MILLIS) {
      public void close() throws IOException {
        if (log.isDebugEnabled()) log.debug("close incoming stream " + targetId + "(");
        Long streamId = getTargetId().getStreamId();
        outgoingStreams.remove(streamId);
        super.close();
        if (log.isDebugEnabled()) log.debug(")close");
      }
		});
		
    if (log.isDebugEnabled()) log.debug(")addIncomingStream");
	}
	
	public BContentStream getIncomingStream(BTargetId targetId) throws IOException {
  	if (log.isDebugEnabled()) log.debug("getIncomingStream(" + targetId);
  	
    long timeoutMillis = HConstants.INCOMING_STREAM_TIMEOUT_MILLIS;
  	BContentStream stream = getIncomingOrOutgoingStream(targetId.getStreamId(), timeoutMillis);
    	
		if (log.isDebugEnabled()) log.debug(")getIncomingStream=" + stream);
		return stream;
	}
	
	public BContentStream getOutgoingStream(BTargetId targetId) throws IOException {
		if (log.isDebugEnabled()) log.debug("getOutgoingStream(" + targetId);
		
		// Wait only a few seconds for an outgoing stream.
		// If the stream was generated in this server, we would not have to wait for it.
		// But it could be handed-over by client too. In this case, the put-stream request
		// might come some seconds later than the message that refers to it.
    long timeoutMillis = 11 * 1000;
		BContentStream ret = getIncomingOrOutgoingStream(targetId.getStreamId(), timeoutMillis);
		
		if (log.isDebugEnabled()) log.debug(")getOutgoingStream=" + ret);
		return ret;
	}
	
	public HRequestContext getAndRemoveRequestContext(Long messageId, HRemoveMessageControl removeControl) throws BException {
		if (log.isDebugEnabled()) log.debug("getAndRemoveRequestContext(" + messageId);
		HActiveMessage msg = activeMessages.get(messageId);
		// msg might be null when called from HActiveMessages.addMessage, HAsyncErrorListener.onTimeout, HActiveMessages.addMessage-HAsyncErrorListener.onError
		HRequestContext rctxt = msg != null ? msg.getAndRemoveRequestContext(removeControl) : null;
		if (log.isDebugEnabled()) log.debug(")getAndRemoveRequestContext=" + rctxt);
		return rctxt;
	}
	
	/**
	 * This function is called, when the worker has finished processing the message.
	 * @param messageId
	 */
	public void removeWorker(Long messageId) {
		if (log.isDebugEnabled()) log.debug("removeWorker(" + messageId);
		HActiveMessage msg = activeMessages.get(messageId);
		if (msg != null) {
			msg.removeWorker();
		}
		if (log.isDebugEnabled()) log.debug(")removeWorker");
	}
	
	/**
	 * Set the cancel flag of the message.
	 * Subsequent access to the message will cause a BException.CANCELED.
	 * This method interrupts the worker thread associated with the message.
	 * Furthermore it closes all streams of the message.
	 * @param messageId
	 */
	public void cancelMessage(final Long messageId) {
		if (log.isDebugEnabled()) log.debug("cancelMessage(" + messageId);
		HActiveMessage msg = activeMessages.get(messageId);
		if (msg != null) {
		  msg.cancelMessage();
		}
		if (log.isDebugEnabled()) log.debug(")cancelMessage");
	}
	
	/**
	 * Set cancel flag for all messages.
	 */
	public void cancelAllMessages() {
	  if (log.isDebugEnabled()) log.debug("cancelAllMessages(");
	  Collection<HActiveMessage> copyOfValues = activeMessages.values();
	  for (HActiveMessage msg : copyOfValues) {
	    msg.cancelMessage();
	  }
	  if (log.isDebugEnabled()) log.debug(")cancelAllMessages");
	}
	
	/**
	 * Close all incoming streams of the given message.
	 * @param messageId
	 */
	public void closeMessageIncomingStreams(final Long messageId) {
		if (log.isDebugEnabled()) log.debug("closeMessageIncomingStreams(" + messageId);
		HActiveMessage msg = activeMessages.get(messageId);
		if (msg != null) {
			msg.removeAllIncomingStreams();
		}
		if (log.isDebugEnabled()) log.debug(")closeMessageIncomingStreams");
	}
	
	
	/**
	 * Cleanup expired messages and close expired streams.
	 * @param all false: cleanup expired, true: cleanup all
	 */
	public void cleanup(final boolean all) {
		if (log.isDebugEnabled()) log.debug("cleanup(all=" + all);
		
		// HashSet for all active incoming streams
		HashSet<Long> activeIncomingStreamIds = new HashSet<Long>(incomingStreams.keys());
		
		// HashSet for referenced incoming streams.
		// Initialize with outgoing streams because incoming streams might be used in 
		// return values or sent to other clients.
		HashSet<Long> referencedIncomingStreamIds = new HashSet<Long>(outgoingStreams.keys());
		
		// Cleanup messages.
		ArrayList<HActiveMessage> arr = new ArrayList<HActiveMessage>(activeMessages.values());
		for (HActiveMessage msg : arr) {
		  
			if (all || msg.checkReferencedStreamIds(activeIncomingStreamIds, referencedIncomingStreamIds)) {
				if (log.isDebugEnabled()) log.debug("remove message=" + msg);
				if (all) msg.cancelMessage();
				if (all || msg.queryCleanup()) {
				  activeMessages.remove(msg.messageId);
				}
			}
			else if (log.isDebugEnabled() && !msg.isLongPoll()) {
	       log.debug("active message=" + msg);
			}
		}
		
		// Cleanup expired or not referenced incoming streams
    if (log.isDebugEnabled()) log.debug("cleanup incoming streams");
		for (Long streamId : activeIncomingStreamIds) {
			BContentStream stream = incomingStreams.get(streamId);
			if (stream == null) continue;
			
			if (log.isDebugEnabled()) log.debug("stream=" + stream + ", expired=" + stream.isExpired() + ", referenced=" + referencedIncomingStreamIds.contains(streamId));
			
		  if (all || stream.isExpired() || !referencedIncomingStreamIds.contains(streamId)) {
		    try {
		      if (log.isDebugEnabled()) log.debug("close/remove");
		      stream.close(); // removes from incomingStreams or outgoingStreams
		      incomingStreams.remove(streamId);
		    }
		    catch (Throwable e) {
		      log.debug("Failed to close stream=" + stream, e);
		    }
		  }
      else {
        if (log.isDebugEnabled()) log.debug("active incoming stream=" + stream);
      }
		}
		
		// Cleanup expired outgoing streams.
		// And cleanup expired upload streams.
    if (log.isDebugEnabled()) log.debug("cleanup outgoing streams");
		ArrayList<BContentStream> ostreams = new ArrayList<BContentStream>(outgoingStreams.values());
    for (BContentStream stream : ostreams) {
      if (log.isDebugEnabled()) log.debug("stream=" + stream + ", expired=" + stream.isExpired());
      if (all || stream.isExpired()) {
        try {
          if (log.isDebugEnabled()) log.debug("close/remove");
          stream.close(); // removes from incomingStreams or outgoingStreams
          outgoingStreams.remove(stream.getTargetId().getStreamId());
        }
        catch (Throwable e) {
          log.debug("Failed to close stream=" + stream, e);
        }
      }
      else {
        if (log.isDebugEnabled()) log.debug("active outgoing stream=" + stream);
      }
    }
		
		if (log.isDebugEnabled()) log.debug(")cleanup");
	}
	
	/**
	 * Returns the IDs of the messages.
	 * @param inclLongPolls
	 * @param excludeThread 
	 * @return
	 */
	public List<Long> getActiveMessageIds(boolean inclLongPolls, Thread excludeThread) {
	  if (log.isDebugEnabled()) log.debug("getActiveMessageIds(");
		List<Long> list = new ArrayList<Long>();
		List<HActiveMessage> msgs = new ArrayList<HActiveMessage>(activeMessages.values());
		for (HActiveMessage msg : msgs) {
		  if (msg.getWorkerThread() != excludeThread) {
  			if (inclLongPolls || !msg.isLongPoll()) {
  			  if (!msg.isFinished()) {
  			    if (log.isDebugEnabled()) log.debug("activeMessage=" + msg);
  			    list.add(msg.messageId);
  			  }
  			}
		  }
		}
    if (log.isDebugEnabled()) log.debug(")getActiveMessageIds #=" + list.size());
		return list;
	}

  public void addOutgoingStreams(List<BContentStream> streams) throws BException {
    if (streams == null || streams.size() == 0) return;

    if (log.isDebugEnabled()) log.debug("addOutgoingStreams(");
    
    for (BContentStream streamRequest : streams) {
   
      if (log.isDebugEnabled()) log.debug("put outgoing stream=" + streamRequest);
      HOutgoingStream ish = new HOutgoingStream(streamRequest, HConstants.REQUEST_TIMEOUT_MILLIS, tempDir) {
        @Override
        public void close() throws IOException {
          if (log.isDebugEnabled()) log.debug("close outgoing stream " + targetId + "(");
          outgoingStreams.remove(targetId.getStreamId());
          super.close();
          if (log.isDebugEnabled()) log.debug(")close");
        }
      };
      
      final Long streamId = streamRequest.getTargetId().getStreamId();
      outgoingStreams.put(streamId, ish);
      
    }

    if (log.isDebugEnabled()) log.debug(")addOutgoingStreams");
  }

  public HActiveMessage addIncomingStream(final BTargetId targetId, final HRequestContext rctxt) throws BException {
    
    final HActiveMessage msg = getOrCreateActiveMessage(targetId.getMessageId());
    
    if (rctxt.isAsync()) {
      addIncomingStreamAsync(targetId, rctxt);
    }
    else {
      addIncomingStreamSync(targetId, rctxt);
    }
    
    msg.addIncomingStream(targetId.getStreamId());
    
    return msg;
  }

  private void addIncomingStreamAsync(final BTargetId targetId, HRequestContext rctxt) throws BException {
    if (log.isDebugEnabled()) log.debug("addIncomingStreamAsync(targetId=" + targetId + ", rctxt=" + rctxt);

    try {
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
          final Long streamId = targetId.getStreamId();
          InputStream is = incomingStreams.remove(streamId);
          if (is != null) {
            is.close();
          }
        }
      };
      rctxt.addListener(alsn);

      BContentStream istrm = null;

      // Is splitted stream?
      if (partId != -1L) {

        istrm = incomingStreams.get(targetId.getStreamId());

        if (istrm == null) {

          istrm = new HIncomingSplittedStreamAsync(targetId, contentType, totalLength, contentDisposition, HConstants.REQUEST_TIMEOUT_MILLIS, tempDir) {
            public void close() throws IOException {
              if (log.isDebugEnabled()) log.debug("close incoming stream " + targetId + "(");
              Long streamId = getTargetId().getStreamId();
              incomingStreams.remove(streamId);
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
          public void close() throws IOException {
            if (log.isDebugEnabled()) log.debug("close incoming stream " + targetId + "(");
            Long streamId = getTargetId().getStreamId();
            incomingStreams.remove(streamId);
            super.close();
            if (log.isDebugEnabled()) log.debug(")close");
          }
        };
        
        incomingStreams.put(targetId.getStreamId(), istrm);
      }

      synchronized(this) {
        notifyAll();
      }

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
  
  private HIncomingStreamSync addIncomingStreamSync2(final BTargetId targetId, HttpServletRequest request) throws BException {
    if (log.isDebugEnabled()) log.debug("addIncomingStreamSync2(" + targetId);
    
    HIncomingStreamSync istrm = null;
    
    try {
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
            Long streamId = getTargetId().getStreamId();
            incomingStreams.remove(streamId);
            super.close();
            if (log.isDebugEnabled()) log.debug(")close");
          }
        };

        if (log.isDebugEnabled()) log.debug("put incoming stream into map, targetId=" + targetId);
        incomingStreams.put(targetId.getStreamId(), istrm);
      }

      // Notify threads waiting to read this stream
      synchronized(this) {
        notifyAll();
      }

    } catch (Throwable e) {
      throw new BException(BExceptionC.IOERROR, "Failed to add incoming stream", e);
    }

    if (log.isDebugEnabled()) log.debug(")addIncomingStreamSync2=" + istrm);
    return istrm;
  }

  public synchronized BContentStream getIncomingOrOutgoingStream(Long streamId, long timeoutMillis) throws IOException, BException {
    if (log.isDebugEnabled()) log.debug("getIncomingStream(streamId=" + streamId);
    long t1 = System.currentTimeMillis();
    BContentStream stream = null;

    while (true) {

      stream = incomingStreams != null ? incomingStreams.get(streamId) : null;
      if (stream != null) break;

      stream = outgoingStreams != null ? outgoingStreams.get(streamId) : null;
      if (stream != null) break;

      // Wait until the requested stream is received
      long t2 = System.currentTimeMillis();
      if (timeoutMillis < (t2 - t1)) {
        String msg = "Wait for stream=" + streamId + " timed out after " + timeoutMillis + "ms";
        if (log.isDebugEnabled()) log.debug(msg);
        throw new BException(BExceptionC.TIMEOUT, msg);
      }

      // Wait not more than 10s to make sure,
      // that we never will hang here because of a lost notify().
      long to = Math.min(timeoutMillis, HConstants.INCOMING_STREAM_TIMEOUT_MILLIS/10);
      if (log.isDebugEnabled()) log.debug("wait for stream=" + streamId + ", timeout=" + to);
      try {
        wait(to);
      } catch (InterruptedException e) {
        throw new BException(BExceptionC.TIMEOUT, "Wait for stream=" + streamId + " interrupted.");
      }
    }
    
    if (log.isDebugEnabled()) log.debug(")getIncomingStream=" + stream);
    return stream;
  }

  public HActiveMessage getActiveMessage(long messageId) {
    return activeMessages.get(messageId);
  }

	
}
