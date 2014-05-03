package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BContentStream;
import byps.BException;
import byps.BExceptionC;

public class HIncomingSplittedStreamAsync extends BContentStream {

	private static Log log = LogFactory.getLog(HIncomingSplittedStreamAsync.class);
	protected final File tempDir;
	protected final long streamId;
	protected long readPos;
	protected long currentPartId;
	protected long maxPartId = Long.MAX_VALUE;
	protected HIncomingStreamAsync currentStreamPart;
	private HashMap<Long, HIncomingStreamAsync> streamParts = new HashMap<Long, HIncomingStreamAsync>();
	
	HIncomingSplittedStreamAsync(String contentType, long totalLength, String contentDisposition, long streamId, long lifetimeMillis, File tempDir) throws IOException {
		super(contentType, totalLength, lifetimeMillis);
		this.streamId = streamId;
		this.tempDir = tempDir;
		setContentDisposition(contentDisposition);
	}
	
	public synchronized void addStream(long partId, long contentLength, boolean isLastPart, HRequestContext rctxt) throws IOException {
		if (log.isDebugEnabled()) log.debug("addStream(" + streamId + ", partId=" + partId + ", contentLength=" + contentLength + ", isLastPart=" + isLastPart);
		HIncomingStreamAsync streamPart = new HIncomingStreamAsync(contentType, contentLength, "", streamId, lifetimeMillis, tempDir, rctxt);
		streamParts.put(partId, streamPart);
		if (isLastPart) maxPartId = partId+1;
		notifyAll(); // notify thread that might wait in read()
		if (log.isDebugEnabled()) log.debug(")addStream");
	}
	
	@Override
	public void close() throws IOException {
		if (log.isDebugEnabled()) log.debug("close(");
		
		for (HIncomingStreamAsync strm : streamParts.values()) {
			try {
				strm.close();
			}
			catch (IOException ignored) {}
		}
	

		if (log.isDebugEnabled()) log.debug(")close");
	}
	
	private HIncomingStreamAsync getCurrentStreamPart(boolean nextPart) throws IOException {
		if (nextPart || currentStreamPart == null) {
			long t1 = System.currentTimeMillis();
			long timeout = lifetimeMillis;
			synchronized(this) {
			  if (nextPart) currentPartId++;
			  if (currentPartId < maxPartId) {
  				currentStreamPart = streamParts.get(currentPartId);
  				while (currentStreamPart == null) {
  					try {
  						wait(timeout);
  						long t2 = System.currentTimeMillis();
  						if (t2 - t1 > timeout) {
  							throw new BException(BExceptionC.TIMEOUT, "Timeout while reading stream part");
  						}
  					} catch (InterruptedException e) {
  						throw new InterruptedIOException();
  					}
  					currentStreamPart = streamParts.get(currentPartId);
  				}
			  }
			  else {
			    currentStreamPart = null;
			  }
			}
		}
		return currentStreamPart;
	}
	
	private int internalRead(byte[] b, int off, int len) throws IOException {
		int ret = -1;
		final long totalLength = super.contentLength;
		if (totalLength == -1 || readPos < totalLength) {
			HIncomingStreamAsync streamPart = getCurrentStreamPart(false);
			if (streamPart != null) {
				ret = b != null ? streamPart.read(b, off, len) : streamPart.read();
				if (ret == -1) {
				  streamPart.close();
					streamPart = getCurrentStreamPart(true);
					if (streamPart != null) {
					  ret = b != null ? streamPart.read(b, off, len) : streamPart.read();
					}
				}
			}
		}
		
		if (ret != -1) {
			readPos += ret;
		}
		
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
	public synchronized BContentStream cloneInputStream() throws BException {
		if (readPos != 0) throw new BException(BExceptionC.INTERNAL, "InputStream cannot be copied after bytes alread have been read.");
		HIncomingStreamSync istrm = null; 
		try {
	    istrm = new HIncomingStreamSync(contentType, contentLength, getContentDisposition(), streamId, lifetimeMillis, tempDir);
			istrm.assignStream(this);
		} catch (IOException e) {
			throw new BException(BExceptionC.IOERROR, "Failed to clone stream", e);
		}
		return istrm;
	}

}
