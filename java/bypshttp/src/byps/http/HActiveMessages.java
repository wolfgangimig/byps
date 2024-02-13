package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BContentStream;
import byps.BContentStreamWrapper;
import byps.BException;
import byps.BExceptionC;
import byps.BHashMap;
import byps.BMessageHeader;
import byps.BTargetId;
import jakarta.servlet.AsyncEvent;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

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
		if (log.isDebugEnabled()) log.debug("closeMessageIncomingStreams({}", messageId);
		HActiveMessage msg = activeMessages.get(messageId);
		if (msg != null) {
		  msg.closeAllIncomingStreams();
		}
		if (log.isDebugEnabled()) log.debug(")closeMessageIncomingStreams");
	}
	
	/**
	 * Cleanup expired messages and close expired streams.
	 * @param all false: cleanup expired, true: cleanup all
	 */
	public void cleanup(final boolean all) {
		if (log.isDebugEnabled()) log.debug("cleanup(all={}", all);
		
		// Cleanup messages.
		ArrayList<HActiveMessage> arr = new ArrayList<>(activeMessages.values());
		for (HActiveMessage msg : arr) {
		  
			if (all || msg.isFinished()) {
				if (log.isDebugEnabled()) log.debug("remove message={}", msg);
				if (all) msg.cancelMessage();
				if (all || msg.queryCleanup()) {
				  activeMessages.remove(msg.messageId);
				}
			}
			else if (log.isDebugEnabled() && !msg.isLongPoll()) {
	       log.debug("active message={}", msg);
			}
		}
		
		// Cleanup expired or not referenced incoming streams
    if (log.isDebugEnabled()) log.debug("cleanup incoming streams");
    cleanupExpiredStreams(incomingStreams.values(), all);
		
		// Cleanup expired outgoing streams.
		// And cleanup expired upload streams.
    if (log.isDebugEnabled()) log.debug("cleanup outgoing streams");
    cleanupExpiredStreams(outgoingStreams.values(), all);
		
		if (log.isDebugEnabled()) log.debug(")cleanup");
	}
	
	/**
	 * Close expired streams.
	 * @param streams Streams
	 * @param all If true, all streams are closed - not only the expired streams.
	 */
	private void cleanupExpiredStreams(Collection<BContentStream> streams, boolean all) {
	  streams = new ArrayList<>(streams);
	  streams.stream().filter(s -> all || s.isExpired()).forEach(this::quietCloseStream);
	}
	
	 /**
   * Close stream, catch Exception.
   * @param stream Stream to close
   */
  private void quietCloseStream(BContentStream stream) {
    if (log.isDebugEnabled()) log.debug("close stream={}", stream.getTargetId());
    try {
      stream.close();
    } catch (IOException e) {
      if (log.isDebugEnabled()) log.debug("failed to close stream={}", stream.getTargetId(), e);
    }
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
    
    HActiveMessage msg = getOrCreateActiveMessage(targetId.getMessageId());

    if (rctxt.isAsync()) {
      addIncomingStreamAsync(msg, targetId, rctxt);
    }
    else {
      addIncomingStreamSync(msg, targetId, rctxt);
    }
    
    return msg;
  }

  private void addIncomingStreamAsync(final HActiveMessage msg, final BTargetId targetId, HRequestContext rctxt) throws BException {
    if (log.isDebugEnabled()) log.debug("addIncomingStreamAsync(targetId={}, rctxt={}", targetId, rctxt);

    try {
      // BYPS-83: POST request as multipart/form-data
      
      final BContentStream preStream = getStreamFromRequestOrMultipartPart(rctxt);
      final String contentType = preStream.getContentType();
      final String contentDisposition = preStream.getContentDisposition();
      final String partIdStr = rctxt.getRequest().getParameter("partid");
      final long partId = partIdStr != null && partIdStr.length() != 0 ? Long.parseLong(partIdStr) : -1L;
      final String lastPartStr = rctxt.getRequest().getParameter("last");
      final boolean isLastPart = lastPartStr != null && lastPartStr.length() != 0 ? (Integer.valueOf(lastPartStr) != 0) : true;
      
      // BYPS-47: A value of Long.MAX for totalLength also means that the stream size is unknown.
      final String totalLengthStr = rctxt.getRequest().getParameter("total");
      long totalLength = -1L;
      if (totalLengthStr != null && !totalLengthStr.isEmpty()) {
        totalLength = Long.parseLong(totalLengthStr);
        if (totalLength == Long.MAX_VALUE) {
          totalLength = -1L;
        }
      }

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
              if (log.isDebugEnabled()) log.debug("close incoming stream={} (", targetId.getStreamId());
              Long streamId = getTargetId().getStreamId();
              incomingStreams.remove(streamId);
              super.close();
              if (log.isDebugEnabled()) log.debug(")close");
            }
          };

          // BYPS-45: Add stream to the map of all streams and to the map of the messages' streams in a synchronized block.
          // It has to be done 'at the same time' to have a consistent state in the cleanup thread.
          if (log.isDebugEnabled()) log.debug("put splitted stream={}", targetId.getStreamId());
          msg.addIncomingStream(targetId.getStreamId(), istrm, incomingStreams);
        }

        ((HIncomingSplittedStreamAsync) istrm).addStream(partId, preStream, isLastPart);

      }
      else {

        istrm = new HIncomingStreamAsync(targetId, preStream, tempDir) {
          public void close() throws IOException {
            if (log.isDebugEnabled()) log.debug("close incoming stream={} (", targetId.getStreamId());
            Long streamId = getTargetId().getStreamId();
            incomingStreams.remove(streamId);
            super.close();
            if (log.isDebugEnabled()) log.debug(")close");
          }
        };
        
        // BYPS-45: see above
        if (log.isDebugEnabled()) log.debug("put stream={}", targetId.getStreamId());
        msg.addIncomingStream(targetId.getStreamId(), istrm, incomingStreams);
      }

      synchronized(this) {
        notifyAll();
      }

    } catch (Throwable e) {
      throw new BException(BExceptionC.IOERROR, "Failed to add incoming stream", e);
    }

    if (log.isDebugEnabled()) log.debug(")addIncomingStreamAsync");
  }

  private void addIncomingStreamSync(final HActiveMessage msg, final BTargetId targetId, final HRequestContext rctxt) throws BException {
    if (log.isDebugEnabled()) log.debug("addIncomingStreamSync({}", targetId);
    
    // Create or get HIncomingStream object in synchronized function.
    final HttpServletRequest request = (HttpServletRequest) (rctxt.getRequest());
    final HIncomingStreamSync istrm = addIncomingStreamSync2(msg, targetId, request);
    
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

  /**
   * Wrap the stream data of the request body into a BContentStream.
   * If the request is of type multipart/form-data get the InputStream from request part "file". 
   * Otherwise wrap the InputStream of the request object. 
   * If a multipart/form-data request contains  a part "originalContentDisposition" take it as 
   * {@link BContentStream#setContentDisposition(String)}. 
   * BYPS-83 
   * @param rctxt Request context (request and response objects)
   * @return BContentStream 
   * @throws IOException
   * @throws ServletException
   */
  private BContentStream getStreamFromRequestOrMultipartPart(HRequestContext rctxt) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest)rctxt.getRequest();
    
    // Is request of type multipart/form-data?
    String requestContentType = request.getContentType();
    boolean isMultipart = requestContentType != null && requestContentType.toLowerCase().startsWith("multipart/form-data");
    
    // If it is a multipart request provide stream part.
    Optional<Part> filePart = isMultipart ? Optional.of(request.getPart("file")) : Optional.empty();
    
    // InputStream, content-type and content-length is either from the "file" part or from the entire request.
    String contentType = filePart.map(Part::getContentType).orElse(requestContentType);
    long contentLength = filePart.map(Part::getSize).orElse(request.getContentLengthLong());
    InputStream istream = filePart.isPresent() ? filePart.get().getInputStream() : request.getInputStream();
    
    // Wrap the InputStream and the headers.
    BContentStream ret = new BContentStreamWrapper(istream, contentType, contentLength, HConstants.REQUEST_TIMEOUT_MILLIS) {
      public void close() throws IOException {
        if (rctxt.isAsync() && !rctxt.isCompleted()) {
          try {
            HttpServletResponse response = (HttpServletResponse)rctxt.getResponse();
            response.getOutputStream().close();
            response.setStatus(HttpServletResponse.SC_OK);
          } finally {
            rctxt.complete();
          }
        }
      }
    };
    
    // Optionally assign the content-disposition value from the dedicated multipart part.
    Optional<Part> cdispPart = isMultipart ? Optional.ofNullable(request.getPart("originalContentDisposition")) : Optional.empty();
    ret.setContentDisposition(cdispPart.map(this::getStringValueFromPart).orElse(request.getHeader("Content-Disposition")));
    
    return ret;
  }
  
  /**
   * Read the multipart part content into a String.  
   * BYPS-83 
   * @param part {@link Part}
   * @return String
   */
  private String getStringValueFromPart(Part part) {
    String ret = "";
    char[] cbuf = new char[1000];
    try (Reader rd = new InputStreamReader(part.getInputStream(), StandardCharsets.UTF_8)) {
      int len = rd.read(cbuf);
      ret = new String(cbuf, 0, len);
    }
    catch (IOException e) {
      // ignored;
    }
    return ret;
  }
  
  private HIncomingStreamSync addIncomingStreamSync2(final HActiveMessage msg, final BTargetId targetId, HttpServletRequest request) throws BException {
    if (log.isDebugEnabled()) log.debug("addIncomingStreamSync2({}", targetId);
    
    HIncomingStreamSync istrm = null;
    
    try {
      HSyncContext rctxt = new HSyncContext(request, null);
      final BContentStream preStream = getStreamFromRequestOrMultipartPart(rctxt);
      final String contentType = preStream.getContentType();
      final String contentDisposition = preStream.getContentDisposition();
      final long contentLength = preStream.getContentLength();
      final String totalLengthStr = request.getParameter("total");
      final long totalLength = totalLengthStr != null && totalLengthStr.length() != 0 ? Long.parseLong(totalLengthStr) : -1L;

      if (log.isDebugEnabled()) {
        log.debug("contentType=" + contentType + ", contentLength=" + contentLength + ", totalLength=" + totalLength);
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

        // BYPS-45: see addIncomingStreamAsync
        if (log.isDebugEnabled()) log.debug("put incoming stream into map, targetId={}", targetId);
        msg.addIncomingStream(targetId.getStreamId(), istrm, incomingStreams);
      }

      // Notify threads waiting to read this stream
      synchronized(this) {
        notifyAll();
      }

    } catch (Throwable e) {
      throw new BException(BExceptionC.IOERROR, "Failed to add incoming stream", e);
    }

    if (log.isDebugEnabled()) log.debug(")addIncomingStreamSync2={}", istrm);
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
