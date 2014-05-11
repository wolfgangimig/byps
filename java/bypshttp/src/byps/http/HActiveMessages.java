package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.AsyncEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BContentStream;
import byps.BException;
import byps.BExceptionC;
import byps.BMessageHeader;
import byps.BTargetId;

public class HActiveMessages {
	
	/**
	 * Messages currently in process.
	 * Includes the long-polls.
	 */
	private final ConcurrentHashMap<Long, HActiveMessage> activeMessages = new ConcurrentHashMap<Long,HActiveMessage>();
	
	/**
	 * Streams posted by HTML file upload.
	 * Streams uploaded by HTML are received independent from a message. 
	 */
	private final ConcurrentHashMap<Long, BContentStream> incomingStreams = new ConcurrentHashMap<Long, BContentStream>();
	private final ConcurrentHashMap<Long, BContentStream> outgoingStreams = new ConcurrentHashMap<Long, BContentStream>();
	
	private final static Log log = LogFactory.getLog(HActiveMessages.class);
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
		
		HActiveMessage msg = getOrCreateActiveMessage(header.messageId);
		
		HAsyncErrorListener alsn = new HAsyncErrorListener() {
		  
			@Override
			public void onTimeout(AsyncEvent arg0) throws IOException {
			  
	      HRequestContext rctxt = getAndRemoveRequestContext(header.messageId);
	      if (rctxt == null) return;
	       
				HttpServletResponse resp = (HttpServletResponse)arg0.getSuppliedResponse();
				
				boolean isLongPoll = (header.flags & BMessageHeader.FLAG_LONGPOLL) != 0;
				int status = isLongPoll ? HttpServletResponse.SC_NO_CONTENT : HttpServletResponse.SC_REQUEST_TIMEOUT;
				resp.setStatus(status);
				  
				resp.getOutputStream().close();
				
        if (log.isDebugEnabled()) log.debug("AsyncErrorListener.onTimeout(" + arg0 + ") status=" + status);
			}
			
			@Override
			public void onError(AsyncEvent arg0) throws IOException {
				if (log.isDebugEnabled()) log.debug("AsyncErrorListener.onError(" + arg0 + ")");
				getAndRemoveRequestContext(header.messageId);
			}
		};
		rctxt.addListener(alsn);

