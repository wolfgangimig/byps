package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BContentStream;
import byps.BException;
import byps.BExceptionC;
import byps.BTargetId;

public class HIncomingSplittedStreamAsync extends BContentStream {

	private static Logger log = LoggerFactory.getLogger(HIncomingSplittedStreamAsync.class);
	protected final File tempDir;
	protected long readPos;
	protected long currentPartId;
	protected long maxPartId = Long.MAX_VALUE;
	protected HIncomingStreamAsync currentStreamPart;
	private HashMap<Long, HIncomingStreamAsync> streamParts = new HashMap<Long, HIncomingStreamAsync>();
	
	HIncomingSplittedStreamAsync(BTargetId targetId, String contentType, long totalLength, String contentDisposition, long lifetimeMillis, File tempDir) throws IOException {
		super(contentType, totalLength, lifetimeMillis);
		this.setTargetId(targetId);
		this.tempDir = tempDir;
		setContentDisposition(contentDisposition);
	}
	
	public synchronized void addStream(long partId, long contentLength, boolean isLastPart, HRequestContext rctxt) throws IOException {
		if (log.isDebugEnabled()) log.debug("addStream(" + targetId + ", partId=" + partId + ", contentLength=" + contentLength + ", isLastPart=" + isLastPart);
		String contentType = getContentType();
		HIncomingStreamAsync streamPart = new HIncomingStreamAsync(targetId, contentType, contentLength, "", lifetimeMillis, tempDir, rctxt);
		streamParts.put(partId, streamPart);
		
		if (isLastPart) {
		  maxPartId = partId+1;
		  if (log.isDebugEnabled()) log.debug("maxPartId={}", maxPartId);
		}
		
		// notify thread that might wait in read()
		if (log.isDebugEnabled()) log.debug("notify thread waiting in read()");
		notifyAll();
		
		extendLifetime();
		if (log.isDebugEnabled()) log.debug(")addStream");
	}
	
	@Override
	public void close() throws IOException {
		if (log.isDebugEnabled()) log.debug("close(");
		
		if (log.isDebugEnabled()) log.debug("close #streamPart={}", streamParts.size());
		for (HIncomingStreamAsync strm : streamParts.values()) {
			try {
			  if (log.isDebugEnabled()) log.debug("close streamPart={}", strm);
				strm.close();
			}
			catch (IOException ignored) {}
		}
	
		if (log.isDebugEnabled()) log.debug("clear streamParts");
		streamParts.clear();
		
		// Causes isExpired() to return true
		super.close();
		
		if (log.isDebugEnabled()) log.debug(")close");
	}
	
	private HIncomingStreamAsync getCurrentStreamPart(boolean nextPart) throws IOException {
	  if (log.isDebugEnabled()) log.debug("getCurrentStreamPart(next={}", nextPart);
	  if (log.isDebugEnabled()) log.debug("currentStreamPart={}, currentPartId={}, maxPartId={}", currentStreamPart, currentPartId, maxPartId);
		if (nextPart || currentStreamPart == null) {
			long t1 = System.currentTimeMillis();
			long timeout = lifetimeMillis;
			synchronized(this) {
			  if (nextPart) currentPartId++;
			  if (currentPartId < maxPartId) {
  				currentStreamPart = streamParts.get(currentPartId);
  				if (log.isDebugEnabled()) { log.debug("currentStreamPart={}, currentPartId={}, maxPartId={}", currentStreamPart, currentPartId, maxPartId); }
  				
  				// Wait for stream part.
  		    while (currentStreamPart == null) {
  					try {
  					  if (log.isDebugEnabled()) log.debug("wait(timeout={}", timeout);
  						wait(timeout);
  						long t2 = System.currentTimeMillis();
  						boolean isTimeout = t2 - t1 > timeout;
  						if (log.isDebugEnabled()) log.debug(")wait, isTimeout={}", isTimeout);
  						if (isTimeout) {
  							throw new BException(BExceptionC.TIMEOUT, "Timeout while reading stream part");
  						}
  					} catch (InterruptedException e) {
  						throw new InterruptedIOException();
  					}
  					currentStreamPart = streamParts.get(currentPartId);
  					if (log.isDebugEnabled()) log.debug("currentStreamPart={}, currentPartId={}, maxPartId={}", currentStreamPart, currentPartId, maxPartId);
  		    }
			  }
			  else {
			    currentStreamPart = null;
			    if (log.isDebugEnabled()) log.debug("no more stream parts");
			  }
			}
		}
		if (log.isDebugEnabled()) log.debug(")getCurrentStreamPart", currentStreamPart);
		return currentStreamPart;
	}
	
