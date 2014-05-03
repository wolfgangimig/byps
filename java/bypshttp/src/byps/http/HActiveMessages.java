package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.AsyncEvent;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BContentStream;
import byps.BException;
import byps.BExceptionC;
import byps.BMessageHeader;

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
	private final ConcurrentHashMap<Long, BContentStream> uploadStreams = new ConcurrentHashMap<Long, BContentStream>();
	
	private Log log = LogFactory.getLog(HActiveMessages.class);
	private final File tempDir;
	
	public HActiveMessages(File tempDir) {
	  this.tempDir = tempDir;
	}
	
	public void done() {
		if (log.isDebugEnabled()) log.debug("done(");
		cleanup(true);
		if (log.isDebugEnabled()) log.debug(")done");
	}
	
	private HActiveMessage getOrCreateActiveMessage(Long messageId) throws BException {
		HActiveMessage msg = new HActiveMessage(messageId, tempDir);
		HActiveMessage msg1 = activeMessages.putIfAbsent(messageId, msg);
		if (msg1 != null) msg = msg1;
		synchronized(msg) {
			if (msg.isCanceled()) {
				if (log.isDebugEnabled()) log.debug("Message was canceled");
				throw new BException(BExceptionC.CANCELLED, "Message was canceled");
			}
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
	public void addMessage(final BMessageHeader header, final HRequestContext rctxt, Thread workerThread) throws BException {
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
	 * This function is called when an incoming stream is received in doPut.
	 * @param messageId
	 * @param streamId
	 * @param partId 
	 * @param rctxt
	 * @throws BException
	 */
	public void addIncomingStream(final Long messageId, final Long streamId, HRequestContext rctxt) throws BException {
		if (log.isDebugEnabled()) log.debug("addIncomingStream(messageId=" + messageId + ", streamId=" + streamId + ", rctxt=" + rctxt);
		
		final HActiveMessage msg = getOrCreateActiveMessage(messageId);
		msg.addIncomingStream(streamId, rctxt);
		
        if (log.isDebugEnabled()) log.debug(")addIncomingStream");
	}
	
	/**
	 * This function is called when an incoming stream is received from a HTML file upload.
	 * @param streamId
	 * @param rctxt
	 * @throws BException
	 */
	public void addIncomingStream(final Long streamId, BContentStream is) throws BException {
		if (log.isDebugEnabled()) log.debug("addIncomingStream(streamId=" + streamId + ", is=" + is);
		
		uploadStreams.put(streamId, is);
		
        if (log.isDebugEnabled()) log.debug(")addIncomingStream");
	}
	
	/**
	 * This function is called to obtain the outgoing streams that belong to the message response.
	 * @param streamRequests
	 * @throws BException
	 */
	public void addOutgoingStreams(List<BContentStream> streamRequests) throws BException {
		if (log.isDebugEnabled()) log.debug("addOutgoingStreams(");
		if (streamRequests != null && streamRequests.size() != 0) {
			Long messageId = streamRequests.get(0).getMessageId();
			HActiveMessage msg = getOrCreateActiveMessage(messageId);
			synchronized(msg) {
				msg.addOutgoingStreams(streamRequests);
			}
		}
		if (log.isDebugEnabled()) log.debug(")addOutgoingStreams");
	}
	
	public BContentStream getIncomingStream(Long messageId, Long streamId) throws IOException {
  	if (log.isDebugEnabled()) log.debug("getIncomingStream(messageId=" + messageId + ", streamId=" + streamId);
  	
  	// Streams uploaded from a HTML form are received before the
  	// corresponding message arrives. This streams are stored in the
  	// map uploadStreams since the message ID is unknown at the time the arrive.
  	BContentStream stream = uploadStreams.get(streamId);
  	
  	if (stream == null) {
  		
  		// The stream is not available. So it cannot be a HTML file upload.
  		// The client side must send this stream with a message ID.
  		
  		HActiveMessage msg = getOrCreateActiveMessage(messageId);
  		stream = msg.getIncomingOrOutgoingStream(streamId);
  	}
    	
		if (log.isDebugEnabled()) log.debug(")getIncomingStream=" + stream);
		return stream;
	}
	
	public BContentStream getOutgoingStream(Long messageId, Long streamId) throws IOException {
		if (log.isDebugEnabled()) log.debug("getOutgoingStream(messageId=" + messageId + ", streamId=" + streamId);
		BContentStream ret = null;
		HActiveMessage msg = activeMessages.get(messageId);
		if (msg == null) {
			throw new FileNotFoundException("Message for outgoing stream not found, messageId=" + messageId + ", streamId=" + streamId);
		}
    	ret = msg.getIncomingOrOutgoingStream(streamId);
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
		
		HActiveMessage msg = new HActiveMessage(messageId, tempDir);
		HActiveMessage msg1 = activeMessages.putIfAbsent(messageId, msg);
		if (msg1 != null) msg = msg1;
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
			msg.cleanupIncomingStreams(true);
		}
		if (log.isDebugEnabled()) log.debug(")closeMessageIncomingStreams");
	}
	
	/**
	 * Cleanup expired messages and close expired streams.
	 * @param all false: cleanup expired, true: cleanup all
	 */
	public void cleanup(boolean all) {
		if (log.isDebugEnabled()) log.debug("cleanup(");
		
		// Cleanup messages.
		ArrayList<HActiveMessage> arr = new ArrayList<HActiveMessage>(activeMessages.values());
		for (HActiveMessage msg : arr) {
			if (msg.cleanup(all)) {
				if (log.isDebugEnabled()) log.debug("remove expired message, messageId=" + msg.messageId);
				activeMessages.remove(msg.messageId);
			}
		}
		
		// Cleanup HTML file uploads.
		HashMap<Long, BContentStream> htmlStreams = new HashMap<Long, BContentStream>(uploadStreams);
		for (Long streamId : htmlStreams.keySet()) {
			BContentStream stream = htmlStreams.get(streamId);
			if (stream.isExpired()) {
				uploadStreams.remove(streamId);
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

}