		msg.setRequestContext(rctxt, workerThread);
		if (log.isDebugEnabled()) log.debug(")addMessage");
	}

	/**
	 * This function is called when an incoming stream is received from a HTML file upload.
	 * @param streamId
	 * @param rctxt
	 * @throws BException
	 */
	public void addIncomingUploadStream(final BTargetId targetId, BContentStream is) throws BException {
		if (log.isDebugEnabled()) log.debug("addIncomingStream(targetId=" + targetId + ", is=" + is);
		
		incomingStreams.put(targetId.getStreamId(), is);
		
    if (log.isDebugEnabled()) log.debug(")addIncomingStream");
	}
	
	public BContentStream getIncomingStream(BTargetId targetId) throws IOException {
  	if (log.isDebugEnabled()) log.debug("getIncomingStream(" + targetId);
  	
  	BContentStream stream = getIncomingOrOutgoingStream(targetId.getStreamId());
    	
		if (log.isDebugEnabled()) log.debug(")getIncomingStream=" + stream);
		return stream;
	}
	
	public BContentStream getOutgoingStream(BTargetId targetId) throws IOException {
		if (log.isDebugEnabled()) log.debug("getOutgoingStream(" + targetId);
		BContentStream ret = getIncomingOrOutgoingStream(targetId.getStreamId());
		if (log.isDebugEnabled()) log.debug(")getOutgoingStream=" + ret);
		return ret;
	}
	
	public HRequestContext getAndRemoveRequestContext(Long messageId) throws BException {
		if (log.isDebugEnabled()) log.debug("getAndRemoveRequestContext(" + messageId);
		HActiveMessage msg = activeMessages.get(messageId);
		// msg might be null when called from HActiveMessages.addMessage, HAsyncErrorListener.onTimeout, HActiveMessages.addMessage-HAsyncErrorListener.onError
		HRequestContext rctxt = msg != null ? msg.getAndRemoveRequestContext() : null;
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
		msg.cancelMessage();
		if (log.isDebugEnabled()) log.debug(")cancelMessage");
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
		if (log.isDebugEnabled()) log.debug("cleanup(");
		
		// HashSet for all active incoming streams
		HashSet<Long> activeIncomingStreamIds = new HashSet<Long>(incomingStreams.keySet());
		
		// HashSet for referenced incoming streams.
		// Initialize with outgoing streams because incoming streams might be used in 
		// return values or sent to other clients.
		HashSet<Long> referencedIncomingStreamIds = new HashSet<Long>(outgoingStreams.keySet());
		
		// Cleanup messages.
		ArrayList<HActiveMessage> arr = new ArrayList<HActiveMessage>(activeMessages.values());
		for (HActiveMessage msg : arr) {
		  
			if (all || msg.checkReferencedStreamIds(activeIncomingStreamIds, referencedIncomingStreamIds)) {
				if (log.isDebugEnabled()) log.debug("remove message=" + msg);
				if (all) msg.cancelMessage();
				activeMessages.remove(msg.messageId);
			}
			else if (log.isDebugEnabled() && !msg.isLongPoll()) {
	       log.debug("active message=" + msg);
			}
		}
		
		// Cleanup expired or not referenced incoming streams
		for (Long streamId : activeIncomingStreamIds) {
			BContentStream stream = incomingStreams.get(streamId);
			if (stream == null) continue;
			
		  if (all || stream.isExpired() || !referencedIncomingStreamIds.contains(streamId)) {
		    try {
		      if (log.isDebugEnabled()) log.debug("close/remove incoming stream=" + stream);
		      stream.close(); // removes from incomingStreams or outgoingStreams
		    }
		    catch (Throwable e) {
		      log.debug("Failed to close stream=" + stream, e);
		    }
		  }
      else {
        if (log.isDebugEnabled()) log.debug("active incoming stream=" + stream);
      }
		}
		
		// Cleanup expired outgoing streams
    for (BContentStream stream : outgoingStreams.values()) {
      if (all || stream.isExpired()) {
        try {
          if (log.isDebugEnabled()) log.debug("close/remove outgoing stream=" + stream);
          stream.close(); // removes from incomingStreams or outgoingStreams
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
	 * @return
	 */
	public List<Long> getActiveMessageIds(boolean inclLongPolls) {
		List<Long> list = new ArrayList<Long>();
		List<HActiveMessage> msgs = new ArrayList<HActiveMessage>(activeMessages.values());
		for (HActiveMessage msg : msgs) {
			if (inclLongPolls || !msg.isLongPoll()) {
				list.add(msg.messageId);
			}
		}
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

  public void addIncomingStream(final BTargetId targetId, final HRequestContext rctxt) throws BException {
    if (rctxt.isAsync()) {
      addIncomingStreamAsync(targetId, rctxt);
    }
    else {
      addIncomingStreamSync(targetId, rctxt);
    }
    
    final HActiveMessage msg = getOrCreateActiveMessage(targetId.getMessageId());
    msg.addIncomingStream(targetId.getStreamId());
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
          istrm = new HIncomingSplittedStreamAsync(targetId, contentType, totalLength, contentDisposition, HConstants.REQUEST_TIMEOUT_MILLIS, tempDir);
          incomingStreams.put(targetId.getStreamId(), istrm);
        }

        ((HIncomingSplittedStreamAsync) istrm).addStream(partId, contentLength, isLastPart, rctxt);

      }
      else {
        istrm = new HIncomingStreamAsync(targetId, contentType, contentLength, contentDisposition, HConstants.REQUEST_TIMEOUT_MILLIS, tempDir, rctxt);        
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
        istrm = new HIncomingStreamSync(targetId, contentType, length, contentDisposition, HConstants.REQUEST_TIMEOUT_MILLIS, tempDir);
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

  public synchronized BContentStream getIncomingOrOutgoingStream(Long streamId) throws IOException, BException {
    if (log.isDebugEnabled()) log.debug("getIncomingStream(streamId=" + streamId);
    long t1 = System.currentTimeMillis();
    BContentStream stream = null;
    long timeoutMillis = HConstants.REQUEST_TIMEOUT_MILLIS;

    while (timeoutMillis > 0) {

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
      if (log.isDebugEnabled()) log.debug("wait for stream=" + streamId + ", timeout=" + to);
      try {
        wait(to);
      } catch (InterruptedException e) {
        throw new InterruptedIOException("Wait for stream=" + streamId + " interrupted.");
      }
    }
    
    // Stream might be already read. Then, it is closed and BContentStream.isExpired() returns true
    if (stream.isExpired()) {
      throw new FileNotFoundException("Stream has already been read or is expired.");
    }

    if (log.isDebugEnabled()) log.debug(")getIncomingStream=" + stream);
    return stream;
  }

	
}