	private int internalRead(byte[] b, int off, int len) throws IOException {
	  if (log.isDebugEnabled()) log.debug("internalRead(b, off={}, len={}", off, len);
		int ret = -1;
		
		final long totalLength = getContentLength();
		if (log.isDebugEnabled()) log.debug("readPos={}, totalLength={}", readPos, totalLength);

		if (totalLength == -1 || readPos < totalLength) {
			
		  // Get current stream part.
		  HIncomingStreamAsync streamPart = getCurrentStreamPart(false);
			if (log.isDebugEnabled()) log.debug("current streamPart={}", streamPart);
			
			if (streamPart != null) {
				ret = b != null ? streamPart.read(b, off, len) : streamPart.read();
				if (log.isDebugEnabled()) log.debug("streamPart.read()={}", ret);
				while (ret == -1) {
				  
				  // Closing the stream also releases the PUT request that submits the part.
				  if (log.isDebugEnabled()) log.debug("streamPart.close()");
				  streamPart.close();
				  
				  // Next stream part.
					streamPart = getCurrentStreamPart(true);
					if (log.isDebugEnabled()) log.debug("next streamPart={}", streamPart);
					if (streamPart == null) break;
					
					ret = b != null ? streamPart.read(b, off, len) : streamPart.read();
					if (log.isDebugEnabled()) log.debug("streamPart.read()={}", ret);
				}
			}
		}
		else if (readPos == totalLength) {
      // BYPS-48: if readPos == totalLength, the current stream part should be closed.
      HIncomingStreamAsync streamPart = getCurrentStreamPart(false);
      if (log.isDebugEnabled()) log.debug("current streamPart={}", streamPart);
      if (streamPart != null) {
        streamPart.close();
      }
    }
		
		if (ret != -1) {
			readPos += ret;
			if (log.isDebugEnabled()) log.debug("next readPos={}", readPos);
		}
		
		if (log.isDebugEnabled()) log.debug(")internalRead={}", ret);
		return ret;
	}
	
	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		return internalRead(b, off, len);
	}

	@Override
	public int read() throws IOException {
		return internalRead(null, 0, 0);
	}
	
	@Override
	public synchronized BContentStream materialize() throws BException {
	  if (log.isDebugEnabled()) log.debug("materialize(");
		if (readPos != 0) throw new BException(BExceptionC.INTERNAL, "InputStream cannot be copied after bytes alread have been read.");
		HIncomingStreamSync istrm = null; 
		try {
		  if (log.isDebugEnabled()) log.debug("new HIncomintStreamSync");
	    istrm = new HIncomingStreamSync(this, lifetimeMillis, tempDir);
			istrm.assignStream(this);
			
	    // Reset stream IDs. 
	    // Otherwise the stream would not be sent, see BOutput.createStreamRequest.
	    istrm.setTargetId(BTargetId.ZERO);

			// materialize closes "this"
	    if (log.isDebugEnabled()) log.debug("this.close()");
			this.close();
			
		} catch (IOException e) {
			throw new BException(BExceptionC.IOERROR, "Failed to clone stream", e);
		}
		if (log.isDebugEnabled()) log.debug(")materialize={}", istrm);
		return istrm;
	}

}
