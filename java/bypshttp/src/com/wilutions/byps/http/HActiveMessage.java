package com.wilutions.byps.http;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.AsyncEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BContentStream;
import com.wilutions.byps.BException;
import com.wilutions.byps.BStreamRequest;

public 	class HActiveMessage {
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
		if (log.isDebugEnabled()) log.debug("isFinished(" + messageId);
		if (log.isDebugEnabled()) {
			log.debug("longPoll=" + isLongPoll());
			log.debug("rctxtMessage=" + rctxtMessage);
			log.debug("workerThread=" + workerThread);
			log.debug("incomingStreams=" + incomingStreams);
			log.debug("outgoingStreams=" + outgoingStreams);
		}
		boolean finished = rctxtMessage == null && workerThread == null && 
				(incomingStreams == null || incomingStreams.size() == 0) && 
				(outgoingStreams == null || outgoingStreams.size() == 0);
		
		if (log.isDebugEnabled()) log.debug(")isFinished=" + finished);
		return finished;
	}
	
	private synchronized void checkFinished() {
		if (log.isDebugEnabled()) log.debug("checkFinished(");
		
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
		if (log.isDebugEnabled()) log.debug(")checkFinished");
	}
	
	public synchronized void cleanupIncomingStreams(boolean all) {
		if (log.isDebugEnabled()) log.debug("cleanupIncomingStreams(" + messageId + ", all=" + all);
		if (incomingStreams != null) {
			ArrayList<BContentStream> allStreams = new ArrayList<BContentStream>(incomingStreams.values());
			for (BContentStream istrm : allStreams) {
				if (all || istrm.isExpired()) {
					try { istrm.close(); } catch (Throwable e) {}
				}
			}
		}
		if (log.isDebugEnabled()) log.debug(")cleanupIncomingStreams");
	}
	
	private synchronized void cleanupOutgoingStreams(boolean all) {
		if (log.isDebugEnabled()) log.debug("cleanupOutgoingStreams(" + messageId + ", all=" + all);
		if (outgoingStreams != null ) {
			ArrayList<BContentStream> allStreams = new ArrayList<BContentStream>(outgoingStreams.values());
			for (BContentStream istrm : allStreams) {
				if (all || istrm.isExpired()) {
					try { istrm.close(); } catch (Throwable e) {}
				}
			}
		}
		if (log.isDebugEnabled()) log.debug(")cleanupOutgoingStreams");
	}
	
	public synchronized void addOutgoingStreams(List<BStreamRequest> streamRequests) throws BException {
		if (log.isDebugEnabled()) log.debug("addOutgoingStreams(");

		final HActiveMessage msg = this;

		if (outgoingStreams == null) {
			outgoingStreams = new HashMap<Long, BContentStream>();
		}
		
		for (BStreamRequest streamRequest  : streamRequests) {
			if (log.isDebugEnabled()) log.debug("put outgoing stream, messageId=" + streamRequest.messageId + ", streamId=" + streamRequest.streamId + ", stream=" + streamRequest.strm);
			HOutgoingStream ish = new HOutgoingStream(streamRequest.strm, streamRequest.streamId, HConstants.REQUEST_TIMEOUT_MILLIS) {
				@Override
				public void close() throws IOException {
					if (log.isDebugEnabled()) log.debug("close outgoing stream " + streamId + "(");
					synchronized(msg) {
						if (log.isDebugEnabled()) log.debug("remove outgoing stream, streamId=" + streamId);
						outgoingStreams.remove(streamId);
						checkFinished();
					}
					super.close();
					if (log.isDebugEnabled()) log.debug(")close");
				}
			};
			outgoingStreams.put(streamRequest.streamId, ish);
		}
		
		if (log.isDebugEnabled()) log.debug(")addOutgoingStreams");
	}

	public void addIncomingStream(final Long streamId, HRequestContext rctxt) throws BException {
		if (rctxt.isAsync()) {
			addIncomingStreamAsync(streamId, rctxt);
		}
		else {
			addIncomingStreamSync(streamId, rctxt);
		}
	}
	
	private synchronized void addIncomingStreamAsync(final Long streamId, HRequestContext rctxt) throws BException {
		if (log.isDebugEnabled()) log.debug("addIncomingStreamAsync(streamId=" + streamId + ", rctxt=" + rctxt);
		
		final HActiveMessage msg = this;
		final HttpServletRequest request = (HttpServletRequest)(rctxt.getRequest());
		final String contentType = request.getContentType();
		final String contentLengthStr = request.getHeader("Content-Length");
		final long contentLength = contentLengthStr != null && contentLengthStr.length() != 0 ? Long.parseLong(contentLengthStr) : -1L;
	
		HAsyncErrorListener alsn = new HAsyncErrorListener() {
			@Override
			public void onError(AsyncEvent arg0) throws IOException {
				if (log.isDebugEnabled()) log.debug("AsyncErrorListener.onError(" + arg0 + ")");
				InputStream is = null;
				synchronized(msg) {
					is = incomingStreams.remove(streamId);
				}
				if (is != null) is.close();
			}
		};
		rctxt.addListener(alsn);
		
		HIncomingStreamAsync istrm;
		try {
			istrm = new HIncomingStreamAsync(contentType, contentLength, streamId, HConstants.REQUEST_TIMEOUT_MILLIS, tempDir, rctxt) {
				private Log log = LogFactory.getLog(HIncomingStreamAsync.class);
				public void close() throws IOException {
					if (log.isDebugEnabled()) log.debug("close incoming stream " + streamId + "(");
					
					synchronized(msg) {
						if (log.isDebugEnabled()) log.debug("remove incoming stream, streamId=" + streamId);
						incomingStreams.remove(streamId);
						checkFinished();
					}
					
					super.close();
					
					if (log.isDebugEnabled()) log.debug(")close");
				}
			};
		} catch (IOException e) {
			throw new BException(BException.IOERROR, e.getMessage(), e);
		}

		if (incomingStreams == null) {
			incomingStreams = new HashMap<Long, BContentStream>();
		}
        incomingStreams.put(streamId, istrm);
        notifyAll();
		
        if (log.isDebugEnabled()) log.debug(")addIncomingStreamAsync");
	}
	
	private synchronized void addIncomingStreamSync(final Long streamId, final HRequestContext rctxt) throws BException {
		if (log.isDebugEnabled()) log.debug("addIncomingStreamSync(" + streamId);
	
		final HActiveMessage msg = this;
		final HttpServletRequest request = (HttpServletRequest)(rctxt.getRequest());
		final String contentType = request.getContentType();
		final String contentLengthStr = request.getHeader("Content-Length");
		final long contentLength = contentLengthStr != null && contentLengthStr.length() != 0 ? Long.parseLong(contentLengthStr) : -1L;

		try {
			if (log.isDebugEnabled()) log.debug("create HInputStreamBuffer");
			final HIncomingStreamSync istrm = new HIncomingStreamSync(contentType, contentLength, streamId, HConstants.REQUEST_TIMEOUT_MILLIS, tempDir) {
				
				@Override
				public synchronized void writeClose() {
					if (writeClosed) return;
					if (log.isDebugEnabled()) log.debug("writeClose " + streamId + "(");
					HttpServletResponse response = (HttpServletResponse)rctxt.getResponse();
					response.setStatus(HttpServletResponse.SC_OK);
					try {
						response.getOutputStream().close();
					} catch (IOException ignored) {}
					super.writeClose();
					if (log.isDebugEnabled()) log.debug(")writeClose");
				}
				
				@Override
				public synchronized void close() throws IOException {
					if (log.isDebugEnabled()) log.debug("close " + streamId + "(");
					
					synchronized(msg) {
						if (log.isDebugEnabled()) log.debug("remove incoming stream, streamId=" + streamId);
						incomingStreams.remove(streamId);
						checkFinished();
					}

					super.close();
					if (log.isDebugEnabled()) log.debug(")close");
				}
			};
			
			synchronized (this) {
				if (log.isDebugEnabled()) log.debug("put incoming stream into map, streamId=" + streamId);
				if (incomingStreams == null) {
					incomingStreams = new HashMap<Long, BContentStream>();
				}
		        incomingStreams.put(streamId, istrm);
		        notifyAll();
			}
	        
			// Copy the stream into the buffer.
			// This is done synchronously.
	        if (log.isDebugEnabled()) log.debug("start copying stream, streamId=" + streamId);
	        istrm.assignStream(rctxt.getRequest().getInputStream());
	        if (log.isDebugEnabled()) log.debug("end copying stream, streamId=" + streamId);
		}
		catch (IOException e) {
			throw new BException(BException.IOERROR, "Failed to add incoming stream", e);
		}
		
		if (log.isDebugEnabled()) log.debug(")addIncomingStreamSync");
	}

	public synchronized BContentStream getIncomingStream(Long streamId, long timeoutMillis) throws InterruptedException, BException {
    	if (log.isDebugEnabled()) log.debug("getIncomingStream(streamId=" + streamId);
    	long t1 = System.currentTimeMillis();
    	BContentStream stream = null;
    	
		while (timeoutMillis > 0) {
			
			if (canceled) {
				if (log.isDebugEnabled()) log.debug("Message has been canceled.");
				throw new BException(BException.CANCELED, "Message canceled");
			}
			
			stream = incomingStreams != null ? incomingStreams.get(streamId) : null;
			if (stream != null) break;
			
			// Wait until the requested stream is received
			long t2 = System.currentTimeMillis();
			long to = timeoutMillis - (t2 - t1);
			if (to <= 0) {
				if (log.isDebugEnabled()) log.debug("Timeout");
				throw new BException(BException.TIMEOUT, "Timeout while waiting for streamId=" + streamId);
			}
			if (log.isDebugEnabled()) log.debug("wait for stream, timeout=" + to);
			wait(to);
		}
		
		if (log.isDebugEnabled()) log.debug(")getIncomingStream=" + stream);
		return stream;
	}

	public synchronized BContentStream getOutgoingStream(Long streamId) throws IOException {
		if (log.isDebugEnabled()) log.debug("getOutgoingStream(messageId=" + messageId + ", streamId=" + streamId);
		BContentStream ret = null;
		
		if (outgoingStreams == null) {
			throw new FileNotFoundException("Message does not contain any outgoing streams, messageId=" + messageId + ", streamId=" + streamId);
		}
		
		BContentStream streamHolder = outgoingStreams.get(streamId);
   		if (streamHolder == null) {
			throw new FileNotFoundException("Message does not contain outgoing stream, messageId=" + messageId + ", streamId=" + streamId);
		}
   		ret = streamHolder;
   		
		if (log.isDebugEnabled()) log.debug(")getOutgoingStream=" + ret);
		return ret;
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
			
			if (log.isDebugEnabled()) log.debug("assume long-poll, complete response (return 408, timeout)");
			
			// Assume Longpoll request because a worker thread would have called getAndRemoveRequestContext
			// before it has called removeWorker.
			
			HttpServletResponse resp = (HttpServletResponse)rctxtMessage.getResponse();
			resp.setStatus(HttpServletResponse.SC_REQUEST_TIMEOUT);
			rctxtMessage.complete();
			rctxtMessage = null;
		}
		
		cleanupIncomingStreams(true);
		cleanupOutgoingStreams(true);

		checkFinished();

 		if (log.isDebugEnabled()) log.debug(")cancelMessage");
	}

	public synchronized boolean cleanup(boolean all) {
		if (log.isDebugEnabled()) log.debug("cleanup(messageId=" + messageId + ", all=" + all);
		if (all) {
			cancelMessage();
		}
		else {
			if (log.isDebugEnabled()) log.debug("cleanup expired members");
			cleanupIncomingStreams(false);
			cleanupOutgoingStreams(false);
			checkFinished();
		}
		
		boolean exp = isExpired();
		if (log.isDebugEnabled()) log.debug(")cleanup=" + exp);
		return exp;
	}

	@Override
	public String toString() {
		return "[" + messageId + "," + canceled + "," + workerThread + "," + new Date(bestBefore) + "]";
	}

}

